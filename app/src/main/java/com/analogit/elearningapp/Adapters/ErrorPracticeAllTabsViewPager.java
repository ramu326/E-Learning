package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.ErrorPracticeFinalSolutionFragment;

public class ErrorPracticeAllTabsViewPager  extends FragmentStateAdapter {
    public ErrorPracticeAllTabsViewPager(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new ErrorPracticeFinalSolutionFragment();
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
