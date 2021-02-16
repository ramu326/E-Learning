package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.R;


public class GroupDiscusionExplanationTabsFragment extends Fragment {

 View view;

    public GroupDiscusionExplanationTabsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      view= inflater.inflate(R.layout.fragment_group_discusion_explanation_tabs, container, false);
      return  view;
    }
}