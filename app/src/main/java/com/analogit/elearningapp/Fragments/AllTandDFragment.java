package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.DiffDiscussionTypesViewpager;
import com.analogit.elearningapp.Adapters.DiffTestTypesViewPager;
import com.analogit.elearningapp.Adapters.RecyclerTnDThreeAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class AllTandDFragment extends Fragment {

    private View v;


    private RecyclerTnDThreeAdapter recyclerTnDThreeAdapter;
    int position;
    private TabLayout tabLayout, dis_tablayout;
    private ViewPager2 viewPager, dis_viewpager;


    public AllTandDFragment(int position) {

        this.position = position;
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        switch (position) {
            case 0:
                v = inflater.inflate(R.layout.start_resume_test_dis_layout, container, false);
                tabLayout = v.findViewById(R.id.test_tablayout);
                viewPager = v.findViewById(R.id.test_view_pager);
                DiffTestTypesViewPager diffTestTypesViewPager = new DiffTestTypesViewPager(this);
                viewPager.setAdapter(diffTestTypesViewPager);
                viewPager.setUserInputEnabled(false);
                new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {

                            case 0:
                                tab.setText("All Test");
                                break;
                            case 1:
                                tab.setText("Live Test");
                                break;
                            case 2:
                                tab.setText("Grand Test");
                                break;
                            case 3:
                                tab.setText("Allied Test");

                                break;
                            case 4:
                                tab.setText("Recall Test");
                                break;
                            case 5:
                                tab.setText("Prev Test");
                                break;
                            case 6:
                                tab.setText("SWT Test");
                                break;
                            case 7:
                                tab.setText("Daily Test");
                                break;
                        }
                    }
                }).attach();

                return v;
            case 1:
                v = inflater.inflate(R.layout.discussion_with_tabs_layout, container, false);
                dis_tablayout = v.findViewById(R.id.discusion_with_tabs);
                dis_viewpager = v.findViewById(R.id.discussion_with_viewpager);
                DiffDiscussionTypesViewpager diffDiscussionTypesViewpager = new DiffDiscussionTypesViewpager(this);
                dis_viewpager.setAdapter(diffDiscussionTypesViewpager);

                new TabLayoutMediator(dis_tablayout, dis_viewpager, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                        switch (position) {
                            case 0:
                                tab.setText("All");
                                break;
                            case 1:
                                tab.setText("Anatomy");
                                break;
                            case 2:
                                tab.setText("Physiology");
                                break;
                            case 3:
                                tab.setText("Biochemistry");
                                break;
                            case 4:
                                tab.setText("Pathology");

                                break;
                            case 5:
                                tab.setText("Pharmacology");
                                break;
                            case 6:
                                tab.setText("Microbiology");
                                break;
                            case 7:
                                tab.setText("Forensic Medicine");
                                break;
                            case 8:
                                tab.setText("Community Medicine");
                                break;
                        }
                    }
                }).attach();


                return v;

        }


        return v;
    }
}