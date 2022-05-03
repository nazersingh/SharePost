package com.socialpost.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.socialpost.R;
import com.socialpost.callback.AdapterCallback;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;

public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.StoryViewHolder>  {
    private ArrayList<BaseMediaContentPojo> mediaDataList;
    private AdapterCallback mediaAdapterItemClickCallback;
    private View.OnClickListener onClickListener;

    public StoryListAdapter(ArrayList<BaseMediaContentPojo> arrayList, AdapterCallback mediaAdapterItemClickCallback, View.OnClickListener onClickListener) {
        this.mediaDataList = arrayList;
        this.mediaAdapterItemClickCallback=mediaAdapterItemClickCallback;
        this.onClickListener=onClickListener;
    }


    @NonNull
    @Override
    public StoryListAdapter.StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_story, parent, false);
    return new StoryViewHolder(view,mediaAdapterItemClickCallback);

    }

    @Override
    public void onBindViewHolder(@NonNull StoryListAdapter.StoryViewHolder holder, int position) {

        holder.tv_story_Heading.setText(mediaDataList.get(position).getStoryName());
//        holder.img_story
        holder.itemView.setOnClickListener(v -> {
            v.setTag(mediaDataList.get(position));
            onClickListener.onClick(v);
        });

    }

    @Override
    public int getItemCount() {
        return mediaDataList.size();
    }

    public class StoryViewHolder extends BaseMediaViewHolder {

        TextView tv_story_Heading;
        ImageView img_story;

        StoryViewHolder(View itemView,AdapterCallback mediaAdapterItemClickCallback) {
            super(itemView,mediaAdapterItemClickCallback);

            tv_story_Heading=itemView.findViewById(R.id.tv_story_Heading);
        }


        @Override
        public void bind() {

        }

        @Override
        public void onViewModelAttached() {

        }
    }
}
