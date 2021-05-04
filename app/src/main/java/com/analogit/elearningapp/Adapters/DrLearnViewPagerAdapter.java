package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.HomeLiveClassFragment;

public class DrLearnViewPagerAdapter extends FragmentStateAdapter {
    public DrLearnViewPagerAdapter(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new DrLearnTabsFragment();
            case 1:
                return new HomeLiveClassFragment();
        }
     return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
