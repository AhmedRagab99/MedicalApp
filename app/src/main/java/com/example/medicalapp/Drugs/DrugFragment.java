package com.example.medicalapp.Drugs;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicalapp.API.DrugModel.DrugResponse;
import com.example.medicalapp.R;
import com.google.android.material.tabs.TabLayout;

public class DrugFragment extends Fragment {

    TabLayout tabLayout;
    RecyclerView recyclerView;
    DrugsAdapter Adapter;
    Context context;
    DrugsViewModel drugsViewModel;

    String pageNumber;

    public DrugFragment(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drug_small, container, false);
        //Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        //context.setSupportActionBar(toolbar);
        //initialize view Model

        tabLayout = view.findViewById(R.id.dr_tablayout);
        drugsViewModel = ViewModelProviders.of(this).get(DrugsViewModel.class);
        drugsViewModel.loadDrugs(pageNumber);
        initRecyclerView(view);
        //drugsViewModel.loadDrugInfo("CHEMBL1237026");

        subscribeToLiveData();
        return view;
    }


    public void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setHasFixedSize(true);


    }

    public void subscribeToLiveData() {

        drugsViewModel.Drug.observe(this, new Observer<DrugResponse>() {
            @Override
            public void onChanged(DrugResponse drugResponse) {
                Adapter = new DrugsAdapter(drugResponse.getRecords(), getContext());
                recyclerView.setAdapter(Adapter);
                //setTabLayoutWithNewsSources();

            }
        });
    }


//    private void setTabLayoutWithNewsSources() {
//        for (int i = 1; i <= 20; i++) {
//            final TabLayout.Tab tab = tabLayout.newTab();
//            tab.setText(" Page " + i + " ");
//            tab.setTag(drugsViewModel.loadDrugs(String.valueOf(i)));
//            tabLayout.addTab(tab);
//
//        }

}
