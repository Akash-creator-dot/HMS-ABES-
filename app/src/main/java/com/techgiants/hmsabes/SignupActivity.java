package com.techgiants.hmsabes;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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
import com.techgiants.hmsabes.databinding.ActivitySignUpBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();
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
                String email = binding.emailIdSignUp.getText().toString().trim();
                String usernm=binding.usernameSignup.getText().toString().trim();
                String admn = binding.admnNo.getText().toString().trim();
                String retypeAdmn = binding.retypeAdmn.getText().toString().trim();
                String password = binding.passwordSignUp.getText().toString().trim();
                String retypePassword = binding.retypePasswordSignUp.getText().toString().trim();
                String roomno = binding.roomNO.getText().toString().trim();
                String department = binding.dept.getText().toString().trim();
                String blocknm=binding.block.getText().toString().trim();

                if (email.isEmpty() || admn.isEmpty() || retypeAdmn.isEmpty() || password.isEmpty() || retypePassword.isEmpty() || roomno.isEmpty() || department.isEmpty()||usernm.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(retypePassword)) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    //send verification link
                                    FirebaseUser user = auth.getCurrentUser();
                                    user.sendEmailVerification().addOnSuccessListener((new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Toast.makeText(SignupActivity.this, "Verification Email has been sent.", Toast.LENGTH_SHORT).show();
                                        }
                                    })).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Log.d(TAG, "onFailure: Email not sent"+ e.getMessage());
                                        }
                                    });



                                    SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("gmail", email);
                                    editor.putString("username",usernm);
                                    editor.putString("adm", admn);
                                    editor.putString("readm", retypeAdmn);
                                    editor.putString("pass", password);
                                    editor.putString("repas", retypePassword);
                                    editor.putString("roomno", roomno);
                                    editor.putString("dept", department);
                                    editor.putString("block",blocknm);
                                    editor.apply();
                                    Toast.makeText(SignupActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    String errorMessage = task.getException().getMessage();
                                    Toast.makeText(SignupActivity.this, "Registration Failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}
