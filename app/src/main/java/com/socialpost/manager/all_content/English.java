package com.socialpost.manager.all_content;

import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialpost.manager.MyApplication;
import com.socialpost.pojo.base.BaseMediaContentPojo;
import com.socialpost.pojo.ResponsePojo;

import java.io.InputStream;
import java.util.ArrayList;

public class English {


    public ArrayList<BaseMediaContentPojo> getQuotes()
    {
        ArrayList<BaseMediaContentPojo> quotesList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("EnglishData/Poetry/english_quotes.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.english_quotes);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);
            ResponsePojo responsePojo=getMediaContentPojo(response);
            quotesList=responsePojo.getQuotesList();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return quotesList;
    }

    public ArrayList<BaseMediaContentPojo> getEnglishAllStories()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("EnglishData/Stories/english_short_stories.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.english_short_stories);
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



    public ArrayList<BaseMediaContentPojo> getEnglishCelebritiesStories()
    {
        ArrayList<BaseMediaContentPojo> storyList = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("EnglishData/Stories/english_celebrities_story.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.english_celebrities_story);
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

    public ArrayList<BaseMediaContentPojo> getEnglishLiveNewsEnglishVideos()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("EnglishData/Videos/english_news_english_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.english_news_english_videos);
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
    public ArrayList<BaseMediaContentPojo> getEnglishLearningItalianVideos()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("EnglishData/Videos/Learning/english_videos_learn_italian.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.english_news_english_videos);
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
    public ArrayList<BaseMediaContentPojo> getEnglishLearningGuitarVideos()
    {
        ArrayList<BaseMediaContentPojo> list = new ArrayList<>();
        try {
            AssetManager assetManager = MyApplication.getInstance().getAssets();
            InputStream is = assetManager.open("EnglishData/Videos/Learning/english_Learing_Guitar_videos.json");
//            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.english_news_english_videos);
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

    public ResponsePojo getMediaContentPojo(String responseData)
    {
        Gson gson=new GsonBuilder().create();
        return gson.fromJson(responseData, ResponsePojo.class);
    }

}
