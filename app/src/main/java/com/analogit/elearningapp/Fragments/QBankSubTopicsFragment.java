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

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerQbankSubTopicsAdapter;
import com.analogit.elearningapp.ApiModel.QbankSubTopicsModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QBankSubTopicsFragment extends Fragment {

    View v;

    RecyclerView rView;
    RecyclerQbankSubTopicsAdapter recyclerSubjectsAdapter;
    ArrayList<QbankSubTopicsModel> arrayListData = new ArrayList<>();
    API REST_CLIENT;
    ProgressBar progressBar;
    public TextView textView;
    public String content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    public SharedPreferences pref;
    public SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;

    public QBankSubTopicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_q_blank_tabs, container, false);
        rView = v.findViewById(R.id.qwam_layout_rec);
        textView = v.findViewById(R.id.qbank_sub_name);
        progressBar = v.findViewById(R.id.qbank_topic_progress);
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        REST_CLIENT = RestClient.get();
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);

        rView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        if (getArguments() != null) {

            textView.setText(getArguments().getString("name"));
            Call<List<QbankSubTopicsModel>> call = REST_CLIENT.getQbankSubjectTopics(pref.getString("token", "-1"), content, getArguments().getInt("sid"));
            call.enqueue(new Callback<List<QbankSubTopicsModel>>() {
                List<QbankSubTopicsModel> qbankSubTopicsModelList;
                QbankSubTopicsModel qbankSubTopicsmap;

                @Override
                public void onResponse(Call<List<QbankSubTopicsModel>> call, Response<List<QbankSubTopicsModel>> response) {
                    qbankSubTopicsModelList = response.body();
                    progressBar.setVisibility(View.VISIBLE);
                    if (response.isSuccessful()) {
                        progressBar.setVisibility(View.GONE);
                        for (int i = 0; i < qbankSubTopicsModelList.size(); i++) {
                            qbankSubTopicsmap = qbankSubTopicsModelList.get(i);
                            arrayListData.add(new QbankSubTopicsModel(qbankSubTopicsmap.getTopic_id(), qbankSubTopicsmap.getTotal_question(), qbankSubTopicsmap.getTopic_name(), qbankSubTopicsmap.getImage()));
                        }
                    } else {

                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    recyclerSubjectsAdapter = new RecyclerQbankSubTopicsAdapter(getContext(), arrayListData, QBankSubTopicsFragment.this);
                    rView.setAdapter(recyclerSubjectsAdapter);
                    recyclerSubjectsAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<QbankSubTopicsModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "Please check your Internet connection", Toast.LENGTH_SHORT).show();
                }
            });

        }


        return v;
    }
}