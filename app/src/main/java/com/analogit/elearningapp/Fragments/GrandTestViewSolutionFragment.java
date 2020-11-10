package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.R;


public class GrandTestViewSolutionFragment extends Fragment {


        int position;
        View  v;
    public GrandTestViewSolutionFragment(int position) {
       this.position=position;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_grand_test_view_solution, container, false);
        return v;
    }
}