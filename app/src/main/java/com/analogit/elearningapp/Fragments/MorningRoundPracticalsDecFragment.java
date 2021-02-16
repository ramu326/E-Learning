package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.MorningRoundPrctlesViewPagerAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MorningRoundPracticalsDecFragment extends Fragment {

    View v;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v= inflater.inflate(R.layout.morning_round_dec, container, false);

        tabLayout= v.findViewById(R.id.tab_practicles);
        viewPager=v.findViewById(R.id.view_pager_practiles);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        MorningRoundPrctlesViewPagerAdapter morningRoundViewPagerThreeDec=new MorningRoundPrctlesViewPagerAdapter(this);
        viewPager.setAdapter(morningRoundViewPagerThreeDec);
        viewPager.setUserInputEnabled(false);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("Notes");
                        break;
                    case 1:
                        tab.setText("Images");
                        break;
                    case 2:
                        tab.setText("UpNext");
                        break;

                }
            }
        }).attach();

        return v;

    }
}
