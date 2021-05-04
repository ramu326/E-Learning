package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.R;

public class EditProfileFragment extends Fragment {
    View v;

    public EditProfileFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.edit_profile_layout, container, false);
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);
        return v;
    }
}
