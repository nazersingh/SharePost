package com.socialpost.base;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.socialpost.manager.MyApplication;
import com.socialpost.manager.database.DatabaseClient;
import com.socialpost.manager.database.MainDatabase;
import com.socialpost.pojo.AllCategoryListItemPojo;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BaseViewModel extends ViewModel  {

    private MutableLiveData<ArrayList<AllCategoryListItemPojo>> onHomeScreenCategoryListFetched = new MutableLiveData<>();
    private MutableLiveData<ArrayList<BaseMediaContentPojo>> onMediaContentFetched = new MutableLiveData<>();
    private MutableLiveData<ArrayList<BaseMediaContentPojo>> onAllStoriesListFetched = new MutableLiveData<>();
    private MutableLiveData<ArrayList<BaseMediaContentPojo>> onVideosListFetched = new MutableLiveData<>();
    private Executor executor = Executors.newSingleThreadExecutor();


    public void getHomeScreenCategoryList() {

        executor.execute(new Runnable() {
            @Override
            public void run() {

                ArrayList<AllCategoryListItemPojo> categoryListItemPojos= (ArrayList<AllCategoryListItemPojo>) DatabaseClient.getInstance(MyApplication.getInstance()).getAppDatabase().allCategoryDAO().getAll();
                if( categoryListItemPojos.isEmpty()) {
                    Log.e("BaseViewModel", "execute: if size "+categoryListItemPojos.size() );
                    onHomeScreenCategoryListFetched.postValue(MainDatabase.getMainDataBaseInstance().getHomeScreenCategoryList());
                }
                else
                {
                    Log.e("BaseViewModel", "execute: size "+categoryListItemPojos.size() );
                    onHomeScreenCategoryListFetched.postValue(categoryListItemPojos);
                }
            }
        });
    }

    public LiveData<ArrayList<AllCategoryListItemPojo>> onHomeScreenCategoryListFetched()
    {
        return onHomeScreenCategoryListFetched;
    }


    public void getPoetryData(String catId) {
//        onMediaContentFetched.postValue(MainDatabase.getMainDataBaseInstance().getAllSpecificCategoryMediaList(mediaCategoryId));
        Log.e("BaseViewModel", "getMediaContentList: " + catId);

        executor.execute(new Runnable() {
            @Override
            public void run() {

                ArrayList<BaseMediaContentPojo> mediaContentList= (ArrayList<BaseMediaContentPojo>) DatabaseClient.getInstance(MyApplication.getInstance()).getAppDatabase().mediaContentDao().getAll(catId);
                if( mediaContentList.isEmpty()) {
                    onMediaContentFetched.postValue(MainDatabase.getMainDataBaseInstance().getPoetryData(catId));
                }
                else
                {
                    onMediaContentFetched.postValue(mediaContentList);
                }
            }
        });

    }


    public void getMotivationalCategoryData(String catId) {


        onMediaContentFetched.postValue(MainDatabase.getMainDataBaseInstance().getMotivationalData(catId));
    }
    public LiveData<ArrayList<BaseMediaContentPojo>> onMediaContentFetched()
    {
        return onMediaContentFetched;
    }

    public void getAllStories(String categoryId) {
        onAllStoriesListFetched.postValue(MainDatabase.getMainDataBaseInstance().getStories(categoryId));
    }

    public LiveData<ArrayList<BaseMediaContentPojo>> onAllStoriesListFetched()
    {
        return onAllStoriesListFetched;
    }


    public void getVideos(String categoryName,String subCatName,String languageCode) {
        onVideosListFetched.postValue(MainDatabase.getMainDataBaseInstance().getVideos(categoryName,subCatName,languageCode));
    }
 public ArrayList<BaseMediaContentPojo> getAllSpecificCategoryVideos() {
       return onVideosListFetched.getValue();
    }

    public LiveData<ArrayList<BaseMediaContentPojo>> onVideosListFetched()
    {
        return onVideosListFetched;
    }

}
