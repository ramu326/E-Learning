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

import com.analogit.elearningapp.ApiModel.IcardsPastExamsTopicsModel;
import com.analogit.elearningapp.NewAdapter.RecyclerPastExamsYearWiseAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PastExamsYearWiseFragment extends Fragment {

    RecyclerView recyclerView;
    View v;
    ArrayList<IcardsPastExamsTopicsModel> arrayLis = new ArrayList<>();
    API REST_CLIENT;
    TextView textView;
    ProgressBar progressBar;
    String content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;

    public PastExamsYearWiseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_past_exams_year_wise, container, false);
        recyclerView = v.findViewById(R.id.rec_past_eams);
        textView = v.findViewById(R.id.past_year_exam);
        progressBar = v.findViewById(R.id.pro_past_exam);
        REST_CLIENT = RestClient.get();
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        if (getArguments() != null) {
            textView.setText(getArguments().getString("subject"));
            Call<List<IcardsPastExamsTopicsModel>> call = REST_CLIENT.getIcardPastEaxmsTopics(pref.getString("token", "-1"), content, getArguments().getInt("id"));
            call.enqueue(new Callback<List<IcardsPastExamsTopicsModel>>() {
                List<IcardsPastExamsTopicsModel> icardsPastExamsTopicsModelList;
                IcardsPastExamsTopicsModel icardsPastExamsTopicsModelMap;

                @Override
                public void onResponse(Call<List<IcardsPastExamsTopicsModel>> call, Response<List<IcardsPastExamsTopicsModel>> response) {
                    icardsPastExamsTopicsModelList = response.body();
                    progressBar.setVisibility(View.VISIBLE);
                    if (response.isSuccessful()) {
                        arrayLis.clear();
                        progressBar.setVisibility(View.GONE);
                        for (int i = 0; i < icardsPastExamsTopicsModelList.size(); i++) {
                            icardsPastExamsTopicsModelMap = icardsPastExamsTopicsModelList.get(i);
                            arrayLis.add(new IcardsPastExamsTopicsModel(icardsPastExamsTopicsModelMap.getId(), icardsPastExamsTopicsModelMap.getPast_exam(), icardsPastExamsTopicsModelMap.getSubject(), icardsPastExamsTopicsModelMap.getImage()));

                        }
                    } else {
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }

                    RecyclerPastExamsYearWiseAdapter recyclerPastExamsYearWiseAdapter = new RecyclerPastExamsYearWiseAdapter(getContext(), arrayLis);
                    recyclerView.setAdapter(recyclerPastExamsYearWiseAdapter);
                    recyclerPastExamsYearWiseAdapter.notifyDataSetChanged();

                }

                @Override
                public void onFailure(Call<List<IcardsPastExamsTopicsModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            });
        }

        return v;
    }
}