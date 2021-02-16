package com.analogit.elearningapp.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerQbankBookmarkAdapter;
import com.analogit.elearningapp.Adapters.RecyclerQbankErrorAdapter;
import com.analogit.elearningapp.Adapters.RecyclerSubjectsAdapter;
import com.analogit.elearningapp.R;


public class DummyTabsQbankFragment extends Fragment {


    View v;
    RecyclerView rView, recyclerView, recyclererror;
    RecyclerSubjectsAdapter recyclerSubjectsAdapter;
    int pos;


    public DummyTabsQbankFragment(int pos) {
        // Required empty public constructor
        this.pos = pos;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        switch (pos) {
            case 0:
                v = inflater.inflate(R.layout.fragment_dummy_tabs_qbank, container, false);
                rView = v.findViewById(R.id.dummy_layout_rec);
                recyclerSubjectsAdapter = new RecyclerSubjectsAdapter(this);
                rView.setAdapter(recyclerSubjectsAdapter);

                rView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                break;
            case 1:
                v = inflater.inflate(R.layout.qbank_bookmark_layout, container, false);
                recyclerView = v.findViewById(R.id.rec_bookmark);
                RecyclerQbankBookmarkAdapter recyclerQbankBookmarkAdapter = new RecyclerQbankBookmarkAdapter(this);
                recyclerView.setAdapter(recyclerQbankBookmarkAdapter);

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                break;
            case 2:
                v = inflater.inflate(R.layout.qbank_error_layout, container, false);
                recyclererror = v.findViewById(R.id.rec_error);
                RecyclerQbankErrorAdapter recyclerQbankErrorAdapter = new RecyclerQbankErrorAdapter(this);
                recyclererror.setAdapter(recyclerQbankErrorAdapter);
                recyclererror.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                break;
        }

        return v;
    }
}