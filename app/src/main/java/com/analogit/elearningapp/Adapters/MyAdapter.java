package com.analogit.elearningapp.Adapters;

import android.content.Context;
//TestNLiveAdapter
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.analogit.elearningapp.Fragments.TestNDiscussionFragment;
import com.analogit.elearningapp.Fragments.WallPosterVideosFragment;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TestNDiscussionFragment testNDiscussionFragment = new TestNDiscussionFragment();
                return testNDiscussionFragment;
            case 1:
               WallPosterVideosFragment videosFragment = new WallPosterVideosFragment();
                return videosFragment;
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
