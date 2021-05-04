package com.analogit.elearningapp.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.analogit.elearningapp.Adapters.RecyclerIcardsBookMarksAdapter;
import com.analogit.elearningapp.ApiModel.IcardsBookmarkModel;
import com.analogit.elearningapp.Model.AudioModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

public class IcardsBookMarksFragment extends Fragment {

  RecyclerView recyclerView;

  ArrayList<IcardsBookmarkModel>audioModel=new ArrayList<>();

  View v;

  ProgressBar progressBar;

    String content = "application/json", token;

    private static final String PREF_NAME = "SharedPref";

    SharedPreferences pref;

    SharedPreferences.Editor editor;

    int PRIVATE_MODE = 0;

    public IcardsBookMarksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_icards_book_marks, container, false);

        recyclerView=v.findViewById(R.id.cards_bookmark_rec);

        pref =getActivity(). getSharedPreferences(PREF_NAME, PRIVATE_MODE);

        editor = pref.edit();

        progressBar=v.findViewById(R.id.nookmark_pro);

        progressBar.setVisibility(View.GONE);

        RecyclerIcardsBookMarksAdapter recyclerIcardsBookMarksAdapter=new RecyclerIcardsBookMarksAdapter(getContext(),audioModel);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        recyclerView.setAdapter(recyclerIcardsBookMarksAdapter);

        return  v;
    }
}