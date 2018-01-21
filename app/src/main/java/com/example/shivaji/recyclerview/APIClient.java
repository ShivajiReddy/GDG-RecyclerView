package com.example.shivaji.recyclerview;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class APIClient{
    private Retrofit retrofit;
    private String baseURL = "https://api.myjson.com/";

    public APIInterface getAPIInterface() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(baseURL).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(APIInterface.class);
    }

    public interface APIInterface{
        @GET("bins/r4q95")
        Call<DataList> getData();
    }
}