package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class
HostelFloorDetail extends AppCompatActivity {
    ArrayList<RoomnumberStracture> arrgroundabb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrfirstabb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrsecondabb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrthirdabb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrgroundvkb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrfirstvkb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrsecondvkb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrthirdvkv = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrgroundckb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrfirstckb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrsecondckb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrthirdckb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrgrounddnb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrfirstdnb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrseconddnb = new ArrayList<>();
    ArrayList<RoomnumberStracture> arrthirddnb= new ArrayList<>();
    RoomDetailsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hostel_floor_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        RecyclerView recycleContact = findViewById(R.id.recycont);
        recycleContact.setLayoutManager(new LinearLayoutManager(this));

        // Initialize room number data for different floors
        initializeRoomData();

        Intent intent = getIntent();
        String card=intent.getStringExtra("floor");
        String str = intent.getStringExtra("txt");
        if(card.equals("abb")) {
            if (str.equals("Ground Floor")) {
                adapter = new RoomDetailsAdapter(this, arrgroundabb);
            } else if (str.equals("First Floor")) {
                adapter = new RoomDetailsAdapter(this, arrfirstabb);
            } else if (str.equals("Second Floor")) {
                adapter = new RoomDetailsAdapter(this, arrsecondabb);
            } else {
                adapter = new RoomDetailsAdapter(this, arrthirdabb);
            }

            recycleContact.setAdapter(adapter);
        } else if (card.equals("vkb")) {
            if (str.equals("Ground Floor")) {
                adapter = new RoomDetailsAdapter(this, arrgroundvkb);
            } else if (str.equals("First Floor")) {
                adapter = new RoomDetailsAdapter(this, arrfirstvkb);
            } else if (str.equals("Second Floor")) {
                adapter = new RoomDetailsAdapter(this, arrsecondvkb);
            } else {
                adapter = new RoomDetailsAdapter(this, arrthirdvkv);
            }

            recycleContact.setAdapter(adapter);
        } else if (card.equals("ckb")) {
            if (str.equals("Ground Floor")) {
                adapter = new RoomDetailsAdapter(this, arrgroundckb);
            } else if (str.equals("First Floor")) {
                adapter = new RoomDetailsAdapter(this, arrfirstckb);
            } else if (str.equals("Second Floor")) {
                adapter = new RoomDetailsAdapter(this, arrsecondckb);
            } else {
                adapter = new RoomDetailsAdapter(this, arrthirdckb);
            }

            recycleContact.setAdapter(adapter);
        } else if (card.equals("rkb")) {
            if (str.equals("Ground Floor")) {
                adapter = new RoomDetailsAdapter(this, arrgrounddnb);
            } else if (str.equals("First Floor")) {
                adapter = new RoomDetailsAdapter(this, arrfirstdnb);
            } else if (str.equals("Second Floor")) {
                adapter = new RoomDetailsAdapter(this, arrseconddnb);
            } else {
                adapter = new RoomDetailsAdapter(this, arrthirddnb);
            }

            recycleContact.setAdapter(adapter);
        }
    }

    private void initializeRoomData() {
        arrgroundabb.add(new RoomnumberStracture("G-01-B-01","0 Vacant","3 Seater"));
        arrgroundabb.add(new RoomnumberStracture("G-01-B-02","0 Vacant","3 Seater"));
        arrgroundabb.add(new RoomnumberStracture("G-01-B-03","0 Vacant","3 Seater"));
        arrgroundabb.add(new RoomnumberStracture("G-01-S","0 Vacant","1 Seater"));
        arrgroundabb.add(new RoomnumberStracture("G-01-H","0 Vacant","2 Seater"));
        arrgroundabb.add(new RoomnumberStracture("G-02-B-01","0 Vacant","3 Seater"));
        arrgroundabb.add(new RoomnumberStracture("G-02-B-02","0 Vacant","3 Seater"));
        arrgroundabb.add(new RoomnumberStracture("G-02-B-03","0 Vacant","3 Seater"));
        arrgroundabb.add(new RoomnumberStracture("G-02-S","0 Vacant","1 Seater"));
        arrgroundabb.add(new RoomnumberStracture("G-02-H","0 Vacant","2 Seater"));

        arrfirstabb.add(new RoomnumberStracture("F-01-B-01","0 Vacant","3 Seater"));
        arrfirstabb.add(new RoomnumberStracture("F-01-B-02","0 Vacant","3 Seater"));
        arrfirstabb.add(new RoomnumberStracture("F-01-B-03","0 Vacant","3 Seater"));
        arrfirstabb.add(new RoomnumberStracture("F-01-S","0 Vacant","1 Seater"));
        arrfirstabb.add(new RoomnumberStracture("F-01-H","0 Vacant","2 Seater"));
        arrfirstabb.add(new RoomnumberStracture("F-02-B-01","0 Vacant","3 Seater"));
        arrfirstabb.add(new RoomnumberStracture("F-02-B-01","0 Vacant","3 Seater"));
        arrfirstabb.add(new RoomnumberStracture("F-02-B-01","0 Vacant","3 Seater"));
        arrfirstabb.add(new RoomnumberStracture("F-02-S","0 Vacant","1 Seater"));
        arrfirstabb.add(new RoomnumberStracture("F-02-H","0 Vacant","2 Seater"));

        arrsecondabb.add(new RoomnumberStracture("S-01-B-01","0 Vacant","3 Seater"));
        arrsecondabb.add(new RoomnumberStracture("S-01-B-02","0 Vacant","3 Seater"));
        arrsecondabb.add(new RoomnumberStracture("S-01-B-03","0 Vacant","3 Seater"));
        arrsecondabb.add(new RoomnumberStracture("S-01-S","0 Vacant","1 Seater"));
        arrsecondabb.add(new RoomnumberStracture("S-01-H","0 Vacant","2 Seater"));
        arrsecondabb.add(new RoomnumberStracture("S-02-B-01","0 Vacant","3 Seater"));
        arrsecondabb.add(new RoomnumberStracture("S-02-B-01","0 Vacant","3 Seater"));
        arrsecondabb.add(new RoomnumberStracture("S-02-B-01","0 Vacant","3 Seater"));
        arrsecondabb.add(new RoomnumberStracture("S-02-S","0 Vacant","1 Seater"));
        arrsecondabb.add(new RoomnumberStracture("S-02-H","0 Vacant","2 Seater"));

        arrthirdabb.add(new RoomnumberStracture("T-01-B-01","0 Vacant","3 Seater"));
        arrthirdabb.add(new RoomnumberStracture("T-01-B-02","0 Vacant","3 Seater"));
        arrthirdabb.add(new RoomnumberStracture("T-01-B-03","0 Vacant","3 Seater"));
        arrthirdabb.add(new RoomnumberStracture("T-01-S","0 Vacant","1 Seater"));
        arrthirdabb.add(new RoomnumberStracture("T-01-H","0 Vacant","2 Seater"));
        arrthirdabb.add(new RoomnumberStracture("T-02-B-01","0 Vacant","3 Seater"));
        arrthirdabb.add(new RoomnumberStracture("T-02-B-01","0 Vacant","3 Seater"));
        arrthirdabb.add(new RoomnumberStracture("T-02-B-01","0 Vacant","3 Seater"));
        arrthirdabb.add(new RoomnumberStracture("T-02-S","0 Vacant","1 Seater"));
        arrthirdabb.add(new RoomnumberStracture("T-02-H","0 Vacant","2 Seater"));

        arrgroundvkb.add(new RoomnumberStracture("G-01","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-02","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-03","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-04","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-05","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-06","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-07","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-08","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-09","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-10","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-11","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-12","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-13","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-14","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-15","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-16","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-17","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-18","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-19","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-20","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-21","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-22","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-23","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-24","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-25","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-26","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-27","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-28","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-29","0 Vacant","4 Seater"));
        arrgroundvkb.add(new RoomnumberStracture("G-30","0 Vacant","4 Seater"));

        arrfirstvkb.add(new RoomnumberStracture("F-01","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-02","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-03","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-04","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-05","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-06","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-07","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-08","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-09","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-10","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-11","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-12","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-13","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-14","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-15","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-16","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-17","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-18","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-19","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-20","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-21","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-22","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-23","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-24","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-25","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-26","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-27","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-28","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-29","0 Vacant","4 Seater"));
        arrfirstvkb.add(new RoomnumberStracture("F-30","0 Vacant","4 Seater"));

        arrsecondvkb.add(new RoomnumberStracture("S-01","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-02","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-03","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-04","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-05","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-06","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-07","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-08","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-09","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-10","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-11","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-12","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-13","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-14","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-15","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-16","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-17","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-18","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-19","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-20","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-21","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-22","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-23","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-24","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-25","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-26","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-27","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-28","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-29","0 Vacant","4 Seater"));
        arrsecondvkb.add(new RoomnumberStracture("S-30","0 Vacant","4 Seater"));

        arrthirdvkv.add(new RoomnumberStracture("T-01","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-02","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-03","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-04","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-05","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-06","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-07","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-08","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-09","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-10","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-11","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-12","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-13","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-14","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-15","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-16","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-17","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-18","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-19","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-20","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-21","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-22","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-23","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-24","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-25","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-26","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-27","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-28","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-29","0 Vacant","4 Seater"));
        arrthirdvkv.add(new RoomnumberStracture("T-30","0 Vacant","4 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-01-B-01","0 Vacant","3 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-01-B-02","0 Vacant","3 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-01-B-03","0 Vacant","3 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-01-S","0 Vacant","1 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-01-H","0 Vacant","2 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-02-B-01","0 Vacant","3 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-02-B-02","0 Vacant","3 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-02-B-03","0 Vacant","3 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-02-S","0 Vacant","1 Seater"));
        arrgroundckb.add(new RoomnumberStracture("G-02-H","0 Vacant","2 Seater"));

        arrfirstckb.add(new RoomnumberStracture("F-01-B-01","0 Vacant","3 Seater"));
        arrfirstckb.add(new RoomnumberStracture("F-01-B-02","0 Vacant","3 Seater"));
        arrfirstckb.add(new RoomnumberStracture("F-01-B-03","0 Vacant","3 Seater"));
        arrfirstckb.add(new RoomnumberStracture("F-01-S","0 Vacant","1 Seater"));
        arrfirstckb.add(new RoomnumberStracture("F-01-H","0 Vacant","2 Seater"));
        arrfirstckb.add(new RoomnumberStracture("F-02-B-01","0 Vacant","3 Seater"));
        arrfirstckb.add(new RoomnumberStracture("F-02-B-01","0 Vacant","3 Seater"));
        arrfirstckb.add(new RoomnumberStracture("F-02-B-01","0 Vacant","3 Seater"));
        arrfirstckb.add(new RoomnumberStracture("F-02-S","0 Vacant","1 Seater"));
        arrfirstckb.add(new RoomnumberStracture("F-02-H","0 Vacant","2 Seater"));

        arrsecondckb.add(new RoomnumberStracture("S-01-B-01","0 Vacant","3 Seater"));
        arrsecondckb.add(new RoomnumberStracture("S-01-B-02","0 Vacant","3 Seater"));
        arrsecondckb.add(new RoomnumberStracture("S-01-B-03","0 Vacant","3 Seater"));
        arrsecondckb.add(new RoomnumberStracture("S-01-S","0 Vacant","1 Seater"));
        arrsecondckb.add(new RoomnumberStracture("S-01-H","0 Vacant","2 Seater"));
        arrsecondckb.add(new RoomnumberStracture("S-02-B-01","0 Vacant","3 Seater"));
        arrsecondckb.add(new RoomnumberStracture("S-02-B-01","0 Vacant","3 Seater"));
        arrsecondckb.add(new RoomnumberStracture("S-02-B-01","0 Vacant","3 Seater"));
        arrsecondckb.add(new RoomnumberStracture("S-02-S","0 Vacant","1 Seater"));
        arrsecondckb.add(new RoomnumberStracture("S-02-H","0 Vacant","2 Seater"));

        arrthirdckb.add(new RoomnumberStracture("T-01-B-01","0 Vacant","3 Seater"));
        arrthirdckb.add(new RoomnumberStracture("T-01-B-02","0 Vacant","3 Seater"));
        arrthirdckb.add(new RoomnumberStracture("T-01-B-03","0 Vacant","3 Seater"));
        arrthirdckb.add(new RoomnumberStracture("T-01-S","0 Vacant","1 Seater"));
        arrthirdckb.add(new RoomnumberStracture("T-01-H","0 Vacant","2 Seater"));
        arrthirdckb.add(new RoomnumberStracture("T-02-B-01","0 Vacant","3 Seater"));
        arrthirdckb.add(new RoomnumberStracture("T-02-B-01","0 Vacant","3 Seater"));
        arrthirdckb.add(new RoomnumberStracture("T-02-B-01","0 Vacant","3 Seater"));
        arrthirdckb.add(new RoomnumberStracture("T-02-S","0 Vacant","1 Seater"));
        arrthirdckb.add(new RoomnumberStracture("T-02-H","0 Vacant","2 Seater"));

        arrgrounddnb.add(new RoomnumberStracture("G-01","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-02","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-03","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-04","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-05","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-06","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-07","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-08","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-09","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-10","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-11","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-12","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-13","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-14","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-15","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-16","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-17","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-18","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-19","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-20","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-21","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-22","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-23","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-24","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-25","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-26","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-27","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-28","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-29","0 Vacant","2 Seater"));
        arrgrounddnb.add(new RoomnumberStracture("G-30","0 Vacant","2 Seater"));

        arrfirstdnb.add(new RoomnumberStracture("F-01","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-02","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-03","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-04","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-05","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-06","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-07","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-08","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-09","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-10","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-11","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-12","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-13","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-14","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-15","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-16","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-17","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-18","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-19","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-20","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-21","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-22","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-23","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-24","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-25","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-26","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-27","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-28","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-29","0 Vacant","2 Seater"));
        arrfirstdnb.add(new RoomnumberStracture("F-30","0 Vacant","2 Seater"));

        arrseconddnb.add(new RoomnumberStracture("S-01","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-02","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-03","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-04","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-05","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-06","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-07","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-08","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-09","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-10","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-11","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-12","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-13","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-14","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-15","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-16","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-17","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-18","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-19","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-20","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-21","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-22","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-23","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-24","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-25","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-26","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-27","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-28","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-29","0 Vacant","2 Seater"));
        arrseconddnb.add(new RoomnumberStracture("S-30","0 Vacant","2 Seater"));

        arrthirddnb.add(new RoomnumberStracture("T-01","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-02","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-03","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-04","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-05","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-06","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-07","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-08","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-09","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-10","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-11","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-12","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-13","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-14","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-15","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-16","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-17","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-18","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-19","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-20","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-21","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-22","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-23","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-24","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-25","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-26","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-27","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-28","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-29","0 Vacant","2 Seater"));
        arrthirddnb.add(new RoomnumberStracture("T-30","0 Vacant","2 Seater"));
    }
}
