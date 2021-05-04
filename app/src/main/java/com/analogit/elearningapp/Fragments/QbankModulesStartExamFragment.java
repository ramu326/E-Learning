package com.analogit.elearningapp.Fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.analogit.elearningapp.Activities.MainActivity;

import com.analogit.elearningapp.R;

public class QbankModulesStartExamFragment extends Fragment {
    View v;
    LinearLayout linearLayout;
    CardView cardViewOption;
    ImageView ivAttemtedQuest;
    TextView tvNext;
    CardView cardViewOne,cardViewTwo,cardViewThree,cardViewFour;
    TextView srNo,optA,optB,optC,optD,tvQues,tvA,tvB,tvC,tvD;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.subject_with_topic_name_questions_layout,container,false);
        linearLayout=v.findViewById(R.id.ll_explanation_with_percent_sub_with_fr);

        ivAttemtedQuest=v.findViewById(R.id.fr_sub_with_topic_attempted_questions);
        tvNext=v.findViewById(R.id.topic_tv_next_sub_with_fr);
        cardViewOne=v.findViewById(R.id.card_one);
        cardViewTwo=v.findViewById(R.id.card_two);
        cardViewThree=v.findViewById(R.id.card_three);
        cardViewFour=v.findViewById(R.id.card_four);
        optA=v.findViewById(R.id.option_a);
        optB=v.findViewById(R.id.option_b);
        optC=v.findViewById(R.id.option_c);
        optD=v.findViewById(R.id.option_d);
        tvQues=v.findViewById(R.id.qbank_module_quest);

        tvA=v.findViewById(R.id.tv_a);
        tvB=v.findViewById(R.id.tv_b);
        tvC=v.findViewById(R.id.tv_c);
        tvD=v.findViewById(R.id.tv_d);

        CardViewBackgroundcolorMethod();


        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new GrandTestFinalReportFragment());
                fr.addToBackStack(null);
                fr.commit();

            }
        });
      //  linearLayout.setVisibility(View.GONE);

        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

     /////this is important dont delete
//        cardViewOption.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                linearLayout.setVisibility(View.VISIBLE);
//            }
//        });
//        ivAttemtedQuest.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                BottomSheetFragment bottomSheetFragment=new BottomSheetFragment();
//                bottomSheetFragment.show(getActivity().getSupportFragmentManager(),"bottomsheet");
//            }
//        });
        return v;
    }

    private void CardViewBackgroundcolorMethod() {

        cardViewOne.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                cardViewOne.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0da5af")));
                cardViewTwo.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                cardViewThree.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                cardViewFour.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));


                optA.setTextColor(getResources().getColor(R.color.white));
                optB.setTextColor(getResources().getColor(R.color.black));
                optC.setTextColor(getResources().getColor(R.color.black));
                optD.setTextColor(getResources().getColor(R.color.black));

                tvA.setTextColor(getResources().getColor(R.color.white));
                tvB.setTextColor(getResources().getColor(R.color.black));
                tvC.setTextColor(getResources().getColor(R.color.black));
                tvD.setTextColor(getResources().getColor(R.color.black));
            }
        });
        cardViewTwo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                cardViewOne.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                cardViewTwo.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0da5af")));
                cardViewThree.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                cardViewFour.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));


                optA.setTextColor(getResources().getColor(R.color.black));
                optB.setTextColor(getResources().getColor(R.color.white));
                optC.setTextColor(getResources().getColor(R.color.black));
                optD.setTextColor(getResources().getColor(R.color.black));

                tvA.setTextColor(getResources().getColor(R.color.black));
                tvB.setTextColor(getResources().getColor(R.color.white));
                tvC.setTextColor(getResources().getColor(R.color.black));
                tvD.setTextColor(getResources().getColor(R.color.black));
            }
        });
        cardViewThree.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                cardViewOne.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                cardViewTwo.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                cardViewThree.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0da5af")));
                cardViewFour.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));


                optA.setTextColor(getResources().getColor(R.color.black));
                optB.setTextColor(getResources().getColor(R.color.black));
                optC.setTextColor(getResources().getColor(R.color.white));
                optD.setTextColor(getResources().getColor(R.color.black));

                tvA.setTextColor(getResources().getColor(R.color.black));
                tvB.setTextColor(getResources().getColor(R.color.black));
                tvC.setTextColor(getResources().getColor(R.color.white));
                tvD.setTextColor(getResources().getColor(R.color.black));
            }
        });
        cardViewFour.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                cardViewOne.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                cardViewTwo.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                cardViewThree.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
                cardViewFour.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0da5af")));


                optA.setTextColor(getResources().getColor(R.color.black));
                optB.setTextColor(getResources().getColor(R.color.black));
                optC.setTextColor(getResources().getColor(R.color.black));
                optD.setTextColor(getResources().getColor(R.color.white));

                tvA.setTextColor(getResources().getColor(R.color.black));
                tvB.setTextColor(getResources().getColor(R.color.black));
                tvC.setTextColor(getResources().getColor(R.color.black));
                tvD.setTextColor(getResources().getColor(R.color.white));
            }
        });
    }
}
