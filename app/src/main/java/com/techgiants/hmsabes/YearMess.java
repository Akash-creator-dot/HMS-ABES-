package com.techgiants.hmsabes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class YearMess extends AppCompatActivity {
    CardView cardFirst, cardThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_year_mess);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cardFirst = findViewById(R.id.cardcommonmessmenufirst);
        cardThird = findViewById(R.id.cardcommonmessmenuthird);

        cardFirst.setOnClickListener(v -> {
            Intent intent = new Intent(YearMess.this, MessMenu.class);
            intent.putExtra("Year", "First");
            startActivity(intent);
        });

        cardThird.setOnClickListener(v -> {
            Intent intent = new Intent(YearMess.this, MessMenu.class);
            intent.putExtra("Year", "Third");
            startActivity(intent);
        });
    }
}
