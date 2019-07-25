package com.example.medicalapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.DrugModel.DrugResponse;
import com.example.medicalapp.Diagnoses.DiagnosesFragment;
import com.example.medicalapp.Doctors.DoctorsFragment;
import com.example.medicalapp.Drugs.DrugFragment;
import com.example.medicalapp.Drugs.DrugParentFragment;
import com.example.medicalapp.Home.HomeFragment;
import com.example.medicalapp.Symptom.SymptomFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = new HomeFragment();

            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    fragment = new HomeFragment();
                    break;
                }
                case R.id.navigation_dashboard: {
                    fragment = new DrugParentFragment();
                    break;
                }
                case R.id.navigation_notifications: {
                    fragment = new DiagnosesFragment();
                    break;
                }

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.setSelectedItemId(R.id.navigation_home);
    }


}

