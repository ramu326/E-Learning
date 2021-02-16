package com.analogit.elearningapp.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.analogit.elearningapp.Activities.MainActivity;
import com.analogit.elearningapp.ApiModel.QuestionOfDayDecModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeeExplantionFragment  extends Fragment {
    private View v;
    TextView tv_Question,tv_otpA,tv_otpB,tv_otpC,tv_otpD,tv_Dec;
    API REST_CLIENT;
    int value;
    String questuin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.question_of_the_day_explanation, container, false);

        viewIds();
        SeeExplanation();
        value=getArguments().getInt("question_id");
        questuin=getArguments().getString("answer");
        Log.d("ansmessage1",String.valueOf(value)+ "name"+questuin);
        ((MainActivity)(getActivity())).bottomNavigationView.setVisibility(View.GONE);

          tv_Question.setText("Q."+""+getArguments().getString("question"));
          tv_otpA.setText("A."+" "+getArguments().getString("optionone"));
         tv_otpB.setText("B."+" "+getArguments().getString("optiontwo"));
         tv_otpC.setText("C."+" "+getArguments().getString("optionthree"));
          tv_otpD.setText("D."+" "+getArguments().getString("optionfour"));
          tv_Dec.setText(getArguments().getString("dec"));

        return v;
    }
    public void viewIds(){
        tv_Question=v.findViewById(R.id.tv_main_question);
        tv_otpA=v.findViewById(R.id.tv_expl_option_one);
        tv_otpB=v.findViewById(R.id.tv_expl_option_two);
        tv_otpC=v.findViewById(R.id.tv_expl_option_three);
        tv_otpD=v.findViewById(R.id.tv_expl_option_four);
        tv_Dec=v.findViewById(R.id.tv_expl_solution);
        REST_CLIENT= RestClient.get();

    }
    public void SeeExplanation(){
        Log.d("answermessage",getArguments().getInt("question_id")+ "name"+getArguments().getString("answer_of_question"));



        Call<QuestionOfDayDecModel>question=REST_CLIENT.getQuestionDec(getArguments().getInt("question_id"),getArguments().getString("answer_of_question"));
        question.enqueue(new Callback<QuestionOfDayDecModel>() {
            QuestionOfDayDecModel questionData;
            @Override
            public void onResponse(Call<QuestionOfDayDecModel> call, Response<QuestionOfDayDecModel> response) {
                if (response.isSuccessful()){
                    questionData=response.body();


                  if(getArguments().getString("optionone").equals(questionData.getAnswer())){
                      tv_otpA.setBackgroundColor(Color.parseColor("#0da5af"));
                      tv_otpA.setTextColor(Color.parseColor("#ffffff"));
                  }
                  else if(getArguments().getString("optiontwo").equals(questionData.getAnswer())){
                      tv_otpB.setBackgroundColor(Color.parseColor("#0da5af"));
                      tv_otpB.setTextColor(Color.parseColor("#ffffff"));
                  }
                  else if(getArguments().getString("optionthree").equals(questionData.getAnswer())){
                      tv_otpC.setBackgroundColor(Color.parseColor("#0da5af"));
                      tv_otpC.setTextColor(Color.parseColor("#ffffff"));
                  }
                  else{
                      tv_otpD.setBackgroundColor(Color.parseColor("#0da5af"));
                      tv_otpD.setTextColor(Color.parseColor("#ffffff"));

                  }


                }
                else{
                    Log.d("messageiss",response.message());
                }

            }

            @Override
            public void onFailure(Call<QuestionOfDayDecModel> call, Throwable t) {
                Toast.makeText(getContext(), "please check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
