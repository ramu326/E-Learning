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


public class TestDiscussionAllTabsFinalViewSolutionFragment extends Fragment {
    int position;
    RecyclerView recyclerView;
    View v;

    public TestDiscussionAllTabsFinalViewSolutionFragment(int position) {
        // Required empty public constructor
        this.position = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_test_discussion_final_solution, container, false);
        recyclerView = v.findViewById(R.id.fr_test_discussion_final_view_rec);
        RecyclerAllQuestionsRow recyclerAllQuestionsRow = new RecyclerAllQuestionsRow(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(recyclerAllQuestionsRow);
        return v;
    }
}