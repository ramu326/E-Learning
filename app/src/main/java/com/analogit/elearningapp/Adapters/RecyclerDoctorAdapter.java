package com.analogit.elearningapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.ApiModel.TeachersModel;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerDoctorAdapter extends RecyclerView.Adapter<RecyclerDoctorAdapter.MyViewHolder>{

    Context context;
    ArrayList<TeachersModel>arrayList;

    public RecyclerDoctorAdapter(Context context, ArrayList<TeachersModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_role_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
        holder.tv_Name.setText(arrayList.get(position).getName());

        holder.tv_sub.setText(arrayList.get(position).getS_name());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        TextView tv_Name,tv_sub;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.tec_picture);
            tv_Name=itemView.findViewById(R.id.tv_tec_name);
            tv_sub=itemView.findViewById(R.id.tv_tec_sub_name);
        }
    }
}
