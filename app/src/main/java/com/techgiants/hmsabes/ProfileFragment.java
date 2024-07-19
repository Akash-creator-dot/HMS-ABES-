package com.techgiants.hmsabes;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProfileFragment extends Fragment {
    private FirebaseAuth auth;
    private FirebaseFirestore fstore;


    public ProfileFragment() {

        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button btnLogout, btnLeave, btnComplain, verifyBtn;
        String userId;
        TextView emailVerificationText;
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        auth=FirebaseAuth.getInstance();
        userId=auth.getCurrentUser().getUid();
        final FirebaseUser user =auth.getCurrentUser();
        fstore= FirebaseFirestore.getInstance();
        btnLeave = view.findViewById(R.id.profileleave);
        btnComplain = view.findViewById(R.id.profilecomplain);
        btnLogout = view.findViewById(R.id.profilelogutbtn);
        verifyBtn=view.findViewById(R.id.verifyBtn);
        emailVerificationText=view.findViewById(R.id.emailVerificationText);
        if(!user.isEmailVerified()){
            emailVerificationText.setVisibility(View.VISIBLE);
            verifyBtn.setVisibility(View.VISIBLE);
            verifyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    user.sendEmailVerification().addOnSuccessListener((new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(v.getContext(), "Verification Email has been sent.", Toast.LENGTH_SHORT).show();
                        }
                    })).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: Email not sent"+ e.getMessage());
                        }
                    });
                }
            });
        }

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
