package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.NewAdapter.RecyclerMegaQNDAdapter;
import com.analogit.elearningapp.R;

public class MegaQnDFragment extends Fragment {


        View v;
        RecyclerView recyclerView;
    public MegaQnDFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_mega_qn_d, container, false);
        ( (MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        recyclerView=v.findViewById(R.id.rec_mega_qnd);
        RecyclerMegaQNDAdapter recyclerMegaQNDAdapter=new RecyclerMegaQNDAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(recyclerMegaQNDAdapter);

        return v;
    }
}