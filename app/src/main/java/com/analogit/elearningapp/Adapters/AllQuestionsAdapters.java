package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.QAViewpagerFragment;

public class AllQuestionsAdapters extends FragmentStateAdapter {

    public AllQuestionsAdapters(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new QAViewpagerFragment(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
