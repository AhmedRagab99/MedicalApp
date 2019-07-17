package com.example.medicalapp.Home;
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
import android.widget.TextView;

import com.example.medicalapp.API.APIManager;
import com.example.medicalapp.API.NewsModel.ArticlesItem;
import com.example.medicalapp.API.NewsModel.NewsResponse;
import com.example.medicalapp.Base.BaseFragment;
import com.example.medicalapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    View view;
    HomeNewsAdapter adapter;
    HomeViewModel homeViewModel;
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        //initialize view Model
        homeViewModel = ViewModelProviders.of(HomeFragment.this).get(HomeViewModel.class);

        initRecyclerView(view);
        homeViewModel.loadNews();
        subscribeToLiveData();
        return view;
    }


    public void initRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        adapter = new HomeNewsAdapter();


    }

    public void subscribeToLiveData() {
        homeViewModel.articles.observe(this, new Observer<List<ArticlesItem>>() {
            @Override
            public void onChanged(List<ArticlesItem> articlesItems) {
                adapter.changeData(articlesItems);
                recyclerView.setAdapter(adapter);
            }
        });

        homeViewModel.showLoading.observe(getActivity(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean show) {
                if (show)
                    System.out.println("ifshow");
                else System.out.println("else");
                ;
            }
        });

        homeViewModel.alertMessage.observe(getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
            }
        });
    }
}




