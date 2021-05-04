package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
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
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.AllPosterImagesModel;
import com.analogit.elearningapp.ApiModel.AllSubjectModel;
import com.analogit.elearningapp.ApiModel.PosterSubImagesModel;
import com.analogit.elearningapp.Fragments.ImagesBankFragment;
import com.analogit.elearningapp.Fragments.WallPosterGridfFragment;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.WebServices.API;
import com.analogit.elearningapp.WebServices.RestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerPosterSubjectsAdapter extends RecyclerView.Adapter<RecyclerPosterSubjectsAdapter.MyViewHolder> {

    Context context;
    ArrayList<AllSubjectModel> allSubjectDataList;
    WallPosterGridfFragment fragment;
    API REST_CLIENT = RestClient.get();

    int id1=-1;

    public RecyclerPosterSubjectsAdapter(Context context, ArrayList<AllSubjectModel> allSubjectDataList, WallPosterGridfFragment wallPosterGridfFragment) {
        this.context = context;
        this.allSubjectDataList = allSubjectDataList;
        this.fragment = wallPosterGridfFragment;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.all_poster_sub_row, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.textView.setText(allSubjectDataList.get(position).getName());

            if(id1==position){

                holder.textView.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#257274")));
                holder.textView.setTextColor(context.getResources().getColor(R.color.white));
            }
            else{
                holder.textView.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#b5e8ef")));
                holder.textView.setTextColor(context.getResources().getColor(R.color.black));
            }


        holder.textView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                id1=position;
                notifyDataSetChanged();

                 PosterImages();



            }


            private void PosterImages() {

                Call<List<PosterSubImagesModel>> call = REST_CLIENT.getsubPosters(fragment.pref.getString("token", "-1"),fragment.content,allSubjectDataList.get(position).getId());
                call.enqueue(new Callback<List<PosterSubImagesModel>>() {
                    List<PosterSubImagesModel> posterSubImagesList;
                    PosterSubImagesModel posterSubImagesData;

                    @Override
                    public void onResponse(Call<List<PosterSubImagesModel>> call, Response<List<PosterSubImagesModel>> response) {
                        posterSubImagesList = response.body();

                        if (response.isSuccessful()) {

                            fragment.arrayListsubposterData.clear();
                            for (int i = 0; i < posterSubImagesList.size(); i++) {

                                fragment. arrayListposterData.clear();
                                fragment.arrayListsubposterData.clear();
                                posterSubImagesData = posterSubImagesList.get(i);
                                fragment.arrayListsubposterData.add(new PosterSubImagesModel(posterSubImagesData.getId(), posterSubImagesData.getSubject(), posterSubImagesData.getVideo(), posterSubImagesData.getImage(), posterSubImagesData.getName()));
                            }
                        } else {

                            fragment.arrayListsubposterData.clear();
                            Toast.makeText(fragment.getContext(), response.message(), Toast.LENGTH_SHORT).show();
                        }

                        RecyclerSubPosterImageAdapter recyclerSubPosterImageAdapter = new RecyclerSubPosterImageAdapter(fragment.getContext(), fragment.arrayListsubposterData);
                        fragment.rviewsubposter.setAdapter(recyclerSubPosterImageAdapter);
                        recyclerSubPosterImageAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onFailure(Call<List<PosterSubImagesModel>> call, Throwable t) {
                        Toast.makeText(fragment.getContext(), "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return allSubjectDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_poster_subjects);

        }
    }
}
