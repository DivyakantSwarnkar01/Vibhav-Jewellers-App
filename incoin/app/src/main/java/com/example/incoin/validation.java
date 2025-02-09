package com.example.incoin;

import android.os.Bundle;
import android.os.Looper;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;

public class validation extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ValidatorAdapter adapter;
    private List<Validator> validatorList;
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_validation);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        validatorList = new ArrayList<>();
        adapter = new ValidatorAdapter(validatorList);
        recyclerView.setAdapter(adapter);

        loadSkeleton();
    }

    private void loadSkeleton() {
        handler.postDelayed(() -> {
            List<Validator> data = new ArrayList<>();
            data.add(new Validator("Validator 1", "PublicKey_1234"));
            data.add(new Validator("Validator 2", "PublicKey_5678"));
            data.add(new Validator("Validator 3", "PublicKey_9101"));
            adapter.setData(data);
        }, 2000);
    }
}