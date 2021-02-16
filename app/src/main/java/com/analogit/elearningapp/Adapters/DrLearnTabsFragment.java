package com.analogit.elearningapp.Adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import de.hdodenhof.circleimageview.CircleImageView;


public class DrLearnTabsFragment extends Fragment {

          View v;

    private RecyclerView onGoing_rview,upComing_rView,previous_rView;
    private RecyclerLiveTestAdapterPartTwo RltAdapter;
    private RecyclerView recyclerView,rViewliveboard;
    RecyclerLearnVideoAdapter recyclerLearnVideoAdapter;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    CircleImageView llMoringRonund,wallposter;

    int postion;
    public DrLearnTabsFragment() {

        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


            v=inflater.inflate(R.layout.fragment_dr_learn_tabs, container, false);
           tabLayout=v.findViewById(R.id.dr_home_tab_layout);
           viewPager=v.findViewById(R.id.dr_home_view_pager);

           viewPager.setUserInputEnabled(false);
           DrHomeAdapter drHomeAdapter=new DrHomeAdapter(this);
           viewPager.setAdapter(drHomeAdapter);
           new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
               @Override
               public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                   switch (position){
                       case 0:
                           tab.setText("Video");
                           break;
                       case 1:
                           tab.setText("Audio");
                           break;
                       case 2:
                           tab.setText("Notes");
                           break;
                       case 3:
                           tab.setText("Saved");
                           break;
                   }
               }
           }).attach();






       return v;
    }
}