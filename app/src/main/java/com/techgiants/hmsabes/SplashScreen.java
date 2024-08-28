package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.concurrent.Executor;

public class SplashScreen extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Determine where to navigate after the splash screen
        FirebaseUser currentUser = auth.getCurrentUser();
        final Intent intent;
        if (currentUser != null) {
            intent = new Intent(SplashScreen.this, MainActivity.class);
        } else {
            intent = new Intent(SplashScreen.this, LoginActivityJava.class);
        }

        // Call the proceedToNextActivity method with the intent
        proceedToNextActivity(intent);
    }

    private void proceedToNextActivity(Intent intent) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 1000); // Delay of 1000 milliseconds (1 second)
    }
}
