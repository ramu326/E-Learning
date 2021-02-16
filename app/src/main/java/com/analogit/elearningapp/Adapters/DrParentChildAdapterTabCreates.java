package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.DrParentChildAdapterTabCreatedFragment;

public class DrParentChildAdapterTabCreates extends FragmentStateAdapter {
    public DrParentChildAdapterTabCreates(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new DrParentChildAdapterTabCreatedFragment();
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}