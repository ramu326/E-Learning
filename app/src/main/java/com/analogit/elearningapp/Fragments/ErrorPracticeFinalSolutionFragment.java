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

public class ErrorPracticeFinalSolutionFragment extends Fragment {

 View view;
RecyclerView recyclerView;
    public ErrorPracticeFinalSolutionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_error_practice_final_solution, container, false);
        recyclerView=view.findViewById(R.id.fr_error_practice_final_view_rec);

        RecyclerAllQuestionsRow recyclerAllQuestionsRow=new RecyclerAllQuestionsRow(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(recyclerAllQuestionsRow);
        return view;
    }
}