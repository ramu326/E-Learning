package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerLearnSubjectsSubTopicAdapter;
import com.analogit.elearningapp.R;


public class LearnSubjectsSubTopicFragment extends Fragment {

   View view;
   RecyclerView recyclerView;

    public LearnSubjectsSubTopicFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_learn_subjects_sub_topic, container, false);
       recyclerView=view.findViewById(R.id.fr_learn_sub_topic_rec);
        RecyclerLearnSubjectsSubTopicAdapter recyclerLearnSubjectsSubTopicAdapter=new RecyclerLearnSubjectsSubTopicAdapter(this);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
       recyclerView.setAdapter(recyclerLearnSubjectsSubTopicAdapter);
        return  view;
    }
}