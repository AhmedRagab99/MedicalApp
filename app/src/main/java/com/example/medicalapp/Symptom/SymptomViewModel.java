package com.example.medicalapp.Symptom;

import android.app.Application;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.SymptomModel.SymptomResponse;
import com.example.medicalapp.Constants;
import com.example.medicalapp.R;
import android.app.Application;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.SymptomModel.SymptomResponse;
import com.example.medicalapp.API.SymptomModel.SymptomResponse;
import com.example.medicalapp.Constants;
import com.example.medicalapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class SymptomViewModel extends AndroidViewModel {

    public SymptomViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<SymptomResponse>> symptom = new MutableLiveData<>();
    public MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    public MutableLiveData<String> alertMessage = new MutableLiveData<>();
    View view;




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