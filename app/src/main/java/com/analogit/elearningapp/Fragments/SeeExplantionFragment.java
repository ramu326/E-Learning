package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.R;

public class SeeExplantionFragment  extends Fragment {
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.question_of_the_day_explanation, container, false);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        return v;
    }
}
