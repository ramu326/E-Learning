package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.GroupDiscusionExplanationTabsFragment;

public class GroupDiscussionViewPager extends FragmentStateAdapter {
    public GroupDiscussionViewPager(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new GroupDiscusionExplanationTabsFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
