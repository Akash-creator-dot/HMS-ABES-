package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ComplainsDetail extends AppCompatActivity {

    AutoCompleteTextView problems_related;
    EditText Complains_related_to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] problem_related_to = {
                "Fan",
                "Switch Board",
                "Bed",
                "Table",
                "Chair",
                "Paint",
                "Pests"
        };
        TextView txtcmp;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_complains_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtcmp = findViewById(R.id.complaintype);
        problems_related = findViewById(R.id.problemrelatedto_txt_auto);
        Complains_related_to = findViewById(R.id.complainsdescription);

        Intent intent = getIntent();
        String field = intent.getStringExtra("complains");
        if (field != null) {
            txtcmp.setText(field);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_dropdown_item_1line, problem_related_to);
        problems_related.setAdapter(adapter);
    }
}
