package com.example.medicalapp.Doctors;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.medicalapp.API.DoctorsModel.DataItem;
import com.example.medicalapp.R;
import com.example.medicalapp.viewPager;
import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class doctor_details extends Fragment {

    TextView name;
    private ViewPager mViewPager;
    viewPager drugViewPager;
    DataItem  dataItem;
    public doctor_details(DataItem  dataItem) {
        this.dataItem=dataItem;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_doctor_details, container, false);
        name=view.findViewById(R.id.dr_name2);
        mViewPager = (ViewPager) view.findViewById(R.id.page_container);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.dr_tablayout);
        name.setText(dataItem.getProfile().getSlug());
        setupViewPager(mViewPager);
        tabLayout.setupWithViewPager(mViewPager);
        return  view;
    }
    private void setupViewPager(ViewPager viewPager) {
        drugViewPager = new viewPager(getChildFragmentManager());
        drugViewPager.addFragment(new dr_small_details(dataItem), " Doctor's info");
        //drugViewPager.addFragment(new DrugFragment(String.valueOf(i)), " "+String.valueOf(i)+" ");
        viewPager.setAdapter(drugViewPager);
    }

}
