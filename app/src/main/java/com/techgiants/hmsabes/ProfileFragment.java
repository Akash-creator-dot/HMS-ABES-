package com.techgiants.hmsabes;

import static android.app.PendingIntent.getActivity;
import static android.content.ContentValues.TAG;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment {
    private FirebaseAuth auth;
    private FirebaseFirestore fstore;
    private ImageView profileimageview;
    StorageReference storageReference;



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
        storageReference= FirebaseStorage.getInstance().getReference();
        StorageReference profileRef=storageReference.child("users/"+auth.getCurrentUser().getUid()+"profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileimageview);
            }
        });
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
            String block=bundle.getString("block");
            String name=bundle.getString("nam");


            TextView nm = view.findViewById(R.id.profilename);
            TextView admission = view.findViewById(R.id.profileadm);
            TextView roomno = view.findViewById(R.id.profileroomno);
            TextView depart = view.findViewById(R.id.profiledeptname);
            nm.setText(name);
            if (adm != null) {
                String customText = "Admission No.: " + adm;
                admission.setText(customText);
            }
            if (room != null) {
                String customText = "Room No.: "+block+" "+ room;
                roomno.setText(customText);
            }
            if (dept != null) {
                String customText = "Department: " + dept;
                depart.setText(customText);
            }
        }


        profileimageview=view.findViewById(R.id.profile_image);
        profileimageview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent openGalleryIntent= new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent,1000);
                return false;
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000){
            if(resultCode== MainActivity.RESULT_OK){
                Uri imageUri=data.getData();
                profileimageview.setImageURI(imageUri);
                uploadImageToFirebase(imageUri);
                }
            }
        }
    private void uploadImageToFirebase(Uri imageUri) {
        StorageReference fileRef=storageReference.child("users/"+auth.getCurrentUser().getUid()+"profile.jpg" );
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(profileimageview);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Upload Failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), LoginActivityJava.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }
}
