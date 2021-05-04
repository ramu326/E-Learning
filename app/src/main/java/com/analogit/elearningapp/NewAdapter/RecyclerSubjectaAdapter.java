package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.AllSubjectModel;
import com.analogit.elearningapp.ApiModel.IBSubImagesModel;
import com.analogit.elearningapp.Fragments.ImagesBankFragment;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerSubjectaAdapter extends RecyclerView.Adapter<RecyclerSubjectaAdapter.MyViewHolder> {

    Context context;
    ArrayList<AllSubjectModel> allSubjectModel;
    ImagesBankFragment imagesBankFragment;

    int pos = -1;
    API REST_CLIENT = RestClient.get();

    public RecyclerSubjectaAdapter(Context context, ArrayList<AllSubjectModel> allSubjectModel, ImagesBankFragment imagesBankFragment) {
        this.context = context;
        this.allSubjectModel = allSubjectModel;
        this.imagesBankFragment = imagesBankFragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.imagebank_all_subjects_row,parent,false));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.tv_subject.setText(allSubjectModel.get(position).getName());
        if (pos == position) {
            holder.tv_subject.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#257274")));
            holder.tv_subject.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            holder.tv_subject.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#b5e8ef")));
            holder.tv_subject.setTextColor(context.getResources().getColor(R.color.black));
        }

        holder.tv_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos = position;
                notifyDataSetChanged();
                SubjectsImagesMethod();


            }

            private void SubjectsImagesMethod() {
                Log.d("kjlllgvsdf",imagesBankFragment.pref.getString("token", "-1")+imagesBankFragment.content+allSubjectModel.get(position).getId());
                Call<List<IBSubImagesModel>> call = REST_CLIENT.getSubImages(imagesBankFragment.pref.getString("token", "-1"), imagesBankFragment.content, allSubjectModel.get(position).getId());
                call.enqueue(new Callback<List<IBSubImagesModel>>() {
                    List<IBSubImagesModel> ibSubImagesList;
                    IBSubImagesModel ibSubImagesData;

                    @Override
                    public void onResponse(Call<List<IBSubImagesModel>> call, Response<List<IBSubImagesModel>> response) {
                        ibSubImagesList = response.body();

                        if (response.isSuccessful()) {
                            if (ibSubImagesList.size() != 0) {
                                imagesBankFragment.arrayListIBSubImages.clear();

                                for (int i = 0; i < ibSubImagesList.size(); i++) {

                                    ibSubImagesData = ibSubImagesList.get(i);
                                    imagesBankFragment.arrayListIBSubImages.add(new IBSubImagesModel(ibSubImagesData.getSubject_id(),ibSubImagesData.getSubject_name(),ibSubImagesData.getImage_no(),ibSubImagesData.getImage(),ibSubImagesData.getDescription()));
                                }
                            } else {
                                Toast.makeText(context, "No Images found", Toast.LENGTH_SHORT).show();
                            }

                        } else {

                            imagesBankFragment.arrayListIBSubImages.clear();
                            Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                        }

                        RecyclerIBSubImagesAdapter recyclerIBSubImagesAdapter = new RecyclerIBSubImagesAdapter(imagesBankFragment.getContext(), imagesBankFragment.arrayListIBSubImages);
                        imagesBankFragment.recIbSubImage.setAdapter(recyclerIBSubImagesAdapter);
                        recyclerIBSubImagesAdapter.notifyDataSetChanged();


                    }

                    @Override
                    public void onFailure(Call<List<IBSubImagesModel>> call, Throwable t) {
                        Toast.makeText(imagesBankFragment.getContext(), "Please Check internet Connection ", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return allSubjectModel.size();
    }

  class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_subject;

     public MyViewHolder(@NonNull final View itemView) {
         super(itemView);

         tv_subject=itemView.findViewById(R.id.tv_img_subjects);




     }
 }
}
