package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.DrLearnTranUpnextFragment;

public class MorningRoundViewPagerThreeDec extends FragmentStateAdapter {
    public MorningRoundViewPagerThreeDec(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new DrLearnTranUpnextFragment(position);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
