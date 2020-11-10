package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerTnDOneAdapter;
import com.analogit.elearningapp.Adapters.RecyclerTnDThreeAdapter;
import com.analogit.elearningapp.R;


public class DiffTestTypesFragment extends Fragment {

    private View v;
    private RecyclerView rView_one,rView_three;
    private RecyclerTnDOneAdapter recyclerTnDOneAdapter;
    int position;
    private RecyclerTnDThreeAdapter recyclerTnDThreeAdapter;

    public DiffTestTypesFragment(int position) {
        // Required empty public constructor
        this.position=position;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v= inflater.inflate(R.layout.fragment_diff_test_types, container, false);
         rView_one=v.findViewById(R.id.diff_test_rec);
        rView_three=v.findViewById(R.id.diff_test_type_rec);

        rView_one.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerTnDOneAdapter=new RecyclerTnDOneAdapter(this);
        rView_one.setAdapter(recyclerTnDOneAdapter);



        rView_three.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerTnDThreeAdapter=new RecyclerTnDThreeAdapter(this);
        rView_three.setAdapter(recyclerTnDThreeAdapter);
        return v;
    }
}