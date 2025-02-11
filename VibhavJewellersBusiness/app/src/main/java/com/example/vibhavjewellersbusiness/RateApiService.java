package com.example.vibhavjewellersbusiness;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RateApiService {
    @GET("rates") // Replace with your API endpoint
    Call<RateResponse> getRates();
}