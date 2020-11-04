package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.analogit.elearningapp.Adapters.RecyclerAllQuestionsRow;
import com.analogit.elearningapp.R;

public class QAViewpagerFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    int position;
    private  View v;
    private RecyclerView recyclerView;
    private RecyclerAllQuestionsRow recyclerAllQuestionsRow;

    public QAViewpagerFragment(int position) {
      this.position=position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       v= inflater.inflate(R.layout.fragment_q_a_viewpager, container, false);
       recyclerView=v.findViewById(R.id.qaViewpagerRecycler);
       recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
       recyclerAllQuestionsRow=new RecyclerAllQuestionsRow(this);
       recyclerView.setAdapter(recyclerAllQuestionsRow);
       return v;
    }
}