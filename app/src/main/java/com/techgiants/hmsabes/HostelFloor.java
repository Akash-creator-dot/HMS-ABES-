package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HostelFloor extends AppCompatActivity {
 CardView cardgf,cardff,cardsf,cardtf;
 TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hostel_floor);
        cardgf=findViewById(R.id.allotmentfloordetailsgfcrd);
        cardff=findViewById(R.id.allotmentfloordetailsffcrd);
        cardsf=findViewById(R.id.allotmentfloordetailssfcrd);
        cardtf=findViewById(R.id.allotmentfloordetailstfcrd);
        txt=findViewById(R.id.allotmentfloordetailsgftxt);
        Intent iNext=new Intent(this,HostelFloorDetail.class);
        Intent card=getIntent();
        String car=card.getStringExtra("card");
        cardgf.setOnClickListener(new View.OnClickListener() {
            String str=txt.getText().toString();
            public void onClick(View v) {
                iNext.putExtra("floor",car);
                iNext.putExtra("txt", "Ground Floor");
                startActivity(iNext);
            }
        });
        cardff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iNext.putExtra("floor",car);
                iNext.putExtra("txt","First Floor");
                startActivity(iNext);
            }
        });
        cardsf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iNext.putExtra("floor",car);
                iNext.putExtra("txt","Second Floor");
                startActivity(iNext);
            }
        });
        cardtf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iNext.putExtra("floor",car);
                iNext.putExtra("txt","Third Floor");
                startActivity(iNext);
            }
        });
    }
}