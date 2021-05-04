package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.DiagnosticPagesModel;
import com.analogit.elearningapp.NewAdapter.RecyclerDiffrentailDiagnosisPagesAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DiffrentailDiagnosisPagesFragment extends Fragment {


View v;
ViewPager2 viewPager;
ArrayList<DiagnosticPagesModel>arrayList=new ArrayList<>();
API REST_CLIENT;
ProgressBar progressBar;
    public DiffrentailDiagnosisPagesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_diffrentail_diagnosis_pages, container, false);
        viewPager=v.findViewById(R.id.dia_viewpager);
        progressBar=v.findViewById(R.id.dia_pro_two);
        REST_CLIENT= RestClient.get();
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        if(getArguments()!=null){
            Call<List<DiagnosticPagesModel>>call=REST_CLIENT.getdiagnosticpages(getArguments().getInt("id"));
            call.enqueue(new Callback<List<DiagnosticPagesModel>>() {
                List<DiagnosticPagesModel> diagnosticPagesModelList;
                DiagnosticPagesModel diagnosticPagesModelMaP;
                @Override
                public void onResponse(Call<List<DiagnosticPagesModel>> call, Response<List<DiagnosticPagesModel>> response) {
                    diagnosticPagesModelList=response.body();
                    progressBar.setVisibility(View.VISIBLE);
                    if(response.isSuccessful()){
                        progressBar.setVisibility(View.GONE);
                        for (int i = 0; i <diagnosticPagesModelList.size() ; i++) {
                            diagnosticPagesModelMaP=diagnosticPagesModelList.get(i);
                            arrayList.add(new DiagnosticPagesModel(diagnosticPagesModelMaP.getImage()));
                        }
                    }
                    else{
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    RecyclerDiffrentailDiagnosisPagesAdapter recyclerDiffrentailDiagnosisPagesAdapter=new RecyclerDiffrentailDiagnosisPagesAdapter(getContext(),arrayList);
                    viewPager.setAdapter(recyclerDiffrentailDiagnosisPagesAdapter);
                    recyclerDiffrentailDiagnosisPagesAdapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<DiagnosticPagesModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "Please check internet Connection", Toast.LENGTH_SHORT).show();

                    progressBar.setVisibility(View.GONE);

                }
            });
        }
        return v;
    }
}