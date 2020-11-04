package com.analogit.elearningapp.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.analogit.elearningapp.Fragments.QnAFragment;
import com.analogit.elearningapp.Fragments.TnDFragment;

public class SubjectGTestAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public SubjectGTestAdapter(Context context,FragmentManager fm,int totalTabs) {

        super(fm);
        myContext=context;
        this.totalTabs=totalTabs;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                QnAFragment qnAFragment=new QnAFragment();
                return qnAFragment;
            case 1:
                TnDFragment tnDFragment=new TnDFragment();
                return tnDFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
