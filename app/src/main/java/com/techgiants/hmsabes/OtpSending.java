package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OtpSending extends AppCompatActivity {
 Button btnget;
 EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.otpsending);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
     btnget=findViewById(R.id.getbutton);
     number=findViewById(R.id.inputmobilenumber);
     btnget.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             if((!number.getText().toString().trim().isEmpty())){
                 if((number.getText().toString().trim().length()==10)){
                     Intent intent=new Intent(getApplicationContext(), OtpVerification.class);
                     intent.putExtra("mobile",number.getText().toString());
                     startActivity(intent);

                 }else{
                     Toast.makeText(OtpSending.this, "Please enter the correct number", Toast.LENGTH_SHORT).show();
                 }
             }else{
                 Toast.makeText(OtpSending.this, "Please Enter the number", Toast.LENGTH_SHORT).show();
             }
         }
     });
    }
}