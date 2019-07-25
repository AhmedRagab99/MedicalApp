package com.example.medicalapp.Doctors;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.DiagnosesModel.DiagnosesResponse;
import com.example.medicalapp.API.DoctorsModel.DataItem;
import com.example.medicalapp.API.DoctorsModel.DoctorResponse;
import com.example.medicalapp.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorsViewModel extends AndroidViewModel {
    public DoctorsViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<DataItem>> doctors=new MutableLiveData<>();
    public MutableLiveData<Boolean> showLoading=new MutableLiveData<>();
    public MutableLiveData<String> alertMessage=new MutableLiveData<>();


public void loadDoctors(){
    showLoading.setValue(true);
    APIManager.getDoctorApi().getDoctors(Constants.DOCTORAPI,"clara").enqueue(new Callback<DoctorResponse>() {
        @Override
        public void onResponse(Call<DoctorResponse> call, Response<DoctorResponse> response) {
            if (!response.isSuccessful()){
                System.out.println("A7aaaaaaaaaa");
                return;
            }
            doctors.setValue(response.body().getData());
            System.out.println("Yaaaaaaa"+response.body().getData().get(0).getProfile().getFirstName());



        }

        @Override
        public void onFailure(Call<DoctorResponse> call, Throwable t) {
            System.out.println("yalllllllllllllllllllllllllllllllllla"+t.getLocalizedMessage());
        }
    });
}
}
