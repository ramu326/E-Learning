package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.analogit.elearningapp.Fragments.GrandTestViewSolutionFragment;

public class GrandTestFinalViewPager  extends FragmentStateAdapter {
    public GrandTestFinalViewPager(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new GrandTestViewSolutionFragment(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
