package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.analogit.elearningapp.R;

public class SubjectFragment extends Fragment {
    private  View v;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.question_with_all_modules_layout, container, false);
        return v;
    }

}
