package com.analogit.elearningapp.Fragments;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.R;

public class TdStartFragment extends Fragment {


  private TextView startTest;
  private AlertDialogLayout dialogLayout;
    public TdStartFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_td_start, container, false);
        startTest=v.findViewById(R.id.tv_start_test_td);

        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dailogbox();

            }
        });
        return  v;
    }
    private void Dailogbox(){

        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        final View confirmdailog = layoutInflater.inflate(R.layout.dailog_layout, null);
        final androidx.appcompat.app.AlertDialog dailogbox = new AlertDialog.Builder(getActivity()).create();
        dailogbox.setCancelable(true);
       dailogbox.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dailogbox.setView(confirmdailog);
        confirmdailog.findViewById(R.id.dl_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new GeneralIndructionFragmment());
                fr.addToBackStack(null);
                fr.commit();
                dailogbox.dismiss();
            }
        });
        confirmdailog.findViewById(R.id.dl_exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dailogbox.dismiss();
            }
        });
        dailogbox.show();
    }

}