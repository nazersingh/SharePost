package com.socialpost.adapter;

import android.view.View;
import android.widget.TextView;

import com.socialpost.R;
import com.socialpost.callback.AdapterCallback;
import com.socialpost.pojo.base.BaseMediaContentPojo;

public class MediaTextViewHolder extends BaseMediaViewHolder{

    private final String TAG=this.getClass().getSimpleName();

    private BaseMediaContentPojo mediaContentPojo;
    private TextView mTvTextContent;
    public MediaTextViewHolder(View itemView, AdapterCallback mediaAdapterItemClickCallback, BaseMediaContentPojo mediaContentPojo) {
        super(itemView,mediaAdapterItemClickCallback);
        this.mediaContentPojo=mediaContentPojo;

        mTvTextContent=itemView.findViewById(R.id.tv_media_text);
    }

    @Override
    public void bind() {
        mTvTextContent.setText(mediaContentPojo.getText());
    }

    @Override
    public void onViewModelAttached() {

    }
}
