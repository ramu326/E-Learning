package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.analogit.elearningapp.Fragments.DiffTestTypesFragment;


public class DiffTestTypesViewPager extends FragmentStateAdapter {


     public DiffTestTypesViewPager(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new DiffTestTypesFragment(position);
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
