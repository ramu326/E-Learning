package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.GrandTestFinalViewPager;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class GrandTestFinalReportFragment extends Fragment {

   View v;
    TabLayout tabLayout;
    ViewPager2 viewPager;

    public GrandTestFinalReportFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.fragment_grand_test_final_report, container, false);
       tabLayout=v.findViewById(R.id.grand_test_tablayout);
       viewPager=v.findViewById(R.id.grand_test_viewpager);
        GrandTestFinalViewPager grandTestFinalViewPager=new GrandTestFinalViewPager(this);
        viewPager.setAdapter(grandTestFinalViewPager);
        viewPager.setUserInputEnabled(false);
      // viewPager.setAdapter(tabLayout);
       new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
           @Override
           public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

               switch (position){
                   case  0:
                       tab.setText("Total"+"("+36+")");
                       break;
                   case 1:
                       tab.setText("Correct"+"("+30+")");
                       break;
                   case 2:
                       tab.setText("InCorrect"+"("+32+")");
                       break;
                   case 3:
                       tab.setText("Skipped"+"("+33+")");
                       break;
                   case 4:
                       tab.setText("NotViewed"+"("+31+")");
                       break;
               }

           }
       }).attach();

       return v;
    }
}