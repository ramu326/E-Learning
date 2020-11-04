package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.analogit.elearningapp.Adapters.DiffTestTypesViewPager;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TestNDisAllTabsFragment  extends Fragment {

    private  View v;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.test_dis_all_types_tabs,container,false);

        tabLayout=v.findViewById(R.id.test_dis_tablayout);
        viewPager=v.findViewById(R.id.test_dis_view_pager);

        DiffTestTypesViewPager diffTestTypesViewPager =new DiffTestTypesViewPager(this);

        viewPager.setAdapter(diffTestTypesViewPager);
        viewPager.setUserInputEnabled(false);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("All Test");
                        break;
                    case 1:
                        tab.setText("Live Test");
                        break;
                    case 2:
                        tab.setText("Grand Test");
                        break;
                    case 3:
                        tab.setText("Allied Test");
                        break;
                    case 4:
                        tab.setText("Recall Test");
                        break;
                    case 5:
                        tab.setText("Prev Test");
                        break;
                    case 6:
                        tab.setText("SWT Test");
                        break;
                    case 7:
                        tab.setText("Daily Test");
                        break;
                }
            }
        }).attach();
        return v;
    }
}
