package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.MorningRoundViewPagerThreeDec;
import com.analogit.elearningapp.Adapters.RecyclerMorningConAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MoringRoundFragment extends Fragment {
 private View v;
private RecyclerView recyclerView;
int position;
TabLayout tabLayout;
ViewPager2 viewPager;
TextView tvNotesDec;
RelativeLayout rlNotes,rlShareapp;
private RecyclerMorningConAdapter recyclerMorningConAdapter;

    public MoringRoundFragment() {
        // Required empty public constructor
      //  this.position=position;
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.morning_round_layout, container, false);
        tabLayout= v.findViewById(R.id.tab_morning_round);
        viewPager=v.findViewById(R.id.view_pager_morning_round);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        MorningRoundViewPagerThreeDec morningRoundViewPagerThreeDec=new MorningRoundViewPagerThreeDec(this);
        viewPager.setAdapter(morningRoundViewPagerThreeDec);
        viewPager.setUserInputEnabled(false);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {

                switch (position){
                    case 0:
                        tab.setText("Notes");
                        break;
                    case 1:
                        tab.setText("Images");
                        break;
                    case 2:
                        tab.setText("UpNext");
                        break;

                }
            }
        }).attach();
//        recyclerView=v.findViewById(R.id.mrl_rec);
//        rlNotes=v.findViewById(R.id.relative_notes);
//        tvNotesDec=v.findViewById(R.id.tv_relative_notes_dec);
//        rlShareapp=v.findViewById(R.id.relative_share);
//
//        tvNotesDec.setVisibility(View.GONE);
//
//
//        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
//        recyclerMorningConAdapter=new RecyclerMorningConAdapter(this);
//        recyclerView.setAdapter(recyclerMorningConAdapter);
//        Log.d("hello","moringrounds");
//
//        rlNotes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(tvNotesDec.getVisibility()==View.GONE){
//                    tvNotesDec.setVisibility(View.VISIBLE);
//                }
//                else {
//                    tvNotesDec.setVisibility(View.GONE);
//
//                }
//            }
//        });
//        rlShareapp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
//                sendIntent.setType("text/plain");
//
//                Intent shareIntent = Intent.createChooser(sendIntent, null);
//                startActivity(shareIntent);
//            }
//        });
        return v;

    }
}