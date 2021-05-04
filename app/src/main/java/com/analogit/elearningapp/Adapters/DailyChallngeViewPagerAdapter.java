package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.DailyChallngeTabsLayoutInfoFragment;

public class DailyChallngeViewPagerAdapter  extends FragmentStateAdapter{
    public DailyChallngeViewPagerAdapter(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new DailyChallngeTabsLayoutInfoFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
