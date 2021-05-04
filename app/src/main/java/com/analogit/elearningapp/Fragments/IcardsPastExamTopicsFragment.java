package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.analogit.elearningapp.Adapters.RecyclerIcardsPastExamAdapter;
import com.analogit.elearningapp.ApiModel.IcardsPastExamsModel;
import com.analogit.elearningapp.Model.AudioModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IcardsPastExamTopicsFragment extends Fragment {

    RecyclerView recyclerView;
    View v;
    ArrayList<IcardsPastExamsModel> arrayList = new ArrayList<>();
    API REST_CLIENT;
    ProgressBar progressBar;
    String content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    public IcardsPastExamTopicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_icards_past_exam_topics, container, false);
        recyclerView = v.findViewById(R.id.cards_pastexam_rec);
        progressBar = v.findViewById(R.id.pro_topic);
        pref =getActivity(). getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        REST_CLIENT = RestClient.get();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        Call<List<IcardsPastExamsModel>> call = REST_CLIENT.getIcardPastEaxms(pref.getString("token", "-1"),content);
        call.enqueue(new Callback<List<IcardsPastExamsModel>>() {

            List<IcardsPastExamsModel> icardsPastExamsModelList;

            IcardsPastExamsModel icardsPastExamsModelMap;

            @Override
            public void onResponse(Call<List<IcardsPastExamsModel>> call, Response<List<IcardsPastExamsModel>> response) {
                icardsPastExamsModelList = response.body();
                progressBar.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    arrayList.clear();
                    progressBar.setVisibility(View.GONE);
                    for (int i = 0; i < icardsPastExamsModelList.size(); i++) {
                        icardsPastExamsModelMap = icardsPastExamsModelList.get(i);
                        arrayList.add(new IcardsPastExamsModel(icardsPastExamsModelMap.getId(), icardsPastExamsModelMap.getPast_exam(), icardsPastExamsModelMap.getImage(), icardsPastExamsModelMap.getSubject()));
                    }
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
                RecyclerIcardsPastExamAdapter recyclerIcardsPastExamAdapter = new RecyclerIcardsPastExamAdapter(getContext(), arrayList);
                recyclerView.setAdapter(recyclerIcardsPastExamAdapter);
                recyclerIcardsPastExamAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<IcardsPastExamsModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });

        return v;
    }
}