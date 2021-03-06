package com.analogit.elearningapp.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.TestNDiscussionAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class BothTestNDiscussionFragment  extends Fragment {
    private  View v,firsttab,secondtab;;
    int position;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    public BothTestNDiscussionFragment(){

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView( LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.both_test_discussion,container,false);
        viewPager=v.findViewById(R.id.both_view_pager);
        tabLayout=v.findViewById(R.id.both_tab_layout);

        TestNDiscussionAdapter testNDiscussionAdapter=new TestNDiscussionAdapter(this);
        viewPager.setAdapter(testNDiscussionAdapter);
        viewPager.setUserInputEnabled(false);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.VISIBLE);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("Test");
                        break;
                    case 1:
                        tab.setText("T&D Session");
                        break;
                    default:
                        break;
                }

            }
        }).attach();
//        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                switch (position){
//                    case 0:
//
//                            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(0);
//                            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
//                            p.setMargins(32, 0, 32, 0);
//                            tab.requestLayout();
//
//
//                        break;
//
//
//
//                }
//            }
//        });
        return v;
    }
}
