package com.techgiants.hmsabes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class HelpandSupport extends AppCompatActivity {
    ArrayList<String> arrsubject=new ArrayList<>();
    Button helpsend;
    EditText helpcomment;
    Spinner subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_helpand_support);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        arrsubject.add("Related to UI");
        arrsubject.add("Related to Backend");
        arrsubject.add("Related to Desing");
        arrsubject.add("Suggestions");
        arrsubject.add("Others");
        helpcomment = findViewById(R.id.helptext);
        subject = findViewById(R.id.spinner);
        helpsend = findViewById(R.id.helpsendbtn);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrsubject);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        subject.setAdapter(adapter);
        helpsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent igmail=new Intent();
                String emailSubject = subject.getSelectedItem().toString();
                String emailBody = helpcomment.getText().toString();
                igmail.setAction(Intent.ACTION_SEND);
                igmail.setType("message/rfc822");
                igmail.putExtra(Intent.EXTRA_EMAIL,new String[]{"akashsolanki926@gmail.com"});
                igmail.putExtra(Intent.EXTRA_SUBJECT,emailSubject);
                igmail.putExtra(Intent.EXTRA_TEXT,emailBody);
                startActivity(Intent.createChooser(igmail,"via Email"));
            }
        });
    }
}
