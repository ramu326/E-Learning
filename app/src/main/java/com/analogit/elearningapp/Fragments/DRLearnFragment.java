package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.DrLearnViewPagerAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class DRLearnFragment extends Fragment {

    private View v;


    TabLayout tabLayout;
    ViewPager2 viewPager;
    int pos;

    public DRLearnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.new_qbnak_row, container, false);

        tabLayout = v.findViewById(R.id.dr_learn_qbank_tab_layout);
        viewPager = v.findViewById(R.id.dr_learn_qbank_view_pager);


        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.VISIBLE);
        DrLearnViewPagerAdapter drLearnViewPagerAdapter = new DrLearnViewPagerAdapter(this);
        viewPager.setAdapter(drLearnViewPagerAdapter);
        viewPager.setUserInputEnabled(false);


        if (getArguments() != null) {
            int pos1 = getArguments().getInt("pos", 0);

            viewPager.setCurrentItem(pos1);


        }
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0:
                        tab.setText("PRIME");
                        break;
                    case 1://"("+36+")"
                        tab.setText("Live"+"'");
                        break;
                }
            }
        }).attach();

        return v;
    }
}