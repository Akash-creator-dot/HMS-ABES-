package com.techgiants.hmsabes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ComplainData extends AppCompatActivity {
    ArrayList<ComplainHistoryStructure> arrcomplain = new ArrayList<>();
    ComplainHistoryAdapter adapter;
    RecyclerView complainsrecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaindata);

        // Initialize RecyclerView
        complainsrecycle = findViewById(R.id.recyclerComplains);
        complainsrecycle.setLayoutManager(new LinearLayoutManager(this));

        // Add sample data to the ArrayList
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
        adapter = new ComplainHistoryAdapter(this, arrcomplain);
        complainsrecycle.setAdapter(adapter);
    }
}
