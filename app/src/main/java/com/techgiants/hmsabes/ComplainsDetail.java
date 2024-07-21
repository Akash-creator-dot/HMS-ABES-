package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ComplainsDetail extends AppCompatActivity {

    AutoCompleteTextView problems_related;
    EditText Complains_related_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complains_detail);

        String[] problem_related_to = {
                "Fan",
                "Switch Board",
                "Bed",
                "Table",
                "Chair",
                "Paint",
                "Pests"
        };

        TextView txtcmp = findViewById(R.id.complaintype);
        problems_related = findViewById(R.id.problemrelatedto_txt_auto);
        Complains_related_to = findViewById(R.id.complainsdescription);
        Button btn=findViewById(R.id.complaindetailsbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ComplainsDetail.this, "Request send", Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = getIntent();
        String field = intent.getStringExtra("complains");
        if (field != null) {
            txtcmp.setText(field);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, problem_related_to);
        problems_related.setAdapter(adapter);
    }
}
