package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button btnLogout, btnLeave, btnComplain;
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btnLeave = view.findViewById(R.id.profileleave);
        btnComplain = view.findViewById(R.id.profilecomplain);
        btnLogout = view.findViewById(R.id.profilelogutbtn);

        Intent iLeave = new Intent(getActivity(), Leavedata.class);
        Intent iComplain = new Intent(getActivity(), Complaindata.class);

        btnLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iLeave);
            }
        });

        btnComplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(iComplain);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null) {
            String gmail = bundle.getString("gmail");
            String adm = bundle.getString("adm");
            String pass = bundle.getString("pass");
            String room = bundle.getString("room");
            String dept = bundle.getString("dept");

            TextView name = view.findViewById(R.id.profilename);
            TextView admission = view.findViewById(R.id.profileadm);
            TextView roomno = view.findViewById(R.id.profileroomno);
            TextView depart = view.findViewById(R.id.profiledeptname);

            name.setText(gmail);
            if (adm != null) {
                String customText = "Admission No.: " + adm;
                admission.setText(customText);
            }
            if (room != null) {
                String customText = "Room No.: " + room;
                roomno.setText(customText);
            }
            if (dept != null) {
                String customText = "Department: " + dept;
                depart.setText(customText);
            }
        }

        return view;
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), LoginActivityJava.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }
}
