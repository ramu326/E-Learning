package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.AllTandDFragment;


public class TestNDiscussionAdapter extends FragmentStateAdapter {
    public TestNDiscussionAdapter(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new AllTandDFragment(position);


    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
