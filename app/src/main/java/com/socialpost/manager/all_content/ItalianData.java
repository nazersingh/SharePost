package com.socialpost.manager.all_content;

import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialpost.manager.MyApplication;
import com.socialpost.pojo.base.BaseMediaContentPojo;
import com.socialpost.pojo.ResponsePojo;

import java.io.InputStream;
import java.util.ArrayList;

public class ItalianData {




    public ArrayList<BaseMediaContentPojo> getItalianLiveNews()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("ItalianData/Videos/italian_live_news_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.italian_live_news_videos);
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

    public ArrayList<BaseMediaContentPojo> getItalianLivePlaces()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("ItalianData/Videos/italian_live_places_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.italian_live_places_videos);
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

    public ArrayList<BaseMediaContentPojo> getItalianCartoons()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("ItalianData/Videos/Learning/kids_videos_learn_italian.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.kids_videos_learn_italian);
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
    public ArrayList<BaseMediaContentPojo> getItalianRomanticSongs()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("ItalianData/Videos/Music/italian_romantic_music.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.kids_videos_learn_italian);
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
    public ArrayList<BaseMediaContentPojo> getItalianShortAttitudeVideos()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("ItalianData/Videos/Music/italian_romantic_music.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.kids_videos_learn_italian);
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
