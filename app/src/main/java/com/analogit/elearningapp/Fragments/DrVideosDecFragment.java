package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.NewAdapter.RecyclerDrVideosAdapter;
import com.analogit.elearningapp.R;

import java.util.ArrayList;


public class DrVideosDecFragment extends Fragment {

    View v;
    ArrayList<DoctorModel> arrayList = new ArrayList<>();
    RecyclerView recyclerView;

    public DrVideosDecFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_dr_videos_dec, container, false);
        recyclerView = v.findViewById(R.id.rec_dr_videos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        RecyclerDrVideosAdapter recyclerDrVideosAdapter = new RecyclerDrVideosAdapter(getContext(), arrayList);
        recyclerView.setAdapter(recyclerDrVideosAdapter);
        return v;
    }
}