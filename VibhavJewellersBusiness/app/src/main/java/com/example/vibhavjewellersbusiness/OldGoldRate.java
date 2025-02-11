package com.example.vibhavjewellersbusiness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OldGoldRate extends AppCompatActivity {

    // UI Components
    private EditText weightInput, purityInput, discountInput, gstInput;
    private TextView priceValue;
    private Button calculateButton;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_gold_rate);

        // Initialize UI components
        weightInput = findViewById(R.id.weightInput);
        purityInput = findViewById(R.id.purityInput);
        discountInput = findViewById(R.id.discountInput);
        gstInput = findViewById(R.id.gstInput);
        priceValue = findViewById(R.id.priceValue);
        calculateButton = findViewById(R.id.calculateButton);
        backButton = findViewById(R.id.backButton);

        // Set default values
        purityInput.setText("60");
        discountInput.setText("0");
        gstInput.setText("0");

        // Set click listener for calculate button
        calculateButton.setOnClickListener(v -> calculatePrice());

        // Set click listener for back button
        backButton.setOnClickListener(v -> {
            // Navigate back to MainActivity
            startActivity(new Intent(OldGoldRate.this, MainActivity.class));
            finish(); // Close the current activity
        });
    }

    private void calculatePrice() {
        // Get input values
        String weightStr = weightInput.getText().toString().trim();
        String purityStr = purityInput.getText().toString().trim();
        String discountStr = discountInput.getText().toString().trim();
        String gstStr = gstInput.getText().toString().trim();

        // Validate empty fields
        if (weightStr.isEmpty() || purityStr.isEmpty() || discountStr.isEmpty() || gstStr.isEmpty()) {
            priceValue.setText("कृपया सभी फ़ील्ड भरें");
            return;
        }

        try {
            // Parse values
            double weight = Double.parseDouble(weightStr);
            double purity = Double.parseDouble(purityStr);
            double discount = Double.parseDouble(discountStr);
            double gst = Double.parseDouble(gstStr);

            // Validate ranges
            if (weight <= 0) {
                priceValue.setText("वजन शून्य से अधिक होना चाहिए");
                return;
            }
            if (purity <= 0 || purity > 100) {
                priceValue.setText("शुद्धता 0-100% के बीच होनी चाहिए");
                return;
            }
            if (discount < 0 || discount > 100) {
                priceValue.setText("छूट 0-100% के बीच होनी चाहिए");
                return;
            }
            if (gst < 0 || gst > 100) {
                priceValue.setText("GST 0-100% के बीच होना चाहिए");
                return;
            }

            // Calculation logic
            double currentGoldRate = 84000.0 / 10; // ₹8400 per gram
            double discountedRate = currentGoldRate * (1 - (discount / 100)); // Apply discount
            double pureValue = weight * discountedRate * (purity / 100); // Adjust for purity
            double totalPrice = pureValue * (1 + (gst / 100)); // Add GST

            // Display result
            priceValue.setText(String.format("₹%,.2f", totalPrice));

        } catch (NumberFormatException e) {
            priceValue.setText("अमान्य संख्या प्रारूप");
        }
    }
}