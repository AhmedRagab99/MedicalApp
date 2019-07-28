package com.example.medicalapp.Doctors;


import android.os.Bundle;

import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;

import com.example.medicalapp.API.DoctorsModel.DataItem;
import com.example.medicalapp.HomeActivity;
import com.example.medicalapp.R;
import com.example.medicalapp.Symptom.SymptomAdapter;

import java.util.ArrayList;
import java.util.List;


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
    Button searchbtn ;
    SearchView searchview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_doctors, container, false);
        searchview=view.findViewById(R.id.dr_searchView);
        doctorsViewModel = ViewModelProviders.of(getActivity()).get(DoctorsViewModel.class);
        doctorsViewModel.loadDoctors("a");
        initRecyclerView(view);
        subscribeToLiveData();
         return view;
    }

    public void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.doctor_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


    }

    public void subscribeToLiveData() {

        doctorsViewModel.doctors.observe(this, new Observer<List<DataItem>>() {
            @Override
            public void onChanged(List<DataItem> dataItems) {
                adapter=new DoctorsAdapter(dataItems,DoctorsFragment.this);
                recyclerView.setAdapter(adapter);
            }
        });
    }



    @Override
    public void onStart() {
        super.onStart();

        searchview.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                adapter.setDoctors(adapter.sesrcDoctors);
                return false;
            }
        });
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                doctorsViewModel.loadDoctors(query);
                doctorsViewModel.doctors.observe(DoctorsFragment.this, new Observer<List<DataItem>>() {
                    @Override
                    public void onChanged(List<DataItem> dataItems) {
                        adapter.setDoctors(dataItems);
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                doctorsViewModel.loadDoctors(newText);
                doctorsViewModel.doctors.observe(DoctorsFragment.this, new Observer<List<DataItem>>() {
                    @Override
                    public void onChanged(List<DataItem> dataItems) {
                        adapter.setDoctors(dataItems);
                    }
                });
                return false;
            }
        });
    }




}
