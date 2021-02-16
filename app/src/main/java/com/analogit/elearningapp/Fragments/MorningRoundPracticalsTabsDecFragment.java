package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerMorningRoundPracticalAdapter;
import com.analogit.elearningapp.Adapters.RecyclerOverViewAdapter;
import com.analogit.elearningapp.Adapters.RecyclerSlideImagesAdapter;
import com.analogit.elearningapp.Model.AllQuestionsModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class MorningRoundPracticalsTabsDecFragment extends Fragment {
        private  View v;
        RecyclerView rView,recslides,transrecyclerview;
    ArrayList<AllQuestionsModel> arrayList;
int pos;
        public MorningRoundPracticalsTabsDecFragment(int pos){
            this.pos=pos;
        }
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {


        switch(pos) {
            case 0:
                v=inflater.inflate(R.layout.transcript_layout,container,false);
                transrecyclerview=v.findViewById(R.id.trans_script_rec);
                RecyclerOverViewAdapter recyclerOverViewAdapter=new RecyclerOverViewAdapter(this);
                transrecyclerview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                transrecyclerview.setAdapter(recyclerOverViewAdapter);
                break;
            case 1:
                v=inflater.inflate(R.layout.slides_images,container,false);
                recslides=v.findViewById(R.id.rec_slides_images);
                RecyclerSlideImagesAdapter recyclerSlideImagesAdapter=new RecyclerSlideImagesAdapter(getContext(),arrayList);
                recslides.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                recslides.setAdapter(recyclerSlideImagesAdapter);
                break;
            case 2:
                v = inflater.inflate(R.layout.tr_rapid_fragment, container, false);
                rView = v.findViewById(R.id.rec_practicals);
                rView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                RecyclerMorningRoundPracticalAdapter recyclerMorningRoundPracticalAdapter = new RecyclerMorningRoundPracticalAdapter(this);
                rView.setAdapter(recyclerMorningRoundPracticalAdapter);
                ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);

                break;
        }
        return v;
    }
}

//  switch (position){
//          case 0:
//          v=inflater.inflate(R.layout.transcript_layout,container,false);
//          transrecyclerview=v.findViewById(R.id.trans_script_rec);
//          RecyclerOverViewAdapter recyclerOverViewAdapter=new RecyclerOverViewAdapter(this);
//          transrecyclerview.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
//          transrecyclerview.setAdapter(recyclerOverViewAdapter);
//          ( (MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
//          break;
//          case 1:
//          v=inflater.inflate(R.layout.slides_images,container,false);
//          recslides=v.findViewById(R.id.rec_slides_images);
//          RecyclerSlideImagesAdapter recyclerSlideImagesAdapter=new RecyclerSlideImagesAdapter(getContext(),arrayList);
//          recslides.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
//          recslides.setAdapter(recyclerSlideImagesAdapter);
//          break;
//          case 2:
//          v= inflater.inflate(R.layout.fragment_dr_learn_tran_upnext, container, false);
//          recyclerView=v.findViewById(R.id.fr_tran_upnext_rec);
//          RecyclerMorningRoundDecAdapter recyclerMorningRoundDecAdapter=new RecyclerMorningRoundDecAdapter(this);
//          recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
//          recyclerView.setAdapter(recyclerMorningRoundDecAdapter);
//          ( (MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
//
//          break;
//          }