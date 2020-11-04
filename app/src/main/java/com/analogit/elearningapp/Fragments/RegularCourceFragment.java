package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerRegularNTrAdapter;
import com.analogit.elearningapp.R;

public class RegularCourceFragment extends Fragment {
    private  View v;
   private RecyclerView rView;
   private RecyclerRegularNTrAdapter recyclerRegularNTrAdapter;

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
       v= inflater.inflate(R.layout.regular_fragment, container, false);

       rView=v.findViewById(R.id.rf_rview);

       rView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
       recyclerRegularNTrAdapter=new RecyclerRegularNTrAdapter(this);
       rView.setAdapter(recyclerRegularNTrAdapter);

       return v;
    }
}
