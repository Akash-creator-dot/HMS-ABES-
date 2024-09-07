package com.techgiants.hmsabes;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

public class MessMenu extends AppCompatActivity {
    private ProgressBar progressbar;
    private ImageView img;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mess_menu);

        progressbar = findViewById(R.id.progresscanteenmenu);
        img = findViewById(R.id.imgmessmenu);

        // Reference to the Firebase Storage location
        storageReference = FirebaseStorage.getInstance().getReference().child("Admin").child("MessMenu");

        loadLatestMenuImage();
    }

    private void loadLatestMenuImage() {
        progressbar.setVisibility(View.VISIBLE);

        // List all images in the "CanteenMenu" folder
        storageReference.listAll().addOnSuccessListener(listResult -> {
            if (!listResult.getItems().isEmpty()) {
                // Get the latest image by using the last item in the list
                StorageReference latestImageRef = listResult.getItems().get(listResult.getItems().size() - 1);

                // Get the download URL of the latest image
                latestImageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                    String imageUrl = uri.toString();

                    // Load the image using Glide
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
