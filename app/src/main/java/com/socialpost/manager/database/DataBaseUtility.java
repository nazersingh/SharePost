package com.socialpost.manager.database;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class DataBaseUtility {

    public static enum MediaType {
        MEDIA_TEXT("0"),
        MEDIA_IMAGE("1"),
        MEDIA_VIDEO("2");

        public final String value;

        MediaType(String value) {
            this.value = value;
        }
    }

    @Deprecated
    public static enum CategoryName {
        NEW("new"),
        MOTIVATIONAL("motivational"),
        ACHIEVEMENT("achievement"),
        AFFILIATION("affiliation"),
        COMPETENCE("competence"),
        INSPIRATION("inspiration"),
        POWER("power"),
        FEAR("fear"),
        QUOTES("quotes"),
        ENGLISH_STORIES("englishStories"),
        Love_Story("loveStories"),
        SAD_STORIES("sadStories"),
        HINDI_STORIES("hindiStories"),
        PUNJABI_STORIES("punjabiStories"),
        CELEBRITIES_STORIES("celebritiesStories"),
        SAD("sad"),
        FUNNY("funny"),
        KASH("kash"),
        Life("life"),
        FriendShip("friendship"),
        ATTITUDE("attitude"),
        TRENDING("trending"),
        LATEST("latest"),
        LOVE("love"),
        ALONE("alone"),
        BREAKUP("breakup"),
        DHARMIK("dharmik");

        public final String value;
        private final static HashMap<String,CategoryName> categoryMap = new HashMap<String,CategoryName>();

        public static String[] allCategories() {
            String[] categoryList=new String[CategoryName.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= CategoryName.values()[pos].value;
                categoryMap.put(CategoryName.values()[pos].value, CategoryName.values()[pos]);
            }
            return categoryList;
        }
        public static CategoryName valueOfCategoryName(String keyString) {
            allCategories();
            return (CategoryName) categoryMap.get(keyString);
        }

        CategoryName(String value) {

            this.value = value;
        }
    }

    public static enum ContentLanguage {
        English("en"),
        Hindi("hindi"),
        Punjabi("pbi"),
        Italian("it"),
        Mix("mix");

        public final String value;

        ContentLanguage(String value) {
            this.value = value;
        }

        private  final static HashMap signalMap = new HashMap();

        public static  String[] getContentLanguagesList() {
            String[] signalList=new String[ContentLanguage.values().length];
            for(int pos = 0; pos< ContentLanguage.values().length; pos++)
            {
                signalList[pos]= ContentLanguage.values()[pos].value;
                signalMap.put(ContentLanguage.values()[pos].value, ContentLanguage.values()[pos]);
            }
            return signalList;
        }
        public static ContentLanguage valueOfContentLanguage(String keyString) {
            getContentLanguagesList();
            return (ContentLanguage) signalMap.get(keyString);
        }
    }
}
