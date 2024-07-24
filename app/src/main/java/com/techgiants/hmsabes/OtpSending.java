package com.techgiants.hmsabes;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OtpSending extends AppCompatActivity {
    private EditText phoneNumberInput;
    private Button getOtpButton;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private String verificationId;
    private Handler handler;
    private Runnable cooldownRunnable;
    private boolean isCooldown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otpsending);

        // Initialize Firebase
        FirebaseApp.initializeApp(this);

        phoneNumberInput = findViewById(R.id.phone_number_input);
        getOtpButton = findViewById(R.id.get_otp_button);
        progressBar = findViewById(R.id.progress_bar);

        mAuth = FirebaseAuth.getInstance();
        handler = new Handler();
        isCooldown = false;

        getOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInternetAvailable() && !isCooldown) {
                    String phoneNumber = "+91"+phoneNumberInput.getText().toString().trim();
                    if (isValidPhoneNumber(phoneNumber)) {
                        startCooldown();
                        progressBar.setVisibility(View.VISIBLE);
                        getOtpButton.setVisibility(View.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                phoneNumber,
                                60,
                                TimeUnit.SECONDS,
                                OtpSending.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(View.GONE);
                                        getOtpButton.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(View.GONE);
                                        getOtpButton.setVisibility(View.VISIBLE);
                                        Toast.makeText(OtpSending.this, "Verification Failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
                                        Log.e("OTP", "Verification Failed", e);
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(View.GONE);
                                        getOtpButton.setVisibility(View.VISIBLE);
                                        verificationId = s;
                                        Intent intent = new Intent(OtpSending.this, com.techgiants.hmsabes.OtpVerification.class);
                                        intent.putExtra("backend", verificationId);
                                        startActivity(intent);
                                    }
                                }
                        );
                    } else {
                        Toast.makeText(OtpSending.this, "Enter a valid phone number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    if (isCooldown) {
                        Toast.makeText(OtpSending.this, "Please wait before requesting another OTP", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(OtpSending.this, "Check Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean isInternetAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Define the phone number pattern (E.164 format)
        Pattern pattern = Pattern.compile("^\\+?[1-9]\\d{1,14}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private void startCooldown() {
        isCooldown = true;
        getOtpButton.setEnabled(false);
        cooldownRunnable = new Runnable() {
            @Override
            public void run() {
                isCooldown = false;
                getOtpButton.setEnabled(true);
            }
        };
        handler.postDelayed(cooldownRunnable, 60000); // 1-minute cooldown
    }
}
