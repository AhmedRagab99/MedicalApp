package com.example.medicalapp.Symptom;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicalapp.API.NewsModel.ArticlesItem;
import com.example.medicalapp.API.SymptomModel.SymptomResponse;
import com.example.medicalapp.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SymptomFragment extends Fragment {

    SymptomAdapter adapter;
    SymptomViewModel symptomViewModel;
    RecyclerView recyclerView;

    public SymptomFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_symptom, container, false);

        symptomViewModel = ViewModelProviders.of(SymptomFragment.this).get(SymptomViewModel.class);
        initRecyclerView(view);
        symptomViewModel.loadSymptom();
        subscribeToLiveData();
        return view;
    }


    public void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.symptom_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter = new SymptomAdapter();


    }

    public void subscribeToLiveData() {
        symptomViewModel.symptom.observe(this, new Observer<List<SymptomResponse>>() {
            @Override
            public void onChanged(List<SymptomResponse> symptomResponses) {
                adapter.Changed(symptomResponses);
                recyclerView.setAdapter(adapter);
            }
        });

    }
}