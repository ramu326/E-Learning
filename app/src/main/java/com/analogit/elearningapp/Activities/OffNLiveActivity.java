package com.analogit.elearningapp.Activities;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.analogit.elearningapp.Adapters.TestNLiveAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;

public class OffNLiveActivity  extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    View firsttab,secondtab;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offnlive_layout);
        tabLayout=findViewById(R.id.live_tablayout);
        viewPager=findViewById(R.id.live_view_pager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //setTabBG(R.drawable.tab_select_bg,R.drawable.tab_unselect_bg);

        tabLayout.addTab(tabLayout.newTab().setText("Live Test"));
        tabLayout.addTab(tabLayout.newTab().setText("Live Class"));

        firsttab = ((ViewGroup)    tabLayout.getChildAt(0)).getChildAt(0);
        secondtab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(1);

        firsttab.setBackground(getDrawable(R.drawable.tab_select_bg));
        secondtab .setBackground(getDrawable(R.drawable.tab_unselect_bg));


        final TestNLiveAdapter testNLiveAdapter=new TestNLiveAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(testNLiveAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                int selectedTabPosition = tab.getPosition();

                firsttab.setBackground(getDrawable(R.drawable.tab_select_bg));

                if(selectedTabPosition==0){

                    firsttab.setBackground(getDrawable(R.drawable.tab_select_bg));
                    secondtab .setBackground(getDrawable(R.drawable.tab_unselect_bg));
                }
                else if(selectedTabPosition==1){
                    secondtab .setBackground(getDrawable(R.drawable.tab_select_bg));
                    firsttab.setBackground(getDrawable(R.drawable.tab_unselect_bg));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
