package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerQbankBookmarkAdapter;
import com.analogit.elearningapp.Adapters.RecyclerQbankErrorAdapter;
import com.analogit.elearningapp.Adapters.RecyclerSubjectsAdapter;
import com.analogit.elearningapp.ApiModel.QbankBookMarkModel;
import com.analogit.elearningapp.ApiModel.QbankSubjectModel;
import com.analogit.elearningapp.NewAdapter.QBankErrorModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DummyTabsQbankFragment extends Fragment {


    View v;

    RecyclerView rView, recyclerView, recyclererror;

    RecyclerSubjectsAdapter recyclerSubjectsAdapter;

    int pos;

    API REST_CLIENT;

    ConstraintLayout customModule, previousyears;

    ProgressBar progressBar, progressBarone, progressBarTwo;

    ArrayList<QbankSubjectModel> arrayListData = new ArrayList<>();

    ArrayList<QbankBookMarkModel> arrayList = new ArrayList<>();

    ArrayList<QBankErrorModel> arrayListone = new ArrayList<>();

    int userid = 3, userid1 = 28;

    public String content = "application/json", token;

    private static final String PREF_NAME = "SharedPref";

    public SharedPreferences pref;

    public SharedPreferences.Editor editor;

    int PRIVATE_MODE = 0, val = 1;

    public DummyTabsQbankFragment(int pos) {
        // Required empty public constructor
        this.pos = pos;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        switch (pos) {

            case 0:

                v = inflater.inflate(R.layout.fragment_dummy_tabs_qbank, container, false);

                progressBar = v.findViewById(R.id.qbank_progress);

                rView = v.findViewById(R.id.dummy_layout_rec);

                customModule = v.findViewById(R.id.cons_custo_mcqs);

                previousyears = v.findViewById(R.id.cons_past_year);

                pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);

                editor = pref.edit();
                // progressBar.setVisibility(View.GONE);
                customModule.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();

                        fr.replace(R.id.content, new CustomModuleFragment());

                        fr.addToBackStack(null);

                        fr.commit();
                    }
                });

                previousyears.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();

                        fr.replace(R.id.content, new QBankPastYearQustionsFragment());

                        fr.addToBackStack(null);

                        fr.commit();
                    }
                });

                REST_CLIENT = RestClient.get();

                ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.VISIBLE);

                rView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

                Call<List<QbankSubjectModel>> call = REST_CLIENT.getQbankSubjects(pref.getString("token", "-1"), content);

                call.enqueue(new Callback<List<QbankSubjectModel>>() {

                    List<QbankSubjectModel> qbankSubjectModelData;

                    QbankSubjectModel qbankSubjectmap;

                    @Override
                    public void onResponse(Call<List<QbankSubjectModel>> call, Response<List<QbankSubjectModel>> response) {

                        qbankSubjectModelData = response.body();

                        progressBar.setVisibility(View.VISIBLE);

                        if (response.isSuccessful()) {

                            progressBar.setVisibility(View.GONE);

                            arrayListData.clear();

                            for (int i = 0; i < qbankSubjectModelData.size(); i++) {

                                qbankSubjectmap = qbankSubjectModelData.get(i);

                                arrayListData.add(new QbankSubjectModel(qbankSubjectmap.getId(), qbankSubjectmap.getTotal_topics(), qbankSubjectmap.getOut_of(), qbankSubjectmap.getName(), qbankSubjectmap.getImage()));
                            }
                        } else {
                            progressBar.setVisibility(View.GONE);
                        }
                        recyclerSubjectsAdapter = new RecyclerSubjectsAdapter(getContext(), arrayListData);
                        rView.setAdapter(recyclerSubjectsAdapter);
                        recyclerSubjectsAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<List<QbankSubjectModel>> call, Throwable t) {

                        progressBar.setVisibility(View.GONE);

                    }
                });


                break;

            case 1:
                v = inflater.inflate(R.layout.qbank_bookmark_layout, container, false);
                recyclerView = v.findViewById(R.id.rec_bookmark);
                progressBarone = v.findViewById(R.id.progress_one);
                pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
                editor = pref.edit();
                REST_CLIENT = RestClient.get();
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

                Call<List<QbankBookMarkModel>> listCall = REST_CLIENT.getQbankBookmarks(pref.getString("token", "-1"), content);
                listCall.enqueue(new Callback<List<QbankBookMarkModel>>() {
                    List<QbankBookMarkModel> qbankBookMarkModelList;
                    QbankBookMarkModel qbankBookMarkModelMap;

                    @Override
                    public void onResponse(Call<List<QbankBookMarkModel>> call, Response<List<QbankBookMarkModel>> response) {
                        progressBarone.setVisibility(View.VISIBLE);
                        qbankBookMarkModelList = response.body();
                        try {
                            if (response.isSuccessful()) {
                                arrayList.clear();
                                progressBarone.setVisibility(View.GONE);
                                for (int i = 0; i < qbankBookMarkModelList.size(); i++) {
                                    qbankBookMarkModelMap = qbankBookMarkModelList.get(i);
                                    arrayList.add(new QbankBookMarkModel(qbankBookMarkModelMap.getId(), qbankBookMarkModelMap.getBookmark(), qbankBookMarkModelMap.getName(), qbankBookMarkModelMap.getImage()));

                                }

                            } else {
                                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                                progressBarone.setVisibility(View.GONE);
                            }
                            RecyclerQbankBookmarkAdapter recyclerQbankBookmarkAdapter = new RecyclerQbankBookmarkAdapter(getContext(), arrayList);
                            recyclerView.setAdapter(recyclerQbankBookmarkAdapter);
                            recyclerQbankBookmarkAdapter.notifyDataSetChanged();
                        } catch (Exception e) {

                        }
                    }

                    @Override
                    public void onFailure(Call<List<QbankBookMarkModel>> call, Throwable t) {
                        Toast.makeText(getContext(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
                        progressBarone.setVisibility(View.GONE);
                    }
                });

                break;
            case 2:

                v = inflater.inflate(R.layout.qbank_error_layout, container, false);

                recyclererror = v.findViewById(R.id.rec_error);
                progressBarTwo = v.findViewById(R.id.progress_two);
                REST_CLIENT = RestClient.get();
                pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
                editor = pref.edit();
                recyclererror.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

                Call<List<QBankErrorModel>> call1 = REST_CLIENT.getQbankErrors(pref.getString("token", "-1"), content);
                call1.enqueue(new Callback<List<QBankErrorModel>>() {
                    List<QBankErrorModel> qBankErrorModelList;
                    QBankErrorModel qBankErrorModelMap;

                    @Override
                    public void onResponse(Call<List<QBankErrorModel>> call, Response<List<QBankErrorModel>> response) {
                        progressBarTwo.setVisibility(View.VISIBLE);
                        qBankErrorModelList = response.body();
                        try {
                            if (response.isSuccessful()) {
                                arrayList.clear();
                                progressBarTwo.setVisibility(View.GONE);
                                for (int i = 0; i < qBankErrorModelList.size(); i++) {
                                    qBankErrorModelMap = qBankErrorModelList.get(i);
                                    arrayListone.add(new QBankErrorModel(qBankErrorModelMap.getId(), qBankErrorModelMap.getError(), qBankErrorModelMap.getName(), qBankErrorModelMap.getImage()));
                                }
                            } else {
                                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                                progressBarTwo.setVisibility(View.GONE);
                            }
                            RecyclerQbankErrorAdapter recyclerQbankErrorAdapter = new RecyclerQbankErrorAdapter(getContext(), arrayListone);
                            recyclererror.setAdapter(recyclerQbankErrorAdapter);
                            recyclerQbankErrorAdapter.notifyDataSetChanged();
                        } catch (Exception e) {

                        }
                    }

                    @Override
                    public void onFailure(Call<List<QBankErrorModel>> call, Throwable t) {

                        Toast.makeText(getContext(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
                    }
                });

                break;
        }

        return v;
    }

    @Override
    public void onResume() {
        v.requestLayout();
        super.onResume();
    }
}