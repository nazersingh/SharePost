package com.socialpost.callback;

import com.socialpost.pojo.AllCategoryListItemPojo;
import com.socialpost.pojo.base.BaseMediaContentPojo;

import java.util.ArrayList;

public interface MainDatabaseCallback {

    ArrayList<AllCategoryListItemPojo> getHomeScreenCategoryList();
    ArrayList<AllCategoryListItemPojo> getAllSpecificCategoryList();
    ArrayList<BaseMediaContentPojo> getAllSpecificCategoryMediaList(String mediaCategoryId);
    ArrayList<BaseMediaContentPojo> getAllEnglishQuotes();
    ArrayList<BaseMediaContentPojo> getAllEnglishStories();
    ArrayList<BaseMediaContentPojo> getHindiAttitudeShayari();
    ArrayList<BaseMediaContentPojo> getPunjabiAttitudeShayari();
    ArrayList<BaseMediaContentPojo> getPunjabiMotivationalShayari();
    ArrayList<BaseMediaContentPojo> getHindiFunnyShayari();
    ArrayList<BaseMediaContentPojo> getHindiKashShayari();
    ArrayList<BaseMediaContentPojo> getHindiSadShayari();
    ArrayList<BaseMediaContentPojo> getHindiZindagiShayari();
    ArrayList<BaseMediaContentPojo> getPunjabiNewShayari();
    ArrayList<BaseMediaContentPojo> getAllPunjabiStories();

    ArrayList<BaseMediaContentPojo> getContentData(String mediaCategoryId);
    ArrayList<BaseMediaContentPojo> getStories(String mediaCategoryId);
    ArrayList<BaseMediaContentPojo> getAllHindiStories();
    ArrayList<BaseMediaContentPojo> getHindiFriendsShayari();
    ArrayList<BaseMediaContentPojo> getHindiNewShayari();
}
