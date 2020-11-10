package com.analogit.elearningapp.Fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
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
                     break;

                    case 1:
                        tab.setText("AUDIO CARDS");
                        break;

                    case 2:

                       tab.setText("BOOKMARKS");
                        break;

                    case 3:

                        tab.setText("PAST EXAM TOPICS");
                        break;
                }
            }
        }).attach();
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageSelected(int position) {

                super.onPageSelected(position);
                switch (position){
                    case 0:
                        if(position==0){
                            tabLayout.getTabAt(0).setIcon(R.drawable.phonee);
                            tabLayout.getTabAt(1).setIcon(R.drawable.ic_icards);
                            tabLayout.getTabAt(2).setIcon(R.drawable.ic_icards);
                            tabLayout.getTabAt(3).setIcon(R.drawable.ic_icards);
                        }



                        break;
                    case 1:
                        if(position==1){
                            tabLayout.getTabAt(0).setIcon(R.drawable.ic_icards);
                            tabLayout.getTabAt(1).setIcon(R.drawable.phonee);
                            tabLayout.getTabAt(2).setIcon(R.drawable.ic_icards);
                            tabLayout.getTabAt(3).setIcon(R.drawable.ic_icards);
                        }

                        break;
                    case 2:
                        if(position==2){
                            tabLayout.getTabAt(0).setIcon(R.drawable.ic_icards);
                            tabLayout.getTabAt(1).setIcon(R.drawable.ic_icards);
                            tabLayout.getTabAt(2).setIcon(R.drawable.phonee);
                            tabLayout.getTabAt(3).setIcon(R.drawable.ic_icards);
                        }

                        break;
                    case 3:
                        if(position==3){
                            tabLayout.getTabAt(0).setIcon(R.drawable.ic_icards);
                            tabLayout.getTabAt(1).setIcon(R.drawable.ic_icards);
                            tabLayout.getTabAt(2).setIcon(R.drawable.ic_icards);
                            tabLayout.getTabAt(3).setIcon(R.drawable.phonee);
                        }

                        break;
                }
            }

        });

        return v;
    }
}