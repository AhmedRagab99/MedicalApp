package com.example.medicalapp.Diagnoses;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.DiagnosesModel.DiagnosesResponse;
import com.example.medicalapp.Constants;

import org.json.JSONArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiagnosesViewModel extends AndroidViewModel {
    public MutableLiveData<List<DiagnosesResponse>> Diagnoses=new MutableLiveData<>();
    public MutableLiveData<Boolean> showLoading=new MutableLiveData<>();
    public MutableLiveData<String> alertMessage=new MutableLiveData<>();
    public DiagnosesViewModel(@NonNull Application application) {
        super(application);
    }
    public void loadDiadnoses(){

        JSONArray arr = new JSONArray();
        arr.put(29);
        arr.put(11);

        APIManager.getSymptomChkerApis().getDiagnoses(arr,"male",1984, Constants.Language).enqueue(new Callback<List<DiagnosesResponse>>() {
            @Override
            public void onResponse(Call<List<DiagnosesResponse>> call, Response<List<DiagnosesResponse>> response) {
                if(!response.isSuccessful()){
                    System.out.println("a7a");
                    return;
                }
                System.out.println("HEREEEE"+response.body().get(0).getIssue().getName());
            }

            @Override
            public void onFailure(Call<List<DiagnosesResponse>> call, Throwable t) {
                System.out.println("yalaaaheweeeeeeeeeeeeeeeeeeeeeeeee"+t.getLocalizedMessage());
            }
        });
    }

}
