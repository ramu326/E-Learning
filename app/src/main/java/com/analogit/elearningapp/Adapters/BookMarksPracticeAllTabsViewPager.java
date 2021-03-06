package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.BookMarksPracticeFinalSolutionFragment;

public class BookMarksPracticeAllTabsViewPager extends FragmentStateAdapter {
    public BookMarksPracticeAllTabsViewPager(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new BookMarksPracticeFinalSolutionFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
