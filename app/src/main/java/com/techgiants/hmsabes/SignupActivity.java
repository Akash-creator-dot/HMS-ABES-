package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.techgiants.hmsabes.databinding.ActivitySignUpBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth = FirebaseAuth.getInstance();

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
                String admn = binding.admnNo.getText().toString().trim();
                String retypeAdmn = binding.retypeAdmn.getText().toString().trim();
                String password = binding.passwordSignUp.getText().toString().trim();
                String retypePassword = binding.retypePasswordSignUp.getText().toString().trim();
                String dept = binding.dept.getText().toString().trim();
                String roomno = binding.roomNO.getText().toString().trim();

                if (email.isEmpty() || admn.isEmpty() || password.isEmpty() || retypePassword.isEmpty()||retypeAdmn.isEmpty()||roomno.isEmpty()||dept.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please fill all the details", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(retypePassword)) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(SignupActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignupActivity.this, LoginActivityJava.class));
                                        finish();
                                    } else {
                                        String errorMessage = task.getException().getMessage();
                                        Toast.makeText(SignupActivity.this, "Registration Failed: " + errorMessage, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
}
