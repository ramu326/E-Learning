package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.QbankPastExamsEntraceModel;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.NewAdapter.RecyclerQBankPastYearExamTopicsAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QBankPastYearExamTopicsFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
ArrayList<QbankPastExamsEntraceModel>arrayList=new ArrayList<>();
API REST_CLIENT;
TextView textView;
ProgressBar progressBar;
    public QBankPastYearExamTopicsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_q_bank_past_year_exam_topics, container, false);
        REST_CLIENT= RestClient.get();
        recyclerView=v.findViewById(R.id.rec_qbank_past_year_topics);
        textView=v.findViewById(R.id.past_sub_name);
        progressBar=v.findViewById(R.id.progress_past_year);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        if(getArguments()!=null){
            textView.setText(getArguments().getString("subject"));
            Call<List<QbankPastExamsEntraceModel>>call=REST_CLIENT.getpastentranceExams(getArguments().getInt("id"));
            call.enqueue(new Callback<List<QbankPastExamsEntraceModel>>() {
                List<QbankPastExamsEntraceModel>qbankPastExamsEntraceModelsList;
                QbankPastExamsEntraceModel qbankPastExamsEntraceModelMap;
                @Override
                public void onResponse(Call<List<QbankPastExamsEntraceModel>> call, Response<List<QbankPastExamsEntraceModel>> response) {
                    qbankPastExamsEntraceModelsList=response.body();
                    progressBar.setVisibility(View.VISIBLE);
                    if(response.isSuccessful()){
                      //  qbankPastExamsEntraceModelsList.clear();
                        progressBar.setVisibility(View.GONE);
                        for (int i = 0; i <qbankPastExamsEntraceModelsList.size() ; i++) {
                            qbankPastExamsEntraceModelMap=qbankPastExamsEntraceModelsList.get(i);
                            Log.d("helloooooo",qbankPastExamsEntraceModelMap.getExamination_name());
                            arrayList.add(new QbankPastExamsEntraceModel(qbankPastExamsEntraceModelMap.getId(),qbankPastExamsEntraceModelMap.getNo_of_question(),qbankPastExamsEntraceModelMap.getImage(),qbankPastExamsEntraceModelMap.getExamination_name(),qbankPastExamsEntraceModelMap.getName()));
                        }

                    }
                    else {
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    RecyclerQBankPastYearExamTopicsAdapter recyclerQBankPastYearExamTopicsAdapter=new RecyclerQBankPastYearExamTopicsAdapter(getActivity(),arrayList);
                    recyclerView.setAdapter(recyclerQBankPastYearExamTopicsAdapter);
                    recyclerQBankPastYearExamTopicsAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<QbankPastExamsEntraceModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            });
        }


        return v;
    }
}