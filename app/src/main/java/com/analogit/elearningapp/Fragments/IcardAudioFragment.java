package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerAudioAdapter;
import com.analogit.elearningapp.Adapters.RecyclerVideosSubAdapter;
import com.analogit.elearningapp.R;


public class IcardAudioFragment extends Fragment {

    private  View v;
    private RecyclerVideosSubAdapter recyclerVideosSubAdapter;
    private RecyclerAudioAdapter recyclerAudioAdapter;
    private RecyclerView rSub,rAudio;

    public IcardAudioFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.icards_audios_layout, container, false);
        rSub=v.findViewById(R.id.ial_rec);
        rAudio=v.findViewById(R.id.ial_audios);

        rSub.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerVideosSubAdapter=new RecyclerVideosSubAdapter(this);
        rSub.setAdapter(recyclerVideosSubAdapter);

        rAudio.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerAudioAdapter=new RecyclerAudioAdapter(this);
        rAudio.setAdapter(recyclerAudioAdapter);
        return v;
    }
}