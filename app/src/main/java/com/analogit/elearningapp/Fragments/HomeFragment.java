package com.analogit.elearningapp.Fragments;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerAppwallAdapter;
import com.analogit.elearningapp.Adapters.RecyclerDoctorAdapter;
import com.analogit.elearningapp.Adapters.RecyclerHomeImageOAdapter;
import com.analogit.elearningapp.Adapters.RecyclerHomeImageTAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLectureAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLiveClassAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLiveTestAdapter;
import com.analogit.elearningapp.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;


public class HomeFragment extends Fragment {

    private View v;
    ImageView Imenu,Isearch,Igroup;
    private  int[] images=new int[]{
            R.drawable.home_image,R.drawable.home_itwo,R.drawable.home_three_image
    };
    private RecyclerView videorView,apprwall,DrView,LrView;


    private RecyclerLiveTestAdapter recyclerLiveTestAdapter;
    private RecyclerDoctorAdapter recyclerDoctorAdapter;
    private RecyclerAppwallAdapter recyclerAppwallAdapter;
    private RecyclerLectureAdapter recyclerLectureAdapter;
    private CarouselView carouselView;
    private  ImageView iv_Recall,viewAppwall,liveViewall;
    private CardView daily_challenge;
    private  ImageView icards;
    private CardView cardView;
    private TextView seeExplanation,schedule;

    public HomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      v= inflater.inflate(R.layout.fragment_home, container, false);
      Imenu=v.findViewById(R.id.iv_fh_menu_style);
      Isearch=v.findViewById(R.id.iv_fh_searh);
      Igroup=v.findViewById(R.id.iv_fh_group);

        daily_challenge=v.findViewById(R.id.todays_challenge);
       videorView=v.findViewById(R.id.rec_fh_live_rec);
        apprwall=v.findViewById(R.id.rec_dr_wall);
      DrView=v.findViewById(R.id.fh_rec_doctors);
      //LrView=v.findViewById(R.id.fh_lecture_rec);
      carouselView=v.findViewById(R.id.fh_carousel);
     seeExplanation=v.findViewById(R.id.tv_see_explanation);
    //  viewAllWall=v.findViewById(R.id.iv_fh_view_wall);
     // viewAppwall=v.findViewById(R.id.iv_fh_wall_view);
    //  liveViewall=v.findViewById(R.id.fh_live_all);
        schedule=v.findViewById(R.id.tv_fh_live_all);
     // icards=v.findViewById(R.id.fh_card_image_bank);
      cardView=v.findViewById(R.id.card_fh);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.VISIBLE);

      carouselView.setPageCount(images.length);
      carouselView.setImageListener(new ImageListener() {
          @Override
          public void setImageForPosition(int position, ImageView imageView) {
              imageView.setImageResource(images[position]);
          }
      });
      carouselView.setImageClickListener(new ImageClickListener() {
          @Override
          public void onClick(int position) {

              FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
              fr.replace(R.id.content,new MorningRoundTabsFragment());
              fr.addToBackStack(null);
              fr.commit();

          }
      });

seeExplanation.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.content,new SeeExplantionFragment());
        fr.addToBackStack(null);
        fr.commit();
    }
});




cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
         FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
         fr.replace(R.id.content,new IcardsAllTabsFragment());
         fr.addToBackStack(null);
         fr.commit();
    }
});
        daily_challenge.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.content,new DailyChallengeFragment());
        fr.addToBackStack(null);
        fr.commit();

    }
});

schedule.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.content,new BothTestNLiveFragment());
        fr.addToBackStack(null);
        fr.commit();
    }
});


        videorView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerLiveTestAdapter=new RecyclerLiveTestAdapter(this);
        videorView.setAdapter(recyclerLiveTestAdapter);





        apprwall.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerAppwallAdapter=new RecyclerAppwallAdapter(this);
        apprwall.setAdapter(recyclerAppwallAdapter);


        //fifth RecyclerView
        DrView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        recyclerDoctorAdapter=new RecyclerDoctorAdapter(this);
        DrView.setAdapter(recyclerDoctorAdapter);
//sixth RecyclerView
//        LrView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
//        recyclerLectureAdapter=new RecyclerLectureAdapter(this);
//        LrView.setAdapter(recyclerLectureAdapter);
        Imenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("home123","drawwrwr");
                if (((MainActivity)(getActivity())).drawerLayout.isDrawerOpen(GravityCompat.START)){
                    Log.d("if123","open");
                    ((MainActivity)(getActivity())).drawerLayout.closeDrawer(GravityCompat.START);

                }

                else{
                    ((MainActivity)(getActivity())).drawerLayout.openDrawer(GravityCompat.START);
                    Log.d("if456","close");

                }

            }
        });


      return v;

    }


}
