package com.techgiants.hmsabes;

import static android.app.PendingIntent.getActivity;
import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Map;

public class ProfileFragment extends Fragment {
    private FirebaseAuth auth;
    private FirebaseFirestore fstore;
    private ImageView profileimageview;
    private ImageButton aboutus;
    StorageReference storageReference;
    private TextView nm, admission, roomno, depart;



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
        FirebaseUser currentUser = auth.getCurrentUser();
        nm = view.findViewById(R.id.profilename);
        admission = view.findViewById(R.id.profileadm);
        roomno = view.findViewById(R.id.profileroomno);
        depart = view.findViewById(R.id.profiledeptname);
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
        fstore.collection("users").document(currentUser.getUid()).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            Map<String, Object> userDetails = documentSnapshot.getData();
                            if (userDetails != null) {
                                nm.setText(userDetails.get("name").toString());
                                admission.setText("Admission No.: " + userDetails.get("admission_no").toString());
                                roomno.setText("Room No.: " + userDetails.get("block").toString() + " " + userDetails.get("room_no").toString());
                                depart.setText("Department: " + userDetails.get("department").toString());
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Failed to fetch user details: ", e);
                    }
                });
        btnLeave = view.findViewById(R.id.profileleave);
        btnComplain = view.findViewById(R.id.profilecomplain);
        btnLogout = view.findViewById(R.id.profilelogutbtn);
        aboutus=view.findViewById(R.id.dashboardaboutus);
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getContext(),Aboutus.class));
            }
        });

        Intent iLeave = new Intent(getActivity(), Leavedata.class);
        Intent iComplain = new Intent(getActivity(), ComplainData.class);

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
