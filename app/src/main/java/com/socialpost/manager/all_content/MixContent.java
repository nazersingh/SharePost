package com.socialpost.manager.all_content;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialpost.R;
import com.socialpost.manager.MyApplication;
import com.socialpost.pojo.base.BaseMediaContentPojo;
import com.socialpost.pojo.ResponsePojo;

import java.io.InputStream;
import java.util.ArrayList;

public class MixContent {

private final String TAG=this.getClass().getSimpleName();


    public ArrayList<BaseMediaContentPojo> getAwareVideosData()
    {
        Log.e(TAG, "getAwareVideosData: " );
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.aware_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            list=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    private ResponsePojo getMediaContentPojo(String responseData)
    {
        Gson gson=new GsonBuilder().create();
        return gson.fromJson(responseData, ResponsePojo.class);
    }
}
