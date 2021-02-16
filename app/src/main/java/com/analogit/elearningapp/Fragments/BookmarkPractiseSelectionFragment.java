package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analogit.elearningapp.R;


public class BookmarkPractiseSelectionFragment extends Fragment {


 View v;
 TextView tvPractise,tvError;
 int a;
    public BookmarkPractiseSelectionFragment(int a) {
      this.a=a;  // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      if(a==0){
         v= inflater.inflate(R.layout.fragment_bookmark_practise_selection, container, false);
         tvPractise=v.findViewById(R.id.tv_fr_book_go_practise);
         tvPractise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
               fr.replace(R.id.content,new BookMarksPracticeFragment());
               fr.addToBackStack(null);
               fr.commit();
            }
         });
      }
      else{
         v= inflater.inflate(R.layout.fragment_error_practise_selection, container, false);
         tvError=v.findViewById(R.id.tv_fr_error_go_practise);
         tvError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
               fr.replace(R.id.content,new ErrorsPracticeFragment());
               fr.addToBackStack(null);
               fr.commit();
            }
         });
               }

       return v;
    }
}