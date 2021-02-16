package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analogit.elearningapp.Adapters.DailyChallngeViewPagerAdapter;
import com.analogit.elearningapp.NewAdapter.RecyclerQuizAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class DailyChallngeAtempetdFragment extends Fragment {
    private  View v;
    private RecyclerView recyclerView;
    private RecyclerQuizAdapter recyclerQuizAdapter;

    TabLayout tabLayout;
    ViewPager2 viewPager;
    String value;
    int rank;
    TextView tv_accuarcy,tv_Avgtime,tv_Strenth,tv_rank;
    public DailyChallngeAtempetdFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.daily_challenge_attempted_layout, container, false);

        tabLayout=v.findViewById(R.id.daily_challenge_tablayout);
        viewPager=v.findViewById(R.id.dail_challenge_viewpager);


        tv_accuarcy=v.findViewById(R.id.tv_dca_accuracy_percent);
        tv_Avgtime=v.findViewById(R.id.tv_dca_avg_time_percent);
        tv_Strenth=v.findViewById(R.id.tv_dca_tv_dca_strenth_percent);
        tv_rank=v.findViewById(R.id.tv_final_score);
            rank=getArguments().getInt("rank");
        Log.d("xxxxxxx",String.valueOf(rank));

        value=getArguments().getString("strength");
        String upperString = value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();

        tv_accuarcy.setText(getArguments().getInt("accuracy")+"%");
        tv_Avgtime.setText(getArguments().getInt("average")+"/Q");
        tv_Strenth.setText(upperString);
        tv_rank.setText(String.valueOf(rank));

        Log.d("wwwwwwwww",String.valueOf(getArguments().getInt("rank")));


        DailyChallngeViewPagerAdapter dailyChallngeViewPagerAdapter=new DailyChallngeViewPagerAdapter(this);
        viewPager.setAdapter(dailyChallngeViewPagerAdapter);
        viewPager.setUserInputEnabled(true);
         new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
             @Override
             public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                 switch (position){

                     case 0:
                         tab.setText("Total"+"("+getArguments().getInt("daily_question")+")");
                         break;
                     case 1:
                         tab.setText("correct"+"("+getArguments().getInt("correct")+")");
                         break;
                     case 2:
                         tab.setText("In correct"+"("+getArguments().getInt("wrong")+")");
                         break;
                     case 3:
                         tab.setText("Skipped"+"("+getArguments().getInt("skip")+")");
                         break;
                     case 4:
                         tab.setText("Not Viewed"+"("+14+")");
                         break;
                 }
             }
         }).attach();
//        recyclerView=v.findViewById(R.id.dcal_rec);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
//        recyclerQuizAdapter=new RecyclerQuizAdapter(this);
//        recyclerView.setAdapter(recyclerQuizAdapter);
        return v;
    }
}