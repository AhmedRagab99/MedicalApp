package com.example.medicalapp.Diagnoses;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.medicalapp.API.DiagnosesModel.DiagnosesResponse;
import com.example.medicalapp.R;
import com.example.medicalapp.Symptom.SymptomAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiagnosesFragment extends Fragment {

    List<String> checkedSymptoms = new ArrayList<>();

    public DiagnosesFragment(List<String> checkedSymptoms) {
        this.checkedSymptoms = checkedSymptoms;
    }
    public DiagnosesFragment(){}
    DiagnosesViewModel diagnosesViewModel;
   DiagnosesAdapter adapter;
    RecyclerView recyclerView;
    ImageView diago;
    ConstraintLayout notfound;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_diagnoses, container, false);
        diago=view.findViewById(R.id.diagoimge);
        notfound=view.findViewById(R.id.notfound);
        diagnosesViewModel= ViewModelProviders.of(this).get(DiagnosesViewModel.class);
        initRecyclerView(view);
        diagnosesViewModel.loadDiadnoses(this.checkedSymptoms);
        subscribeToLiveData();
//        if(this.checkedSymptoms.isEmpty()||adapter.diagnoses.isEmpty() ){
//            diago.setVisibility(View.GONE);
//            recyclerView.setVisibility(View.GONE);
//        }
//           else if(adapter.diagnoses==null){
//            diago.setVisibility(View.GONE);
//            recyclerView.setVisibility(View.GONE);
//        }
//        else  notfound.setVisibility(View.VISIBLE);
//        if(this.checkedSymptoms.size()!=0){
//        System.out.println(adapter.getItemCount()+"///"+adapter.diagnoses.size());
//            if(adapter.getItemCount()!=0)
//            notfound.setVisibility(View.GONE);
//            else {
//                diago.setVisibility(View.GONE);
//                recyclerView.setVisibility(View.GONE);
//            }
//        }
//        else {
//            diago.setVisibility(View.GONE);
//            recyclerView.setVisibility(View.GONE);
//        }
//
//            //notfound.setVisibility(View.GONE);

        return  view;
    }



    public void subscribeToLiveData() {
        diagnosesViewModel.Diagnoses.observe(this, new Observer<List<DiagnosesResponse>>() {
            @Override
            public void onChanged(List<DiagnosesResponse> diagnosesResponses) {
                if(diagnosesResponses==null) System.out.println("ppppppppp");

                adapter = new DiagnosesAdapter(diagnosesResponses);

                System.out.println(adapter.diagnoses.size()+".........................");
                recyclerView.setAdapter(adapter);
            }
        });

    }


    public void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.diagnosesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


    }


}
