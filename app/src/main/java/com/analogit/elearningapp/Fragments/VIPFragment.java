package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerVIPAdapter;
import com.analogit.elearningapp.R;

public class VIPFragment extends Fragment {


View v;
RecyclerView recyclerView;
    public VIPFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      v=inflater.inflate(R.layout.fragment_v_i_p, container, false);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        recyclerView=v.findViewById(R.id.rec_vip);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        RecyclerVIPAdapter recyclerVIPAdapter=new RecyclerVIPAdapter(this);
        recyclerView.setAdapter(recyclerVIPAdapter);
      return v;
    }
}