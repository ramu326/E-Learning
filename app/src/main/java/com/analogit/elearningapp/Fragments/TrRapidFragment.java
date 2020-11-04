package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.R;

public class TrRapidFragment extends Fragment {
        private  View v;
        RecyclerView rView;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.tr_rapid_fragment, container, false);

        rView=v.findViewById(R.id.tr_rapid_rview);
        return v;
    }
}
