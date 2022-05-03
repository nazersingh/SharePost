package com.socialpost.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.RecyclerView;

import com.socialpost.R;
import com.socialpost.base.BaseViewModel;
import com.socialpost.callback.AdapterCallback;

public abstract class BaseMediaViewHolder extends RecyclerView.ViewHolder implements LifecycleOwner {

    BaseViewModel baseViewModel;
    private final LifecycleRegistry lifecycleRegistry=new LifecycleRegistry(this);
    protected Context context;
    private TextView mTvLike;
    private ImageView mImgShare,mImgLike;
    private AdapterCallback mediaAdapterItemClickCallback;

    public BaseMediaViewHolder(View view, AdapterCallback mediaAdapterItemClickCallback) {
        super(view);
        context=view.getContext();
        this.mediaAdapterItemClickCallback=mediaAdapterItemClickCallback;
        lifecycleRegistry.setCurrentState(Lifecycle.State.INITIALIZED);
        mImgShare=view.findViewById(R.id.img_share);
        mImgLike=view.findViewById(R.id.imgLike);



        final TypedValue value = new TypedValue ();
        context.getTheme ().resolveAttribute (R.attr.colorPrimary, value, true);
//        mImgShare.settint(value.data);
        ImageViewCompat.setImageTintList(mImgShare, ColorStateList.valueOf(value.data));
//        mImgShare.setColorFilter(ContextCompat.getColor(context, R.color.card_background_color_day), android.graphics.PorterDuff.Mode.MULTIPLY);

        mImgShare.setOnClickListener(this::onShareClick);
        mImgLike.setOnClickListener(this::onLikeClick);
    }

    private void onLikeClick(View view) {
        mediaAdapterItemClickCallback.onLikeClick(getAdapterPosition());
    }

    private void onShareClick(View view) {
        mediaAdapterItemClickCallback.onShareClick(getAdapterPosition());
    }

    protected void setLikeCount(String countNumber )
    {

    }

    public abstract void bind();

    public abstract void onViewModelAttached();
    public BaseViewModel getViewModel()
    {
        if(baseViewModel ==null)
        {
            throw new IllegalStateException("View Model is not attached with BaseViewHolder");
        }
        return baseViewModel;
    }

    public void onAppear(BaseViewModel model) {
        lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        this.baseViewModel =model;
        onViewModelAttached();
    }


    public void onDisappear() {
        lifecycleRegistry.setCurrentState(Lifecycle.State.DESTROYED);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return lifecycleRegistry;
    }
}