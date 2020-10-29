package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.analogit.elearningapp.R;

public class TdExamFragment  extends Fragment {
    private ImageView ansSheet;

    public TdExamFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_td_start_question, container, false);
        ansSheet=v.findViewById(R.id.fr_sq_ans_sheet);
        ansSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetFragment bottomSheetFragment=new BottomSheetFragment();
                bottomSheetFragment.show(getActivity().getSupportFragmentManager(),"bottomsheet");
            }
        });
        return v;
    }
}
