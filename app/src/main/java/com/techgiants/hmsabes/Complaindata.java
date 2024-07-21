package com.techgiants.hmsabes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Complaindata extends AppCompatActivity {
    ArrayList<ComplainHistoryStracture> arrcomplain = new ArrayList<>();
    ComplainHistoryAdapter adapter;
    RecyclerView complainsrecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaindata);

        // Initialize RecyclerView
        complainsrecycle = findViewById(R.id.recyclercomplains);
        complainsrecycle.setLayoutManager(new LinearLayoutManager(this));

        // Add sample data to the ArrayList
        arrcomplain.add(new ComplainHistoryStracture("12/05/2024", "Carpenter"));
        arrcomplain.add(new ComplainHistoryStracture("14/05/2024", "Electrician"));
        arrcomplain.add(new ComplainHistoryStracture("30/05/2024", "Plumber"));
        arrcomplain.add(new ComplainHistoryStracture("11/06/2024", "Pest Control"));
        arrcomplain.add(new ComplainHistoryStracture("22/06/2024", "Sweeper"));
        arrcomplain.add(new ComplainHistoryStracture("31/06/2024", "Carpenter"));
        arrcomplain.add(new ComplainHistoryStracture("12/07/2024", "Electrician"));
        arrcomplain.add(new ComplainHistoryStracture("01/08/2024", "Plumber"));
        arrcomplain.add(new ComplainHistoryStracture("12/08/2024", "Carpenter"));
        arrcomplain.add(new ComplainHistoryStracture("14/08/2024", "Electrician"));
        arrcomplain.add(new ComplainHistoryStracture("30/08/2024", "Plumber"));
        arrcomplain.add(new ComplainHistoryStracture("11/09/2024", "Pest Control"));
        arrcomplain.add(new ComplainHistoryStracture("22/09/2024", "Sweeper"));
        arrcomplain.add(new ComplainHistoryStracture("31/09/2024", "Carpenter"));
        arrcomplain.add(new ComplainHistoryStracture("12/10/2024", "Electrician"));
        arrcomplain.add(new ComplainHistoryStracture("01/10/2024", "Plumber"));

        // Initialize adapter and set it to RecyclerView
        adapter = new ComplainHistoryAdapter(this, arrcomplain);
        complainsrecycle.setAdapter(adapter);
    }
}
