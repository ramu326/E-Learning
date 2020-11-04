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

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerTopicAdapter;
import com.analogit.elearningapp.R;


public class IcardsFragment extends Fragment {

        private  View v;
        private RecyclerView recyclerView;
        private RecyclerTopicAdapter recyclerTopicAdapter;
        private ImageView more;
    public IcardsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.icards_text_layout, container, false);
        recyclerView=v.findViewById(R.id.itl_rec);
        more=v.findViewById(R.id.iv_itl_more);

        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerTopicAdapter=new RecyclerTopicAdapter(this);
        recyclerView.setAdapter(recyclerTopicAdapter);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new IcardAudioFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        return v;
    }
}