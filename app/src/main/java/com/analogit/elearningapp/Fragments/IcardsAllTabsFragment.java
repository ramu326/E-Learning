package com.analogit.elearningapp.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.IcardsViewPager;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class IcardsAllTabsFragment extends Fragment {


        private  View v;
        private TabLayout tabLayout;
        private ViewPager2 viewPager;

        public IcardsAllTabsFragment() {

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_icards_all_tabs, container, false);
        tabLayout=v.findViewById(R.id.fragment_icard_tab_layout);
        viewPager=v.findViewById(R.id.fragment_icard_view_pager);
        IcardsViewPager icardsViewPager=new IcardsViewPager(this);
        viewPager.setAdapter(icardsViewPager);
        viewPager.setUserInputEnabled(false);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @SuppressLint("ResourceType")
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                       tab.setText("ALL CARDS");
                      tab.setIcon(R.drawable.ic_icards);

                       // tab.setCustomView(R.drawable.ic_icards);

                        break;
                    case 1:
                        tab.setIcon(R.drawable.ic_headset);
                        tab.setText("AUDIO CARDS");
                        break;
                    case 2:
                        tab.setIcon(R.drawable.ic_baseline_star);
                        tab.setText("BOOKMARKS");
                        break;
                    case 3:
                        tab.setIcon(R.drawable.ic_icards);
                        tab.setText("PAST EXAM TOPICS");
                        break;
                }
            }
        }).attach();
        return v;
    }
}