package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.DailyBoostModel;
import com.analogit.elearningapp.NewAdapter.RecyclerQuizAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DailyChallengeFragment extends Fragment {

    View v;
    public RecyclerView recyclerView;
    public RecyclerQuizAdapter recyclerQuizAdapter;
    public ImageView Imagecal;
    public TextView tvSubmit, tv_optA, tv_optB, tv_optC, tv_optD, tv_question, tv_Total, tv_Next, tv_submit;

    public CardView layout1, layout2, layout3, layout4;
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;
    API REST_CLIENT;
    SharedPreferences.Editor editor;
    String  content = "application/json";
    int PRIVATE_MODE = 0;
    ArrayList<DailyBoostModel> dailyBoostModel = new ArrayList<>();

    public DailyChallengeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_daily_challenge, container, false);


       // ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        recyclerView=v.findViewById(R.id.fdc_rec);
        tvSubmit=v.findViewById(R.id.fdc_submit);
        Imagecal=v.findViewById(R.id.iv_fdc_cal);
        tv_question=v.findViewById(R.id.tv_fdc_question);
        tv_optA=v.findViewById(R.id.tv_option_a);
        tv_optB=v.findViewById(R.id.tv_option_b);
        tv_optC=v.findViewById(R.id.tv_option_c);
        tv_optD=v.findViewById(R.id.tv_option_d);
        tv_Total=v.findViewById(R.id.tv_fdc_tq);
        tv_Next=v.findViewById(R.id.fdc_next);
        tv_submit=v.findViewById(R.id.fdc_submit);


        layout1=v.findViewById(R.id.card_rl_one);
        layout2=v.findViewById(R.id.card_rl_two);
        layout3=v.findViewById(R.id.card_rl_three);
        layout4=v.findViewById(R.id.card_rl_four);

        REST_CLIENT = RestClient.get();

        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
        Log.d("jklfklnfdklfnd",pref.getString("token", "-1"));
        Call<List<DailyBoostModel>>dailyboost=REST_CLIENT.getDailyBoostQuestions(pref.getString("token", "-1"),content);
        dailyboost.enqueue(new Callback<List<DailyBoostModel>>() {
            List<DailyBoostModel>dailyBoostModellist;
            DailyBoostModel dailyBoostModelData;
            @Override
            public void onResponse(Call<List<DailyBoostModel>> call, Response<List<DailyBoostModel>> response) {
                dailyBoostModellist=response.body();
                if(response.isSuccessful()){

                    for (int i=0;i<dailyBoostModellist.size();i++){
                        dailyBoostModelData=dailyBoostModellist.get(i);
                        Log.d("suss",dailyBoostModellist.get(i).getQuestion());

                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
                        recyclerQuizAdapter=new RecyclerQuizAdapter(getContext(),dailyBoostModellist,DailyChallengeFragment.this);

                        recyclerView.setAdapter(recyclerQuizAdapter);

                    }
                }

            }

            @Override
            public void onFailure(Call<List<DailyBoostModel>> call, Throwable t) {
                if(getActivity()!=null)
                 Toast.makeText(getContext(),"Please check Internet connection!",Toast.LENGTH_SHORT).show();


            }
        });





        return v;
    }
}