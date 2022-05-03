package com.socialpost.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.socialpost.R;
import com.socialpost.pojo.PostCategoryPojo;

import java.util.ArrayList;

public class PostCategoryListAdapter extends RecyclerView.Adapter {
    private ArrayList<PostCategoryPojo> PostCategoryPojoArrayList;
    private int mLastPosition = -1;
    private int lastSelectedPosition = 0;
    private View.OnClickListener onClickListener;

    public PostCategoryListAdapter(ArrayList<PostCategoryPojo> arrayList, View.OnClickListener onClickListener) {
        this.PostCategoryPojoArrayList = arrayList;
        this.onClickListener = onClickListener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post_category, parent, false);
        return new PostCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        PostCategoryHolder postCategoryHolder = (PostCategoryHolder) holder;
        postCategoryHolder.mTvCategoryName.setText(PostCategoryPojoArrayList.get(position).getCategoryText());
        String url="https://source.unsplash.com/1600x900/?" + PostCategoryPojoArrayList.get(position).getCategoryText();
        Glide.with(postCategoryHolder.mTvCategoryName).load(url).into(postCategoryHolder.mImgCategoryType);

        postCategoryHolder.itemView.setOnClickListener(v -> {
            v.setTag(PostCategoryPojoArrayList.get(position));
            onClickListener.onClick(v);
        });
    }

    @Override
    public int getItemCount() {
        return PostCategoryPojoArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {

        return PostCategoryPojoArrayList.size();
    }


    public class PostCategoryHolder extends RecyclerView.ViewHolder {

        TextView mTvCategoryName;
        ImageView mImgCategoryType;

        PostCategoryHolder(View itemView) {
            super(itemView);
            mTvCategoryName = itemView.findViewById(R.id.tv_cat_name);
            mImgCategoryType = itemView.findViewById(R.id.img_category_type);


        }
    }
}