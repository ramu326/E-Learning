package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerQuizAdapter;
import com.analogit.elearningapp.R;


public class DailyChallngeAtempetdFragment extends Fragment {
    private  View v;
    private RecyclerView recyclerView;
    private RecyclerQuizAdapter recyclerQuizAdapter;


    public DailyChallngeAtempetdFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.daily_challenge_attempted_layout, container, false);
        recyclerView=v.findViewById(R.id.dcal_rec);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerQuizAdapter=new RecyclerQuizAdapter(this);
        recyclerView.setAdapter(recyclerQuizAdapter);
        return v;
    }
}