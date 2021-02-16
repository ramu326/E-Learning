package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerAudioListenAdapter;
import com.analogit.elearningapp.R;


public class IcardsFragment extends Fragment {

        private  View v;
        private RecyclerView recyclerView;
        private RecyclerAudioListenAdapter recyclerAudioListenAdapter;
        private ImageView more;
    public IcardsFragment() {
        // Required empty public constructor
    }

//RecyclerAudioAdapter


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.icards_text_layout, container, false);
        recyclerView=v.findViewById(R.id.itl_rec);


        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerAudioListenAdapter=new RecyclerAudioListenAdapter(this);
        recyclerView.setAdapter(recyclerAudioListenAdapter);


        return v;
    }
}