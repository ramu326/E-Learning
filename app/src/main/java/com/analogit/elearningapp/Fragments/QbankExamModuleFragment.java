package com.analogit.elearningapp.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.analogit.elearningapp.ApiModel.QbankModuleOptionModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QbankExamModuleFragment extends Fragment {

    private  View v;
    CardView cardViewSolveExam,cardViewOne,cardViewTwo,cardViewThree,cardViewFour;
    TextView subName,suTopicName,mcq,srNo,optA,optB,optC,optD,tvQues;
    API REST_CLIENT;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.anatomy_layout,container,false);

        cardViewSolveExam=v.findViewById(R.id.card_view_slove_exam);
        subName=v.findViewById(R.id.sub_name);
        suTopicName=v.findViewById(R.id.sub_topic_name);
        mcq=v.findViewById(R.id.mcqs);

        REST_CLIENT= RestClient.get();


        if(getArguments()!=null){
            subName.setText(getArguments().getString("subjectname"));
            suTopicName.setText(getArguments().getString("topicname"));
            mcq.setText(getArguments().getInt("total")+" MCQ'S");

            Call<List<QbankModuleOptionModel>> call=REST_CLIENT.getQbankoptions(getArguments().getInt("tid"));
            call.enqueue(new Callback<List<QbankModuleOptionModel>>() {
                List<QbankModuleOptionModel> qbankModuleOptionModelList;
                QbankModuleOptionModel qbankModuleOptionMap;
                @Override
                public void onResponse(Call<List<QbankModuleOptionModel>> call, Response<List<QbankModuleOptionModel>> response) {
                    qbankModuleOptionModelList=response.body();
                    if(response.isSuccessful()){
                        for (int i = 0; i <qbankModuleOptionModelList.size() ; i++) {
                            qbankModuleOptionMap=qbankModuleOptionModelList.get(i);


                        }

                    }
                    else{
                        Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<List<QbankModuleOptionModel>> call, Throwable t) {
                    Toast.makeText(getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();

                }
            });
        }



        cardViewSolveExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr=getActivity().getSupportFragmentManager().beginTransaction();
                fr.replace(R.id.content,new QbankModulesStartExamFragment());
                fr.addToBackStack(null);
                fr.commit();
            }
        });
        return v;
    }
}
