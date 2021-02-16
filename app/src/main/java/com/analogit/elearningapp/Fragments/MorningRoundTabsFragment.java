package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.MoriningRoundViewPager;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MorningRoundTabsFragment extends Fragment {

   private  View view;
   private ViewPager2 viewPager;
   private TabLayout tabLayout;
    public MorningRoundTabsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_morning_round_tabs, container, false);
       viewPager=view.findViewById(R.id.morning_round_view_pager);
       tabLayout=view.findViewById(R.id.morning_round_tab_layout);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        MoriningRoundViewPager moriningRoundViewPager=new MoriningRoundViewPager(this);
       viewPager.setAdapter(moriningRoundViewPager);
        viewPager.setUserInputEnabled(false);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){

                       case 0:
                        tab.setText("Clinicals");
                        break;
                       case 1:
                        tab.setText("Practicals");
                        break;
                }

            }
        }).attach();
       return view;
    }
}