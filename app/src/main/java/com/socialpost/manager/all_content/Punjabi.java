package com.socialpost.manager.all_content;

import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialpost.manager.MyApplication;
import com.socialpost.pojo.base.BaseMediaContentPojo;
import com.socialpost.pojo.ResponsePojo;

import java.io.InputStream;
import java.util.ArrayList;

public class Punjabi {

private final String TAG=this.getClass().getSimpleName();


    public ArrayList<BaseMediaContentPojo> getPunjabiAttitudeShayariList()
    {
        ArrayList<BaseMediaContentPojo> attitudeShayariList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("PunjabiData/Poetry/punjabi_attitude_shayari.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.punjabi_attitude_shayari);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            attitudeShayariList=responsePojo.getPunjabiAttitudeShayariList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attitudeShayariList;
    }

    public ArrayList<BaseMediaContentPojo> getPunjabiMotivationalList()
    {
        ArrayList<BaseMediaContentPojo> attitudeShayariList = new ArrayList<>();
        try {
            Log.e("Punjabi", "getPunjabiMotivationalList: " );
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("PunjabiData/Poetry/punjabi_motivational_shayari.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.punjabi_motivational_shayari);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            attitudeShayariList=responsePojo.getPunjabiMotivationalShayariList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attitudeShayariList;
    }


    public ArrayList<BaseMediaContentPojo> getPunjabiNewList()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("PunjabiData/Poetry/punjbai_new.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.punjbai_new);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            list=responsePojo.getPunjabiNewList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<BaseMediaContentPojo> getPunjabiAllStoriesData()
    {
        Log.e(TAG, "getPunjabiAllStories: " );
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("PunjabiData/Stories/punjabi_short_stories.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.punjabi_short_stories);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            list=responsePojo.getStoryList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<BaseMediaContentPojo> getPunjabiCultureVideosData()
    {
        Log.e(TAG, "getPunjabiCultureVideosData: " );
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("PunjabiData/Videos/punjbai_culture_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.punjbai_culture_videos);
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
 public ArrayList<BaseMediaContentPojo> getPunjabiItalianVideosData()
    {
        Log.e(TAG, "getPunjabiCultureVideosData: " );
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("PunjabiData/Videos/punjabi_videos_learn_italian.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.punjabi_videos_learn_italian);
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
    public ArrayList<BaseMediaContentPojo> getPunjabiItalianLicenceVideosData()
    {
        Log.e(TAG, "getPunjabiItalianLicenceVideosData: " );
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("PunjabiData/Videos/punjabi_videos_learn_italianLicence.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.punjabi_videos_learn_italian);
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
 public ArrayList<BaseMediaContentPojo> getPunjabiLiveNewsPbiVideos()
    {
        Log.e(TAG, "getPunjabiLiveNewsPbiVideos: " );
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("PunjabiData/Videos/pbi_news_pbi_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.pbi_news_pbi_videos);
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

    public ArrayList<BaseMediaContentPojo> getPunjabiShortAttitudeVideos()
    {
        Log.e(TAG, "getPunjabiShortAttitudeVideos: " );
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("PunjabiData/Videos/punjbai_short_attitude_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.pbi_news_pbi_videos);
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
