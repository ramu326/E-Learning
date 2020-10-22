package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerWallPosterAdapter;
import com.analogit.elearningapp.R;


public class WallPosterFragment extends Fragment {

    private View v;
    private RecyclerView rView;
    private RecyclerWallPosterAdapter recyclerWallPosterAdapter;


    public WallPosterFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.wall_poster_layout, container, false);
        rView=v.findViewById(R.id.rec_wpl);
        rView.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));

        recyclerWallPosterAdapter=new RecyclerWallPosterAdapter(this);
        rView.setAdapter(recyclerWallPosterAdapter);
        return v;
    }
}