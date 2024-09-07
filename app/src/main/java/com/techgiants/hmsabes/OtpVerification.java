package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OtpVerification extends AppCompatActivity {
    private String verificationId;
    private EditText[] otpFields;
    private Button verifyButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otpverification);

        mAuth = FirebaseAuth.getInstance();
        otpFields = new EditText[]{
                findViewById(R.id.otp_enter_1),
                findViewById(R.id.otp_enter_2),
                findViewById(R.id.otp_enter_3),
                findViewById(R.id.otp_enter_4),
                findViewById(R.id.otp_enter_5),
                findViewById(R.id.otp_enter_6)
        };
        verifyButton = findViewById(R.id.verify_button);

        verificationId = getIntent().getStringExtra("backend");

        for (int i = 0; i < otpFields.length; i++) {
            final int index = i;
            otpFields[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                    if (charSequence.length() == 1 && index < otpFields.length - 1) {
                        // Move focus to the next field if a character is entered
                        otpFields[index + 1].requestFocus();
                    } else if (charSequence.length() == 0 && index > 0) {
                        // Move focus to the previous field if the character is deleted (backspace)
                        otpFields[index - 1].requestFocus();
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {}
            });
        }


        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code = "";
                for (EditText otpField : otpFields) {
                    code += otpField.getText().toString().trim();
                }
                if (code.length() == 6 && verificationId != null) {
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
                    mAuth.signInWithCredential(credential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(OtpVerification.this,"Verified",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(OtpVerification.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(OtpVerification.this, "Please enter valid OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
