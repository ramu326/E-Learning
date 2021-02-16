package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerMorningRoundPracticalAdapter;
import com.analogit.elearningapp.R;

public class MorningRoundPracticlesFragment extends Fragment {


        View v;
        RecyclerView recyclerView;
        //RecyclerMorningRoundPracticalAdapter
    public MorningRoundPracticlesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_morning_round_practicles, container, false);
        recyclerView=v.findViewById(R.id.rec_morning_round_practical);

        RecyclerMorningRoundPracticalAdapter recyclerMorningRoundPracticalAdapter=new RecyclerMorningRoundPracticalAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(recyclerMorningRoundPracticalAdapter);
        return v;
    }
}