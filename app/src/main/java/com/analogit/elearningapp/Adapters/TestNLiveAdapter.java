package com.analogit.elearningapp.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.analogit.elearningapp.Fragments.LiveClassFragment;
import com.analogit.elearningapp.Fragments.LiveTestFragment;

public class TestNLiveAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public TestNLiveAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LiveTestFragment liveTestFragment = new LiveTestFragment();
                return liveTestFragment;
            case 1:
                LiveClassFragment liveClassFragment = new LiveClassFragment();
                return liveClassFragment;
            case 2:

            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}
