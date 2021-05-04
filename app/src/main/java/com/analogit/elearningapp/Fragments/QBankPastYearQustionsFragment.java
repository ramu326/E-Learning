package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.QbankPastExamsWithSubJectsModel;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.NewAdapter.RecyclerQbankPreviousAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QBankPastYearQustionsFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    ArrayList<QbankPastExamsWithSubJectsModel> arrayList = new ArrayList<>();
    API REST_CLIENT;
    String entrance = "Entrance";
    ProgressBar progressBar;

    public QBankPastYearQustionsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_q_bank_past_year_qustions, container, false);
        recyclerView = v.findViewById(R.id.rec_qbank_past);
        progressBar = v.findViewById(R.id.progress_o);
        REST_CLIENT = RestClient.get();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        Call<List<QbankPastExamsWithSubJectsModel>> call = REST_CLIENT.getpastExams(entrance);
        call.enqueue(new Callback<List<QbankPastExamsWithSubJectsModel>>() {
            List<QbankPastExamsWithSubJectsModel> qbankPastExamsWithSubJectsModelList;
            QbankPastExamsWithSubJectsModel qbankPastExamsWithSubJectMap;

            @Override
            public void onResponse(Call<List<QbankPastExamsWithSubJectsModel>> call, Response<List<QbankPastExamsWithSubJectsModel>> response) {
                qbankPastExamsWithSubJectsModelList = response.body();

                progressBar.setVisibility(View.VISIBLE);
                if (response.isSuccessful()) {
                    arrayList.clear();
                    progressBar.setVisibility(View.GONE);
                    for (int i = 0; i < qbankPastExamsWithSubJectsModelList.size(); i++) {
                        qbankPastExamsWithSubJectMap = qbankPastExamsWithSubJectsModelList.get(i);

                        arrayList.add(new QbankPastExamsWithSubJectsModel(qbankPastExamsWithSubJectMap.getId(), qbankPastExamsWithSubJectMap.getSubject(), qbankPastExamsWithSubJectMap.getImage()));
                    }
                } else {
                    Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
                RecyclerQbankPreviousAdapter recyclerQbankPreviousAdapter = new RecyclerQbankPreviousAdapter(getContext(), arrayList);
                recyclerView.setAdapter(recyclerQbankPreviousAdapter);
                recyclerQbankPreviousAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<QbankPastExamsWithSubJectsModel>> call, Throwable t) {
                Toast.makeText(getContext(), "please check internet connection", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        });

        return v;
    }
}