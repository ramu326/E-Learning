package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.DrLearnVideoPlayViewpagerAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class QbankQlabFragment extends Fragment {

       TabLayout tabLayout;
       ViewPager2 viewPager;
        View v;

    public QbankQlabFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.fragment_qbank_qlab, container, false);
        tabLayout= v.findViewById(R.id.dr_learn_tablayout);
        viewPager=v.findViewById(R.id.dr_learn_viewpager);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        DrLearnVideoPlayViewpagerAdapter drLearnVideoPlayViewpagerAdapter=new DrLearnVideoPlayViewpagerAdapter(this);
        viewPager.setAdapter(drLearnVideoPlayViewpagerAdapter);
        viewPager.setUserInputEnabled(false);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("OverView");
                        break;
                    case 1:
                        tab.setText("Images");
                        break;
                    case 2:
                        tab.setText("Notes");
                        break;
                    case 3:
                        tab.setText("UpNext");
                        break;
                }
            }
        }).attach();

       return v;
    }
}