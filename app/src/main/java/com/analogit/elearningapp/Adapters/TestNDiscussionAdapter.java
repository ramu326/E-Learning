package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.AllTandDFragment;
import com.analogit.elearningapp.Fragments.BothTestNDiscussionFragment;

public class TestNDiscussionAdapter extends FragmentStateAdapter {
    public TestNDiscussionAdapter(@NonNull BothTestNDiscussionFragment fragmentActivity) {
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
