package com.techgiants.hmsabes;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class MessMenu extends AppCompatActivity {
    private ProgressBar progressbar;
    private PhotoView img;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_menu);

        progressbar = findViewById(R.id.progresscanteenmenu);
        img = findViewById(R.id.imgmessmenu);

        // Reference to the Firebase Storage location
        storageReference = FirebaseStorage.getInstance().getReference().child("Admin").child("MessMenu").child("FirstAndSecondYear");

        loadLatestMenuImage();
    }

    private void loadLatestMenuImage() {
        progressbar.setVisibility(View.VISIBLE);
        storageReference.listAll().addOnSuccessListener(listResult -> {
            if (!listResult.getItems().isEmpty()) {
                StorageReference latestImageRef = listResult.getItems().get(listResult.getItems().size() - 1);
                latestImageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                    String imageUrl = uri.toString();
                    Glide.with(MessMenu.this)
                            .load(imageUrl)
                            .into(img);
                    progressbar.setVisibility(View.GONE);
                }).addOnFailureListener(e -> {
                    progressbar.setVisibility(View.GONE);
                    Toast.makeText(MessMenu.this, "Failed to get image URL", Toast.LENGTH_SHORT).show();
                });
            } else {
                progressbar.setVisibility(View.GONE);
                Toast.makeText(MessMenu.this, "No images found", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(e -> {
            progressbar.setVisibility(View.GONE);
            Toast.makeText(MessMenu.this, "Failed to list images", Toast.LENGTH_SHORT).show();
        });
    }
}
