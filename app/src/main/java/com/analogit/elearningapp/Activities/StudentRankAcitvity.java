package com.analogit.elearningapp.Activities;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.analogit.elearningapp.Adapters.SubjectGTestAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;

public class StudentRankAcitvity extends AppCompatActivity {
    private TabLayout tabLayout;
    private  View tab1,tab2;
    private ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anatomy_swt_test_layout);
        tabLayout=findViewById(R.id.sub_tablayout);
        viewPager=findViewById(R.id.sub_view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Question & Answer"));
        tabLayout.addTab(tabLayout.newTab().setText("Test & Discussion"));
        tabLayout.setVisibility(View.GONE);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final SubjectGTestAdapter subjectGTestAdapter=new SubjectGTestAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(subjectGTestAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tab1= ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(0);
//        tab2= ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(1);
//        tab1.setVisibility(View.GONE);
//        tab2.setVisibility(View.GONE);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0DA5AF"));

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0DA5AF"));

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0DA5AF"));

            }
        });
    }
}
