package com.example.vibhavjewellersbusiness;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NewGoldRate extends AppCompatActivity {

    // UI Components
    private EditText weightInput, purityInput, gstInput;
    private TextView priceValue;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_gold_rate);

        // Initialize UI components
        weightInput = findViewById(R.id.weightInput);
        purityInput = findViewById(R.id.makingChargeInput); // Your custom ID
        gstInput = findViewById(R.id.gstInput);
        priceValue = findViewById(R.id.priceValue);
        calculateButton = findViewById(R.id.calculateButton);

        // Set default purity to 100%
        purityInput.setText("100");
        gstInput.setText("10"); // <-- Default value added here

        // Set click listener
        calculateButton.setOnClickListener(v -> calculatePrice());
    }

    private void calculatePrice() {
        // Get input values
        String weightStr = weightInput.getText().toString().trim();
        String purityStr = purityInput.getText().toString().trim();
        String gstStr = gstInput.getText().toString().trim();

        // Validate empty fields
        if (weightStr.isEmpty() || purityStr.isEmpty() || gstStr.isEmpty()) {
            priceValue.setText("कृपया सभी फ़ील्ड भरें");
            return;
        }

        try {
            // Parse values
            double weight = Double.parseDouble(weightStr);
            double purity = Double.parseDouble(purityStr);
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
            if (gst < 0 || gst > 100) {
                priceValue.setText("GST 0-100% के बीच होना चाहिए");
                return;
            }

            // Calculation Logic
            double goldRatePerGram = 84000.0 / 10; // ₹8,400 per gram
            double pureValue = weight * goldRatePerGram * (purity / 100);
            double totalPrice = pureValue * (1 + (gst / 100));

            // Display result
            priceValue.setText(String.format("₹%,.2f", totalPrice));

        } catch (NumberFormatException e) {
            priceValue.setText("अमान्य संख्या प्रारूप");
        }
    }
}