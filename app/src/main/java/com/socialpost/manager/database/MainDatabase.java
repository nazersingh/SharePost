package com.socialpost.manager.database;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.socialpost.R;
import com.socialpost.callback.MainDatabaseCallback;
import com.socialpost.manager.MyApplication;
import com.socialpost.manager.all_content.AllCategories;
import com.socialpost.manager.all_content.English;
import com.socialpost.manager.all_content.Hindi;
import com.socialpost.manager.all_content.ItalianData;
import com.socialpost.manager.all_content.MixContent;
import com.socialpost.manager.all_content.Punjabi;
import com.socialpost.manager.room_db.SaveCategoryContent;
import com.socialpost.manager.room_db.SaveMediaContent;
import com.socialpost.pojo.AllCategoryListItemPojo;
import com.socialpost.pojo.base.BaseMediaContentPojo;
import com.socialpost.pojo.ResponsePojo;

import java.io.InputStream;
import java.util.ArrayList;

public class MainDatabase implements MainDatabaseCallback {

    private static MainDatabase mMainDatabase;
    private final String TAG = this.getClass().getSimpleName();
    private Punjabi mPunjabiContent;
    private Hindi mHindiContent;
    private English mEnglishContent;
    private MixContent mMixContent;
    private ItalianData italianData;

    private MainDatabase() {
        mEnglishContent = new English();
        mHindiContent = new Hindi();
        mPunjabiContent = new Punjabi();
        mMixContent=new MixContent();
        italianData=new ItalianData();
    }

    public static MainDatabase getMainDataBaseInstance() {
        if (mMainDatabase == null) {
            mMainDatabase = new MainDatabase();
        }
        return mMainDatabase;
    }


    @Override
    public ArrayList<AllCategoryListItemPojo> getHomeScreenCategoryList() {
        return getHomeScreenCategoryListDb();
    }

    @Override
    public ArrayList<AllCategoryListItemPojo> getAllSpecificCategoryList() {
        return null;
    }

    private ArrayList<AllCategoryListItemPojo> getHomeScreenCategoryListDb() {
        ArrayList<AllCategoryListItemPojo> allCategoryListItems = new ArrayList<>();
        try {
            InputStream is = MyApplication.getInstance().getResources().openRawResource(R.raw.all_categories);
            byte[] b = new byte[is.available()];
            is.read(b);
            String response = new String(b);

            ResponsePojo responsePojo = getMediaContentPojo(response);
            allCategoryListItems = responsePojo.getCategoryList();
            new SaveCategoryContent(allCategoryListItems).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCategoryListItems;
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getAllSpecificCategoryMediaList(String mediaCategoryId) {
        return getHomeScreenCategoryMediaListDb(mediaCategoryId);
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getAllEnglishQuotes() {
        return mEnglishContent.getQuotes();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getAllEnglishStories() {
        return mEnglishContent.getEnglishAllStories();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getHindiAttitudeShayari() {
        return mHindiContent.getHindiAttitudeShayariList();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getPunjabiAttitudeShayari() {
        return mPunjabiContent.getPunjabiAttitudeShayariList();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getPunjabiMotivationalShayari() {
        return mPunjabiContent.getPunjabiMotivationalList();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getHindiFunnyShayari() {
        return mHindiContent.getHindiFunnyList();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getHindiKashShayari() {
        return mHindiContent.getHindiKashList();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getHindiSadShayari() {
        return mHindiContent.getHindiSadList();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getAllHindiStories() {
        return mHindiContent.getHindiAllStoriesData();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getHindiZindagiShayari() {
        return mHindiContent.getHindiZindagiList();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getHindiFriendsShayari() {
        return mHindiContent.getHindiFriendShipShayari();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getHindiNewShayari() {
        return mHindiContent.getHindiNewShayari();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getPunjabiNewShayari() {
        return mPunjabiContent.getPunjabiNewList();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getAllPunjabiStories() {
        return mPunjabiContent.getPunjabiAllStoriesData();
    }

    public ArrayList<BaseMediaContentPojo> getPoetryData(String categoryId) {
        Log.e(TAG, "getPoetryData: "+categoryId );
        String[] categoryNameArray = categoryId.split("_");
        String categoryMain = categoryNameArray[0];
        String categoryData = categoryNameArray[1];
        String categoryLanguage = categoryNameArray[2];

        AllCategories.PoetryCategory poetryCategory =  AllCategories.PoetryCategory.valueOfCategoryName(categoryData);
        DataBaseUtility.ContentLanguage contentLanguage = DataBaseUtility.ContentLanguage.valueOfContentLanguage(categoryLanguage);
        Log.e(TAG, "getPoetryData: "+poetryCategory );
        ArrayList<BaseMediaContentPojo> mediaContentPojos=new ArrayList<>();
        switch (poetryCategory)
        {
            case Friendship:
                switch (contentLanguage) {
                    case English:
                       mediaContentPojos=getAllEnglishQuotes();
                        new SaveMediaContent(mediaContentPojos).execute();
                    return mediaContentPojos;
                    case Hindi:
                        mediaContentPojos=mHindiContent.getHindiFriendShipShayari();
                        new SaveMediaContent(mediaContentPojos).execute();
                      return mediaContentPojos;
                    case Punjabi:
                       break;
                }
                break;
            case Funny:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:
                        mediaContentPojos=mHindiContent.getHindiFunnyList();
                        new SaveMediaContent(mediaContentPojos).execute();
                        return mediaContentPojos;
                    case Punjabi:
                        break;

                }
                break;
            case Kash:
                switch (contentLanguage) {
                    case English:
                        break;
                    case Hindi:
                        mediaContentPojos=mHindiContent.getHindiKashList();
                        new SaveMediaContent(mediaContentPojos).execute();
                        return mediaContentPojos;
                    case Punjabi:
                      break;

                }
                break;
                case Life:
                switch (contentLanguage) {
                    case English:
                        break;
                    case Hindi:
                        mediaContentPojos=mHindiContent.getHindiZindagiList();
                        new SaveMediaContent(mediaContentPojos).execute();
                        return mediaContentPojos;
                    case Punjabi:
                        break;

                }
            break;  case Sad:
                switch (contentLanguage) {
                    case English:
                        break;
                    case Hindi:
                        mediaContentPojos=mHindiContent.getHindiSadList();
                        new SaveMediaContent(mediaContentPojos).execute();
                        return mediaContentPojos;
                    case Punjabi:
                        break;

                }
            break; case New:
                switch (contentLanguage) {
                    case English:
                        break;
                    case Hindi:
                        mediaContentPojos=getHindiNewShayari();
                        new SaveMediaContent(mediaContentPojos).execute();
                        return mediaContentPojos;
                    case Punjabi:
                        mediaContentPojos=getPunjabiNewShayari();
                        new SaveMediaContent(mediaContentPojos).execute();
                        return mediaContentPojos;
                }
                break;

        }

        return new ArrayList<>();

    }


    public ArrayList<BaseMediaContentPojo> getMotivationalData(String categoryId) {

        String[] categoryNameArray = categoryId.split("_");
        String categoryMain = categoryNameArray[0];
        String categoryData = categoryNameArray[1];
        String categoryLanguage = categoryNameArray[2];
        AllCategories.MotivationalCategory motivationalCategory =  AllCategories.MotivationalCategory.valueOfCategoryName(categoryData);
        DataBaseUtility.ContentLanguage contentLanguage = DataBaseUtility.ContentLanguage.valueOfContentLanguage(categoryLanguage);
        Log.e(TAG, "getStories: "+motivationalCategory );
        switch (motivationalCategory)
        {
            case quotes:
                switch (contentLanguage) {
                    case English:
                        return getAllEnglishQuotes();
                    case Hindi:
                        break;
                    case Punjabi:
                        return mPunjabiContent.getPunjabiMotivationalList();
                }
            case attitude:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:
                        return getHindiAttitudeShayari();
                    case Punjabi:
                        return getPunjabiAttitudeShayari();

                }
            case NEW:
                switch (contentLanguage) {
                    case English:
                        break;
                    case Hindi:
                        return getHindiNewShayari();
                    case Punjabi:
                        return getPunjabiNewShayari(); // TODO need to change here I don't know but yes :)

                }

        }

        return new ArrayList<>();

    }

    @Override
    public ArrayList<BaseMediaContentPojo> getContentData(String mediaCategoryId) {
        Log.e(TAG, "getContentData: " + mediaCategoryId);
        String categoryName, language;
        String[] categoryNameArray = mediaCategoryId.split("_");
        categoryName = categoryNameArray[0];
        language = categoryNameArray[1];
        DataBaseUtility.CategoryName categoryName_ = DataBaseUtility.CategoryName.valueOfCategoryName(categoryName.trim());
        DataBaseUtility.ContentLanguage contentLanguage = DataBaseUtility.ContentLanguage.valueOfContentLanguage(language);
        switch (categoryName_) {
            case MOTIVATIONAL:
                switch (contentLanguage) {
                    case English:
                        return getAllEnglishQuotes();
                    case Hindi:
                        break;
                    case Punjabi:
                        return mPunjabiContent.getPunjabiMotivationalList();
                }
                break;
            case ACHIEVEMENT:
                break;
            case AFFILIATION:
                break;
            case COMPETENCE:
                break;
            case FEAR:
                break;
            case INSPIRATION:
                break;
            case ATTITUDE:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:
                        return getHindiAttitudeShayari();
                    case Punjabi:
                        return getPunjabiAttitudeShayari();

                }
                break;

            case Love_Story:
                break;


            case Life:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:
                        return getHindiZindagiShayari();
                    case Punjabi:
                        break;

                }
                break;
            case FriendShip:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:
                        return getHindiFriendsShayari();
                    case Punjabi:

                        break;

                }

                break;
            case HINDI_STORIES:
                break;

            case SAD:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:
                        return getHindiSadShayari();
                    case Punjabi:

                        break;

                }

                break;
            case FUNNY:

                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:
                        return getHindiFunnyShayari();
                    case Punjabi:
                        break;

                }
                break;
            case KASH:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:
                        return getHindiKashShayari();
                    case Punjabi:
                        break;

                }
                break;
            case LATEST:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:

                        break;
                    case Punjabi:
                        return getPunjabiNewShayari();

                }
                break;
            case TRENDING:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:

                        break;
                    case Punjabi:
                        break;

                }
                break;
            case NEW:
                switch (contentLanguage) {
                    case English:
                        break;
                    case Hindi:
                        return getHindiNewShayari();
                    case Punjabi:
                        return getPunjabiNewShayari(); // TODO need to change here I don't know but yes :)

                }
                break;
        }
        return new ArrayList<>();
    }

    @Override
    public ArrayList<BaseMediaContentPojo> getStories(String mediaCategoryId) {

        String categoryName, language;
        String[] categoryNameArray = mediaCategoryId.split("_");
        categoryName = categoryNameArray[0];
        language = categoryNameArray[1];
        AllCategories.StoryCategory storyCategory =  AllCategories.StoryCategory.valueOfCategoryName(categoryName.trim());
        DataBaseUtility.ContentLanguage contentLanguage = DataBaseUtility.ContentLanguage.valueOfContentLanguage(language);
        Log.e(TAG, "getStories: "+storyCategory );
        switch (storyCategory)
        {
            case Punjabi:
                return getAllPunjabiStories();
            case Hindi:
                return getAllHindiStories();
            case English:
                return getAllEnglishStories();
            case Celebrities:
                switch (contentLanguage) {

                    case Hindi:
                    return mHindiContent.getHindiCelebritiesStories();
                    case Punjabi:
                        break;
                    case English:
                       return mEnglishContent.getEnglishCelebritiesStories();
                }
                break;

        }

        return new ArrayList<>();
    }

    public ArrayList<BaseMediaContentPojo> getVideos(String  videosCategoryKey, String subCategory, String contentLanguageKey) {

//        String categoryName, language;
//        String[] categoryNameArray = videoCategoryId.split("_");
//        categoryName = categoryNameArray[0];
//        language = categoryNameArray[1];
        AllCategories.VideosCategory videosCategory =  AllCategories.VideosCategory.valueOfCategoryName(videosCategoryKey);
        DataBaseUtility.ContentLanguage contentLanguage = DataBaseUtility.ContentLanguage.valueOfContentLanguage(contentLanguageKey);
        Log.e(TAG, "getVideos: "+videosCategory+" sub "+subCategory +" lang "+contentLanguage);
        switch (videosCategory)
        {
            case Facts:
                AllCategories.VideosFactsSubCategory factsSubCategory =  AllCategories.VideosFactsSubCategory.valueOfCategoryName(subCategory);
                switch (factsSubCategory)
                {
                    case Facts:
                        return mHindiContent.getHindiVideosFactsVideos();
                }
                break;
            case History:
                AllCategories.VideosHistorySubCategory videosHistorySubCategory =  AllCategories.VideosHistorySubCategory.valueOfCategoryName(subCategory);
                switch (videosHistorySubCategory)
                {
                    case History:
                        return mHindiContent.getHindiHistoryVideos();
                }
                break;
            case Science:
                 return mHindiContent.getHindiScienceVideos();
            case TECH:
                AllCategories.VideosTechSubCategory videosTechSubCategory =  AllCategories.VideosTechSubCategory.valueOfCategoryName(subCategory);
                switch (videosTechSubCategory)
                {
                    case Tech:
                        switch (contentLanguage) {

                            case Hindi:
                                return mHindiContent.getHindiTechVideos();
                            case Punjabi:
                                break;
                            case English:
                                break;
                        }
                        break;
                }

                break;
            case Aware:
                AllCategories.VideosAwareSubCategory videosAwareSubCategory =  AllCategories.VideosAwareSubCategory.valueOfCategoryName(subCategory);
                switch (videosAwareSubCategory)
                {
                    case Aware:
                        return mMixContent.getAwareVideosData();
                }

            case Culture:
                AllCategories.VideosCultureSubCategory videosCultureSubCategory =  AllCategories.VideosCultureSubCategory.valueOfCategoryName(subCategory);
                switch (videosCultureSubCategory)
                {
                    case Culture:
                        return mPunjabiContent.getPunjabiCultureVideosData();
                }
                break;
            case Motivational:
                AllCategories.VideosMotivationalSubCategory videosMotivationalSubCategory =  AllCategories.VideosMotivationalSubCategory.valueOfCategoryName(subCategory);

                switch (videosMotivationalSubCategory)
                {
                    case Motivational:
                        switch (contentLanguage) {

                            case Hindi:
                                return mHindiContent.getHindiMotivationalVideos();
                            case Punjabi:
                                break;
                            case English:
                                break;
                        }
                }

                break;
            case kids:
                AllCategories.VideosKidsSubCategory videosKidsSubCategory =  AllCategories.VideosKidsSubCategory.valueOfCategoryName(subCategory);

                switch (videosKidsSubCategory)
                {
                    case cartoon:
                        switch (contentLanguage) {

                            case Hindi:
                                break;
                            case Punjabi:
                                break;
                            case English:
                                break;
                            case Italian:
                                return italianData.getItalianCartoons();
                        }
                }
                break;
            case Learning:
                AllCategories.VideosLearningSubCategory videosLearningSubCategory =  AllCategories.VideosLearningSubCategory.valueOfCategoryName(subCategory);

                switch (videosLearningSubCategory)
                {
                    case Italian:
                        switch (contentLanguage) {

                            case Hindi:
                                break;
                            case Punjabi:
                                return mPunjabiContent.getPunjabiItalianVideosData();
                            case English:
                                return mEnglishContent.getEnglishLearningItalianVideos();
                        }
                        break;
                    case Guitar:
                        switch (contentLanguage) {
                            case Hindi:
                                return mHindiContent.getHindiLearningGuitarVideos();
                            case Punjabi:
                               break;
                            case English:
                                return mEnglishContent.getEnglishLearningGuitarVideos();
                        }
                        break;
                    case ItalianLicence:
                        switch (contentLanguage) {
                            case Hindi:
                                break;
                            case Punjabi:
                                return mPunjabiContent.getPunjabiItalianLicenceVideosData();
                            case English:
                               break;
                        }
                        break;
                }

                break;
                case News:
                AllCategories.VideosNewsSubCategory videosNewsSubCategory =  AllCategories.VideosNewsSubCategory.valueOfCategoryName(subCategory);

                switch (videosNewsSubCategory)
                {
                    case Italian:
                        switch (contentLanguage) {

                            case Hindi:
                               break;
                            case Punjabi:
                                break;
                            case English:
                                break;
                            case Italian:
                                return italianData.getItalianLiveNews();
                        }
                        break;
                    case Hindi:
                        switch (contentLanguage) {

                            case Hindi:
                                return mHindiContent.getHindiNewsVideosHindi();
                            case Punjabi:
                                break;
                            case English:
                                return mHindiContent.getHindiNewsVideosEnglish();
                            case Italian:
                                break;
                        }
                        break; case English:
                        switch (contentLanguage) {

                            case Hindi:
                                break;
                            case Punjabi:
                                break;
                            case English:
                                return mEnglishContent.getEnglishLiveNewsEnglishVideos();
                            case Italian:
                                break;
                        }
                        break; case Punjabi:
                        switch (contentLanguage) {

                            case Hindi:
                               break;
                            case Punjabi:
                                return mPunjabiContent.getPunjabiLiveNewsPbiVideos();
                            case English:
                                break;
                            case Italian:
                                break;
                        }
                        break;
                }

                break;
            case Places:
                AllCategories.VideosLiveCountrySubCategory videosLiveCountrySubCategory =  AllCategories.VideosLiveCountrySubCategory.valueOfCategoryName(subCategory);
                switch (videosLiveCountrySubCategory)
                {
                    case Italy:
                        switch (contentLanguage) {
                            case Italian:
                                return italianData.getItalianLivePlaces();
                        }
                        break;
                }
                break;
            case Music:
                AllCategories.VideosMusicSubCategory musicCategory =  AllCategories.VideosMusicSubCategory.valueOfCategoryName(subCategory);

                switch (musicCategory)
                {
                    case Romantic:
                        switch (contentLanguage) {
                            case Hindi:
                                return mHindiContent.getHindiMusicRomanticVideos();
                            case Italian:
                                return italianData.getItalianRomanticSongs();
                        }
                        break;
                }
                break;
            case ShortVideos:
                AllCategories.VideosShortSubCategory videosShortSubCategory =  AllCategories.VideosShortSubCategory.valueOfCategoryName(subCategory);

                switch (videosShortSubCategory)
                {
                    case Attitude:
                        switch (contentLanguage) {
                            case Hindi:
                                return mHindiContent.getHindiShortAttitudeVideos();
                            case Italian:
                                return italianData.getItalianShortAttitudeVideos();
                            case Punjabi:
                                return mPunjabiContent.getPunjabiShortAttitudeVideos();
                        }
                        break;
                }
                break;
        }

        return new ArrayList<>();
    }


    public ArrayList<BaseMediaContentPojo> getNewsVideosData(String categoryId, String language) {

        AllCategories.MotivationalCategory motivationalCategory =  AllCategories.MotivationalCategory.valueOfCategoryName(categoryId);
        DataBaseUtility.ContentLanguage contentLanguage = DataBaseUtility.ContentLanguage.valueOfContentLanguage(language);
        Log.e(TAG, "getStories: "+motivationalCategory );
        switch (motivationalCategory)
        {
            case quotes:
                switch (contentLanguage) {
                    case English:
                        return getAllEnglishQuotes();
                    case Hindi:
                        break;
                    case Punjabi:
                        return mPunjabiContent.getPunjabiMotivationalList();
                }
            case attitude:
                switch (contentLanguage) {
                    case English:

                        break;
                    case Hindi:
                        return getHindiAttitudeShayari();
                    case Punjabi:
                        return getPunjabiAttitudeShayari();

                }
            case NEW:
                switch (contentLanguage) {
                    case English:
                        break;
                    case Hindi:
                        return getHindiNewShayari();
                    case Punjabi:
                        return getPunjabiNewShayari(); // TODO need to change here I don't know but yes :)

                }

        }

        return new ArrayList<>();

    }

    private ArrayList<BaseMediaContentPojo> getHomeScreenCategoryMediaListDb(String mediaCategoryId) {
        ArrayList<BaseMediaContentPojo> allMediaDataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BaseMediaContentPojo mediaContentPojo = new BaseMediaContentPojo();
            mediaContentPojo.setLikeCount("" + 100 + i);
            mediaContentPojo.setMediaText(" Hello this is dummy text to share on social Media");
            allMediaDataList.add(mediaContentPojo);
        }
        return allMediaDataList;
    }

    private ResponsePojo getMediaContentPojo(String responseData) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(responseData, ResponsePojo.class);
    }
}
