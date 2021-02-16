package com.analogit.elearningapp.Fragments;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.analogit.elearningapp.R;


public class CustomModuleFragment extends Fragment {


ImageView ivAllCustomModules;
TextView GoPractise;
   int myear, mMonth, mDay;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      //  ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
          View view= inflater.inflate(R.layout.fragment_custom_module, container, false);
          GoPractise=view.findViewById(R.id.tv_go_practise);
           ivAllCustomModules=view.findViewById(R.id.iv_custom_module_cal);


             ivAllCustomModules.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {


                DatePickerDialog datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view,int dayOfMonth, int month,int year)
                    {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new CustomModuleFinalReportFragment());
                fr.addToBackStack(null);
                fr.commit();
                    }
                }, mDay, mMonth,myear);
                datePickerDialog.show();


            }
        });

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