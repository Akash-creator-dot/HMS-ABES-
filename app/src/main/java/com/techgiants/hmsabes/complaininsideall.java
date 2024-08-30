package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class complaininsideall extends AppCompatActivity {
    Spinner spinner;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> electrician=new ArrayList<>();
        ArrayList<String> carpanter=new ArrayList<>();
        ArrayList<String> plumber=new ArrayList<>();
        ArrayList<String> welder=new ArrayList<>();
        electrician.add("Select Type");
        electrician.add("Switch Board");
        electrician.add("Water Heater");
        electrician.add("Fan");
        electrician.add("Regulator");
        electrician.add("Air Conditioner");
        electrician.add("Tube Light");
        electrician.add("Others");
        carpanter.add("Select Type");
        carpanter.add("Bed");
        carpanter.add("Chair");
        carpanter.add("Table");
        carpanter.add("Window");
        carpanter.add("Door");
        carpanter.add("Window Glass");
        carpanter.add("Door Upper Glass");
        carpanter.add("Others");
        plumber.add("Select Type");
        plumber.add("Flush");
        plumber.add("Jet");
        plumber.add("Commod");
        plumber.add("Others");
        welder.add("Select Type");
        welder.add("Almirah");
        welder.add("Chair");
        welder.add("Others");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_complaininsideall);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt=findViewById(R.id.txtcmp);
        spinner=findViewById(R.id.spinner);
        Intent intent=getIntent();
        ArrayAdapter<String> id;
        String type=intent.getStringExtra("complains");
        txt.setText(type);
        if(type.equals("Electrician")){
           id=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,electrician);
        }
        else if(type.equals("Carpanter")){
            id=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,carpanter);
        }
        else if(type.equals("Plumber")){
            id=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,plumber);
        }
        else{
           id=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,welder);
        }
        spinner.setAdapter(id);
    }
}