package com.analogit.elearningapp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.analogit.elearningapp.Fragments.BothTestNLiveFragment;
import com.analogit.elearningapp.Fragments.LiveClassFragment;
import com.analogit.elearningapp.Fragments.LiveTestFragment;

public class LiveTestNClassAdapter extends FragmentStateAdapter {
    public LiveTestNClassAdapter(@NonNull BothTestNLiveFragment fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
       switch (position){
           case  0:
                    LiveTestFragment liveTestFragment=new LiveTestFragment();
               return  liveTestFragment;
           case 1:
                 LiveClassFragment liveClassFragment=new LiveClassFragment();
                    return  liveClassFragment;
           default: break;
       }
return  null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
