package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.analogit.elearningapp.ApiModel.IcardsPastExamsTopicsModel;
import com.analogit.elearningapp.ApiModel.IcardsPastExamsTopicsPagesModel;
import com.analogit.elearningapp.NewAdapter.RecyclerPastExamTopicsPages;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class IcardsPastExamsPagesFragment extends Fragment {


    View v;
    ViewPager2 viewPager;
    API REST_CLIENT;
    ProgressBar progressBar;
    ArrayList<IcardsPastExamsTopicsPagesModel> arrayList = new ArrayList<>();
    String content = "application/json", token;
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE = 0;
    public IcardsPastExamsPagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_icards_past_exams_pages, container, false);
        viewPager = v.findViewById(R.id.past_topic_viewpager);
        progressBar=v.findViewById(R.id.past_pro);
        REST_CLIENT= RestClient.get();
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        if (getArguments()!=null){
            Call<List<IcardsPastExamsTopicsPagesModel>>call=REST_CLIENT.getIcardPastEaxmsPages(pref.getString("token", "-1"), content,getArguments().getInt("topicid"));
            call.enqueue(new Callback<List<IcardsPastExamsTopicsPagesModel>>() {
                List<IcardsPastExamsTopicsPagesModel>icardsPastExamsTopicsPagesModelList;
                IcardsPastExamsTopicsPagesModel icardsPastExamsTopicsModelMap;
                @Override
                public void onResponse(Call<List<IcardsPastExamsTopicsPagesModel>> call, Response<List<IcardsPastExamsTopicsPagesModel>> response) {
                    icardsPastExamsTopicsPagesModelList=response.body();
                    progressBar.setVisibility(View.VISIBLE);
                    if(response.isSuccessful()){
                        arrayList.clear();
                        progressBar.setVisibility(View.GONE);
                        for (int i = 0; i <icardsPastExamsTopicsPagesModelList.size() ; i++) {
                            icardsPastExamsTopicsModelMap=icardsPastExamsTopicsPagesModelList.get(i);
                            arrayList.add(new IcardsPastExamsTopicsPagesModel(icardsPastExamsTopicsModelMap.getId(),icardsPastExamsTopicsModelMap.getPage()));
                        }
                    }
                    else{
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                    RecyclerPastExamTopicsPages recyclerPastExamTopicsPages = new RecyclerPastExamTopicsPages(getContext(), arrayList);
                    viewPager.setAdapter(recyclerPastExamTopicsPages);
                    recyclerPastExamTopicsPages.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<IcardsPastExamsTopicsPagesModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "Please Check Internet Connection", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }
            });

        }

        return v;
    }
}