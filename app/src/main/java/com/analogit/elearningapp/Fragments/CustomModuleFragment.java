package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.R;


public class CustomModuleFragment extends Fragment {



TextView GoPractise;
    //SpecificSubFragment()

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
      View view= inflater.inflate(R.layout.fragment_custom_module, container, false);
      GoPractise=view.findViewById(R.id.tv_go_practise);

      GoPractise.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
              fr.replace(R.id.content,new SpecificSubFragment());
              fr.addToBackStack(null);
              fr.commit();
          }
      });
      return view;
    }
}