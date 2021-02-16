package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.analogit.elearningapp.Adapters.DummyQbankAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class DummyQbankFragment extends Fragment {


View v;
TabLayout tabLayout;
ViewPager2 viewPager;
LinearLayout llMegaQnD,llCustomMcq,llPast;
    public DummyQbankFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_dummy_qbank, container, false);

        llMegaQnD=v.findViewById(R.id.ll_mega_qnd);
        llCustomMcq=v.findViewById(R.id.ll_custom_mcq);
        llPast=v.findViewById(R.id.ll_past_mcqs);
        tabLayout=v.findViewById(R.id.dummy_qbank_tablayout);
        viewPager=v.findViewById(R.id.dummy_qbank_view_pager);

        viewPager.setUserInputEnabled(false);
        DummyQbankAdapter dummyQbankAdapter=new DummyQbankAdapter(this);
        viewPager.setAdapter(dummyQbankAdapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Qbank");
                        break;
                    case 1:
                        tab.setText("BookMark");
                        break;
                    case 2:
                        tab.setText("Error");
                        break;
                }
            }
        }).attach();

        onclicks();
        return v;
    }

    private void onclicks() {

        llMegaQnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new MegaQnDFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        llCustomMcq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new CustomModuleFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
    }
}