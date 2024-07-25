package com.techgiants.hmsabes;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
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

    private ArrayList<Student_Details> arrdetails = new ArrayList<>();
    private BottomNavigationView navigation;
    private String gmails, adm, retyadm, pas, retypas, romno, dept, blockname;
    private FirebaseFirestore firestore;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting up window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
        adm = documentSnapshot.getString("admission_no");
        retyadm = documentSnapshot.getString("retype_admission_no");
        pas = documentSnapshot.getString("password");
        retypas = documentSnapshot.getString("retype_password");
        romno = documentSnapshot.getString("room_no");
        dept = documentSnapshot.getString("department");
        blockname = documentSnapshot.getString("block");

        arrdetails.add(new Student_Details("name", romno, blockname, dept, adm));
    }

    private void setupBottomNavigationView() {
        navigation = findViewById(R.id.bottomnavigation);
        navigation.setItemIconTintList(null);
        navigation.setOnItemSelectedListener(this::onNavigationItemSelected);
        navigation.setSelectedItemId(R.id.wifi);
    }

    private boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment selectedFragment = null;
        int id = menuItem.getItemId();
        if (id == R.id.wifi) {
            frag(new WifiFragment(),true);
        } else if (id == R.id.complains) {
            frag(new ComplainsFragment(), false);
        } else if (id == R.id.leave) {
            frag(new LeaveFragment(), false);
        }else{
            //profile
            frag(new ProfileFragment(), false);
        }
        return true;
    }

    public void frag(Fragment fragment, boolean flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Bundle user details
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("array", arrdetails);
        fragment.setArguments(bundle);

        if (flag) {
            fragmentTransaction.add(R.id.containeer, fragment);
        } else {
            fragmentTransaction.replace(R.id.containeer, fragment);
        }
        fragmentTransaction.commit();
    }
}
