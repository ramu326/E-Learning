package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerAudioAdapter;
import com.analogit.elearningapp.Adapters.RecyclerNewIcardsAdapter;
import com.analogit.elearningapp.R;

public class IcardsAudioFragment extends Fragment {


View v;
RecyclerView rSub;
    public IcardsAudioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_icards_audio, container, false);
        v = inflater.inflate(R.layout.icards_layout_with_tab_info, container, false);
        rSub = v.findViewById(R.id.new_cards_rec);
        rSub.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        RecyclerAudioAdapter recyclerAudioAdapter = new RecyclerAudioAdapter(this);
        rSub.setAdapter(recyclerAudioAdapter);
        return v;
    }
}