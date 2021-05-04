package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.analogit.elearningapp.Adapters.RecyclerAudioAdapter;
import com.analogit.elearningapp.Adapters.RecyclerNewIcardsAdapter;
import com.analogit.elearningapp.Model.AudioModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IcardsAudioFragment extends Fragment {


    View v;
    RecyclerView rSub;
    ArrayList<AudioModel> arrayList = new ArrayList<>();
    API REST_CLIENT;
    ProgressBar progressBar;
    String content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    public IcardsAudioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.icards_layout_with_tab_info, container, false);
        progressBar = v.findViewById(R.id.icard_pro);
        rSub = v.findViewById(R.id.new_cards_rec);
        REST_CLIENT = RestClient.get();
        pref =getActivity(). getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        rSub.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        Call<List<AudioModel>> call = REST_CLIENT.getIcardAudio(pref.getString("token", "-1"),content);
        call.enqueue(new Callback<List<AudioModel>>() {
            List<AudioModel> audioModelList;
            AudioModel audioModelMap;

            @Override
            public void onResponse(Call<List<AudioModel>> call, Response<List<AudioModel>> response) {
                audioModelList = response.body();
                progressBar.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {

                    arrayList.clear();

                    progressBar.setVisibility(View.GONE);

                    for (int i = 0; i < audioModelList.size(); i++) {
                        audioModelMap = audioModelList.get(i);
                        arrayList.add(new AudioModel(audioModelMap.getId(), audioModelMap.getIcard(), audioModelMap.getSubject(), audioModelMap.getImage()));
                    }
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
                RecyclerAudioAdapter recyclerAudioAdapter = new RecyclerAudioAdapter(getContext(), arrayList);
                rSub.setAdapter(recyclerAudioAdapter);
                recyclerAudioAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AudioModel>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);

                Toast.makeText(getContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}