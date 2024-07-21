package com.techgiants.hmsabes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    String gmails, adm, retyadm, pas, retypas, romno, dept,blockname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Retrieve values from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        String gmail = sharedPreferences.getString("gmail", null);
        String admission = sharedPreferences.getString("adm", null);
        String retypeadm = sharedPreferences.getString("readm", null);
        String pass = sharedPreferences.getString("pass", null);
        String retypepass = sharedPreferences.getString("repas", null);
        String roomno = sharedPreferences.getString("roomno", null);
        String department = sharedPreferences.getString("dept", null);
        String block = sharedPreferences.getString("blockname", null);



        gmails = gmail;
        adm = admission;
        retyadm = retypeadm;
        pas = pass;
        retypas = retypepass;
        romno = roomno;
        dept = department;
        blockname=block;

        navigation = findViewById(R.id.bottomnavigation);
        navigation.setItemIconTintList(null);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.leave) {
                    frag(new LeaveFragment(), false);
                } else if (id == R.id.complains) {
                    frag(new ComplainsFragment(), false);
                } else if (id == R.id.profile) {
                    frag(new ProfileFragment(), true);
                } else {
                    frag(new AllotmentFragment(), false);
                }
                return true;
            }
        });
        navigation.setSelectedItemId(R.id.profile);
    }

    public void frag(Fragment fragment, boolean flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("gmail", gmails);
        bundle.putString("adm", adm);
        bundle.putString("retyadm", retyadm);
        bundle.putString("pass", pas);
        bundle.putString("pasre", retypas);
        bundle.putString("room", romno);
        bundle.putString("dept", dept);
        fragment.setArguments(bundle);

        if (flag) {
            fragmentTransaction.add(R.id.containeer, fragment);
        } else {
            fragmentTransaction.replace(R.id.containeer, fragment);
        }
        fragmentTransaction.commit();
    }
}
