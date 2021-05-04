package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.QBankSubTopicsFragment;

public class QBankViewAdapter extends FragmentStateAdapter{
    public QBankViewAdapter(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new QBankSubTopicsFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
