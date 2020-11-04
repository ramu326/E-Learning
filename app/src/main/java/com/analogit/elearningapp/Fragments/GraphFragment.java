package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerAllSubjectsAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLearnVideoAdapter;
import com.analogit.elearningapp.Adapters.RecylerRankOneAdapter;
import com.analogit.elearningapp.Adapters.RecylerRankTwoAdapter;
import com.analogit.elearningapp.R;


public class GraphFragment extends Fragment {

    private View v;
private RecyclerView recyclerView;
RecyclerLearnVideoAdapter recyclerLearnVideoAdapter;


    public GraphFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.new_qbnak_row, container, false);

       recyclerView=v.findViewById(R.id.learn_rec);

       recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
       recyclerLearnVideoAdapter=new RecyclerLearnVideoAdapter(this);
       recyclerView.setAdapter(recyclerLearnVideoAdapter);
        return v;
    }
}