package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerBottomSheetAdapter;
import com.analogit.elearningapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class TestDiscussionBottomSheetFragment extends BottomSheetDialogFragment {

 View view;
 RecyclerView recyclerView;
    public TestDiscussionBottomSheetFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_test_discussion_bottom_sheet, container, false);
       recyclerView=view.findViewById(R.id.fr_test_discussion_rec_bottom_sheet_question);
       recyclerView.setLayoutManager(new GridLayoutManager(getContext(),6,RecyclerView.VERTICAL,false));
       RecyclerBottomSheetAdapter recyclerBottomSheetAdapter=new RecyclerBottomSheetAdapter(this);
       recyclerView.setAdapter(recyclerBottomSheetAdapter);
       return view;
    }
}