package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.analogit.elearningapp.R;

public class TdExamFragment extends Fragment {
    private ImageView ansSheet;
    TextView tvMark;

    public TdExamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_td_start_question, container, false);
        ansSheet = v.findViewById(R.id.fr_sq_ans_sheet);
        tvMark = v.findViewById(R.id.tv_mark_fr_td_start_mark);
        tvMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new DiscussionVideoExplantaionFragment(1));
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        ansSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TestDiscussionBottomSheetFragment testDiscussionBottomSheetFragment = new TestDiscussionBottomSheetFragment();
                testDiscussionBottomSheetFragment.show(getActivity().getSupportFragmentManager(), "hello");


            }
        });
        return v;
    }
}
