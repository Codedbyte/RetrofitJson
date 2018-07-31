package com.codedbyte.retrofitjson;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    public static String BASE_URL = "https://restcountries.eu/rest/v2/";

    @GET("all")
    Call<ArrayList<Model>> getCountry();
}
