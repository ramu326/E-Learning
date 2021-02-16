package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.analogit.elearningapp.R;


public class BookMarksPracticeFragment extends Fragment {

  ImageView bottomSheetAnswerSheet;
  View v;
  LinearLayout linearLayout;
    CardView cardViewOptionOne;
    TextView tvNext;
    public BookMarksPracticeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_book_marks_practice, container, false);
        bottomSheetAnswerSheet=v.findViewById(R.id.fr_book_mark_practise_attempted_questions);
        linearLayout=v.findViewById(R.id.ll_explanation_with_percent_fr);
        cardViewOptionOne=v.findViewById(R.id.fr_book_mark_practise_card_view_option_one);
      //  ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        tvNext=v.findViewById(R.id.topic_tv_next_fr);
        cardViewOptionOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout.setVisibility(View.VISIBLE);
            }
        });
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                BookMarksPracticeAllTabsFragment bookMarksPracticeAllTabsFragment=new BookMarksPracticeAllTabsFragment();
                fr.replace(R.id.content,bookMarksPracticeAllTabsFragment);
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        bottomSheetAnswerSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TestDiscussionBottomSheetFragment testDiscussionBottomSheetFragment=new TestDiscussionBottomSheetFragment();
                testDiscussionBottomSheetFragment.show(getActivity().getSupportFragmentManager(),"hello");


            }
        });
        return v;
    }
}