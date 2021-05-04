package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.RecentUpdatePagesModel;
import com.analogit.elearningapp.NewAdapter.RecyclerRecentUpdatePagesAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecentUpadetPagesFragment extends Fragment {

    View v;
    ViewPager2 viewPager;
    ArrayList<RecentUpdatePagesModel> arrayList = new ArrayList<>();
    API REST_CLIENT;
    ProgressBar progressBar;

    public RecentUpadetPagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_recent_upadet_pages, container, false);
        viewPager = v.findViewById(R.id.recent_update_pages);
        progressBar = v.findViewById(R.id.recent_pro_two);
        REST_CLIENT = RestClient.get();
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);
        if (getArguments() != null) {
            Call<List<RecentUpdatePagesModel>> call = REST_CLIENT.getRecentUpadtepages(getArguments().getInt("id"));
            call.enqueue(new Callback<List<RecentUpdatePagesModel>>() {
                List<RecentUpdatePagesModel> recentUpdatePagesModelsList;
                RecentUpdatePagesModel recentUpdatePagesModelMap;

                @Override
                public void onResponse(Call<List<RecentUpdatePagesModel>> call, Response<List<RecentUpdatePagesModel>> response) {
                    recentUpdatePagesModelsList = response.body();
                    progressBar.setVisibility(View.VISIBLE);
                    if (response.isSuccessful()) {
                        progressBar.setVisibility(View.GONE);
                        for (int i = 0; i < recentUpdatePagesModelsList.size(); i++) {
                            recentUpdatePagesModelMap = recentUpdatePagesModelsList.get(i);
                            arrayList.add(new RecentUpdatePagesModel(recentUpdatePagesModelMap.getImage()));
                        }
                    } else {
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    RecyclerRecentUpdatePagesAdapter recyclerRecentUpdatePagesAdapter = new RecyclerRecentUpdatePagesAdapter(getContext(), arrayList);
                    viewPager.setAdapter(recyclerRecentUpdatePagesAdapter);
                    recyclerRecentUpdatePagesAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<RecentUpdatePagesModel>> call, Throwable t) {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();

                }
            });
        }


        return v;
    }
}