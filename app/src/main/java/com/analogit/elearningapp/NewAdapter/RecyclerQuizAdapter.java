package com.analogit.elearningapp.NewAdapter;

import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.DailyBoostModel;
import com.analogit.elearningapp.ApiModel.OptionSelectModel;
import com.analogit.elearningapp.ApiModel.SubmitModel;
import com.analogit.elearningapp.Fragments.DailyChallengeFragment;
import com.analogit.elearningapp.Fragments.DailyChallngeAtempetdFragment;
import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class RecyclerQuizAdapter extends RecyclerView.Adapter<RecyclerQuizAdapter.MyViewholder> {

    Context context;
    List<DailyBoostModel> dailyBoostModelList;
    DailyChallengeFragment fragment;
    String option1 = "";
    String option2 = "";
    String option3 = "";
    String option4 = "";
    String option="";
    int pos1 = -1;
    int suUser = 3;
    API REST_CLIENT = RestClient.get();
String date="2021-01-28";
    int pos;
    String pos2="0";

    public RecyclerQuizAdapter(Context context, List<DailyBoostModel> dailyBoostModelList, DailyChallengeFragment dailyChallengeFragment) {
        this.context = context;
        this.dailyBoostModelList = dailyBoostModelList;
        this.fragment = dailyChallengeFragment;
        // this.fragment=fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.total_questions_row, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final MyViewholder holder, final int position) {


        if (position == 0) {
            holder.tv_question.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0da5af")));

            fragment.tv_Total.setText(String.valueOf(dailyBoostModelList.size()));
            fragment.tv_question.setText(dailyBoostModelList.get(0).getQuestion());
            fragment.tv_optA.setText(dailyBoostModelList.get(0).getOption1());
            fragment.tv_optB.setText(dailyBoostModelList.get(0).getOption2());
            fragment.tv_optC.setText(dailyBoostModelList.get(0).getOption3());
            fragment.tv_optD.setText(dailyBoostModelList.get(0).getOption4());



            OptionAtPostion();
        }
        else{
            holder.tv_question.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));

        }

        if (pos1 != -1 && pos1 == position) {
            holder.tv_question.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0da5af")));

            fragment.tv_question.setText(dailyBoostModelList.get(position).getQuestion());
            fragment.tv_optA.setText(dailyBoostModelList.get(position).getOption1());
            fragment.tv_optB.setText(dailyBoostModelList.get(position).getOption2());
            fragment.tv_optC.setText(dailyBoostModelList.get(position).getOption3());
            fragment.tv_optD.setText(dailyBoostModelList.get(position).getOption4());

          AllWhiteColor();


        } else {
            if(position!=0)
                holder.tv_question.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
        }


        holder.tv_question.setText(String.valueOf(position + 1));
        Submit();


        holder.tv_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos1 = holder.getAdapterPosition();


                Options();

                notifyDataSetChanged();

            }

        });
        fragment.tv_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (pos < dailyBoostModelList.size()) {
                    Log.d("mytestingpos", String.valueOf(pos));

                    if (option1.isEmpty() && option2.isEmpty() && option3.isEmpty() && option4.isEmpty()) {

                        fragment.tv_question.setText(dailyBoostModelList.get(pos).getQuestion());
                        fragment.tv_optA.setText(dailyBoostModelList.get(pos).getOption1());
                        fragment.tv_optB.setText(dailyBoostModelList.get(pos).getOption2());
                        fragment.tv_optC.setText(dailyBoostModelList.get(pos).getOption3());
                        fragment.tv_optD.setText(dailyBoostModelList.get(pos).getOption4());
                        pos++;
                        AllWhiteColor();

                        if (pos >= dailyBoostModelList.size())
                            pos = 0;

                    } else {

                        if(!option1.isEmpty()){
                            option =option1;
                            Toast.makeText(context, option, Toast.LENGTH_SHORT).show();
                        }
                        if(!option2.isEmpty()){
                            option =option2;
                            Toast.makeText(context, option, Toast.LENGTH_SHORT).show();
                        }
                        if(!option3.isEmpty()){
                            option =option3;
                            Toast.makeText(context, option, Toast.LENGTH_SHORT).show();
                        }
                        if(!option4.isEmpty()){
                            option=option4;
                            Toast.makeText(context, option, Toast.LENGTH_SHORT).show();

                        }
                            Log.d("selectedans",option);
                            int questionId=dailyBoostModelList.get(pos).getQuestion_id();
                            Log.d("questionmane",String.valueOf(questionId));
                            String time = "20";
                            QuestionResponse(suUser, questionId, option, time);
                            AllWhiteColor();


                    }


                }


            }
        });


    }

    private void OptionAtPostion() {
      //  Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();

        fragment.tv_optA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                option1 = dailyBoostModelList.get(0).getOption1();

                option2="";
                option4="";
                option3="";
                //   Toast.makeText(context, option1, Toast.LENGTH_SHORT).show();
                fragment.layout1.setBackgroundColor(Color.parseColor("#0da5af"));
                fragment.layout2.setBackgroundColor(Color.WHITE);
                fragment.layout3.setBackgroundColor(Color.WHITE);
                fragment.layout4.setBackgroundColor(Color.WHITE);


            }
        });
        fragment.tv_optB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option2 = dailyBoostModelList.get(0).getOption2();


                option1="";
                option4="";
                option3="";
                // Toast.makeText(context, option2, Toast.LENGTH_SHORT).show();
                fragment.layout1.setBackgroundColor(Color.WHITE);
                fragment.layout2.setBackgroundColor(Color.parseColor("#0da5af"));
                fragment.layout3.setBackgroundColor(Color.WHITE);
                fragment.layout4.setBackgroundColor(Color.WHITE);
            }
        });
        fragment.tv_optC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option3 = dailyBoostModelList.get(0).getOption3();
                option1="";
                option4="";
                option2="";
                //   Toast.makeText(context, option3, Toast.LENGTH_SHORT).show();

                fragment.layout1.setBackgroundColor(Color.WHITE);
                fragment.layout2.setBackgroundColor(Color.WHITE);
                fragment.layout3.setBackgroundColor(Color.parseColor("#0da5af"));
                fragment.layout4.setBackgroundColor(Color.WHITE);
            }
        });
        fragment.tv_optD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option4 = dailyBoostModelList.get(0).getOption4();

                option1="";
                option3="";
                option2="";
                //  Toast.makeText(context, option4, Toast.LENGTH_SHORT).show();
                fragment.layout1.setBackgroundColor(Color.WHITE);
                fragment.layout2.setBackgroundColor(Color.WHITE);
                fragment.layout3.setBackgroundColor(Color.WHITE);
                fragment.layout4.setBackgroundColor(Color.parseColor("#0da5af"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dailyBoostModelList.size();
    }

    public static class MyViewholder extends RecyclerView.ViewHolder {
        TextView tv_question;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            tv_question = itemView.findViewById(R.id.tv_total_questions_number);

        }
    }

    public void AllWhiteColor(){
        fragment.layout4.setBackgroundColor(Color.WHITE);
        fragment.layout1.setBackgroundColor(Color.WHITE);
        fragment.layout2.setBackgroundColor(Color.WHITE);
        fragment.layout3.setBackgroundColor(Color.WHITE);

    }
    public void Submit() {

        fragment.tv_submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                Log.d("nanananan",String.valueOf(suUser));


                Call<SubmitModel> submitModel = REST_CLIENT.submit(suUser,date);
                submitModel.enqueue(new Callback<SubmitModel>() {
                    SubmitModel submitModelData;

                    @Override
                    public void onResponse(Call<SubmitModel> call, Response<SubmitModel> response) {
                        submitModelData = response.body();
                        if (response.isSuccessful()) {

                            Bundle args = new Bundle();
                            args.putInt("total_attempts", submitModelData.getTotal_attempts());
                            args.putString("strength", submitModelData.getStrength());
                            args.putInt("average", submitModelData.getAverage());
                            args.putInt("wrong", submitModelData.getWrong());
                            args.putInt("correct", submitModelData.getCorrect());
                            args.putInt("skip", submitModelData.getSkip());
                            args.putInt("accuracy", submitModelData.getAccuracy());
                            args.putInt("rank", submitModelData.getRank());
                            args.putInt("daily_question",submitModelData.getDaily_question());

                            Log.d("quizzzzz",String.valueOf(submitModelData.getRank()));
                            AppCompatActivity activity = (AppCompatActivity) v.getContext();
                            DailyChallngeAtempetdFragment dailyChallngeAtempetdFragment = new DailyChallngeAtempetdFragment();
                            dailyChallngeAtempetdFragment.setArguments(args);
                            activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, dailyChallngeAtempetdFragment).addToBackStack(null).commit();

                        } else {
                            Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SubmitModel> call, Throwable t) {
                        Log.d("failure",t.toString());
                        Toast.makeText(context, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
    public void Options(){

        fragment.tv_optA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                option1 = dailyBoostModelList.get(pos1).getOption1();

                option2="";
                option4="";
                option3="";

                fragment.layout1.setBackgroundColor(Color.parseColor("#0da5af"));
                fragment.layout2.setBackgroundColor(Color.WHITE);
                fragment.layout3.setBackgroundColor(Color.WHITE);
                fragment.layout4.setBackgroundColor(Color.WHITE);


            }
        });
        fragment.tv_optB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option2 = dailyBoostModelList.get(pos1).getOption2();


                option1="";
                option4="";
                option3="";
               // Toast.makeText(context, option2, Toast.LENGTH_SHORT).show();
                fragment.layout1.setBackgroundColor(Color.WHITE);
                fragment.layout2.setBackgroundColor(Color.parseColor("#0da5af"));
                fragment.layout3.setBackgroundColor(Color.WHITE);
                fragment.layout4.setBackgroundColor(Color.WHITE);
            }
        });
        fragment.tv_optC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option3 = dailyBoostModelList.get(pos1).getOption3();
                option1="";
                option4="";
                option2="";
             //   Toast.makeText(context, option3, Toast.LENGTH_SHORT).show();

                fragment.layout1.setBackgroundColor(Color.WHITE);
                fragment.layout2.setBackgroundColor(Color.WHITE);
                fragment.layout3.setBackgroundColor(Color.parseColor("#0da5af"));
                fragment.layout4.setBackgroundColor(Color.WHITE);
            }
        });
        fragment.tv_optD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option4 = dailyBoostModelList.get(pos1).getOption4();

                option1="";
                option3="";
                option2="";
              //  Toast.makeText(context, option4, Toast.LENGTH_SHORT).show();
                fragment.layout1.setBackgroundColor(Color.WHITE);
                fragment.layout2.setBackgroundColor(Color.WHITE);
                fragment.layout3.setBackgroundColor(Color.WHITE);
                fragment.layout4.setBackgroundColor(Color.parseColor("#0da5af"));
            }
        });

    }

    public void QuestionResponse(int user,int questionid,String option,String time) {


        Log.d("loggsss: ", suUser + "    questionid is: " + questionid + "    time is: " + time+"answer is"+option);

        JsonObject v1 = new JsonObject();
        v1.addProperty("user_id", user);
        v1.addProperty("question_id", questionid);
        v1.addProperty("ans", option);
        v1.addProperty("time", time);


        Log.d("loggsss: ", suUser + "    questionid is: " + questionid + "    time is: " + time+"answer is"+option);


        Call<OptionSelectModel> optionresponce = REST_CLIENT.validateOption(v1);

        optionresponce.enqueue(new Callback<OptionSelectModel>() {
            OptionSelectModel optionSelectModelData;

            @Override
            public void onResponse(Call<OptionSelectModel> call, Response<OptionSelectModel> response) {
                optionSelectModelData = response.body();


                if (response.isSuccessful()) {


                    pos++;
                    if (pos < dailyBoostModelList.size()) {


                        Log.d("quiz", String.valueOf(pos));
                        fragment.tv_question.setText(dailyBoostModelList.get(pos).getQuestion());
                        fragment.tv_optA.setText(dailyBoostModelList.get(pos).getOption1());
                        fragment.tv_optB.setText(dailyBoostModelList.get(pos).getOption2());
                        fragment.tv_optC.setText(dailyBoostModelList.get(pos).getOption3());
                        fragment.tv_optD.setText(dailyBoostModelList.get(pos).getOption4());
                    } else {
                        pos = 0;
                        fragment.tv_question.setText(dailyBoostModelList.get(pos).getQuestion());
                        fragment.tv_optA.setText(dailyBoostModelList.get(pos).getOption1());
                        fragment.tv_optB.setText(dailyBoostModelList.get(pos).getOption2());
                        fragment.tv_optC.setText(dailyBoostModelList.get(pos).getOption3());
                        fragment.tv_optD.setText(dailyBoostModelList.get(pos).getOption4());

                    }


                } else {

                    Log.d("quizzzzz", response.message());
                   // Toast.makeText(context, response.toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OptionSelectModel> call, Throwable t) {
                Log.d("fauilue", t.toString());
                Toast.makeText(context, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
            }
        });

    }

}