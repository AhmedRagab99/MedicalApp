package com.example.medicalapp.Symptom;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.medicalapp.API.SymptomModel.SymptomResponse;
import com.example.medicalapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SymptomFragment extends Fragment {

    TextView textView;

    public SymptomFragment() {
        // Required empty public constructor
    }
    TextView t;

    SymptomViewModel symptomViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_symptom, container, false);
        t=(TextView) view.findViewById(R.id.test);
        symptomViewModel= ViewModelProviders.of(getActivity()).get(SymptomViewModel.class);


        return  view;
    }

    public  void subscribeToLiveData() {



    }

}
