package com.analogit.elearningapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerAllQuestionsRow;
import com.analogit.elearningapp.Adapters.RecyclerSubJTopicAdapter;
import com.analogit.elearningapp.R;

public class SpecificSubFragment extends Fragment {

private  View view;
private RecyclerView recyclerView;
private RecyclerAllQuestionsRow recyclerAllQuestionsRow;
private ImageView ivMenu;
private TextView next;

    public SpecificSubFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.subject_with_topic_name_questions_layout, container, false);
       recyclerView=view.findViewById(R.id.rec_all_ques);
       ivMenu=view.findViewById(R.id.iv_attempted_question);
       next=view.findViewById(R.id.topic_tv_next);

        ((MainActivity)getActivity()).bottomNavigationView.setVisibility(View.GONE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerAllQuestionsRow=new RecyclerAllQuestionsRow(this);

        recyclerView.setAdapter(recyclerAllQuestionsRow);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetFragment bottomSheetFragment=new BottomSheetFragment();
                bottomSheetFragment.show(getActivity().getSupportFragmentManager(),"bottomsheet");
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new QnAFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        return view;
    }
}