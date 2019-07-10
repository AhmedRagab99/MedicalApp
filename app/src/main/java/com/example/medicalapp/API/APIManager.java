package com.example.medicalapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIManager {
    private static Retrofit retrofit;

    public static Retrofit getInstance(){

        if(retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static WebServices getApis(){
        return  getInstance().create(WebServices.class);
    }
}
