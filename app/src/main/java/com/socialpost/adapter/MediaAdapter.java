package com.socialpost.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.socialpost.R;
import com.socialpost.callback.AdapterCallback;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;

public class MediaAdapter extends RecyclerView.Adapter {
    private ArrayList<BaseMediaContentPojo> mediaDataList;
    private AdapterCallback mediaAdapterItemClickCallback;

    public MediaAdapter(ArrayList<BaseMediaContentPojo> arrayList, AdapterCallback mediaAdapterItemClickCallback) {
        this.mediaDataList = arrayList;
        this.mediaAdapterItemClickCallback=mediaAdapterItemClickCallback;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_media_text, parent, false);
        BaseMediaContentPojo mediaContentPojo= mediaDataList.get(viewType);
//        DataBaseUtility.MediaType mediaType= mediaContentPojo.getMediaType();

//        switch (mediaType) {
//            case MEDIA_TEXT:
//                return new MediaTextViewHolder(view,mediaAdapterItemClickCallback,mediaContentPojo);
//            case MEDIA_IMAGE:
//                return new MediaTextViewHolder(view,mediaAdapterItemClickCallback,mediaContentPojo);
//            case MEDIA_VIDEO:
//                return new MediaTextViewHolder(view,mediaAdapterItemClickCallback,mediaContentPojo);
//
//            default:
                return new MediaTextViewHolder(view,mediaAdapterItemClickCallback,mediaContentPojo);
//        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        BaseMediaViewHolder baseMediaViewHolder= (BaseMediaViewHolder) holder;
        baseMediaViewHolder.bind();
    }

    @Override
    public int getItemCount() {
        return mediaDataList.size();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }
}
