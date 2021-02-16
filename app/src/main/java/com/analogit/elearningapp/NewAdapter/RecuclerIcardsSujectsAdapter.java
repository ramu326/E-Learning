package com.analogit.elearningapp.NewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.NewIcardExtenFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecuclerIcardsSujectsAdapter extends RecyclerView.Adapter<RecuclerIcardsSujectsAdapter.MyViewholder> {

    Context context;
    ArrayList<DoctorModel>doctorModelArrayList;
    NewIcardExtenFragment fragment;
    public RecuclerIcardsSujectsAdapter(Context context, ArrayList<DoctorModel> doctorModelArrayList, NewIcardExtenFragment fragment){
        this.context=context;
        this.doctorModelArrayList=doctorModelArrayList;
        this.fragment=fragment;
    }
    
    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.icards_sub_row,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
//        switch (position){
//            case 0:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.two));
//                break;
//            case 1:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.thirteen));
//                break;
//            case 2:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.three));
//                break;
//            case 3:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.four));
//                break;
//            case 4:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.five));
//                break;
//            case 5:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.six));
//                break;
//            case 6:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.seven));
//                break;
//            case 7:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.eight));
//                break;
//            case 8:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.nine));
//                break;
//            case 9:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.ten));
//                break;
//            case 10:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.eleven));
//                break;
//            case 11:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.twelve));
//                break;
//            case 12:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.thirteen));
//                break;
//            case 13:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.fourteen));
//                break;
//            case 14:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.fifteen));
//                break;
//            case 15:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.sixteen));
//                break;
//            case 16:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.seventeen));
//                break;
//            case 17:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.eight));
//                break;
//            case 18:
//                holder.imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.nine));
//                break;
//        }

    }

    @Override
    public int getItemCount() {
        return 19;
    }


     class MyViewholder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        ConstraintLayout image;
        public MyViewholder(@NonNull View itemView) {

            super(itemView);
//            imageView=itemView.findViewById(R.id.iv_grid_icard_image);
//            image=itemView.findViewById(R.id.new_learn_video_card_view);
//            Log.d("topics","Anotomysub");
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    RecyclerMorningRoundDecAdapter recyclerAllTopicsAdapter=new RecyclerMorningRoundDecAdapter(fragment);
//
//                    ((NewIcardExtenFragment) (fragment)).fYear_rViewTopic
//                            .setLayoutManager(new LinearLayoutManager(fragment.getContext(), RecyclerView.HORIZONTAL, false));
//                    ((NewIcardExtenFragment) (fragment)).fYear_rViewTopic.setAdapter(recyclerAllTopicsAdapter);
//                }
//            });

        }
    }


}
