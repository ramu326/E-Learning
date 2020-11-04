package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerSubQbankAdapter;
import com.analogit.elearningapp.R;


public class SubjectQbankFragment extends Fragment {

   private View view;
   private RecyclerView recyclerView;
   private RecyclerSubQbankAdapter recyclerSubQbankAdapter;

    public SubjectQbankFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_subject_qbank, container, false);
        recyclerView=view.findViewById(R.id.rec_sub_qbank);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerSubQbankAdapter=new RecyclerSubQbankAdapter(this);
        recyclerView.setAdapter(recyclerSubQbankAdapter);
        return view;
    }
}