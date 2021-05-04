package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.Model.ImageModel;
import com.analogit.elearningapp.NewAdapter.RecyclerDrNotesAdapter;
import com.analogit.elearningapp.R;

import java.util.ArrayList;


public class DrNotesFragment extends Fragment {

View v;
RecyclerView recyclerView;
ArrayList<DoctorModel>arrayList=new ArrayList<>();
ViewPager2 viewPager;
    public DrNotesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_dr_notes, container, false);
      //  viewPager=v.findViewById(R.id.viewpager);
        recyclerView=v.findViewById(R.id.rec_notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        RecyclerDrNotesAdapter recyclerDrNotesAdapter=new RecyclerDrNotesAdapter(getContext(),arrayList);
        recyclerView.setAdapter(recyclerDrNotesAdapter);

        return v;
    }
}