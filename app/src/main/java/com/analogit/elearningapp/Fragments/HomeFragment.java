package com.analogit.elearningapp.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.Adapters.RecyclerDoctorAdapter;
import com.analogit.elearningapp.ApiModel.HomeBannerModel;
import com.analogit.elearningapp.ApiModel.QuestionOfDayModel;
import com.analogit.elearningapp.ApiModel.SuggestedModel;
import com.analogit.elearningapp.ApiModel.TeachersModel;
import com.analogit.elearningapp.NewAdapter.RecyclerDrwallAdapter;
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
    ImageView Imenu, Isearch, Igroup, whatup, facebook, twitter, instagram, more, Icards, ImageBank;
    RecyclerView recsuggested, DrView;
    RecyclerDoctorAdapter recyclerDoctorAdapter;
    CarouselView carouselView;
    ImageView daily_challenge;
    ImageView card_liveclass;
    ImageView askdoubts;
    ImageView ivwallposter, groupDiscussion;
    ArrayList<String> arrayListhomeBanner = new ArrayList<>();
    TextView tv_Question, tv_otpA, tv_otpB, tv_otpC, tv_otpD, doctorname;
    ImageView Diagnosis, RecentUpdates, values;
    API REST_CLIENT;
    int val = 1;
    ProgressBar progressBar;
    private TextView seeExplanation;
    ArrayList<SuggestedModel> arrayList = new ArrayList<>();
    ArrayList<TeachersModel> teachersModelListData = new ArrayList<>();
    private static final String PREF_NAME = "SharedPref";
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    String  content = "application/json";
    int PRIVATE_MODE = 0;

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

//        tvShare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT, "bagunnava");
//                sendIntent.setType("text/plain");
//
//                Intent share = Intent.createChooser(sendIntent, null);
//                startActivity(share);
//            }
//        });


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

        // imageBankCard = v.findViewById(R.id.image_bank_card_view);
        // cardView = v.findViewById(R.id.card_fh);
        ((MainActivity) (getActivity())).bottomNavigationView.setVisibility(View.VISIBLE);


        ImageBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new ImagesBankFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        Icards.setOnClickListener(new View.OnClickListener() {
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
        Diagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new DiffrentailDiagnosisFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        RecentUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new RecentUpdatesFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        values.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new DrNotesFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        // DrNotesFragment
        askdoubts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, new GroupDiscussionQuestionPostFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        card_liveclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                DRLearnFragment homeLiveClassFragment = new DRLearnFragment();
                Bundle args = new Bundle();
                args.putInt("pos", val);
                homeLiveClassFragment.setArguments(args);
                FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content, homeLiveClassFragment);
                fr.addToBackStack(null);
                fr.commit();
            }
        });


        recsuggested.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        Call<List<SuggestedModel>> call = REST_CLIENT.getsuggetdata();
        call.enqueue(new Callback<List<SuggestedModel>>() {
            List<SuggestedModel> suggestedModelList;
            SuggestedModel suggestedModelMap;

            @Override
            public void onResponse(Call<List<SuggestedModel>> call, Response<List<SuggestedModel>> response) {
                suggestedModelList = response.body();
                if (response.isSuccessful()) {
                    arrayList.clear();
                    for (int i = 0; i < suggestedModelList.size(); i++) {
                        suggestedModelMap = suggestedModelList.get(i);
                        arrayList.add(new SuggestedModel(suggestedModelMap.getId(), suggestedModelMap.getTopicId(), suggestedModelMap.getName(), suggestedModelMap.getVideo(), suggestedModelMap.getImage(), suggestedModelMap.getRounds()));
                    }
                    RecyclerDrwallAdapter recyclerDrwallAdapter = new RecyclerDrwallAdapter(getContext(), arrayList);
                    recsuggested.setAdapter(recyclerDrwallAdapter);
                    recyclerDrwallAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<SuggestedModel>> call, Throwable t) {
                if (getContext() != null)
                    Toast.makeText(getContext(), "Please check Internet connection!", Toast.LENGTH_SHORT).show();
            }
        });


        DrView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        Call<List<TeachersModel>> call1 = REST_CLIENT.getTech();
        call1.enqueue(new Callback<List<TeachersModel>>() {
            List<TeachersModel> teachersModelList;
            TeachersModel teachersData;

            @Override
            public void onResponse(Call<List<TeachersModel>> call, Response<List<TeachersModel>> response) {
                teachersModelList = response.body();
                teachersModelListData.clear();
                if (response.isSuccessful()) {
                    for (int i = 0; i < teachersModelList.size(); i++) {
                        teachersData = teachersModelList.get(i);
                        teachersModelListData.add(new TeachersModel(teachersData.getId(), teachersData.getSubject(), teachersData.getName(), teachersData.getImage(), teachersData.getExperience(), teachersData.getS_name()));
                    }
                }
                recyclerDoctorAdapter = new RecyclerDoctorAdapter(getContext(), teachersModelListData);
                DrView.setAdapter(recyclerDoctorAdapter);
                recyclerDoctorAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<TeachersModel>> call, Throwable t) {
                if (getContext() != null)
                  Toast.makeText(getContext(), "Please check Internet connection!", Toast.LENGTH_SHORT).show();

            }
        });

        whatup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, "The text you wanted to share");
                try {
                    getActivity().startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    //   ToastHelper.MakeShortText("Whatsapp have not been installed.");
                }
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Wonderful search engine http://www.google.fr/");
                startActivity(Intent.createChooser(intent, "Share with"));
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

    public void ViewIds() {
        Imenu = v.findViewById(R.id.iv_fh_menu_style);
        Isearch = v.findViewById(R.id.iv_fh_searh);
        Igroup = v.findViewById(R.id.iv_fh_group);
        daily_challenge = v.findViewById(R.id.todays_challenge);
        Icards = v.findViewById(R.id.fh_icard_head);
        recsuggested = v.findViewById(R.id.rec_suggested_rec);
        DrView = v.findViewById(R.id.fh_rec_doctors);
        ImageBank = v.findViewById(R.id.fh_card_image_bank);
        seeExplanation = v.findViewById(R.id.tv_see_explanation);
        groupDiscussion = v.findViewById(R.id.iv_fh_group);
        // tvShare = v.findViewById(R.id.tv_daily_qiuz_share);
        card_liveclass = v.findViewById(R.id.card_live_class);
        ivwallposter = v.findViewById(R.id.wallposter_image);
        tv_Question = v.findViewById(R.id.tv_question);
        tv_otpA = v.findViewById(R.id.tv_opton_one);
        tv_otpB = v.findViewById(R.id.tv_opton_two);
        tv_otpC = v.findViewById(R.id.tv_opton_three);
        tv_otpD = v.findViewById(R.id.tv_opton_four);
        progressBar = v.findViewById(R.id.progress_bar);
        whatup = v.findViewById(R.id.iv_whatsup);
        facebook = v.findViewById(R.id.iv_facebook);
        twitter = v.findViewById(R.id.iv_twitter);
        instagram = v.findViewById(R.id.iv_instagram);
        more = v.findViewById(R.id.iv_more);
        Diagnosis = v.findViewById(R.id.card_pearl);
        RecentUpdates = v.findViewById(R.id.card_pear);
        askdoubts = v.findViewById(R.id.ask_doubts);
        values = v.findViewById(R.id.values);
        doctorname = v.findViewById(R.id.tv_doctor_name);
        progressBar.setProgress(10);
        REST_CLIENT = RestClient.get();
        pref = getActivity().getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        //    user = session.getUserDetails();
        editor = pref.edit();
        doctorname.setText(pref.getString("name", "-1"));

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
                if (getContext() != null)
                Toast.makeText(getContext(), "Please check Internet connection!", Toast.LENGTH_SHORT).show();


            }
        });

    }

    public void QuestionOfDay() {

        Call<QuestionOfDayModel> question = REST_CLIENT.getQuestionofDay(pref.getString("token", "-1"), content);
        question.enqueue(new Callback<QuestionOfDayModel>() {
            QuestionOfDayModel questionOfDayData;

            @Override
            public void onResponse(Call<QuestionOfDayModel> call, Response<QuestionOfDayModel> response) {
                questionOfDayData = response.body();
                if (response.isSuccessful()) {
                    tv_Question.setText(questionOfDayData.getQuestion());
                    tv_otpA.setText("A." + " " + questionOfDayData.getOptoin1());
                    tv_otpB.setText("B." + " " + questionOfDayData.getOptoin2());
                    tv_otpC.setText("C." + " " + questionOfDayData.getOptoin3());
                    tv_otpD.setText("D." + " " + questionOfDayData.getOptoin4());
                    SelectOptions();
                    seeExplanation.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SeeExplantionFragment seeExplantionFragment = new SeeExplantionFragment();
                            Bundle args = new Bundle();
                            args.putInt("question_id", questionOfDayData.getQuestion_id());
                            args.putString("answer_of_question", questionOfDayData.getAnswer_of_question());
                            args.putString("question", questionOfDayData.getQuestion());
                            args.putString("optionone", questionOfDayData.getOptoin1());
                            args.putString("optiontwo", questionOfDayData.getOptoin2());
                            args.putString("optionthree", questionOfDayData.getOptoin3());
                            args.putString("optionfour", questionOfDayData.getOptoin4());
                            args.putString("answer", questionOfDayData.getAnswer_of_question());
                            args.putString("dec", questionOfDayData.getAns_description());
                            args.putString("image",questionOfDayData.getAnswer_image());
                            seeExplantionFragment.setArguments(args);

                            FragmentTransaction fr = getActivity().getSupportFragmentManager().beginTransaction();
                            fr.replace(R.id.content, seeExplantionFragment);
                            fr.addToBackStack(null);
                            fr.commit();
                        }
                    });
                } else {
                    // Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<QuestionOfDayModel> call, Throwable t) {

                //   Toast.makeText(getContext(),"Please check Internet connection!",Toast.LENGTH_SHORT).show();
                if (getContext() != null)
                    Toast.makeText(getContext(), "Please check Internet connection !", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void SelectOptions() {

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
