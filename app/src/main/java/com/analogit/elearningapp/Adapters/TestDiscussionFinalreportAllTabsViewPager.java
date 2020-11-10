package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.TestDiscussionAllTabsFinalViewSolutionFragment;

public class TestDiscussionFinalreportAllTabsViewPager extends FragmentStateAdapter {
    public TestDiscussionFinalreportAllTabsViewPager(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new TestDiscussionAllTabsFinalViewSolutionFragment(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
