package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerLiveClassAdapter;
import com.analogit.elearningapp.R;


public class HomeLiveClassFragment extends Fragment {


View v;
RecyclerView recyclerView,recycler_foundation,recycler_clinical;
//RecyclerLiveClassAdapter
    public HomeLiveClassFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_home_live_class, container, false);
        recyclerView=v.findViewById(R.id.home_live_class);
        recycler_foundation=v.findViewById(R.id.rec_foundation);
        recycler_clinical=v.findViewById(R.id.rec_clinical);
        RecyclerLiveClassAdapter recyclerLiveClassAdapter=new RecyclerLiveClassAdapter(this);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(recyclerLiveClassAdapter);

        recycler_foundation.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recycler_foundation.setAdapter(recyclerLiveClassAdapter);

        recycler_clinical.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recycler_clinical.setAdapter(recyclerLiveClassAdapter);

        return v;
    }
}