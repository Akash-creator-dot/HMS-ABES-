package com.techgiants.hmsabes;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import com.bumptech.glide.Glide;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
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
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Source;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;
public class ProfileFragment extends Fragment {
    private FirebaseAuth auth;
    private FirebaseFirestore fstore;
    private ImageView profileimageview;
    private ImageView aboutus;
    private StorageReference storageReference;
    private TextView nm, admission, roomno, depart,block;
    String name,adm,room,dept;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button verifyBtn;
        CardView btnLeave, btnComplain;
        MaterialCardView btnLogout;
        String userId;
        TextView emailVerificationText;
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        auth = FirebaseAuth.getInstance();
        block=view.findViewById(R.id.profileblock);
        userId = auth.getCurrentUser().getUid();
        FirebaseUser currentUser = auth.getCurrentUser();
        nm = view.findViewById(R.id.profilename);
        admission = view.findViewById(R.id.profileadm);
        roomno = view.findViewById(R.id.profileroomno);
        depart = view.findViewById(R.id.profiledeptname);
        final FirebaseUser user = auth.getCurrentUser();
        fstore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();
        profileimageview = view.findViewById(R.id.profile_image);
        Bundle bundle = getArguments();
        if (bundle != null) {
            name = bundle.getString("name");
            adm = bundle.getString("adm");
            room = bundle.getString("roomno");
            dept = bundle.getString("dept");
        }
        fetchUserDataWithCaching();

        StorageReference profileRef = storageReference.child("users/" + auth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Use Glide to load the image
                Glide.with(getContext())
                        .load(uri)
                        .centerCrop()  // Optional: Adjust according to your needs
                        .into(profileimageview);
            }
        });

        btnLeave = view.findViewById(R.id.profileleave);
        btnComplain = view.findViewById(R.id.profilecomplain);
        btnLogout = view.findViewById(R.id.profilelogutbtn);
        aboutus = view.findViewById(R.id.dashboardaboutus);

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Aboutus.class));
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

        profileimageview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, 1000);
                return false;
            }
        });
        return view;
    }

    // Fetch user data from Firestore and use built-in caching
    private void fetchUserDataWithCaching() {
        // Attempt to fetch from the cache first
        fstore.collection("users").document(auth.getCurrentUser().getUid()).get(Source.CACHE)
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            updateUIWithUserData(documentSnapshot);
                        } else {
                            // If cache is empty, fetch from server
                            fetchUserDataFromServer();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Failed to fetch user details from cache: ", e);
                        fetchUserDataFromServer(); // On failure, fallback to fetching from server
                    }
                });
    }

    // Fetch user data from Firestore server and update cache
    private void fetchUserDataFromServer() {
        fstore.collection("users").document(auth.getCurrentUser().getUid()).get(Source.SERVER)
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        updateUIWithUserData(documentSnapshot);
                        // Update cache by writing the fetched data back
                        fstore.collection("users").document(auth.getCurrentUser().getUid()).set(documentSnapshot.getData(), SetOptions.merge());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Failed to fetch user details from server: ", e);
                    }
                });
    }

//     Update UI with user data
    private void updateUIWithUserData(DocumentSnapshot documentSnapshot) {
        Map<String, Object> userDetails = documentSnapshot.getData();
        if (userDetails != null) {
            nm.setText(userDetails.get("name").toString());
            admission.setText("Admission No.: " + userDetails.get("admission_no").toString());
            roomno.setText("Room No.: "+ userDetails.get("room_no").toString());
            block.setText("Block.: " + userDetails.get("block").toString());
            depart.setText("Department: " + userDetails.get("department").toString());
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == MainActivity.RESULT_OK) {
            Uri imageUri = data.getData();
            profileimageview.setImageURI(imageUri);
            uploadImageToFirebase(imageUri);
        }
    }

    private void uploadImageToFirebase(Uri imageUri) {
        StorageReference fileRef = storageReference.child("users/" + auth.getCurrentUser().getUid() + "/profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(taskSnapshot -> fileRef.getDownloadUrl().addOnSuccessListener(uri -> {
            Picasso.get().load(uri).into(profileimageview);
            Toast.makeText(getActivity(), "Upload Successful", Toast.LENGTH_SHORT).show();
            updateUserProfileInFirestore(uri.toString());
        }).addOnFailureListener(e -> {
            Log.e(TAG, "Failed to get download URL", e);
            Toast.makeText(getActivity(), "Failed to retrieve image URL.", Toast.LENGTH_SHORT).show();
        })).addOnFailureListener(e -> {
            Log.e(TAG, "Upload failed", e);
            Toast.makeText(getActivity(), "Upload Failed.", Toast.LENGTH_SHORT).show();
        });
    }

    // Update Firestore document to reflect the new profile picture URL
    private void updateUserProfileInFirestore(String imageUrl) {
        Map<String, Object> updates = new HashMap<>();
        updates.put("profile_picture_url", imageUrl); // Replace with actual field name in Firestore
        fstore.collection("users").document(auth.getCurrentUser().getUid()).update(updates)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "Profile updated successfully in Firestore"))
                .addOnFailureListener(e -> Log.e(TAG, "Failed to update profile in Firestore", e));
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), LoginActivityJava.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }
}
