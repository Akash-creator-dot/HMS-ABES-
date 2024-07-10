package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button btnLogout,btnleave,btncomplain;
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        btnleave=view.findViewById(R.id.profileleave);
        btncomplain=view.findViewById(R.id.profilecomplain);
        Intent ileave=new Intent(getActivity(),Leavedata.class);
        Intent icomplain=new Intent(getActivity(),Complaindata.class);
        btnleave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ileave);
            }
        });
        btncomplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(icomplain);
            }
        });
        FirebaseAuth auth = FirebaseAuth.getInstance();
        btnLogout = view.findViewById(R.id.profilelogutbtn);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
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