package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerAllSubjectsAdapter;
import com.analogit.elearningapp.Adapters.TestDiscussionFinalreportViewPager;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class TestDiscussionFinalreportFragment extends Fragment {


View view;
TabLayout tabLayout;
ViewPager2 viewPager;
RecyclerView recyclerView;
public TestDiscussionFinalreportFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_test_discussion_finalreport, container, false);
       tabLayout= view.findViewById(R.id.test_discussion_tablayout);
       viewPager=view.findViewById(R.id.test_discussion_viewpager);
       recyclerView=view.findViewById(R.id.test_discussion_rec_subjects);
        RecyclerAllSubjectsAdapter recyclerAllSubjectsAdapter=new RecyclerAllSubjectsAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(recyclerAllSubjectsAdapter);
        TestDiscussionFinalreportViewPager testDiscussionFinalreportViewPager=new TestDiscussionFinalreportViewPager(this);
        viewPager.setAdapter(testDiscussionFinalreportViewPager);
        viewPager.setUserInputEnabled(false);
       new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
           @Override
           public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
               switch (position){

                   case 0:
                       tab.setText("Question & Answer");
                       break;
                   case 1:
                       tab.setText("Test & Discussion");
                       break;
               }
           }
       }).attach();
       return view;
    }
}