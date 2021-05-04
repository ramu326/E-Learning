package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.analogit.elearningapp.R;


public class TestDiscussionSessionStartFragment extends Fragment {


    View v;
    TextView tvSession;
    RelativeLayout rlTest, rlTestDiscussion;

    public TestDiscussionSessionStartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_test_discussion_session_start, container, false);
        tvSession = v.findViewById(R.id.tv_test_discussion_start);
        rlTest = v.findViewById(R.id.relative_test);
        rlTestDiscussion = v.findViewById(R.id.relative_test_discussion);

        rlTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new GeneralIndructionFragmment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        tvSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new DiscussionVideoExplantaionFragment(1));
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        return v;
    }
}