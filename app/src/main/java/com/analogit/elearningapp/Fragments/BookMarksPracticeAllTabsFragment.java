package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.BookMarksPracticeAllTabsViewPager;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class BookMarksPracticeAllTabsFragment extends Fragment {

TabLayout tabLayout;
ViewPager2 viewPager;
View v;
    public BookMarksPracticeAllTabsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_book_marks_practice_all_tabs, container, false);
        tabLayout=v.findViewById(R.id.fr_bookmarks_tablayout);
        viewPager=v.findViewById(R.id.fr_bookmarks_viewpager);
        BookMarksPracticeAllTabsViewPager bookMarksPracticeAllTabsViewPager=new BookMarksPracticeAllTabsViewPager(this);
        viewPager.setAdapter(bookMarksPracticeAllTabsViewPager);
        viewPager.setUserInputEnabled(true);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){

                    case 0:
                        tab.setText("Total"+"("+30+")");
                        break;
                    case 1:
                        tab.setText("correct"+"("+12+")");
                        break;
                    case 2:
                        tab.setText("In correct"+"("+10+")");
                        break;
                    case 3:
                        tab.setText("Skipped"+"("+14+")");
                        break;
                    case 4:
                        tab.setText("Not Viewed"+"("+14+")");
                        break;
                }
            }
        }).attach();
        return v;
    }
}