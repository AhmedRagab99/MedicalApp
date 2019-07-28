package com.example.medicalapp.Doctors;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.DiagnosesModel.DiagnosesResponse;
import com.example.medicalapp.API.DoctorsModel.DataItem;
import com.example.medicalapp.API.DoctorsModel.DoctorResponse;
import com.example.medicalapp.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorsViewModel extends AndroidViewModel {
    public DoctorsViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<DataItem>> doctors = new MutableLiveData<>();
    public List<DataItem> temp = new ArrayList<>();

    public MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    public MutableLiveData<String> alertMessage = new MutableLiveData<>();


    public void loadDoctors(String name) {
        showLoading.setValue(true);

        APIManager.getDoctorApi().getDoctors(Constants.DOCTORAPI, name, "100").enqueue(new Callback<DoctorResponse>() {
            @Override
            public void onResponse(Call<DoctorResponse> call, Response<DoctorResponse> response) {
                if (!response.isSuccessful()) {
                    System.out.println("A7aaaaaaaaaa");
                    return;
                }

                doctors.setValue(response.body().getData());
                return;


            }

            @Override
            public void onFailure(Call<DoctorResponse> call, Throwable t) {
                System.out.println("yalllllllllllllllllllllllllllllllllla" + t.getLocalizedMessage());
            }
        });


    }
}
