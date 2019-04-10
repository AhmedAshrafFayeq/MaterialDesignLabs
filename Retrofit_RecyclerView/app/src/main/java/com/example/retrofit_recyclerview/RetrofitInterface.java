package com.example.retrofit_recyclerview;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("tutorial/jsonparsetutorial.txt")
    Call<JsonResponse> getCountries();
}
