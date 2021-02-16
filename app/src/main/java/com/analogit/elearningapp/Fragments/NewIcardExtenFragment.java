package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerNewIcardsAdapter;
import com.analogit.elearningapp.R;

public class NewIcardExtenFragment extends Fragment {

    View v;
    RecyclerView rSub;


    public NewIcardExtenFragment() {
       // this.position = position;
    }

    private RecyclerNewIcardsAdapter recyclerNewIcardsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       // ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.GONE);

                v = inflater.inflate(R.layout.icards_layout_with_tab_info, container, false);
                rSub = v.findViewById(R.id.new_cards_rec);
                rSub.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
                RecyclerNewIcardsAdapter recyclerLearnVideoAdapter = new RecyclerNewIcardsAdapter(this);
                rSub.setAdapter(recyclerLearnVideoAdapter);




//        rSub=v.findViewById(R.id.icards_rec);
//        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);
//
//        rSub.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
//        RecyclerNewIcardsAdapter recyclerLearnVideoAdapter=new RecyclerNewIcardsAdapter(this);
//        rSub.setAdapter(recyclerLearnVideoAdapter);


        return v;

    }
}
