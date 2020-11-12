package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerAllQuestionsRow;
import com.analogit.elearningapp.R;


public class CustomModuleFinalViewSolutionFragment extends Fragment {

RecyclerView recyclerView;
RecyclerAllQuestionsRow recyclerAllQuestionsRow;
View v;

    public CustomModuleFinalViewSolutionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_custom_module_final_view_solution, container, false);

        recyclerView=v.findViewById(R.id.custom_module_final_view_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerAllQuestionsRow=new RecyclerAllQuestionsRow(this);
        recyclerView.setAdapter(recyclerAllQuestionsRow);
        return v;
    }
}