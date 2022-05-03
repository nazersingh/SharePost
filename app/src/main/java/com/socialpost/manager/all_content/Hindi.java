package com.socialpost.manager.all_content;

import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialpost.manager.MyApplication;
import com.socialpost.pojo.base.BaseMediaContentPojo;
import com.socialpost.pojo.ResponsePojo;

import java.io.InputStream;
import java.util.ArrayList;

public class Hindi {




    public ArrayList<BaseMediaContentPojo> getHindiAttitudeShayariList()
    {
        ArrayList<BaseMediaContentPojo> attitudeShayariList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Poetry/hindi_attitude_shayari.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_attitude_shayari);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            attitudeShayariList=responsePojo.getHindiAttitudeShayariList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attitudeShayariList;
    }
    public ArrayList<BaseMediaContentPojo> getHindiSadList()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_sad_shayari);
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Poetry/hindi_sad_shayari.json");
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            list=responsePojo.getHindiSadShayariList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<BaseMediaContentPojo> getHindiZindagiList()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_life_shayari);
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Poetry/hindi_life_shayari.json");
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            list=responsePojo.getHindiZindagiShayariList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }



    public ArrayList<BaseMediaContentPojo> getHindiFunnyList()
    {
        ArrayList<BaseMediaContentPojo> attitudeShayariList = new ArrayList<>();
        try {
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_funny_shayari);
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Poetry/hindi_funny_shayari.json");
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            attitudeShayariList=responsePojo.getHindiFunnyShayariList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attitudeShayariList;
    }

    public ArrayList<BaseMediaContentPojo> getHindiKashList()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_kash_shayari);
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Poetry/hindi_kash_shayari.json");
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            list=responsePojo.getHindiKashShayariList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<BaseMediaContentPojo> getHindiAllStoriesData()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_short_stories);
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Stories/hindi_short_stories.json");
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
    public ArrayList<BaseMediaContentPojo> getHindiFriendShipShayari()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_frienship_shayari);
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Poetry/hindi_frienship_shayari.json");
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            list=responsePojo.getHindiFriendsShayariList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<BaseMediaContentPojo> getHindiNewShayari()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Poetry/hindi_new_shayari.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_new_shayari);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            list=responsePojo.getHindiNewShayariList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<BaseMediaContentPojo> getHindiCelebritiesStories()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_celebrities_stories);
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Stories/hindi_celebrities_stories.json");
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getStoryList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }

    public ArrayList<BaseMediaContentPojo> getHindiVideosFactsVideos()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_fact_videos);
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/hindi_fact_videos.json");
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }
    public ArrayList<BaseMediaContentPojo> getHindiHistoryVideos()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/hindi_history_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_history_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }

    public ArrayList<BaseMediaContentPojo> getHindiScienceVideos()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/hindi_science_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_science_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }

    public ArrayList<BaseMediaContentPojo> getHindiTechVideos()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/hindi_tech_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_tech_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }

    public ArrayList<BaseMediaContentPojo> getHindiMotivationalVideos()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/hindi_motivational_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_motivational_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }

    public ArrayList<BaseMediaContentPojo> getHindiNewsVideosEnglish()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/hindi_news_eng_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_news_eng_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }public ArrayList<BaseMediaContentPojo> getHindiNewsVideosHindi()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/hindi_news_hindi_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_news_hindi_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }
public ArrayList<BaseMediaContentPojo> getHindiLearningGuitarVideos()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/Learning/hindi_Learing_Guitar_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_news_hindi_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }

    public ArrayList<BaseMediaContentPojo> getHindiMusicRomanticVideos()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/music/hindi_romantic_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_news_hindi_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }
    public ArrayList<BaseMediaContentPojo> getHindiShortAttitudeVideos()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("HindiData/Videos/attitude/hindi_short_attitude_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.hindi_news_hindi_videos);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            storyList=responsePojo.getVideosList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return storyList;
    }
    private ResponsePojo getMediaContentPojo(String responseData)
    {
        Gson gson=new GsonBuilder().create();
        return gson.fromJson(responseData, ResponsePojo.class);
    }

}
