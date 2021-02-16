package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerAllQuestionsRow;
import com.analogit.elearningapp.R;

public class QbankModulesStartExamFragment extends Fragment {
    View v;
    LinearLayout linearLayout;
    RecyclerView recyclerView;
    CardView cardViewOption;
    RecyclerAllQuestionsRow recyclerAllQuestionsRow;
    ImageView ivAttemtedQuest;
    TextView tvNext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.subject_with_topic_name_questions_layout,container,false);
        linearLayout=v.findViewById(R.id.ll_explanation_with_percent_sub_with_fr);
        cardViewOption=v.findViewById(R.id.card_view_option_one);
        ivAttemtedQuest=v.findViewById(R.id.fr_sub_with_topic_attempted_questions);
        tvNext=v.findViewById(R.id.topic_tv_next_sub_with_fr);
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new GrandTestFinalReportFragment());
                fr.addToBackStack(null);
                fr.commit();

            }
        });
        linearLayout.setVisibility(View.GONE);

        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        cardViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
        ivAttemtedQuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetFragment bottomSheetFragment=new BottomSheetFragment();
                bottomSheetFragment.show(getActivity().getSupportFragmentManager(),"bottomsheet");
            }
        });
        return v;
    }
}
