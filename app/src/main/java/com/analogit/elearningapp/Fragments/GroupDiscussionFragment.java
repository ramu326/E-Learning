package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.GroupDiscussionViewPager;
import com.analogit.elearningapp.Adapters.RecyclerGroupDiscussionAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class GroupDiscussionFragment extends Fragment {

  View v;
  RecyclerView recyclerView;
  TextView etAskQues;

  TabLayout tabLayout;
  ViewPager2 viewPager;

    public GroupDiscussionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_group_discussion, container, false);
        etAskQues=v.findViewById(R.id.fr_et_group_discussion);
        recyclerView=v.findViewById(R.id.group_discussion_rec);
        tabLayout=v.findViewById(R.id.group_tab_layout);
        viewPager=v.findViewById(R.id.group_view_pager);

        GroupDiscussionViewPager groupDiscussionViewPager=new GroupDiscussionViewPager(this);

        viewPager.setAdapter(groupDiscussionViewPager);
        viewPager.setUserInputEnabled(false);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Discussion");
                        break;
                    case 1:
                        tab.setText("Mentor Plus");
                        break;
                    default: break;
                }
            }
        }).attach();

        etAskQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new GroupDiscussionQuestionPostFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

        RecyclerGroupDiscussionAdapter recyclerGroupDiscussionAdapter=new RecyclerGroupDiscussionAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(recyclerGroupDiscussionAdapter);
        return v;
    }
}