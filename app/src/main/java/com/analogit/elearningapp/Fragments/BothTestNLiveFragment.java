package com.analogit.elearningapp.Fragments;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.LiveTestNClassAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class BothTestNLiveFragment extends Fragment {

   private  View v, firsttab,secondtab;
   int position;

    private  ViewPager2 viewPager;
   private TabLayout tabLayout;

    public BothTestNLiveFragment() {
        // Required empty public constructor
        this.position=position;
    }





    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_both_test_n_live, container, false);
        viewPager=v.findViewById(R.id.fr_live_view_pager);
        tabLayout=v.findViewById(R.id.fr_live_tab_layout);
        LiveTestNClassAdapter liveTestNClassAdapter=new LiveTestNClassAdapter(this);
        viewPager.setAdapter(liveTestNClassAdapter);
        viewPager.setUserInputEnabled(false);
      //  firsttab = ((ViewGroup)    tabLayout.getChildAt(0)).getChildAt(0);
      //  secondtab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(1);



       // secondtab .setBackground(getDrawable(R.drawable.tab_unselect_bg));
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("LiveTest");

                        break;
                    case 1:
                        tab.setText("Live Class");
                        break;
                    default:
                        break;
                }

            }
        }).attach();
        return v;
    }
}