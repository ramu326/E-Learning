package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.R;

public class GeneralIndructionFragmment extends Fragment {

    private TextView tvBack,tvNext;

    public GeneralIndructionFragmment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.general_instruction_layout, container, false);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        tvNext=v.findViewById(R.id.gil_next);

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new TdExamFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        return v;
    }
}