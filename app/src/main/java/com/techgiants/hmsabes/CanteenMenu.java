package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CanteenMenu extends AppCompatActivity {
    private ProgressBar progressBar;
    private PhotoView img;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_menu);

        progressBar = findViewById(R.id.progresscanteenmenu);
        img = findViewById(R.id.imgmessmenu);

        // Reference to the Firebase Storage location
        Intent intent = getIntent();
        String year = intent.getStringExtra("Year");

        if ("First".equals(year)) {
            storageReference = FirebaseStorage.getInstance().getReference()
                    .child("Admin").child("CanteenMenu");
        } else {
            storageReference = FirebaseStorage.getInstance().getReference()
                    .child("Admin").child("CanteenMenu");
        }

        loadLatestMenuImage();
    }

    private void loadLatestMenuImage() {
        progressBar.setVisibility(View.VISIBLE);
        storageReference.listAll().addOnSuccessListener(listResult -> {
            if (!listResult.getItems().isEmpty()) {
                StorageReference latestImageRef = listResult.getItems().get(listResult.getItems().size() - 1);
                latestImageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                    String imageUrl = uri.toString();
                    Glide.with(CanteenMenu.this)
                            .load(imageUrl)
                            .into(img);
                    progressBar.setVisibility(View.GONE);
                }).addOnFailureListener(e -> {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(CanteenMenu.this, "Failed to get image URL", Toast.LENGTH_SHORT).show();
                });
            } else {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(CanteenMenu.this, "No images found", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(e -> {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(CanteenMenu.this, "Failed to list images", Toast.LENGTH_SHORT).show();
        });
    }
}
