package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.IcardsAudioFragment;
import com.analogit.elearningapp.Fragments.NewIcardExtenFragment;

public class IcardsViewPager extends FragmentStateAdapter {
    public IcardsViewPager(@NonNull Fragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int pos) {
        switch (pos){
            case 0:
                return new NewIcardExtenFragment();

            case 1:
                return new IcardsAudioFragment();
            case 2:
                return new IcardsAudioFragment();
            case 3:
                return new IcardsAudioFragment();

            default: break;
        }
        return  null;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
