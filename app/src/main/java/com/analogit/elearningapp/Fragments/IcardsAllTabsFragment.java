package com.analogit.elearningapp.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
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
        Log.d("newcards","newcards");
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @SuppressLint("ResourceType")
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                     tab.setText("Cards");
                     break;

                    case 1:
                        tab.setText("Audio");
                        break;

                    case 2:
                        tab.setText("Past Exam Topics");
                        break;

                    case 3:
                        tab.setText("Bookmarks");
                        break;
                }
            }
        }).attach();


        return v;
    }
}