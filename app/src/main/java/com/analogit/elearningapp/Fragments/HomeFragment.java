package com.analogit.elearningapp.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerVIPAdapter;
import com.analogit.elearningapp.Adapters.RecyclerDoctorAdapter;
import com.analogit.elearningapp.Adapters.RecyclerLiveTestAdapterPartTwo;
import com.analogit.elearningapp.ApiModel.HomeBannerModel;
import com.analogit.elearningapp.ApiModel.QuestionOfDayModel;
import com.analogit.elearningapp.ApiModel.TeachersModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;
import com.bumptech.glide.Glide;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;


public class HomeFragment extends Fragment {

    View v;
    ImageView Imenu, Isearch, Igroup;
    RecyclerView videorView, apprwall, DrView;
    RecyclerLiveTestAdapterPartTwo recyclerLiveTestAdapter;
    RecyclerDoctorAdapter recyclerDoctorAdapter;
    RecyclerVIPAdapter recyclerAppwallAdapter;
    CarouselView carouselView;
    CardView daily_challenge,card_liveclass;
    ImageView ivwallposter, groupDiscussion;
    ArrayList<String> arrayListhomeBanner = new ArrayList<>();
    TextView tv_Question,tv_otpA,tv_otpB,tv_otpC,tv_otpD;
    CardView cardView, imageBankCard;
    API REST_CLIENT;
    int val=1;
    ProgressBar progressBar;
    private TextView seeExplanation, schedule, tvShare;
ArrayList<TeachersModel>teachersModelListData=new ArrayList<>();

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

        v = inflater.inflate(R.layout.fragment_home, container, false);
      //  getActivity().getWindow().setbac


            ViewIds();

        //  HomeBanners();
        QuestionOfDay();

        tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "bagunnava");
                sendIntent.setType("text/plain");

                Intent share = Intent.createChooser(sendIntent, null);
                startActivity(share);
            }
        });


        groupDiscussion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new GroupDiscussionFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        ivwallposter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new WallPosterGridfFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        imageBankCard = v.findViewById(R.id.image_bank_card_view);
        cardView = v.findViewById(R.id.card_fh);
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.VISIBLE);





        imageBankCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new ImagesBankFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new IcardsAllTabsFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        daily_challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new DailyChallengeFragment());
                fr.addToBackStack(null);
                fr.commit();

            }
        });

        card_liveclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                DRLearnFragment homeLiveClassFragment=  new DRLearnFragment();
                Bundle args=new Bundle();
                args.putInt("pos",val);
                homeLiveClassFragment.setArguments(args);
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, homeLiveClassFragment);
                fr.addToBackStack(null);
                fr.commit();
            }
        });


//        videorView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
//        recyclerLiveTestAdapter = new RecyclerLiveTestAdapterPartTwo(this);
//        videorView.setAdapter(recyclerLiveTestAdapter);


        apprwall.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        recyclerAppwallAdapter = new RecyclerVIPAdapter(this);
        apprwall.setAdapter(recyclerAppwallAdapter);



        Call<List<TeachersModel>>call=REST_CLIENT.getTech();
        call.enqueue(new Callback<List<TeachersModel>>() {
            List<TeachersModel> teachersModelList;
            TeachersModel teachersData;
            @Override
            public void onResponse(Call<List<TeachersModel>> call, Response<List<TeachersModel>> response) {
                teachersModelList=response.body();
                if(response.isSuccessful()){
                    for (int i=0;i<teachersModelList.size();i++){
                        teachersData=teachersModelList.get(i);
                        teachersModelListData.add(new TeachersModel(teachersData.getId(),teachersData.getSubject(),teachersData.getName(),teachersData.getImage(),teachersData.getExperience(),teachersData.getS_name()));
                    }
                }
                DrView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
                recyclerDoctorAdapter = new RecyclerDoctorAdapter(getContext(),teachersModelListData);
                DrView.setAdapter(recyclerDoctorAdapter);
                recyclerDoctorAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<TeachersModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Please check Internet connection!", Toast.LENGTH_SHORT).show();

            }
        });



        Imenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (((MainActivity) (getActivity())).drawerLayout.isDrawerOpen(GravityCompat.START)) {

                    ((MainActivity) (getActivity())).drawerLayout.closeDrawer(GravityCompat.START);

                } else {
                    ((MainActivity) (getActivity())).drawerLayout.openDrawer(GravityCompat.START);


                }

            }
        });


        return v;

    }

public void ViewIds(){
    Imenu = v.findViewById(R.id.iv_fh_menu_style);
    Isearch = v.findViewById(R.id.iv_fh_searh);
    Igroup = v.findViewById(R.id.iv_fh_group);
    daily_challenge = v.findViewById(R.id.todays_challenge);
   // videorView = v.findViewById(R.id.rec_fh_live_rec);
    apprwall = v.findViewById(R.id.rec_dr_wall);
    DrView = v.findViewById(R.id.fh_rec_doctors);
    //carouselView = v.findViewById(R.id.fh_carousel);
    seeExplanation = v.findViewById(R.id.tv_see_explanation);
    groupDiscussion = v.findViewById(R.id.iv_fh_group);
    tvShare = v.findViewById(R.id.tv_daily_qiuz_share);
  card_liveclass = v.findViewById(R.id.card_live_class);
    ivwallposter = v.findViewById(R.id.wallposter_image);
    tv_Question=v.findViewById(R.id.tv_question);
    tv_otpA=v.findViewById(R.id.tv_opton_one);
    tv_otpB=v.findViewById(R.id.tv_opton_two);
    tv_otpC=v.findViewById(R.id.tv_opton_three);
    tv_otpD=v.findViewById(R.id.tv_opton_four);
    progressBar=v.findViewById(R.id.progress_bar);
    progressBar.setProgress(80);
    REST_CLIENT = RestClient.get();
    }
    public void HomeBanners() {
        Call<List<HomeBannerModel>> homebanner = REST_CLIENT.getBanners();
        homebanner.enqueue(new Callback<List<HomeBannerModel>>() {
            List<HomeBannerModel> homeBannerList;
            HomeBannerModel homeBannerModelData;
            @Override
            public void onResponse(Call<List<HomeBannerModel>> call, Response<List<HomeBannerModel>> response) {
                homeBannerList = response.body();
                if (response.isSuccessful()) {
                    arrayListhomeBanner.clear();

                    for (int i = 0; i < homeBannerList.size(); i++) {
                        homeBannerModelData = homeBannerList.get(i);
                        arrayListhomeBanner.add(homeBannerModelData.getImage());
                        carouselView.setImageListener(new ImageListener() {
                            @Override
                            public void setImageForPosition(int position, ImageView imageView) {

                                Glide.with(getContext()).load(Image_Url + homeBannerList.get(position).getImage()).into(imageView);

                            }
                        });

                        carouselView.setPageCount(arrayListhomeBanner.size());



                        carouselView.setImageClickListener(new ImageClickListener() {
                            @Override
                            public void onClick(int position) {
                                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                                fr.replace(R.id.content, new MorningRoundTabsFragment());
                                fr.addToBackStack(null);
                                fr.commit();
                            }
                        });

                    }

                }
            }

            @Override
            public void onFailure(Call<List<HomeBannerModel>> call, Throwable t) {
                Log.i("nothing", t.toString());

                Toast.makeText(getContext(), "Please check Internet connection!", Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void QuestionOfDay(){

        Call<QuestionOfDayModel>question=REST_CLIENT.getQuestionofDay();
        question.enqueue(new Callback<QuestionOfDayModel>() {
            QuestionOfDayModel questionOfDayData;
            @Override
            public void onResponse(Call<QuestionOfDayModel> call, Response<QuestionOfDayModel> response) {
                questionOfDayData=response.body();
                if(response.isSuccessful()){
                    tv_Question.setText(questionOfDayData.getQuestion());
                    tv_otpA.setText("A."+" "+questionOfDayData.getOptoin1());
                    tv_otpB.setText("B."+" "+questionOfDayData.getOptoin2());
                    tv_otpC.setText("C."+" "+questionOfDayData.getOptoin3());
                    tv_otpD.setText("D."+" "+questionOfDayData.getOptoin4());
                    SelectOptions();
                seeExplanation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SeeExplantionFragment seeExplantionFragment=new SeeExplantionFragment();
                        Bundle args=new Bundle();
                        args.putInt("question_id",questionOfDayData.getQuestion_id());
                        args.putString("answer_of_question",questionOfDayData.getAnswer_of_question());
                        args.putString("question",questionOfDayData.getQuestion());
                        args.putString("optionone",questionOfDayData.getOptoin1());
                        args.putString("optiontwo",questionOfDayData.getOptoin2());
                        args.putString("optionthree",questionOfDayData.getOptoin3());
                        args.putString("optionfour",questionOfDayData.getOptoin4());
                        args.putString("answer",questionOfDayData.getAnswer_of_question());
                        args.putString("dec",questionOfDayData.getAns_description());
                        seeExplantionFragment.setArguments(args);
                        FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                        fr.replace(R.id.content, seeExplantionFragment);
                        fr.addToBackStack(null);
                        fr.commit();
                    }
                });
                }
            }

            @Override
            public void onFailure(Call<QuestionOfDayModel> call, Throwable t) {
                Toast.makeText(getContext(), "Please check Internet connection!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void SelectOptions(){

            tv_otpA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    tv_otpA.setBackgroundColor(Color.parseColor("#0da5af"));
                    tv_otpB.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                    tv_otpC.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                    tv_otpD.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));

                    tv_otpA.setTextColor(Color.parseColor("#ffffff"));
                    tv_otpB.setTextColor(Color.parseColor("#8c8c8c"));
                    tv_otpC.setTextColor(Color.parseColor("#8c8c8c"));
                    tv_otpD.setTextColor(Color.parseColor("#8c8c8c"));





                }
            });
        tv_otpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_otpB.setBackgroundColor(Color.parseColor("#0da5af"));
                tv_otpA.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                tv_otpC.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                tv_otpD.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                tv_otpB.setTextColor(Color.parseColor("#ffffff"));

                tv_otpB.setTextColor(Color.parseColor("#ffffff"));
                tv_otpD.setTextColor(Color.parseColor("#8c8c8c"));
                tv_otpC.setTextColor(Color.parseColor("#8c8c8c"));
                tv_otpA.setTextColor(Color.parseColor("#8c8c8c"));


            }
        });
        tv_otpC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                tv_otpC.setBackgroundColor(Color.parseColor("#0da5af"));
                tv_otpA.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                tv_otpB.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                tv_otpD.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                tv_otpC.setTextColor(Color.parseColor("#ffffff"));

                tv_otpC.setTextColor(Color.parseColor("#ffffff"));
                tv_otpB.setTextColor(Color.parseColor("#8c8c8c"));
                tv_otpD.setTextColor(Color.parseColor("#8c8c8c"));
                tv_otpA.setTextColor(Color.parseColor("#8c8c8c"));


            }
        });
        tv_otpD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                tv_otpD.setBackgroundColor(Color.parseColor("#0da5af"));
                tv_otpA.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                tv_otpC.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                tv_otpB.setBackgroundDrawable(getResources().getDrawable(R.drawable.ll_bg_tv_bt));
                tv_otpD.setTextColor(Color.parseColor("#ffffff"));

                tv_otpD.setTextColor(Color.parseColor("#ffffff"));
                tv_otpB.setTextColor(Color.parseColor("#8c8c8c"));
                tv_otpC.setTextColor(Color.parseColor("#8c8c8c"));
                tv_otpA.setTextColor(Color.parseColor("#8c8c8c"));


            }
        });


    }

}
