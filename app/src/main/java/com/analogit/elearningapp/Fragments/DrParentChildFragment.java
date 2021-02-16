package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.analogit.elearningapp.Adapters.DrParentChildAdapterTabCreates;
import com.analogit.elearningapp.Adapters.DrParentChlidAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DrParentChildFragment extends Fragment {

 ExpandableListView expandableListView;
 View view;
 ArrayList<String> drParentlist=new ArrayList<>();
 ArrayList<String>drChildlist=new ArrayList<>();
 Map<String, List<String>>hashmap=new HashMap<>();

 TabLayout tabLayout;
 ViewPager2 viewPager;

    public DrParentChildFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_dr_parent_child, container, false);
        tabLayout= view.findViewById(R.id.dr_tablatout);
        viewPager=view.findViewById(R.id.dr_view_pager);
viewPager.setUserInputEnabled(false);
        DrParentChildAdapterTabCreates drParentChildAdapterTabCreates=new DrParentChildAdapterTabCreates(this);
        viewPager.setAdapter(drParentChildAdapterTabCreates);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {


                switch (position){
                    case 0:
                        tab.setText("All");
                        break;
                    case 1:
                        tab.setText("Paused");
                        break;
                    case 2:
                        tab.setText("Completed");
                        break;
                    case 3:
                        tab.setText("InCompleted");
                        break;
                    case 4:
                        tab.setText("Bookmarked");
                        break;
                    case 5:
                        tab.setText("New");
                        break;
                }
            }
        }).attach();




        return view;
    }
}