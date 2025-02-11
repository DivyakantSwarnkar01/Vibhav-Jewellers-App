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

        // Find the CardViews by their IDs
        CardView newGoldCard = findViewById(R.id.cardView); // First card (New Gold)
        CardView oldGoldCard = findViewById(R.id.cardView2); // Second card (Old Gold)
        CardView newSilverCard = findViewById(R.id.cardView3); // Third card (New Silver)
        CardView oldSilverCard = findViewById(R.id.cardView4); // Fourth card (Old Silver)


        // Set an OnClickListener on the New Gold CardView
        newGoldCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open NewGoldRate activity
                Intent intent = new Intent(MainActivity.this, NewGoldRate.class);
                startActivity(intent); // Start the new activity
            }
        });

        // Set an OnClickListener on the Old Gold CardView
        oldGoldCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open OldGoldRate activity
                Intent intent = new Intent(MainActivity.this, OldGoldRate.class);
                startActivity(intent); // Start the new activity
            }
        });

        // Set an OnClickListener on the New Silver CardView
        newSilverCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open NewSilverRate activity
                Intent intent = new Intent(MainActivity.this, NewSilverRate.class);
                startActivity(intent); // Start the new activity
            }
        });

        // Set an OnClickListener on the Old Silver CardView
        oldSilverCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Create an Intent to open OldSilverRate activity
                Intent intent = new Intent(MainActivity.this, OldSilverRate.class);
                startActivity(intent); // Start the new activity
            }
        });

            }
}