package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.DRHomePageFragment;

public class DrHomeAdapter extends FragmentStateAdapter {
    public DrHomeAdapter(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new DRHomePageFragment(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
