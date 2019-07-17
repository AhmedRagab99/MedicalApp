package com.example.medicalapp.Home;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.NewsModel.ArticlesItem;
import com.example.medicalapp.API.NewsModel.NewsResponse;
import com.example.medicalapp.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel  extends AndroidViewModel {
    public MutableLiveData<Boolean> showLoading=new MutableLiveData<>();
    public MutableLiveData<String> alertMessage=new MutableLiveData<>();
    public MutableLiveData<List<ArticlesItem>> articles=new MutableLiveData<>();


    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void loadNews(){
        showLoading.setValue(true);
        APIManager.getNewsApis().getNews("medical", Constants.NEWS_API)
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        if(!response.isSuccessful()){
                            System.out.println("yalaahwyy");
                            return;
                        }
                        //showLoading.setValue(false);
                        articles.setValue(response.body().getArticles());
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        //showLoading.setValue(false);
                        //alertMessage.setValue(t.getLocalizedMessage());
                        System.out.println("a7a");

                    }
                });

    }
}