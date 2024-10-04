package com.techgiants.hmsabes;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;

public class Leavedata extends AppCompatActivity {
    ArrayList<LeaveHistoryStructure> arrleave = new ArrayList<>();
    LeaveHistoryAdapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leavedata);

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize RecyclerView and ShimmerLayout
        RecyclerView recyclerView = findViewById(R.id.recyclerleaves);
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Show shimmer effect for 3 seconds
        shimmerFrameLayout.startShimmer();

        // Simulate data loading with a 3-second delay
        new Handler().postDelayed(() -> {
            // Stop the shimmer effect and hide the shimmer layout
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);

            // Show the RecyclerView
            recyclerView.setVisibility(View.VISIBLE);

            // Add leave history data
            arrleave.add(new LeaveHistoryStructure("12/05/2024","2:00 PM"));
            arrleave.add(new LeaveHistoryStructure("14/05/2024","3:00 PM"));
            arrleave.add(new LeaveHistoryStructure("12/05/2024","2:00 PM"));
            arrleave.add(new LeaveHistoryStructure("14/05/2024","3:00 PM"));
            arrleave.add(new LeaveHistoryStructure("30/05/2024","2:13 PM"));
            arrleave.add(new LeaveHistoryStructure("11/06/2024","4:50 PM"));
            arrleave.add(new LeaveHistoryStructure("22/06/2024","7:20 PM"));
            arrleave.add(new LeaveHistoryStructure("31/06/2024","2:10 PM"));
            arrleave.add(new LeaveHistoryStructure("12/07/2024","3:00 PM"));
            arrleave.add(new LeaveHistoryStructure("01/08/2024","6:00 PM"));
            arrleave.add(new LeaveHistoryStructure("12/05/2024","2:00 PM"));
            arrleave.add(new LeaveHistoryStructure("14/05/2024","3:00 PM"));
            arrleave.add(new LeaveHistoryStructure("30/05/2024","2:13 PM"));
            arrleave.add(new LeaveHistoryStructure("11/06/2024","4:50 PM"));
            arrleave.add(new LeaveHistoryStructure("22/06/2024","7:20 PM"));
            arrleave.add(new LeaveHistoryStructure("31/06/2024","2:10 PM"));
            arrleave.add(new LeaveHistoryStructure("12/07/2024","3:00 PM"));
            arrleave.add(new LeaveHistoryStructure("01/08/2024","6:00 PM"));

            // Initialize adapter and set it to RecyclerView
            adapter = new LeaveHistoryAdapter(Leavedata.this, arrleave);
            recyclerView.setAdapter(adapter);
        }, 3000); // 3-second delay
    }
}
