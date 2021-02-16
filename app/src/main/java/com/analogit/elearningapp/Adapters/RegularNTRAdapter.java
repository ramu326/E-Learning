package com.analogit.elearningapp.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.analogit.elearningapp.Fragments.RegularCourceFragment;
import com.analogit.elearningapp.Fragments.MorningRoundPracticalsTabsDecFragment;

public class RegularNTRAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;
    public RegularNTRAdapter(Context context, FragmentManager fm,int totalTabs) {

        super(fm);
        myContext=context;
        this.totalTabs=totalTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case  0:
                RegularCourceFragment regularCourceFragment=new RegularCourceFragment();
                return  regularCourceFragment;
            case 1:
                MorningRoundPracticalsTabsDecFragment trRapidFragment=new MorningRoundPracticalsTabsDecFragment(1);
                return trRapidFragment;
            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
