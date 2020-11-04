package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerExamModuleAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLiveClassAdapter;
import com.analogit.elearningapp.R;

public class ExamModuleFragment  extends Fragment {
    private RecyclerView Em_rView;
    private RecyclerExamModuleAdapter RemAdapter;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v= inflater.inflate(R.layout.exam_modules_layout, container, false);
        Em_rView=v.findViewById(R.id.eml_alltest_rec);
        Em_rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        RemAdapter=new RecyclerExamModuleAdapter(this);
        Em_rView.setAdapter(RemAdapter);

        return v;
    }
}
