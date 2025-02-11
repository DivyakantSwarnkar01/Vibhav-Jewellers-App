package com.example.vibhavjewellersbusiness;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RateFetchWorker extends Worker {

    public RateFetchWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        // Fetch rates from API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://your-api-url.com/") // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RateApiService service = retrofit.create(RateApiService.class);
        Call<RateResponse> call = service.getRates();

        try {
            Response<RateResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
                // Save rates in SharedPreferences
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Rates", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("goldRate", (float) response.body().getGoldRate());
                editor.putFloat("silverRate", (float) response.body().getSilverRate());
                editor.apply();
                return Result.success();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.failure();
    }
}