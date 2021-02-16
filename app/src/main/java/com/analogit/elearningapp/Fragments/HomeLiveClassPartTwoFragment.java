package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerLiveTestAdapterPartTwo;
import com.analogit.elearningapp.R;

public class HomeLiveClassPartTwoFragment extends Fragment {


View v;
//RecyclerLiveTestAdapterPartTwo
    RecyclerView recyclerView;
    public HomeLiveClassPartTwoFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_home_live_class_part_two, container, false);
        recyclerView=v.findViewById(R.id.rec_live_class);
        RecyclerLiveTestAdapterPartTwo recyclerLiveTestAdapterPartTwo=new RecyclerLiveTestAdapterPartTwo(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(recyclerLiveTestAdapterPartTwo);
        return v;
    }
}