package com.example.medicalapp.Doctors;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicalapp.R;
import com.example.medicalapp.Symptom.SymptomAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorsFragment extends Fragment {


    DoctorsAdapter adapter;
   DoctorsViewModel doctorsViewModel;
    RecyclerView recyclerView;
    View view;

    public DoctorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view=inflater.inflate(R.layout.fragment_doctors, container, false);
        doctorsViewModel = ViewModelProviders.of(getActivity()).get(DoctorsViewModel.class);
        doctorsViewModel.loadDoctors();

         return view;
    }

}
