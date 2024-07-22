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
        Button btn = findViewById(R.id.complaindetailsbtn);

        Intent intent = getIntent();
        String field = intent.getStringExtra("complains");
        if (field != null) {
            txtcmp.setText(field);
        }
        String gmail = intent.getStringExtra("gmail");
        String adm = intent.getStringExtra("adm");
        String pass = intent.getStringExtra("pass");
        String room = intent.getStringExtra("room");
        String dept = intent.getStringExtra("dept");
        String block = intent.getStringExtra("block");
        String name = intent.getStringExtra("name");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction("com.techgiants.admin.RECEIVE_DATA");
//                intent.setPackage("com.techgiants.admin");
//                intent.putExtra("gmail", gmail);
//                intent.putExtra("adm", adm);
//                intent.putExtra("pass", pass);
//                intent.putExtra("room", room);
//                intent.putExtra("dept", dept);
//                intent.putExtra("block", block);
//                intent.putExtra("name", name);
//                intent.putExtra("type", problems_related.getText().toString());
//                intent.putExtra("description", Complains_related_to.getText().toString());
//                startActivity(intent);
                Toast.makeText(ComplainsDetail.this, "The Request has been sent", Toast.LENGTH_SHORT).show();
            }
        });

        // Now you can use these variables as needed in your activity

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, problem_related_to);
        problems_related.setAdapter(adapter);
    }
}
