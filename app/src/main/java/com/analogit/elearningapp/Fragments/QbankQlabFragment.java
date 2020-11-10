package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerMorningConAdapter;
import com.analogit.elearningapp.R;


public class QbankQlabFragment extends Fragment {

        RecyclerView recyclerView;
        View v;

    public QbankQlabFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       v= inflater.inflate(R.layout.fragment_qbank_qlab, container, false);
       recyclerView=v.findViewById(R.id.qbank_qlab_rec);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
       RecyclerMorningConAdapter    recyclerMorningConAdapter=new RecyclerMorningConAdapter(this);
        recyclerView.setAdapter(recyclerMorningConAdapter);
       return v;
    }
}