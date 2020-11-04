package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerSubjectsAdapter;
import com.analogit.elearningapp.R;


public class QBankFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView rView;
    RecyclerSubjectsAdapter recyclerSubjectsAdapter;
    View v;
    TextView CosModule;

    public QBankFragment() {
        // Required empty public constructor
        Log.d("qba1","jel2jelwqkdfwqefcelw");
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.d("qbankkkkkk","jel2jelwqkdfwqefcelw");
       v=inflater.inflate(R.layout.question_with_all_modules_layout, container, false);
        rView=v.findViewById(R.id.qwam_layout_rec);
      //  CosModule=v.findViewById(R.id.tv_qw_all_custom_module);
         recyclerSubjectsAdapter=new RecyclerSubjectsAdapter(this);
         rView.setAdapter(recyclerSubjectsAdapter);
         rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

       // ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
        ((MainActivity)getActivity()).bottomNavigationView.setVisibility(View.VISIBLE);

//        CosModule.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
//                fr.replace(R.id.content,new CustomModuleFragment());
//                fr.addToBackStack(null);
//                fr.commit();
//            }
//        });

        return v;
    }
}