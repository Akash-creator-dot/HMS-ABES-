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
        arrgroundabb.add(new RoomnumberStracture("G-01-B-01"));
        arrgroundabb.add(new RoomnumberStracture("G-01-B-02"));
        arrgroundabb.add(new RoomnumberStracture("G-01-B-03"));
        arrgroundabb.add(new RoomnumberStracture("G-01-S"));
        arrgroundabb.add(new RoomnumberStracture("G-01-H"));
        arrgroundabb.add(new RoomnumberStracture("G-02-B-01"));
        arrgroundabb.add(new RoomnumberStracture("G-02-B-02"));
        arrgroundabb.add(new RoomnumberStracture("G-02-B-03"));
        arrgroundabb.add(new RoomnumberStracture("G-02-S"));
        arrgroundabb.add(new RoomnumberStracture("G-02-H"));

        arrfirstabb.add(new RoomnumberStracture("F-01-B-01"));
        arrfirstabb.add(new RoomnumberStracture("F-01-B-02"));
        arrfirstabb.add(new RoomnumberStracture("F-01-B-03"));
        arrfirstabb.add(new RoomnumberStracture("F-01-S"));
        arrfirstabb.add(new RoomnumberStracture("F-01-H"));
        arrfirstabb.add(new RoomnumberStracture("F-02-B-01"));
        arrfirstabb.add(new RoomnumberStracture("F-02-B-01"));
        arrfirstabb.add(new RoomnumberStracture("F-02-B-01"));
        arrfirstabb.add(new RoomnumberStracture("F-02-S"));
        arrfirstabb.add(new RoomnumberStracture("F-02-H"));

        arrsecondabb.add(new RoomnumberStracture("S-01-B-01"));
        arrsecondabb.add(new RoomnumberStracture("S-01-B-02"));
        arrsecondabb.add(new RoomnumberStracture("S-01-B-03"));
        arrsecondabb.add(new RoomnumberStracture("S-01-S"));
        arrsecondabb.add(new RoomnumberStracture("S-01-H"));
        arrsecondabb.add(new RoomnumberStracture("S-02-B-01"));
        arrsecondabb.add(new RoomnumberStracture("S-02-B-01"));
        arrsecondabb.add(new RoomnumberStracture("S-02-B-01"));
        arrsecondabb.add(new RoomnumberStracture("S-02-S"));
        arrsecondabb.add(new RoomnumberStracture("S-02-H"));

        arrthirdabb.add(new RoomnumberStracture("T-01-B-01"));
        arrthirdabb.add(new RoomnumberStracture("T-01-B-02"));
        arrthirdabb.add(new RoomnumberStracture("T-01-B-03"));
        arrthirdabb.add(new RoomnumberStracture("T-01-S"));
        arrthirdabb.add(new RoomnumberStracture("T-01-H"));
        arrthirdabb.add(new RoomnumberStracture("T-02-B-01"));
        arrthirdabb.add(new RoomnumberStracture("T-02-B-01"));
        arrthirdabb.add(new RoomnumberStracture("T-02-B-01"));
        arrthirdabb.add(new RoomnumberStracture("T-02-S"));
        arrthirdabb.add(new RoomnumberStracture("T-02-H"));

        arrgroundvkb.add(new RoomnumberStracture("G-01"));
        arrgroundvkb.add(new RoomnumberStracture("G-02"));
        arrgroundvkb.add(new RoomnumberStracture("G-03"));
        arrgroundvkb.add(new RoomnumberStracture("G-04"));
        arrgroundvkb.add(new RoomnumberStracture("G-05"));
        arrgroundvkb.add(new RoomnumberStracture("G-06"));
        arrgroundvkb.add(new RoomnumberStracture("G-07"));
        arrgroundvkb.add(new RoomnumberStracture("G-08"));
        arrgroundvkb.add(new RoomnumberStracture("G-09"));
        arrgroundvkb.add(new RoomnumberStracture("G-10"));
        arrgroundvkb.add(new RoomnumberStracture("G-11"));
        arrgroundvkb.add(new RoomnumberStracture("G-12"));
        arrgroundvkb.add(new RoomnumberStracture("G-13"));
        arrgroundvkb.add(new RoomnumberStracture("G-14"));
        arrgroundvkb.add(new RoomnumberStracture("G-15"));
        arrgroundvkb.add(new RoomnumberStracture("G-16"));
        arrgroundvkb.add(new RoomnumberStracture("G-17"));
        arrgroundvkb.add(new RoomnumberStracture("G-18"));
        arrgroundvkb.add(new RoomnumberStracture("G-19"));
        arrgroundvkb.add(new RoomnumberStracture("G-20"));
        arrgroundvkb.add(new RoomnumberStracture("G-21"));
        arrgroundvkb.add(new RoomnumberStracture("G-22"));
        arrgroundvkb.add(new RoomnumberStracture("G-23"));
        arrgroundvkb.add(new RoomnumberStracture("G-24"));
        arrgroundvkb.add(new RoomnumberStracture("G-25"));
        arrgroundvkb.add(new RoomnumberStracture("G-26"));
        arrgroundvkb.add(new RoomnumberStracture("G-27"));
        arrgroundvkb.add(new RoomnumberStracture("G-28"));
        arrgroundvkb.add(new RoomnumberStracture("G-29"));
        arrgroundvkb.add(new RoomnumberStracture("G-30"));

        arrfirstvkb.add(new RoomnumberStracture("F-01"));
        arrfirstvkb.add(new RoomnumberStracture("F-02"));
        arrfirstvkb.add(new RoomnumberStracture("F-03"));
        arrfirstvkb.add(new RoomnumberStracture("F-04"));
        arrfirstvkb.add(new RoomnumberStracture("F-05"));
        arrfirstvkb.add(new RoomnumberStracture("F-06"));
        arrfirstvkb.add(new RoomnumberStracture("F-07"));
        arrfirstvkb.add(new RoomnumberStracture("F-08"));
        arrfirstvkb.add(new RoomnumberStracture("F-09"));
        arrfirstvkb.add(new RoomnumberStracture("F-10"));
        arrfirstvkb.add(new RoomnumberStracture("F-11"));
        arrfirstvkb.add(new RoomnumberStracture("F-12"));
        arrfirstvkb.add(new RoomnumberStracture("F-13"));
        arrfirstvkb.add(new RoomnumberStracture("F-14"));
        arrfirstvkb.add(new RoomnumberStracture("F-15"));
        arrfirstvkb.add(new RoomnumberStracture("F-16"));
        arrfirstvkb.add(new RoomnumberStracture("F-17"));
        arrfirstvkb.add(new RoomnumberStracture("F-18"));
        arrfirstvkb.add(new RoomnumberStracture("F-19"));
        arrfirstvkb.add(new RoomnumberStracture("F-20"));
        arrfirstvkb.add(new RoomnumberStracture("F-21"));
        arrfirstvkb.add(new RoomnumberStracture("F-22"));
        arrfirstvkb.add(new RoomnumberStracture("F-23"));
        arrfirstvkb.add(new RoomnumberStracture("F-24"));
        arrfirstvkb.add(new RoomnumberStracture("F-25"));
        arrfirstvkb.add(new RoomnumberStracture("F-26"));
        arrfirstvkb.add(new RoomnumberStracture("F-27"));
        arrfirstvkb.add(new RoomnumberStracture("F-28"));
        arrfirstvkb.add(new RoomnumberStracture("F-29"));
        arrfirstvkb.add(new RoomnumberStracture("F-30"));

        arrsecondvkb.add(new RoomnumberStracture("S-01"));
        arrsecondvkb.add(new RoomnumberStracture("S-02"));
        arrsecondvkb.add(new RoomnumberStracture("S-03"));
        arrsecondvkb.add(new RoomnumberStracture("S-04"));
        arrsecondvkb.add(new RoomnumberStracture("S-05"));
        arrsecondvkb.add(new RoomnumberStracture("S-06"));
        arrsecondvkb.add(new RoomnumberStracture("S-07"));
        arrsecondvkb.add(new RoomnumberStracture("S-08"));
        arrsecondvkb.add(new RoomnumberStracture("S-09"));
        arrsecondvkb.add(new RoomnumberStracture("S-10"));
        arrsecondvkb.add(new RoomnumberStracture("S-11"));
        arrsecondvkb.add(new RoomnumberStracture("S-12"));
        arrsecondvkb.add(new RoomnumberStracture("S-13"));
        arrsecondvkb.add(new RoomnumberStracture("S-14"));
        arrsecondvkb.add(new RoomnumberStracture("S-15"));
        arrsecondvkb.add(new RoomnumberStracture("S-16"));
        arrsecondvkb.add(new RoomnumberStracture("S-17"));
        arrsecondvkb.add(new RoomnumberStracture("S-18"));
        arrsecondvkb.add(new RoomnumberStracture("S-19"));
        arrsecondvkb.add(new RoomnumberStracture("S-20"));
        arrsecondvkb.add(new RoomnumberStracture("S-21"));
        arrsecondvkb.add(new RoomnumberStracture("S-22"));
        arrsecondvkb.add(new RoomnumberStracture("S-23"));
        arrsecondvkb.add(new RoomnumberStracture("S-24"));
        arrsecondvkb.add(new RoomnumberStracture("S-25"));
        arrsecondvkb.add(new RoomnumberStracture("S-26"));
        arrsecondvkb.add(new RoomnumberStracture("S-27"));
        arrsecondvkb.add(new RoomnumberStracture("S-28"));
        arrsecondvkb.add(new RoomnumberStracture("S-29"));
        arrsecondvkb.add(new RoomnumberStracture("S-30"));

        arrthirdvkv.add(new RoomnumberStracture("T-01"));
        arrthirdvkv.add(new RoomnumberStracture("T-02"));
        arrthirdvkv.add(new RoomnumberStracture("T-03"));
        arrthirdvkv.add(new RoomnumberStracture("T-04"));
        arrthirdvkv.add(new RoomnumberStracture("T-05"));
        arrthirdvkv.add(new RoomnumberStracture("T-06"));
        arrthirdvkv.add(new RoomnumberStracture("T-07"));
        arrthirdvkv.add(new RoomnumberStracture("T-08"));
        arrthirdvkv.add(new RoomnumberStracture("T-09"));
        arrthirdvkv.add(new RoomnumberStracture("T-10"));
        arrthirdvkv.add(new RoomnumberStracture("T-11"));
        arrthirdvkv.add(new RoomnumberStracture("T-12"));
        arrthirdvkv.add(new RoomnumberStracture("T-13"));
        arrthirdvkv.add(new RoomnumberStracture("T-14"));
        arrthirdvkv.add(new RoomnumberStracture("T-15"));
        arrthirdvkv.add(new RoomnumberStracture("T-16"));
        arrthirdvkv.add(new RoomnumberStracture("T-17"));
        arrthirdvkv.add(new RoomnumberStracture("T-18"));
        arrthirdvkv.add(new RoomnumberStracture("T-19"));
        arrthirdvkv.add(new RoomnumberStracture("T-20"));
        arrthirdvkv.add(new RoomnumberStracture("T-21"));
        arrthirdvkv.add(new RoomnumberStracture("T-22"));
        arrthirdvkv.add(new RoomnumberStracture("T-23"));
        arrthirdvkv.add(new RoomnumberStracture("T-24"));
        arrthirdvkv.add(new RoomnumberStracture("T-25"));
        arrthirdvkv.add(new RoomnumberStracture("T-26"));
        arrthirdvkv.add(new RoomnumberStracture("T-27"));
        arrthirdvkv.add(new RoomnumberStracture("T-28"));
        arrthirdvkv.add(new RoomnumberStracture("T-29"));
        arrthirdvkv.add(new RoomnumberStracture("T-30"));
        arrgroundckb.add(new RoomnumberStracture("G-01-B-01"));
        arrgroundckb.add(new RoomnumberStracture("G-01-B-02"));
        arrgroundckb.add(new RoomnumberStracture("G-01-B-03"));
        arrgroundckb.add(new RoomnumberStracture("G-01-S"));
        arrgroundckb.add(new RoomnumberStracture("G-01-H"));
        arrgroundckb.add(new RoomnumberStracture("G-02-B-01"));
        arrgroundckb.add(new RoomnumberStracture("G-02-B-02"));
        arrgroundckb.add(new RoomnumberStracture("G-02-B-03"));
        arrgroundckb.add(new RoomnumberStracture("G-02-S"));
        arrgroundckb.add(new RoomnumberStracture("G-02-H"));

        arrfirstckb.add(new RoomnumberStracture("F-01-B-01"));
        arrfirstckb.add(new RoomnumberStracture("F-01-B-02"));
        arrfirstckb.add(new RoomnumberStracture("F-01-B-03"));
        arrfirstckb.add(new RoomnumberStracture("F-01-S"));
        arrfirstckb.add(new RoomnumberStracture("F-01-H"));
        arrfirstckb.add(new RoomnumberStracture("F-02-B-01"));
        arrfirstckb.add(new RoomnumberStracture("F-02-B-01"));
        arrfirstckb.add(new RoomnumberStracture("F-02-B-01"));
        arrfirstckb.add(new RoomnumberStracture("F-02-S"));
        arrfirstckb.add(new RoomnumberStracture("F-02-H"));

        arrsecondckb.add(new RoomnumberStracture("S-01-B-01"));
        arrsecondckb.add(new RoomnumberStracture("S-01-B-02"));
        arrsecondckb.add(new RoomnumberStracture("S-01-B-03"));
        arrsecondckb.add(new RoomnumberStracture("S-01-S"));
        arrsecondckb.add(new RoomnumberStracture("S-01-H"));
        arrsecondckb.add(new RoomnumberStracture("S-02-B-01"));
        arrsecondckb.add(new RoomnumberStracture("S-02-B-01"));
        arrsecondckb.add(new RoomnumberStracture("S-02-B-01"));
        arrsecondckb.add(new RoomnumberStracture("S-02-S"));
        arrsecondckb.add(new RoomnumberStracture("S-02-H"));

        arrthirdckb.add(new RoomnumberStracture("T-01-B-01"));
        arrthirdckb.add(new RoomnumberStracture("T-01-B-02"));
        arrthirdckb.add(new RoomnumberStracture("T-01-B-03"));
        arrthirdckb.add(new RoomnumberStracture("T-01-S"));
        arrthirdckb.add(new RoomnumberStracture("T-01-H"));
        arrthirdckb.add(new RoomnumberStracture("T-02-B-01"));
        arrthirdckb.add(new RoomnumberStracture("T-02-B-01"));
        arrthirdckb.add(new RoomnumberStracture("T-02-B-01"));
        arrthirdckb.add(new RoomnumberStracture("T-02-S"));
        arrthirdckb.add(new RoomnumberStracture("T-02-H"));

        arrgrounddnb.add(new RoomnumberStracture("G-01"));
        arrgrounddnb.add(new RoomnumberStracture("G-02"));
        arrgrounddnb.add(new RoomnumberStracture("G-03"));
        arrgrounddnb.add(new RoomnumberStracture("G-04"));
        arrgrounddnb.add(new RoomnumberStracture("G-05"));
        arrgrounddnb.add(new RoomnumberStracture("G-06"));
        arrgrounddnb.add(new RoomnumberStracture("G-07"));
        arrgrounddnb.add(new RoomnumberStracture("G-08"));
        arrgrounddnb.add(new RoomnumberStracture("G-09"));
        arrgrounddnb.add(new RoomnumberStracture("G-10"));
        arrgrounddnb.add(new RoomnumberStracture("G-11"));
        arrgrounddnb.add(new RoomnumberStracture("G-12"));
        arrgrounddnb.add(new RoomnumberStracture("G-13"));
        arrgrounddnb.add(new RoomnumberStracture("G-14"));
        arrgrounddnb.add(new RoomnumberStracture("G-15"));
        arrgrounddnb.add(new RoomnumberStracture("G-16"));
        arrgrounddnb.add(new RoomnumberStracture("G-17"));
        arrgrounddnb.add(new RoomnumberStracture("G-18"));
        arrgrounddnb.add(new RoomnumberStracture("G-19"));
        arrgrounddnb.add(new RoomnumberStracture("G-20"));
        arrgrounddnb.add(new RoomnumberStracture("G-21"));
        arrgrounddnb.add(new RoomnumberStracture("G-22"));
        arrgrounddnb.add(new RoomnumberStracture("G-23"));
        arrgrounddnb.add(new RoomnumberStracture("G-24"));
        arrgrounddnb.add(new RoomnumberStracture("G-25"));
        arrgrounddnb.add(new RoomnumberStracture("G-26"));
        arrgrounddnb.add(new RoomnumberStracture("G-27"));
        arrgrounddnb.add(new RoomnumberStracture("G-28"));
        arrgrounddnb.add(new RoomnumberStracture("G-29"));
        arrgrounddnb.add(new RoomnumberStracture("G-30"));

        arrfirstdnb.add(new RoomnumberStracture("F-01"));
        arrfirstdnb.add(new RoomnumberStracture("F-02"));
        arrfirstdnb.add(new RoomnumberStracture("F-03"));
        arrfirstdnb.add(new RoomnumberStracture("F-04"));
        arrfirstdnb.add(new RoomnumberStracture("F-05"));
        arrfirstdnb.add(new RoomnumberStracture("F-06"));
        arrfirstdnb.add(new RoomnumberStracture("F-07"));
        arrfirstdnb.add(new RoomnumberStracture("F-08"));
        arrfirstdnb.add(new RoomnumberStracture("F-09"));
        arrfirstdnb.add(new RoomnumberStracture("F-10"));
        arrfirstdnb.add(new RoomnumberStracture("F-11"));
        arrfirstdnb.add(new RoomnumberStracture("F-12"));
        arrfirstdnb.add(new RoomnumberStracture("F-13"));
        arrfirstdnb.add(new RoomnumberStracture("F-14"));
        arrfirstdnb.add(new RoomnumberStracture("F-15"));
        arrfirstdnb.add(new RoomnumberStracture("F-16"));
        arrfirstdnb.add(new RoomnumberStracture("F-17"));
        arrfirstdnb.add(new RoomnumberStracture("F-18"));
        arrfirstdnb.add(new RoomnumberStracture("F-19"));
        arrfirstdnb.add(new RoomnumberStracture("F-20"));
        arrfirstdnb.add(new RoomnumberStracture("F-21"));
        arrfirstdnb.add(new RoomnumberStracture("F-22"));
        arrfirstdnb.add(new RoomnumberStracture("F-23"));
        arrfirstdnb.add(new RoomnumberStracture("F-24"));
        arrfirstdnb.add(new RoomnumberStracture("F-25"));
        arrfirstdnb.add(new RoomnumberStracture("F-26"));
        arrfirstdnb.add(new RoomnumberStracture("F-27"));
        arrfirstdnb.add(new RoomnumberStracture("F-28"));
        arrfirstdnb.add(new RoomnumberStracture("F-29"));
        arrfirstdnb.add(new RoomnumberStracture("F-30"));

        arrseconddnb.add(new RoomnumberStracture("S-01"));
        arrseconddnb.add(new RoomnumberStracture("S-02"));
        arrseconddnb.add(new RoomnumberStracture("S-03"));
        arrseconddnb.add(new RoomnumberStracture("S-04"));
        arrseconddnb.add(new RoomnumberStracture("S-05"));
        arrseconddnb.add(new RoomnumberStracture("S-06"));
        arrseconddnb.add(new RoomnumberStracture("S-07"));
        arrseconddnb.add(new RoomnumberStracture("S-08"));
        arrseconddnb.add(new RoomnumberStracture("S-09"));
        arrseconddnb.add(new RoomnumberStracture("S-10"));
        arrseconddnb.add(new RoomnumberStracture("S-11"));
        arrseconddnb.add(new RoomnumberStracture("S-12"));
        arrseconddnb.add(new RoomnumberStracture("S-13"));
        arrseconddnb.add(new RoomnumberStracture("S-14"));
        arrseconddnb.add(new RoomnumberStracture("S-15"));
        arrseconddnb.add(new RoomnumberStracture("S-16"));
        arrseconddnb.add(new RoomnumberStracture("S-17"));
        arrseconddnb.add(new RoomnumberStracture("S-18"));
        arrseconddnb.add(new RoomnumberStracture("S-19"));
        arrseconddnb.add(new RoomnumberStracture("S-20"));
        arrseconddnb.add(new RoomnumberStracture("S-21"));
        arrseconddnb.add(new RoomnumberStracture("S-22"));
        arrseconddnb.add(new RoomnumberStracture("S-23"));
        arrseconddnb.add(new RoomnumberStracture("S-24"));
        arrseconddnb.add(new RoomnumberStracture("S-25"));
        arrseconddnb.add(new RoomnumberStracture("S-26"));
        arrseconddnb.add(new RoomnumberStracture("S-27"));
        arrseconddnb.add(new RoomnumberStracture("S-28"));
        arrseconddnb.add(new RoomnumberStracture("S-29"));
        arrseconddnb.add(new RoomnumberStracture("S-30"));

        arrthirddnb.add(new RoomnumberStracture("T-01"));
        arrthirddnb.add(new RoomnumberStracture("T-02"));
        arrthirddnb.add(new RoomnumberStracture("T-03"));
        arrthirddnb.add(new RoomnumberStracture("T-04"));
        arrthirddnb.add(new RoomnumberStracture("T-05"));
        arrthirddnb.add(new RoomnumberStracture("T-06"));
        arrthirddnb.add(new RoomnumberStracture("T-07"));
        arrthirddnb.add(new RoomnumberStracture("T-08"));
        arrthirddnb.add(new RoomnumberStracture("T-09"));
        arrthirddnb.add(new RoomnumberStracture("T-10"));
        arrthirddnb.add(new RoomnumberStracture("T-11"));
        arrthirddnb.add(new RoomnumberStracture("T-12"));
        arrthirddnb.add(new RoomnumberStracture("T-13"));
        arrthirddnb.add(new RoomnumberStracture("T-14"));
        arrthirddnb.add(new RoomnumberStracture("T-15"));
        arrthirddnb.add(new RoomnumberStracture("T-16"));
        arrthirddnb.add(new RoomnumberStracture("T-17"));
        arrthirddnb.add(new RoomnumberStracture("T-18"));
        arrthirddnb.add(new RoomnumberStracture("T-19"));
        arrthirddnb.add(new RoomnumberStracture("T-20"));
        arrthirddnb.add(new RoomnumberStracture("T-21"));
        arrthirddnb.add(new RoomnumberStracture("T-22"));
        arrthirddnb.add(new RoomnumberStracture("T-23"));
        arrthirddnb.add(new RoomnumberStracture("T-24"));
        arrthirddnb.add(new RoomnumberStracture("T-25"));
        arrthirddnb.add(new RoomnumberStracture("T-26"));
        arrthirddnb.add(new RoomnumberStracture("T-27"));
        arrthirddnb.add(new RoomnumberStracture("T-28"));
        arrthirddnb.add(new RoomnumberStracture("T-29"));
        arrthirddnb.add(new RoomnumberStracture("T-30"));
    }
}
