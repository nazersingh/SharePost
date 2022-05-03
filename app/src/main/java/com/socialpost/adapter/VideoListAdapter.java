package com.socialpost.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.socialpost.R;
import com.socialpost.base.BaseViewModel;
import com.socialpost.callback.AdapterCallback;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;

public class VideoListAdapter extends RecyclerView.Adapter<BaseMediaViewHolder> {
    private ArrayList<BaseMediaContentPojo> PostCategoryPojoArrayList;
    private int mLastPosition = -1;
    private int lastSelectedPosition = 0;
    private VideoAdapterCallback adapterCallback;
    private BaseViewModel baseViewModel;

    public VideoListAdapter(BaseViewModel baseViewModel, ArrayList<BaseMediaContentPojo> arrayList, VideoAdapterCallback onClickListener) {
        this.PostCategoryPojoArrayList = arrayList;
        this.adapterCallback = onClickListener;
        this.baseViewModel =baseViewModel;
    }


    @NonNull
    @Override
    public BaseMediaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_list_layout, parent, false);
        BaseMediaContentPojo mediaContentPojo=PostCategoryPojoArrayList.get(viewType);
        return new VideoListItemHolder(view,mediaContentPojo,adapterCallback);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseMediaViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull BaseMediaViewHolder holder) {
//        super.onViewDetachedFromWindow(holder);
//        holder.setIsRecyclable(true);
        holder.onDisappear();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull BaseMediaViewHolder holder) {
//        super.onViewAttachedToWindow(holder);
//        holder.setIsRecyclable(true);
        holder.onAppear(baseViewModel);
    }

    @Override
    public int getItemCount() {
//        return PostCategoryPojoArrayList.size();
        return PostCategoryPojoArrayList.size();
    }


    public interface VideoAdapterCallback extends AdapterCallback
    {
        void onItemClickListener(BaseMediaContentPojo mediaContentPojo, int position);
    }
}