package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.TestDiscussionFinalreportAllTabsViewPager;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class TestDiscussionFinalreportAllTabsFragment extends Fragment {


View v;
TabLayout tabLayout;
ViewPager2 viewPager;
    public TestDiscussionFinalreportAllTabsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_test_discussion_finalreport_all_tabs, container, false);
        tabLayout=v.findViewById(R.id.test_discussion_all_tabs_tablayout);
        viewPager=v.findViewById(R.id.test_discussion_all_tabs_viewpager);

        TestDiscussionFinalreportAllTabsViewPager testDiscussionFinalreportAllTabsViewPager=new TestDiscussionFinalreportAllTabsViewPager(this);
        viewPager.setAdapter(testDiscussionFinalreportAllTabsViewPager);
        viewPager.setUserInputEnabled(false);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case  0:
                        tab.setText("Total\n"+"("+36+")");
                        break;
                    case 1:
                        tab.setText("Correct\n"+"("+30+")");
                        break;
                    case 2:
                        tab.setText("InCorrect\n"+"("+32+")");
                        break;
                    case 3:
                        tab.setText("Skipped\n"+"("+33+")");
                        break;
                    case 4:
                        tab.setText("NotViewed\n"+"("+31+")");
                        break;
                }
            }
        }).attach();
        return v;
    }
}