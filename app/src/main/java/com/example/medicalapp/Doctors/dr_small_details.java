package com.example.medicalapp.Doctors;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.medicalapp.API.DoctorsModel.DataItem;
import com.example.medicalapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class dr_small_details extends Fragment {

    TextView name;
    DataItem dataItem;
    public dr_small_details(DataItem dataItem) {
        this.dataItem=dataItem;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dr_small_details, container, false);
        name =view.findViewById(R.id.drname_view);
        name.setText(dataItem.getProfile().getSlug());
        return view;
    }

}
