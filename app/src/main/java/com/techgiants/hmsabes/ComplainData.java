package com.techgiants.hmsabes;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class ComplainData extends AppCompatActivity {
    ArrayList<ComplainHistoryStructure> arrcomplain = new ArrayList<>();
    ComplainHistoryAdapter adapter;
    RecyclerView complainsrecycle;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaindata);

        // Initialize RecyclerView and Shimmer
        complainsrecycle = findViewById(R.id.recyclerComplains);
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);

        complainsrecycle.setLayoutManager(new LinearLayoutManager(this));

        // Show shimmer effect for 3 seconds before showing data
        shimmerFrameLayout.startShimmer();

        // Simulate data loading delay using Handler
        new Handler().postDelayed(() -> {
            // Hide shimmer effect
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);

            // Show RecyclerView
            complainsrecycle.setVisibility(View.VISIBLE);

            // Add data to the ArrayList
            arrcomplain.add(new ComplainHistoryStructure("12/05/2024", "Carpenter"));
            arrcomplain.add(new ComplainHistoryStructure("14/05/2024", "Electrician"));
            arrcomplain.add(new ComplainHistoryStructure("30/05/2024", "Plumber"));
            arrcomplain.add(new ComplainHistoryStructure("11/06/2024", "Pest Control"));
            arrcomplain.add(new ComplainHistoryStructure("22/06/2024", "Sweeper"));
            arrcomplain.add(new ComplainHistoryStructure("31/06/2024", "Carpenter"));
            arrcomplain.add(new ComplainHistoryStructure("12/07/2024", "Electrician"));
            arrcomplain.add(new ComplainHistoryStructure("01/08/2024", "Plumber"));
            arrcomplain.add(new ComplainHistoryStructure("12/08/2024", "Carpenter"));
            arrcomplain.add(new ComplainHistoryStructure("14/08/2024", "Electrician"));
            arrcomplain.add(new ComplainHistoryStructure("30/08/2024", "Plumber"));
            arrcomplain.add(new ComplainHistoryStructure("11/09/2024", "Pest Control"));
            arrcomplain.add(new ComplainHistoryStructure("22/09/2024", "Sweeper"));
            arrcomplain.add(new ComplainHistoryStructure("31/09/2024", "Carpenter"));
            arrcomplain.add(new ComplainHistoryStructure("12/10/2024", "Electrician"));
            arrcomplain.add(new ComplainHistoryStructure("01/10/2024", "Plumber"));

            // Initialize adapter and set it to RecyclerView
            adapter = new ComplainHistoryAdapter(ComplainData.this, arrcomplain);
            complainsrecycle.setAdapter(adapter);

        }, 3000); // Delay of 3 seconds
    }
}
