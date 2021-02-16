package com.analogit.elearningapp.Fragments;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.analogit.elearningapp.Adapters.RecyclerAllSubjectsAdapter;
import com.analogit.elearningapp.Adapters.RecyclerImageBankSubjectAdapter;
import com.analogit.elearningapp.Adapters.RecyclerImageGridViewAdapter;
import com.analogit.elearningapp.Adapters.RecylerImageBankAdapter;
import com.analogit.elearningapp.ApiModel.AllSubjectModel;
import com.analogit.elearningapp.ApiModel.IBAllImagesModel;
import com.analogit.elearningapp.ApiModel.IBSubImagesModel;
import com.analogit.elearningapp.NewAdapter.RecyclerIBAliImagesAdapter;
import com.analogit.elearningapp.NewAdapter.RecyclerIBSubImagesAdapter;
import com.analogit.elearningapp.NewAdapter.RecyclerSubjectaAdapter;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ImagesBankFragment extends Fragment {

private  View view;
private RecyclerView recIbSubImage,recSubName,recAllImages;
    RecylerImageBankAdapter recylerImageBankAdapter;
    RecyclerImageBankSubjectAdapter recyclerImageBankSubjectAdapter;
    RecyclerImageGridViewAdapter recyclerImageGridViewAdapter;
    SwitchCompat aSwitch;
    API REST_CLIENT;
    TextView tv_All;
    LinearLayout linearLayout;

    ArrayList<AllSubjectModel>arrayListData=new ArrayList<>();
    ArrayList<IBAllImagesModel>arrayListAllImages=new ArrayList<>();


    ArrayList<IBSubImagesModel>arrayListIBSubImages=new ArrayList<>();
    public ImagesBankFragment() {
        // Required empty public constructor
    }





    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       view= inflater.inflate(R.layout.fragment_images_bank, container, false);






        getIds();
        AllSubjects();
       // WithOutOnclick();
        AllImages();


//           if(getArguments()!=null){
//            arrayListIBSubImages.clear();
//            Call<List<IBSubImagesModel>>call=REST_CLIENT.getSubImages(getArguments().getInt("subid"));
//            call.enqueue(new Callback<List<IBSubImagesModel>>() {
//                List<IBSubImagesModel>ibSubImagesList;
//                IBSubImagesModel ibSubImagesData;
//                @Override
//                public void onResponse(Call<List<IBSubImagesModel>> call, Response<List<IBSubImagesModel>> response) {
//                    ibSubImagesList=response.body();
//
//                    if(response.isSuccessful()){
//                        arrayListIBSubImages.clear();
//                        Log.d("After",String.valueOf(arrayListIBSubImages.size()));
//                        recAllImages.setVisibility(View.GONE);
//                        recIbSubImage.setVisibility(View.VISIBLE);
//
//                        tv_All.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ffffff")));
//                        tv_All.setTextColor(Color.WHITE);
//                        for (int i=0;i<ibSubImagesList.size();i++){
//
//                            ibSubImagesData=ibSubImagesList.get(i);
//                            arrayListIBSubImages.add(new IBSubImagesModel(ibSubImagesData.getImage_no(),ibSubImagesData.getSubject_name(),ibSubImagesData.getImage(),ibSubImagesData.getDescription()));
//                        }
//                    }
//                    else{
//
//                        arrayListIBSubImages.clear();
//                    }
//
//                    RecyclerIBSubImagesAdapter recyclerIBSubImagesAdapter=new RecyclerIBSubImagesAdapter(getContext(),arrayListIBSubImages);
//                    recIbSubImage.setAdapter(recyclerIBSubImagesAdapter);
//                    recyclerIBSubImagesAdapter.notifyDataSetChanged();
//
//
//                }
//
//                @Override
//                public void onFailure(Call<List<IBSubImagesModel>> call, Throwable t) {
//                    Toast.makeText(getContext(), "Please Check internet Connection ", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        else {
//            tv_All.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0da5af")));
//            tv_All.setTextColor(Color.BLACK);
//        }

       return  view;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void getIds() {
        recIbSubImage=view.findViewById(R.id.image_bank_rec);
        recSubName=view.findViewById(R.id.imagebank_sub_rec);


        recAllImages=view.findViewById(R.id.image_bank_all_images);

        REST_CLIENT = RestClient.get();

        recAllImages.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recIbSubImage.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recSubName.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
    }

    private void AllSubjects() {
        Call<List<AllSubjectModel>>call=REST_CLIENT.getSubjects();
        call.enqueue(new Callback<List<AllSubjectModel>>() {
            @Override
            public void onResponse(Call<List<AllSubjectModel>> call, Response<List<AllSubjectModel>> response) {
                List<AllSubjectModel>allSubjectList;
                AllSubjectModel AllSujectData;
                allSubjectList=response.body();
                if(response.isSuccessful()){
                    for (int i=0;i<allSubjectList.size();i++){
                        AllSujectData=allSubjectList.get(i);
                        arrayListData.add(new AllSubjectModel(AllSujectData.getId(),AllSujectData.getCategory(),AllSujectData.getName(),AllSujectData.getCode(),AllSujectData.getStatusCreated(),AllSujectData.getUpdated()));
                    }
                }
                RecyclerSubjectaAdapter recyclerSubjectaAdapter=new RecyclerSubjectaAdapter(getContext(),arrayListData);
                recSubName.setAdapter(recyclerSubjectaAdapter);
                recyclerSubjectaAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AllSubjectModel>> call, Throwable t) {

                Log.d("imagesbank",t.toString());
                Toast.makeText(getContext(), "Please check internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
   public void WithOutOnclick(){
//        tv_All.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0da5af")));
//        tv_All.setTextColor(Color.WHITE);
    Call<List<IBAllImagesModel>>call=REST_CLIENT.getAllImages();
    call.enqueue(new Callback<List<IBAllImagesModel>>() {

        List<IBAllImagesModel>ibAllImageList;
        IBAllImagesModel ibAllImagesData;
        @Override
        public void onResponse(Call<List<IBAllImagesModel>> call, Response<List<IBAllImagesModel>> response) {
            ibAllImageList=response.body();
            if(response.isSuccessful()){
                recIbSubImage.setVisibility(View.GONE);
                recAllImages.setVisibility(View.VISIBLE);
                arrayListAllImages.clear();
                for (int i=0;i<ibAllImageList.size();i++){
                    ibAllImagesData=ibAllImageList.get(i);
                    int imageNo=ibAllImagesData.getImage_no();
                    String image=ibAllImagesData.getImage();
                    String imageDec=ibAllImagesData.getDescription();
                    String imageTopic=ibAllImagesData.getSubject_name();
                    arrayListAllImages.add(new IBAllImagesModel(imageNo,image,imageDec,imageTopic));
                }
            }

            RecyclerIBAliImagesAdapter recyclerIBAliImagesAdapter=new RecyclerIBAliImagesAdapter(getContext(),arrayListAllImages);
            recAllImages.setAdapter(recyclerIBAliImagesAdapter);
            recyclerIBAliImagesAdapter.notifyDataSetChanged();

        }

        @Override
        public void onFailure(Call<List<IBAllImagesModel>> call, Throwable t) {

        }
    });
}
    public  void AllImages()  {
//        tv_All.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onClick(View v) {
//
////                tv_All.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#0da5af")));
////                tv_All.setTextColor(Color.WHITE);
//                Call<List<IBAllImagesModel>>call=REST_CLIENT.getAllImages();
//                call.enqueue(new Callback<List<IBAllImagesModel>>() {
//
//                    List<IBAllImagesModel>ibAllImageList;
//                    IBAllImagesModel ibAllImagesData;
//                    @Override
//                    public void onResponse(Call<List<IBAllImagesModel>> call, Response<List<IBAllImagesModel>> response) {
//                        ibAllImageList=response.body();
//                        if(response.isSuccessful()){
//                            recIbSubImage.setVisibility(View.GONE);
//                            recAllImages.setVisibility(View.VISIBLE);
//                            arrayListAllImages.clear();
//                            for (int i=0;i<ibAllImageList.size();i++){
//                                ibAllImagesData=ibAllImageList.get(i);
//                                int imageNo=ibAllImagesData.getImage_no();
//                                String image=ibAllImagesData.getImage();
//                                String imageDec=ibAllImagesData.getDescription();
//                                String imageTopic=ibAllImagesData.getSubject_name();
//                                arrayListAllImages.add(new IBAllImagesModel(imageNo,image,imageDec,imageTopic));
//                            }
//                        }
//
//                        RecyclerIBAliImagesAdapter recyclerIBAliImagesAdapter=new RecyclerIBAliImagesAdapter(getContext(),arrayListAllImages);
//                        recAllImages.setAdapter(recyclerIBAliImagesAdapter);
//                        recyclerIBAliImagesAdapter.notifyDataSetChanged();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<IBAllImagesModel>> call, Throwable t) {
//
//                    }
//                });
//            }
//        });
    }
}
//        int subid=getArguments().getInt("subid");
//        Log.d("helloidsss",String.valueOf(subid));

//
//        aSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(recyclerViewGried.getVisibility()==View.GONE){
//                    recyclerViewGried.setVisibility(View.VISIBLE);
//                    recyclerViewGried.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
//                    recyclerImageGridViewAdapter=new RecyclerImageGridViewAdapter(ImagesBankFragment.this);
//                    recyclerViewGried.setAdapter(recyclerImageGridViewAdapter);
//                    recIbSubImage.setVisibility(View.GONE);
//
//                }
//                else{
//                    recyclerViewGried.setVisibility(View.GONE);
//                    recyclerViewGried.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
//                    recyclerImageGridViewAdapter=new RecyclerImageGridViewAdapter(ImagesBankFragment.this);
//                    recyclerViewGried.setAdapter(recyclerImageGridViewAdapter);
//                    recyclerViewImage.setVisibility(View.VISIBLE);
//                }
//
//            }
//        });




//        recyclerViewImage.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
//       recylerImageBankAdapter=new RecylerImageBankAdapter(this);
//        recyclerViewImage.setAdapter(recylerImageBankAdapter);