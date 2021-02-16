package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.QBankViewAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class QBankFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    View v;
    ImageView qLab,customModule;
    TabLayout tabLayout;
    ViewPager2 viewPager;

    public QBankFragment() {
        // Required empty public constructor
        Log.d("qba1","jel2jelwqkdfwqefcelw");
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


       v=inflater.inflate(R.layout.question_with_all_modules_layout, container, false);
      //  rView=v.findViewById(R.id.qwam_layout_rec);
       qLab=v.findViewById(R.id.iv_qlab);
       customModule=v.findViewById(R.id.iv_custom);
       tabLayout=v.findViewById(R.id.qbank_tab_layout);
       viewPager=v.findViewById(R.id.qbank_view_pager);
        QBankViewAdapter qBankViewAdapter=new QBankViewAdapter(this);
        viewPager.setUserInputEnabled(false);
            viewPager.setAdapter(qBankViewAdapter);
         new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
           @Override
           public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

               switch (position){
                   case 0:
                       tab.setText("Qbank");
                       break;
                   case 1:
                       tab.setText("Bookmark");
                       break;
                   case 2:
                       tab.setText("Error");
                       break;
               }

           }
       }).attach();



        ((MainActivity)getActivity()).bottomNavigationView.setVisibility(View.VISIBLE);

        qLab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new QbankQlabFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        customModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new CustomModuleFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        return v;
    }
}