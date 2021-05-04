package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.IcardsSubjectTopics;
import com.analogit.elearningapp.NewAdapter.RecycelerIcardsTopicAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IcardsTopicsFragment extends Fragment {

    RecyclerView recyclerView;
    View v;
    TextView textView;
    API REST_CLIENT;
    ArrayList<IcardsSubjectTopics> arrayList = new ArrayList<>();
    String content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    ProgressBar progressBar;
    int PRIVATE_MODE = 0;

    public IcardsTopicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_icards_topics, container, false);
        textView = v.findViewById(R.id.topic_name);
        recyclerView = v.findViewById(R.id.rec_icard_topic);
        REST_CLIENT = RestClient.get();
        progressBar = v.findViewById(R.id.pro_icards);
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        if (getArguments() != null) {
            textView.setText(getArguments().getString("subject"));
            Call<List<IcardsSubjectTopics>> call = REST_CLIENT.getIcardsTopics(pref.getString("token", "-1"), content, getArguments().getInt("sid"));
            call.enqueue(new Callback<List<IcardsSubjectTopics>>() {
                List<IcardsSubjectTopics> icardsSubjectTopicsList;
                IcardsSubjectTopics icardsSubjectTopicsMap;

                @Override
                public void onResponse(Call<List<IcardsSubjectTopics>> call, Response<List<IcardsSubjectTopics>> response) {
                    icardsSubjectTopicsList = response.body();
                    progressBar.setVisibility(View.VISIBLE);
                    if (response.isSuccessful()) {
                        arrayList.clear();
                        progressBar.setVisibility(View.GONE);
                        if (icardsSubjectTopicsList.size() != 0) {
                            for (int i = 0; i < icardsSubjectTopicsList.size(); i++) {
                                icardsSubjectTopicsMap = icardsSubjectTopicsList.get(i);
                                arrayList.add(new IcardsSubjectTopics(icardsSubjectTopicsMap.getId(), icardsSubjectTopicsMap.getIcard(), icardsSubjectTopicsMap.getSubject()));
                            }
                        } else {
                            if (getContext() != null) {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getContext(), "No Icards Found", Toast.LENGTH_SHORT).show();
                            }

                        }

                    } else {
                        progressBar.setVisibility(View.GONE);

                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }
                    RecycelerIcardsTopicAdapter recycelerIcardsTopicAdapter = new RecycelerIcardsTopicAdapter(getContext(), arrayList);
                    recyclerView.setAdapter(recycelerIcardsTopicAdapter);
                    recycelerIcardsTopicAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<IcardsSubjectTopics>> call, Throwable t) {

                    Toast.makeText(getContext(), "Please check your Internet connection", Toast.LENGTH_SHORT).show();
                }
            });
        }


        return v;
    }
}