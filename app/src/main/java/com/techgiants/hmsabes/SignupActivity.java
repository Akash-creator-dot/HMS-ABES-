package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.techgiants.hmsabes.databinding.ActivitySignUpBinding;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    private FirebaseFirestore firestore;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        progressBar = binding.progressBarSignup;
        progressBar.setVisibility(View.GONE);

        binding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivityJava.class));
                finish();
            }
        });

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EmailID = binding.emailIdSignUp.getText().toString().trim();
                String Name = binding.nameSignup.getText().toString().trim();
                String AdmissionNo = binding.admnNo.getText().toString().trim();
                String retypeAdmissionNo = binding.retypeAdmn.getText().toString().trim();
                String Password = binding.passwordSignUp.getText().toString().trim();
                String retypePassword = binding.retypePasswordSignUp.getText().toString().trim();
                String RoomNo = binding.roomNO.getText().toString().trim();
                String department = binding.dept.getText().toString().trim();
                String BlockName = binding.block.getText().toString().trim();
                String ParentMobileNo = binding.parentMobileNo.getText().toString().trim();
                String StudentMobileNo = binding.studentMobileNo.getText().toString().trim();

                if (EmailID.isEmpty() || AdmissionNo.isEmpty() || retypeAdmissionNo.isEmpty() || Password.isEmpty() || retypePassword.isEmpty() || RoomNo.isEmpty() || department.isEmpty() || Name.isEmpty() || ParentMobileNo.isEmpty() || StudentMobileNo.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(ParentMobileNo.equals(StudentMobileNo)){
                    Toast.makeText(SignupActivity.this, "Parent and Student Mobile number should not match.", Toast.LENGTH_LONG).show();
                    return;
                }

                if (!Password.equals(retypePassword)) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check if mobile numbers already exist in the database
                checkMobileNumbers(ParentMobileNo, StudentMobileNo);
            }
        });
    }

    private void checkMobileNumbers(String parentMobileNo, String studentMobileNo) {
        progressBar.setVisibility(View.VISIBLE);

        // Check for parent mobile number
        firestore.collection("users")
                .whereEqualTo("parentMobileNo", parentMobileNo)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && !task.getResult().isEmpty()) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(SignupActivity.this, "Parent mobile number already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        // Check for student mobile number
                        firestore.collection("users")
                                .whereEqualTo("studentMobileNo", studentMobileNo)
                                .get()
                                .addOnCompleteListener(task1 -> {
                                    progressBar.setVisibility(View.GONE);
                                    if (task1.isSuccessful() && !task1.getResult().isEmpty()) {
                                        Toast.makeText(SignupActivity.this, "Student mobile number already exists", Toast.LENGTH_SHORT).show();
                                    } else {
                                        // Proceed with registration
                                        registerUser();
                                    }
                                });
                    }
                });
    }

    private void registerUser() {
        String EmailID = binding.emailIdSignUp.getText().toString().trim();
        String Name = binding.nameSignup.getText().toString().trim();
        String AdmissionNo = binding.admnNo.getText().toString().trim();
        String Password = binding.passwordSignUp.getText().toString().trim();
        String RoomNo = binding.roomNO.getText().toString().trim();
        String department = binding.dept.getText().toString().trim();
        String BlockName = binding.block.getText().toString().trim();
        String ParentMobileNo = binding.parentMobileNo.getText().toString().trim();
        String StudentMobileNo = binding.studentMobileNo.getText().toString().trim();

        auth.createUserWithEmailAndPassword(EmailID, Password)
                .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            Map<String, Object> userDetails = new HashMap<>();
                            userDetails.put("email", EmailID);
                            userDetails.put("name", Name);
                            userDetails.put("admission_no", AdmissionNo);
                            userDetails.put("room_no", RoomNo);
                            userDetails.put("department", department);
                            userDetails.put("block", BlockName);
                            userDetails.put("parentMobileNo", ParentMobileNo);
                            userDetails.put("studentMobileNo", StudentMobileNo);

                            firestore.collection("users").document(user.getUid()).set(userDetails)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(SignupActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(SignupActivity.this, LoginActivityJava.class);
                                        uplaodDetails();
                                        startActivity(intent);
                                        finish();
                                    }).addOnFailureListener(e -> Toast.makeText(SignupActivity.this, "Failed to save user data: " + e.getMessage(), Toast.LENGTH_SHORT).show());

                        } else {
                            String errorMessage = task.getException().getMessage();
                            Toast.makeText(SignupActivity.this, "Registration Failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void uplaodDetails() {
        String EmailID = binding.emailIdSignUp.getText().toString();
        String Name = binding.nameSignup.getText().toString();
        String AdmissionNo = binding.admnNo.getText().toString();
        String RoomNo = binding.roomNO.getText().toString();
        String Department = binding.dept.getText().toString();
        String BlockName = binding.block.getText().toString();
        String ParentMobileNo = binding.parentMobileNo.getText().toString();
        String StudentMobileNo=binding.studentMobileNo.getText().toString();

        HashMap<String, Object> DetailsHashmap = new HashMap<>();
        DetailsHashmap.put("EmailID", EmailID);
        DetailsHashmap.put("Name", Name);
        DetailsHashmap.put("AdmissionNo", AdmissionNo);
        DetailsHashmap.put("RoomNo", RoomNo);
        DetailsHashmap.put("Department", Department);
        DetailsHashmap.put("BlockName", BlockName);
        DetailsHashmap.put("ParentMobileNo", ParentMobileNo);
        DetailsHashmap.put("StudentMobileNo",StudentMobileNo);

        // Instantiate database connection
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference DetailsRef = firebaseDatabase.getReference("Student");

        DetailsRef.child(AdmissionNo).setValue(DetailsHashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(SignupActivity.this, "Details Uploaded Successfully...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
