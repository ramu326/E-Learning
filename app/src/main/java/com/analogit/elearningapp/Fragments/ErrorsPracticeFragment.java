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


public class ErrorsPracticeFragment extends Fragment {


View v;
ImageView ansSheeet;
LinearLayout linearLayout;
CardView cardView;
TextView tvNext;
    public ErrorsPracticeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      v= inflater.inflate(R.layout.fragment_errors_practice, container, false);
      ansSheeet=v.findViewById(R.id.fr_error_practise_attempted_questions);
      linearLayout=v.findViewById(R.id.ll_error_prctice);
      cardView=v.findViewById(R.id.fr_error_practise_card_view_option_one);
      tvNext=v.findViewById(R.id.error_practice_tv_next_fr);

      ansSheeet.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              TestDiscussionBottomSheetFragment testDiscussionBottomSheetFragment=new TestDiscussionBottomSheetFragment();
              testDiscussionBottomSheetFragment.show(getActivity().getSupportFragmentManager(),"hellowolrd");
          }
      });
      cardView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              linearLayout.setVisibility(View.VISIBLE);
          }
      });
      tvNext.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
              ErrorPracticeAllTabsFragment errorPracticeAllTabsFragment=new ErrorPracticeAllTabsFragment();
              fr.replace(R.id.content,errorPracticeAllTabsFragment);
              fr.addToBackStack(null);
              fr.commit();
          }
      });
      return v;
    }
}