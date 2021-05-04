package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.NewAdapter.RecyclerDrNotesWithTopicWiseAdapter;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class DrNotesWithTopicWiseFragment extends Fragment {


View v;
RecyclerView recyclerView;
ArrayList<DoctorModel>arrayList=new ArrayList<>();
    public DrNotesWithTopicWiseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_dr_notes_with_topic_wise, container, false);
        recyclerView=v.findViewById(R.id.rec_notes_topic_wise);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        RecyclerDrNotesWithTopicWiseAdapter recyclerDrNotesWithTopicWiseAdapter=new RecyclerDrNotesWithTopicWiseAdapter(getContext(),arrayList);
        recyclerView.setAdapter(recyclerDrNotesWithTopicWiseAdapter);
        return v;
    }
}