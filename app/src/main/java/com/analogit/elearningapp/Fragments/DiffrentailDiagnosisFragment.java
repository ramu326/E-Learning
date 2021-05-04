package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.DiagnosticModel;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.NewAdapter.RecentUpdatesRecyclerAdapter;
import com.analogit.elearningapp.NewAdapter.RecyclerDifferentialDiagnosisAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DiffrentailDiagnosisFragment extends Fragment {


    View v;
    RecyclerView recyclerView;
    ArrayList<DiagnosticModel> arrayList = new ArrayList<>();
    API REST_CLIENT;
    ProgressBar progressBar;

    public DiffrentailDiagnosisFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_diffrentail_diagnosis, container, false);
        recyclerView = v.findViewById(R.id.rec_differential);
        progressBar = v.findViewById(R.id.dia_pro_one);
        REST_CLIENT = RestClient.get();
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        Call<List<DiagnosticModel>> call = REST_CLIENT.getdiagnostic();
        call.enqueue(new Callback<List<DiagnosticModel>>() {
            List<DiagnosticModel> diagnosticModelList;
            DiagnosticModel diagnosticModelMap;

            @Override
            public void onResponse(Call<List<DiagnosticModel>> call, Response<List<DiagnosticModel>> response) {
                progressBar.setVisibility(View.VISIBLE);
                diagnosticModelList = response.body();

                if (response.isSuccessful()) {
                    arrayList.clear();
                    progressBar.setVisibility(View.GONE);
                    for (int i = 0; i < diagnosticModelList.size(); i++) {
                        diagnosticModelMap = diagnosticModelList.get(i);
                        arrayList.add(new DiagnosticModel(diagnosticModelMap.getId(), diagnosticModelMap.getTopic(), diagnosticModelMap.getImage(), diagnosticModelMap.getSubject()));
                    }
                } else {
                    progressBar.setVisibility(View.GONE);
                }

                RecyclerDifferentialDiagnosisAdapter recyclerDifferentialDiagnosisAdapter = new RecyclerDifferentialDiagnosisAdapter(getContext(), arrayList);
                recyclerView.setAdapter(recyclerDifferentialDiagnosisAdapter);
                recyclerDifferentialDiagnosisAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<DiagnosticModel>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
            }
        });

        return v;
    }
}