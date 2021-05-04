package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.ICardsPagesModel;
import com.analogit.elearningapp.NewAdapter.RecyclerIcardsPagesAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class IcardsPagesFragment extends Fragment {

    View v;
    ViewPager2 viewPager;
    ProgressBar progressBar;
    API REST_CLIENT;
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;

    SharedPreferences.Editor editor;
    String content = "application/json";
    int PRIVATE_MODE = 0;
    ArrayList<ICardsPagesModel> arrayList = new ArrayList<>();

    public IcardsPagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_icards_pages, container, false);
        progressBar = v.findViewById(R.id.icard_page_progress);
        REST_CLIENT = RestClient.get();
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        viewPager = v.findViewById(R.id.icard_viewpager);
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);

        if (getArguments() != null) {
            Log.d("hdiouwefewofdwe", String.valueOf(getArguments().getInt("topicid")));
            Call<List<ICardsPagesModel>> call = REST_CLIENT.getIcardspages(pref.getString("token", "-1"), content, getArguments().getInt("topicid"));
            call.enqueue(new Callback<List<ICardsPagesModel>>() {
                List<ICardsPagesModel> iCardsPagesModelList;
                ICardsPagesModel iCardsPagesModelMap;

                @Override
                public void onResponse(Call<List<ICardsPagesModel>> call, Response<List<ICardsPagesModel>> response) {
                    iCardsPagesModelList = response.body();

                    progressBar.setVisibility(View.VISIBLE);
                    if (response.isSuccessful()) {
                        arrayList.clear();
                        for (int i = 0; i < iCardsPagesModelList.size(); i++) {
                            iCardsPagesModelMap = iCardsPagesModelList.get(i);

                            arrayList.add(new ICardsPagesModel(iCardsPagesModelMap.getId(), iCardsPagesModelMap.getPage()));
                        }
                    } else {
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    RecyclerIcardsPagesAdapter recyclerIcardsPagesAdapter = new RecyclerIcardsPagesAdapter(getContext(), arrayList);
                    viewPager.setAdapter(recyclerIcardsPagesAdapter);
                    recyclerIcardsPagesAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<ICardsPagesModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "Please Check Your Internet connection", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }
            });
        }

        return v;
    }
}