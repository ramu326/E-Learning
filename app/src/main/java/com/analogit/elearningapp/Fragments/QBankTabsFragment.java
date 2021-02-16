package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerSubjectsAdapter;
import com.analogit.elearningapp.R;


public class QBankTabsFragment extends Fragment {

   View v;

    RecyclerView rView;
    RecyclerSubjectsAdapter recyclerSubjectsAdapter;
    public QBankTabsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_q_blank_tabs, container, false);
          rView=v.findViewById(R.id.qwam_layout_rec);
                 recyclerSubjectsAdapter=new RecyclerSubjectsAdapter(this);
         rView.setAdapter(recyclerSubjectsAdapter);
         rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        return v;
    }
}