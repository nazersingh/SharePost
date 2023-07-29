package com.socialpost.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.socialpost.R;
import com.socialpost.Util.Constants;
import com.socialpost.activity.MediaContentListActivity;
import com.socialpost.activity.MotivationActivity;
import com.socialpost.activity.ShortVideosListActivity;
import com.socialpost.activity.SinglePicActivity;
import com.socialpost.activity.StoriesList;
import com.socialpost.activity.VideosListActivity;
import com.socialpost.manager.all_content.AllCategories;
import com.socialpost.pojo.AllCategoryListItemPojo;
import com.socialpost.pojo.PostCategoryPojo;

import java.util.ArrayList;

public class PostCategoryTypeAdapter extends RecyclerView.Adapter {
    private ArrayList<AllCategoryListItemPojo> PostCategoryPojoArrayList;
    private int mLastPosition = -1;
    private int lastSelectedPosition=0;

    public PostCategoryTypeAdapter(ArrayList<AllCategoryListItemPojo> arrayList) {
        this.PostCategoryPojoArrayList = arrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post_category_list, parent, false);
        return new PostCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        PostCategoryHolder postCategoryHolder = (PostCategoryHolder) holder;
        AllCategoryListItemPojo allCategoryListItemPojo= PostCategoryPojoArrayList.get(position);
        postCategoryHolder.mTvCategoryName.setText(allCategoryListItemPojo.getCategoryText());


        PostCategoryListAdapter postCategoryListAdapter=new PostCategoryListAdapter(allCategoryListItemPojo.getCategorySubList(),onClickListener);

        postCategoryHolder.mCatRecycler.setHasFixedSize(true);
        postCategoryHolder. mCatRecycler.setAdapter(postCategoryListAdapter);
        postCategoryHolder.mTvSeeAll.setOnClickListener(this::onSeeAllClick);
    }


    private void onSeeAllClick(View v) {
        v.getContext().startActivity(new Intent(v.getContext(), MediaContentListActivity.class));
    }

    private String TAG=this.getClass().getSimpleName();
    private final View.OnClickListener onClickListener= v -> {
        PostCategoryPojo postCategoryPojo= (PostCategoryPojo) v.getTag();

        Log.e(TAG, ": on category Item Click "+postCategoryPojo.getCategory_list_id() );

        String[] categoryNameArray = postCategoryPojo.getCategory_list_id().split("_");
        String categoryMain = categoryNameArray[0];
        String categoryData = categoryNameArray[1];
        String categoryLanguage = categoryNameArray[2];
        AllCategories.AllAppCategories allAppCategories = AllCategories.AllAppCategories.valueOfCategoryName(categoryMain.trim());
        Intent intent;
        switch (allAppCategories)
        {
            case motivation:
                AllCategories.MotivationalCategory motivationalCategory = AllCategories.MotivationalCategory.valueOfCategoryName(categoryData.trim());
                intent = new Intent(v.getContext(), MotivationActivity.class);
                intent.putExtra(Constants.MAIN_JOINT_CATEGORY_ID, postCategoryPojo.getCategory_list_id());
                intent.putExtra(Constants.CATEGORY_ID, categoryData);
                intent.putExtra(Constants.CATEGORY_Lang, categoryLanguage);
                v.getContext().startActivity(intent);
                break;
            case Stories:
                AllCategories.StoryCategory storyCategory = AllCategories.StoryCategory.valueOfCategoryName(categoryData.trim());
                 intent = new Intent(v.getContext(), StoriesList.class);
                intent.putExtra(Constants.CATEGORY_ID, categoryData+"_"+categoryLanguage);
                v.getContext().startActivity(intent);

                break;
            case Poetry:
                AllCategories.PoetryCategory poetryCategory = AllCategories.PoetryCategory.valueOfCategoryName(categoryData.trim());
                intent = new Intent(v.getContext(), MediaContentListActivity.class);
                intent.putExtra(Constants.MAIN_JOINT_CATEGORY_ID, postCategoryPojo.getCategory_list_id());
                intent.putExtra(Constants.CATEGORY_ID, categoryData);
                intent.putExtra(Constants.CATEGORY_Lang, categoryLanguage);
                v.getContext().startActivity(intent);
                break;
            case Videos:


                String subCategory=categoryNameArray[2];
                categoryLanguage=categoryNameArray[3];

                if(categoryData.equalsIgnoreCase("short"))
                {
                    intent = new Intent(v.getContext(), ShortVideosListActivity.class);
                }
                else
                {
                    intent = new Intent(v.getContext(), VideosListActivity.class);
                }
                intent.putExtra(Constants.CATEGORY_ID, categoryData);
                intent.putExtra(Constants.CATEGORY_SUB_ID, subCategory);
                intent.putExtra(Constants.CATEGORY_Lang, categoryLanguage);

                    v.getContext().startActivity(intent);

                break;
            case Photos:
                String subPhotoCategory=categoryNameArray[2];
                categoryLanguage=categoryNameArray[3];
                intent = new Intent(v.getContext(), SinglePicActivity.class);
                intent.putExtra(Constants.CATEGORY_ID, categoryData);
                intent.putExtra(Constants.CATEGORY_SUB_ID, subPhotoCategory);
                intent.putExtra(Constants.CATEGORY_Lang, categoryLanguage);
                v.getContext().startActivity(intent);
                break;
        }

    };


    @Override
    public int getItemCount() {
        return PostCategoryPojoArrayList.size();
    }

    @Override
    public int getItemViewType(int position) {

        return PostCategoryPojoArrayList.size();
    }


    public class PostCategoryHolder extends RecyclerView.ViewHolder {

        TextView mTvCategoryName,mTvSeeAll;
        RecyclerView mCatRecycler;

        PostCategoryHolder(View itemView) {
            super(itemView);
            mTvCategoryName = itemView.findViewById(R.id.tvHeadingType);
            mCatRecycler = itemView.findViewById(R.id.recyclerCat);
            mTvSeeAll = itemView.findViewById(R.id.tv_see_all);


        }


    }
}