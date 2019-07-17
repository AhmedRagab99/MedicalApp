package com.example.medicalapp.Drugs;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicalapp.R;

public class DrugFragment extends Fragment {


    DrugsViewModel drugsViewModel;
    public DrugFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_drug, container, false);

        drugsViewModel= ViewModelProviders.of(this).get(DrugsViewModel.class);
      //  drugsViewModel.loadDrugs();
        drugsViewModel.loadDrugInfo("CHEMBL1237026");

        return view;
    }


}
