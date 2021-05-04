package com.analogit.elearningapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.analogit.elearningapp.Fragments.TestDiscussionSessionStartFragment;
import com.analogit.elearningapp.Model.DiscussionModel;
import com.analogit.elearningapp.R;
import com.analogit.elearningapp.databinding.NewDiscussionVideosRowBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerDiscussionAdapter extends ListAdapter<DiscussionModel, RecyclerDiscussionAdapter.MyViewholder> {

    Fragment fragment;

    public RecyclerDiscussionAdapter(Fragment fragment) {
        super(DiscussionModel.discussionModelItemCallback);
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.new_discussion_videos_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        DiscussionModel model = getCurrentList().get(position);

        Glide.with(holder.binding.getRoot()).load(model.getImageUrl()).into(holder.binding.ivDiscussion);

        holder.binding.subject.setText(model.getSubject());

        holder.binding.tvDisVideoName.setText(model.getVideos());


    }

    @Override
    public void submitList(@Nullable List<DiscussionModel> list) {
        super.submitList(list == null ? null : new ArrayList<DiscussionModel>(list));
    }

    class MyViewholder extends RecyclerView.ViewHolder {

        CardView cardView;
        NewDiscussionVideosRowBinding binding;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            binding = NewDiscussionVideosRowBinding.bind(itemView);

            cardView = itemView.findViewById(R.id.new_discussion_video_card_view);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity appCompatActivity = (AppCompatActivity) view.getContext();
                    // DiscussionVideoExplantaionFragment discussionVideoExplantaionFragment=new DiscussionVideoExplantaionFragment();
                    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.content, new TestDiscussionSessionStartFragment()).addToBackStack(null).commit();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return getCurrentList().size();
    }
}
