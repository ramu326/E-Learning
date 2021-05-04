package com.analogit.elearningapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.analogit.elearningapp.Fragments.IcardsZoomImagesFragment;
import com.analogit.elearningapp.Fragments.QbankErrorFragment;
import com.analogit.elearningapp.Model.DoctorModel;
import com.analogit.elearningapp.Model.RankOneModel;
import com.analogit.elearningapp.NewAdapter.QBankErrorModel;
import com.analogit.elearningapp.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.analogit.elearningapp.WebServices.RestClient.Image_Url;

public class RecyclerQbankErrorAdapter extends RecyclerView.Adapter<RecyclerQbankErrorAdapter.ErrorAdapter> {
    Context context;
    ArrayList<QBankErrorModel> arrayList;

    public RecyclerQbankErrorAdapter(Context context, ArrayList<QBankErrorModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ErrorAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ErrorAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.qbank_error_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ErrorAdapter holder, int position) {
        Glide.with(context).load(Image_Url+arrayList.get(position).getImage()).into(holder.imageView);
        holder.subName.setText(arrayList.get(position).getName());
        holder.errors.setText(String.valueOf(arrayList.get(position).getError()+" Error+Skipped "));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ErrorAdapter extends RecyclerView.ViewHolder {
        ConstraintLayout constraintLayout;
        CircleImageView imageView;
        TextView subName,errors;

        public ErrorAdapter(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.constaraint_error_qbank);
            imageView=itemView.findViewById(R.id.iv_error_sub_image);
            subName=itemView.findViewById(R.id.tv_error_sub_name);
            errors=itemView.findViewById(R.id.tv_error_sub_work_status);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    activity.getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.content, new QbankErrorFragment()).commit();
                }
            });
        }
    }

}
