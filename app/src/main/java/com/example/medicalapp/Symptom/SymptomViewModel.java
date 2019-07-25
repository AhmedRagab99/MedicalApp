package com.example.medicalapp.Symptom;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.SymptomModel.SymptomResponse;
import com.example.medicalapp.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SymptomViewModel extends AndroidViewModel {



    public MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    public MutableLiveData<String> alertMessage = new MutableLiveData<>();
    public MutableLiveData<List<SymptomResponse>> symptom = new MutableLiveData<>();

    public SymptomViewModel(@NonNull Application application) {
        super(application);
    }


    public void loadSymptom() {
        showLoading.setValue(true);

        APIManager.getSymptomChkerApis().getSymptoms(Constants.Language).enqueue(new Callback<List<SymptomResponse>>() {
            @Override
            public void onResponse(Call<List<SymptomResponse>> call, Response<List<SymptomResponse>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("a7aaaa");
                    return;
                }
                System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
                symptom.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SymptomResponse>> call, Throwable t) {
                System.out.println("hahahhahahahhahahahahahahah");
            }

        });

    }

}