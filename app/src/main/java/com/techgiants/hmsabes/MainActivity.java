package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    private String gmails, adm,romno, dept, blockname,name;
    private FirebaseFirestore firestore;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initialize Firebase instances
        auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        // Get current user
        FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            String userId = user.getUid();
            firestore.collection("users").document(userId).get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            // Fetch user details
                            fetchUserDetails(documentSnapshot);
                        }
                    })
                    .addOnFailureListener(e -> {
                        // Handle any errors here
                    });
        }

        // Setup BottomNavigationView
        setupBottomNavigationView();
    }

    private void fetchUserDetails(DocumentSnapshot documentSnapshot) {
        gmails = documentSnapshot.getString("email");
        name = documentSnapshot.getString("name");
        adm = documentSnapshot.getString("admission_no");
        romno = documentSnapshot.getString("room_no");
        dept = documentSnapshot.getString("department");
        blockname = documentSnapshot.getString("block");
    }

    private void setupBottomNavigationView() {
        navigation = findViewById(R.id.bottomNavigation);
        navigation.setItemIconTintList(null);
        navigation.setOnItemSelectedListener(this::onNavigationItemSelected);
        navigation.setSelectedItemId(R.id.wifi);
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectedFragment = null;
        int id = menuItem.getItemId();
        if (id == R.id.wifi) {
            frag(new WifiFragment(),false);
        }
        else if (id == R.id.leave) {
            frag(new LeaveFragment(), false);
        }
        else if (id == R.id.dashboard) {
            frag(new DashboardFragment(), false);
        }
        else if (id == R.id.complains) {
            frag(new ComplainsFragment(), false);
        }
        else{
            //profile
            frag(new ProfileFragment(), false);
        }
        return true;
    }
    public void frag(Fragment fragment, boolean flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("name",name);
        bundle.putString("adm",adm);
        bundle.putString("roomno",romno);
        bundle.putString("dept",dept);
        bundle.putString("blockname",blockname);
        bundle.putString("gmails",gmails);
        fragment.setArguments(bundle);

        if (flag) {
            fragmentTransaction.add(R.id.containeer, fragment);
        } else {
            fragmentTransaction.replace(R.id.containeer, fragment);
        }
        fragmentTransaction.commit();

    }

}
