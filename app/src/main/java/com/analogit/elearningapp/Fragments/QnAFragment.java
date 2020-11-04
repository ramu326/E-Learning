package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.analogit.elearningapp.Adapters.AllQuestionsAdapters;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class QnAFragment extends Fragment {
    private  View v;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.qna_fragent_layout,container,false);

        tabLayout=v.findViewById(R.id.qna_tablayout);
        viewPager=v.findViewById(R.id.qna_view_pager);
        AllQuestionsAdapters allQuestionsAdapters=new AllQuestionsAdapters(this);
        viewPager.setAdapter(allQuestionsAdapters);
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
