package com.example.medicalapp.Diagnoses;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicalapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiagnosesFragment extends Fragment {


    public DiagnosesFragment() {
        // Required empty public constructor
    }

    DiagnosesViewModel diagnosesViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_diagnoses, container, false);

        diagnosesViewModel= ViewModelProviders.of(this).get(DiagnosesViewModel.class);
        diagnosesViewModel.loadDiadnoses();

    return  view;
    }

}
