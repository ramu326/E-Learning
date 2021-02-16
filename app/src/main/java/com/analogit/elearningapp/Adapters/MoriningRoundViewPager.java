package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.MoringRoundFragment;
import com.analogit.elearningapp.Fragments.MornigRoundSubjectWithDecFragment;
import com.analogit.elearningapp.Fragments.MorningRoundPracticlesFragment;

public class MoriningRoundViewPager extends FragmentStateAdapter {
    public MoriningRoundViewPager(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                return new MornigRoundSubjectWithDecFragment();
            case 1:
                return new MorningRoundPracticlesFragment();
        }
return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
