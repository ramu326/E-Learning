package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.R;


public class MoringRoundFragment extends Fragment {
 private View v;


    public MoringRoundFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.morning_round_layout, container, false);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        Log.d("hello","moringrounds");
        return v;

    }
}