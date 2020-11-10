package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.analogit.elearningapp.R;

public class QbankExamModuleFragment extends Fragment {

    private  View v;
    CardView cardViewSolveExam;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.anatomy_layout,container,false);

        cardViewSolveExam=v.findViewById(R.id.card_view_slove_exam);
        cardViewSolveExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new QbankModulesStartExamFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        return v;
    }
}
