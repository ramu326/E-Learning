package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.CustomModuleFinalReportViewPager;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CustomModuleFinalReportFragment extends Fragment {

  View v;
TabLayout tabLayout;
ViewPager2 viewPager;
    public CustomModuleFinalReportFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.fragment_final_report_custom_module, container, false);
       tabLayout=v.findViewById(R.id.all_custom_module_tablayout);
       viewPager=v.findViewById(R.id.all_custom_module_viewpager);

        CustomModuleFinalReportViewPager customModuleFinalReportViewPager=new CustomModuleFinalReportViewPager(this);
        viewPager.setAdapter(customModuleFinalReportViewPager);
        viewPager.setUserInputEnabled(false);
       new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
           @Override
           public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
               switch (position){
                   case 0:
                       tab.setText("Total"+"("+36+")");
                       break;
                   case 1:
                       tab.setText("Correct"+"("+39+")");
                       break;
                   case 2:
                       tab.setText("InCorrect"+"("+30+")");
                       break;
                   case 3:
                       tab.setText("Skipped"+"("+37+")");
                       break;
                   case 4:
                       tab.setText("NotViewed"+"("+6+")");
                       break;

               }
           }
       }).attach();
       return v;
    }
}