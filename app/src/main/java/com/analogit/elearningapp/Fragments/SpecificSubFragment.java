package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerAllQuestionsRow;
import com.analogit.elearningapp.Adapters.RecyclerSubJTopicAdapter;
import com.analogit.elearningapp.R;

public class SpecificSubFragment extends Fragment {

private  View view;
private RecyclerView recyclerView;
private RecyclerAllQuestionsRow recyclerAllQuestionsRow;

    public SpecificSubFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.subject_with_topic_name_questions_layout, container, false);
       recyclerView=view.findViewById(R.id.rec_all_ques);

        ((MainActivity)getActivity()).bottomNavigationView.setVisibility(View.GONE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerAllQuestionsRow=new RecyclerAllQuestionsRow(this);

        recyclerView.setAdapter(recyclerAllQuestionsRow);
        return view;
    }
}