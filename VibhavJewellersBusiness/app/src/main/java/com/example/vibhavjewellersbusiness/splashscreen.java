package com.example.vibhavjewellersbusiness;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        // Delay for 2 seconds (2000 milliseconds)
        new Handler().postDelayed(() -> {
            // Start MainActivity after the delay
            Intent intent = new Intent(splashscreen.this, MainActivity.class);
            startActivity(intent);
            finish(); // Close the SplashActivity
        }, 2000);

    }
}