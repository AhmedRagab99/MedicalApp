package com.example.medicalapp.API;


import com.example.medicalapp.API.DiagnosesModel.DiagnosesResponse;
import com.example.medicalapp.API.DrugModel.DrugInfoModel.DrugInfoResponse;
import com.example.medicalapp.API.DrugModel.DrugResponse;
import com.example.medicalapp.API.InferamidicaModel.AIQuastionsResponse;
import com.example.medicalapp.API.NewsModel.NewsResponse;
import com.example.medicalapp.API.SymptomModel.SymptomResponse;
import com.example.medicalapp.Constants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServices {

// Rabid Api methods
    @Headers({"RapidAPI Project:default-application_3720189",
    "X-RapidAPI-Host:priaid-symptom-checker-v1.p.rapidapi.com",
            "X-RapidAPI-Key:19254fe262msh78a558e2cc28b5ap1c14d7jsndc5a74cf5506"
    })
    @GET("symptoms")
    Call<SymptomResponse> getSymptoms(@Query("language")String language);



    @Headers({"RapidAPI Project:default-application_3720189",
            "X-RapidAPI-Host:priaid-symptom-checker-v1.p.rapidapi.com",
            "X-RapidAPI-Key:19254fe262msh78a558e2cc28b5ap1c14d7jsndc5a74cf5506"
    })
    @GET("diagnosis")
    Call<DiagnosesResponse> getDiagnoses(@Query("symptoms")int symptomArray[], @Query("gender")String gender, @Query("year_of_birth")String yearOfBirth,
                                         @Query("language")String language);





//DrugsApi
    @GET("drugs")
    Call<DrugResponse> getDrugs();

    @GET("<chembl_id>")
    Call<DrugInfoResponse>getDrugInfo(@Path("chembl_id")String chembl_idٍ);


    //InferamidecaApi

    @Headers({"App-Id:281fe9c7",
            "App-Key:648fad60ec47148a7b6a4cebdc871402",
    "Content-Type:application/json"})
    @POST("parse")
    Call<AIQuastionsResponse>getAIQueastions(@Field("text")String text);



    //NewsApi
    @GET("everything")
    Call<NewsResponse>getNews(@Query("q")String Q,@Query("from")String from,@Query("apiKey")String ApiKey);

}
