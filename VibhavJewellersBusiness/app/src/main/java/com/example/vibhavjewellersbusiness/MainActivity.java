package com.example.vibhavjewellersbusiness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Link the layout file

        // Find the CardView by its ID
        CardView cardView = findViewById(R.id.cardView);

        // Set an OnClickListener on the CardView
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open NewGoldRate activity
                Intent intent = new Intent(MainActivity.this, NewGoldRate.class);
                startActivity(intent); // Start the new activity
            }
        });
    }
}