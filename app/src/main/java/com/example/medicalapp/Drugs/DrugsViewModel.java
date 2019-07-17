package com.example.medicalapp.Drugs;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.DrugModel.DrugInfoModel.DrugInfoResponse;
import com.example.medicalapp.API.DrugModel.DrugResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrugsViewModel  extends AndroidViewModel {
    public DrugsViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<DrugResponse> Drug = new MutableLiveData<>();
    public MutableLiveData<Boolean> showLoading = new MutableLiveData<>();
    public MutableLiveData<String> alertMessage = new MutableLiveData<>();
    public MutableLiveData<DrugInfoResponse>drugInfo=new MutableLiveData<>();
    public void loadDrugs() {
        showLoading.setValue(true);
        APIManager.getDrugApi().getDrugs("2","40").enqueue(new Callback<DrugResponse>() {
            @Override
            public void onResponse(Call<DrugResponse> call, Response<DrugResponse> response) {
                if (!response.isSuccessful()) {
                    System.out.println("a7aaaaaaaaaaa");
                    return;
                }
                System.out.println("heeeeere" + response.body().getRecords().get(25).getName());
            }

            @Override
            public void onFailure(Call<DrugResponse> call, Throwable t) {
                System.out.println("yalllllllllllllllllllllllllla"+t.getLocalizedMessage());
            }
        });


    }
    public void loadDrugInfo(String drugId){
        APIManager.getDrugApi().getDrugInfo(drugId).enqueue(new Callback<DrugInfoResponse>() {
            @Override
            public void onResponse(Call<DrugInfoResponse> call, Response<DrugInfoResponse> response) {
                if(!response.isSuccessful()){
                    System.out.println("a7aaaaaaaaaaaaaa");
                    return;
                }
                System.out.println("yaaaaaaaaaaaaaaa"+response.body().getAttributes().get(1).getName());

            }

            @Override
            public void onFailure(Call<DrugInfoResponse> call, Throwable t) {

                System.out.println("yallll"+t.getLocalizedMessage());

            }
        });
    }

}