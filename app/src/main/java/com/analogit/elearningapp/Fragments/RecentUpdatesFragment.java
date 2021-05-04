package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.RecentUpdateModel;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.NewAdapter.RecentUpdatesRecyclerAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecentUpdatesFragment extends Fragment {

    RecyclerView recyclerView;
    View v;
    ArrayList<RecentUpdateModel> arrayList = new ArrayList<>();
    API REST_CLIENT;
    ProgressBar progressBar;

    public RecentUpdatesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_recent_updates, container, false);
        recyclerView = v.findViewById(R.id.rec_recent_updates);
        progressBar = v.findViewById(R.id.recent_pro_one);
        REST_CLIENT = RestClient.get();
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        Call<List<RecentUpdateModel>> call = REST_CLIENT.getRecentUpadte();
        call.enqueue(new Callback<List<RecentUpdateModel>>() {
            List<RecentUpdateModel> recentUpdateModelList;
            RecentUpdateModel recentUpdateModelMap;

            @Override
            public void onResponse(Call<List<RecentUpdateModel>> call, Response<List<RecentUpdateModel>> response) {

                recentUpdateModelList = response.body();
                progressBar.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                    for (int i = 0; i < recentUpdateModelList.size(); i++) {
                        recentUpdateModelMap = recentUpdateModelList.get(i);
                        arrayList.add(new RecentUpdateModel(recentUpdateModelMap.getId(), recentUpdateModelMap.getUpdate(), recentUpdateModelMap.getName(), recentUpdateModelMap.getImage()));
                    }
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
                RecentUpdatesRecyclerAdapter recentUpdatesRecyclerAdapter = new RecentUpdatesRecyclerAdapter(getContext(), arrayList);
                recyclerView.setAdapter(recentUpdatesRecyclerAdapter);
                recentUpdatesRecyclerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<RecentUpdateModel>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });


        return v;
    }
}