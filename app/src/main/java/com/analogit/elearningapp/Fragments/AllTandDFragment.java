package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.DiffTestTypesViewPager;
import com.analogit.elearningapp.Adapters.RecyclerDiscussionAdapter;
import com.analogit.elearningapp.Adapters.RecyclerTnDOneAdapter;
import com.analogit.elearningapp.Adapters.RecyclerTnDThreeAdapter;
import com.analogit.elearningapp.Adapters.RecyclerTnDTwoAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class AllTandDFragment extends Fragment {

    private View v;
    private   RecyclerView rView;
    private RecyclerDiscussionAdapter recyclerDiscussionAdapter;

    private RecyclerTnDThreeAdapter recyclerTnDThreeAdapter;
    int position;
    private TabLayout tabLayout;
    private ViewPager2 viewPager;


    public AllTandDFragment(int position) {

        this.position=position;
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        switch (position){
            case 0:
                v= inflater.inflate(R.layout.start_resume_test_dis_layout, container, false);
                tabLayout=v.findViewById(R.id.test_tablayout);
                viewPager=v.findViewById(R.id.test_view_pager);
                DiffTestTypesViewPager diffTestTypesViewPager =new DiffTestTypesViewPager(this);
                viewPager.setAdapter(diffTestTypesViewPager);
                //viewPager.setUserInputEnabled(false);
                new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
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

                break;
                           case 1:
                            v= inflater.inflate(R.layout.fragment_new_discussion, container, false);

                            rView=v.findViewById(R.id.new_discussion_video_rec);
                            rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                            recyclerDiscussionAdapter=new RecyclerDiscussionAdapter(this);
                            rView.setAdapter(recyclerDiscussionAdapter);
                            break;

        }




        return v;
    }
}