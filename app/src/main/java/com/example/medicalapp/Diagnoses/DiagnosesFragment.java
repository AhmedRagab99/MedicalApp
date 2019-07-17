package com.example.medicalapp.Diagnoses;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.medicalapp.API.DiagnosesModel.DiagnosesResponse;
import com.example.medicalapp.R;
import com.example.medicalapp.Symptom.SymptomAdapter;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiagnosesFragment extends Fragment {


    public DiagnosesFragment() {
        // Required empty public constructor
    }

    DiagnosesViewModel diagnosesViewModel;
   DiagnosesAdapter adapter;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_diagnoses, container, false);

        diagnosesViewModel= ViewModelProviders.of(this).get(DiagnosesViewModel.class);
        initRecyclerView(view);
        diagnosesViewModel.loadDiadnoses();
        subscribeToLiveData();
    return  view;
    }



    public void subscribeToLiveData() {
        diagnosesViewModel.Diagnoses.observe(this, new Observer<List<DiagnosesResponse>>() {
            @Override
            public void onChanged(List<DiagnosesResponse> diagnosesResponses) {
                adapter.changeData(diagnosesResponses);
                recyclerView.setAdapter(adapter);
            }
        });

    }


    public void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.diagnosesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter = new DiagnosesAdapter();


    }


}
