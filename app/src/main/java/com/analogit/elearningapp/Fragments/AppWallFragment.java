package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Adapters.RecyclerVIPAdapter;
import com.analogit.elearningapp.Adapters.RecyclerMedicalAdapter;
import com.analogit.elearningapp.R;

public class AppWallFragment extends Fragment {

   private View v;
   private RecyclerView recyclerView,rAppvideos;
   private ExpandableListView expandableListView;
   private ImageView medicalImage;
   private CardView cardView,cardProof;
   private RecyclerMedicalAdapter recyclerMedicalAdapter;
   private RecyclerVIPAdapter recyclerAppwallAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v= inflater.inflate(R.layout.appwall_layout, container, false);
        recyclerView=v.findViewById(R.id.ll_rec);
        expandableListView=v.findViewById(R.id.ll_elist);
        medicalImage=v.findViewById(R.id.imageView2);
        cardView=v.findViewById(R.id.cardview_medical);
        rAppvideos=v.findViewById(R.id.rec_app_wall);
        cardProof=v.findViewById(R.id.card_view_proof);
       cardView.setVisibility(View.GONE);
        cardProof.setVisibility(View.GONE);
       rAppvideos.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
       recyclerAppwallAdapter=new RecyclerVIPAdapter(this);
       rAppvideos.setAdapter(recyclerAppwallAdapter);


        medicalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.VISIBLE);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

                recyclerMedicalAdapter=new RecyclerMedicalAdapter(AppWallFragment.this);
                recyclerView.setAdapter(recyclerMedicalAdapter);

            }
        });



        return v;
    }

}
