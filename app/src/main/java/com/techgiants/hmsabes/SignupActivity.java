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
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        progressBar = binding.progressBarSignup;
        progressBar.setVisibility(View.GONE);

        binding.logInButton.setOnClickListener(v -> {
            startActivity(new Intent(SignupActivity.this, LoginActivityJava.class));
            finish();
        });

        binding.registerButton.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String emailID = binding.emailIdSignUp.getText().toString().trim();
        String name = binding.nameSignup.getText().toString().trim();
        String admissionNo = binding.admnNo.getText().toString().trim();
        String retypeAdmissionNo = binding.retypeAdmn.getText().toString().trim();
        String password = binding.passwordSignUp.getText().toString().trim();
        String retypePassword = binding.retypePasswordSignUp.getText().toString().trim();
        String roomNo = binding.roomNO.getText().toString().trim();
        String department = binding.dept.getText().toString().trim();
        String blockName = binding.block.getText().toString().trim();
        String parentMobileNo = binding.parentMobileNo.getText().toString().trim();
        String studentMobileNo = binding.studentMobileNo.getText().toString().trim();

        if (emailID.isEmpty() || admissionNo.isEmpty() || retypeAdmissionNo.isEmpty() ||
                password.isEmpty() || retypePassword.isEmpty() || roomNo.isEmpty() ||
                department.isEmpty() || name.isEmpty() || parentMobileNo.isEmpty() ||
                studentMobileNo.isEmpty()) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
            return;
        }

        if (parentMobileNo.equals(studentMobileNo)) {
            Toast.makeText(this, "Parent and Student Mobile number should not match.", Toast.LENGTH_LONG).show();
            return;
        }

        if (!password.equals(retypePassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        checkMobileNumbers(parentMobileNo, studentMobileNo);
    }

    private void checkMobileNumbers(String parentMobileNo, String studentMobileNo) {
        progressBar.setVisibility(View.VISIBLE);

        firestore.collection("users")
                .whereEqualTo("parentMobileNo", parentMobileNo)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && !task.getResult().isEmpty()) {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, "Parent mobile number already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        firestore.collection("users")
                                .whereEqualTo("studentMobileNo", studentMobileNo)
                                .get()
                                .addOnCompleteListener(task1 -> {
                                    progressBar.setVisibility(View.GONE);
                                    if (task1.isSuccessful() && !task1.getResult().isEmpty()) {
                                        Toast.makeText(this, "Student mobile number already exists", Toast.LENGTH_SHORT).show();
                                    } else {
                                        createUserAccount();
                                    }
                                });
                    }
                });
    }

    private void createUserAccount() {
        String emailID = binding.emailIdSignUp.getText().toString().trim();
        String password = binding.passwordSignUp.getText().toString().trim();

        progressBar.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(emailID, password)
                .addOnCompleteListener(this, task -> {
                    progressBar.setVisibility(View.GONE);
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        saveUserData(user.getUid());
                    } else {
                        Toast.makeText(this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void saveUserData(String userId) {
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("email", binding.emailIdSignUp.getText().toString().trim());
        userDetails.put("name", binding.nameSignup.getText().toString().trim());
        userDetails.put("admission_no", binding.admnNo.getText().toString().trim());
        userDetails.put("room_no", binding.roomNO.getText().toString().trim());
        userDetails.put("department", binding.dept.getText().toString().trim());
        userDetails.put("block", binding.block.getText().toString().trim());
        userDetails.put("parentMobileNo", binding.parentMobileNo.getText().toString().trim());
        userDetails.put("studentMobileNo", binding.studentMobileNo.getText().toString().trim());

        firestore.collection("users").document(userId).set(userDetails)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    uploadDetails();
                    startActivity(new Intent(SignupActivity.this, LoginActivityJava.class));
                    finish();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Failed to save user data: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    private void uploadDetails() {
        String admissionNo = binding.admnNo.getText().toString();
        HashMap<String, Object> detailsMap = new HashMap<>();
        detailsMap.put("EmailID", binding.emailIdSignUp.getText().toString());
        detailsMap.put("Name", binding.nameSignup.getText().toString());
        detailsMap.put("AdmissionNo", admissionNo);
        detailsMap.put("RoomNo", binding.roomNO.getText().toString());
        detailsMap.put("Department", binding.dept.getText().toString());
        detailsMap.put("BlockName", binding.block.getText().toString());
        detailsMap.put("ParentMobileNo", binding.parentMobileNo.getText().toString());
        detailsMap.put("StudentMobileNo", binding.studentMobileNo.getText().toString());

        DatabaseReference detailsRef = FirebaseDatabase.getInstance().getReference("Student");
        detailsRef.child(admissionNo).setValue(detailsMap)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Details Uploaded Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Failed to upload details: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
