package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.DrLearnVideoPlayViewpagerAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class DrLearnVideoPlayFragment extends Fragment {

View view;
RecyclerView recyclerView,recclones;
TabLayout tabLayout;
ViewPager2 viewPager;
ProgressBar progressBar;
LinearLayout linearclones;

    public DrLearnVideoPlayFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_dr_learn_video_play, container, false);
     //   recyclerView=view.findViewById(R.id.rec_fr_learn);
       recclones=view.findViewById(R.id.rec_fr_learn);
        linearclones=view.findViewById(R.id.ll_clones);
        progressBar=view.findViewById(R.id.progress_horizontal);
        linearclones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                recclones.setVisibility(View.VISIBLE);
            }
        });
        tabLayout= view.findViewById(R.id.dr_learn_tablayout);
        viewPager=view.findViewById(R.id.dr_learn_viewpager);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        DrLearnVideoPlayViewpagerAdapter drLearnVideoPlayViewpagerAdapter=new DrLearnVideoPlayViewpagerAdapter(this);
        viewPager.setAdapter(drLearnVideoPlayViewpagerAdapter);
        viewPager.setUserInputEnabled(false);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("Notes");
                        break;
                    case 1:
                        tab.setText("Slides");
                        break;
                    case 2:
                        tab.setText("UpNext");
                        break;
                }
            }
        }).attach();

        return  view;
    }
}