package com.analogit.elearningapp.Fragments;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.analogit.elearningapp.ApiModel.IcardsAudioTopicModel;
import com.analogit.elearningapp.NewAdapter.RecyclerIcardsAudioTopicsAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class IcardsAudioTopicFragment extends Fragment {

    View v;
    ArrayList<IcardsAudioTopicModel> arrayList = new ArrayList<>();
    RecyclerView recyclerView;
    TextView tvsub;
    ProgressBar progressBar;
    API REST_CLIENT;

    public IcardsAudioTopicFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_icards_audio_topic, container, false);
        recyclerView = v.findViewById(R.id.icards_audio_rec);
        tvsub = v.findViewById(R.id.tv_icard_sub_name);
        progressBar = v.findViewById(R.id.pro_icards);
        REST_CLIENT = RestClient.get();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        if (getArguments() != null) {
            tvsub.setText(getArguments().getString("subject"));
            SharedPreferences    pref =getActivity(). getSharedPreferences("SharedPref", Activity.MODE_PRIVATE);
            Call<List<IcardsAudioTopicModel>> call = REST_CLIENT.getIcardAudioTopic(getArguments().getInt("sid"),pref.getString("token", "-1"),"application/json");
            call.enqueue(new Callback<List<IcardsAudioTopicModel>>() {
                List<IcardsAudioTopicModel> icardsAudioTopicModelList;
                IcardsAudioTopicModel icardsAudioTopicModelMap;

                @Override
                public void onResponse(Call<List<IcardsAudioTopicModel>> call, Response<List<IcardsAudioTopicModel>> response) {
                    icardsAudioTopicModelList = response.body();
                    progressBar.setVisibility(View.VISIBLE);
                    if (response.isSuccessful()) {
                        arrayList.clear();
                        progressBar.setVisibility(View.GONE);
                        for (int i = 0; i < icardsAudioTopicModelList.size(); i++) {
                            icardsAudioTopicModelMap = icardsAudioTopicModelList.get(i);
                            arrayList.add(new IcardsAudioTopicModel(icardsAudioTopicModelMap.getId(), icardsAudioTopicModelMap.getIcard(), icardsAudioTopicModelMap.getAudio_topic(), icardsAudioTopicModelMap.getImage()));
                        }
                    } else {
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                    }
                    RecyclerIcardsAudioTopicsAdapter recyclerIcardsAudioTopicsAdapter = new RecyclerIcardsAudioTopicsAdapter(getContext(), arrayList);
                    recyclerView.setAdapter(recyclerIcardsAudioTopicsAdapter);
                    recyclerIcardsAudioTopicsAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<IcardsAudioTopicModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "please check your internet connection", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);

                }
            });

        }

        return v;
    }
}