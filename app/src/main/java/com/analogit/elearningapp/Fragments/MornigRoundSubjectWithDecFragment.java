package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerMorningRoundDecAdapter;
import com.analogit.elearningapp.R;


public class MornigRoundSubjectWithDecFragment extends Fragment {


View v;
//RecyclerMorningRoundDecAdapter
    RecyclerView recyclerView;
    public MornigRoundSubjectWithDecFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_mornig_round_subject_with_dec, container, false);
         recyclerView=v.findViewById(R.id.morning_round_dec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        RecyclerMorningRoundDecAdapter recyclerMorningRoundDecAdapter=new RecyclerMorningRoundDecAdapter(this);
        recyclerView.setAdapter(recyclerMorningRoundDecAdapter);
       return v;
    }
}