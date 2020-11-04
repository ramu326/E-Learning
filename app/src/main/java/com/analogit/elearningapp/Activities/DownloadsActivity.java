package com.analogit.elearningapp.Activities;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.analogit.elearningapp.Adapters.MyAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;

public class DownloadsActivity  extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downloads_layout);
        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Test&Discussion"));
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final MyAdapter adapter = new MyAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#000000"));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#000000"));

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#000000"));

            }
        });
    }
}
