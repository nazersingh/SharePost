package com.socialpost.manager.all_content;

import java.util.HashMap;

public class AllCategories {


    public static enum AllAppCategories {
        motivation("motivational"),
        Stories("stories"),
        Poetry("poetry"),
        Photos("photos"),
        Videos("videos");

        public final String value;
        private final static HashMap<String,AllAppCategories> categoryMap = new HashMap<String,AllAppCategories>();

        public static String[] allCategories() {
            String[] categoryList=new String[AllAppCategories.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= AllAppCategories.values()[pos].value;
                categoryMap.put(AllAppCategories.values()[pos].value, AllAppCategories.values()[pos]);
            }
            return categoryList;
        }
        public static AllAppCategories valueOfCategoryName(String keyString) {
            allCategories();
            return (AllAppCategories) categoryMap.get(keyString);
        }

        AllAppCategories(String value) {

            this.value = value;
        }
    }

    /**
     * ========================================================================   Stories
     */

    public static enum StoryCategory {
        English("english"),
        Punjabi("punjabi"),
        Hindi("hindi"),
        Celebrities("celebrities");

        public final String value;
        private final static HashMap<String,StoryCategory> categoryMap = new HashMap<String,StoryCategory>();

        public static String[] allStories() {
            String[] categoryList=new String[StoryCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= StoryCategory.values()[pos].value;
                categoryMap.put(StoryCategory.values()[pos].value, StoryCategory.values()[pos]);
            }
            return categoryList;
        }
        public static StoryCategory valueOfCategoryName(String keyString) {
            allStories();
            return (StoryCategory) categoryMap.get(keyString);
        }

        StoryCategory(String value) {

            this.value = value;
        }
    }

    /**
     * ================================================================== Poetry
     */

    public static enum PoetryCategory {
        Sad("sad"),
        Kash("kash"),
        Funny("funny"),
        Life("life"),
        Friendship("friendship"),
        New("new");

        public final String value;
        private final static HashMap<String,PoetryCategory> categoryMap = new HashMap<String,PoetryCategory>();

        public static String[] allStories() {
            String[] categoryList=new String[PoetryCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= PoetryCategory.values()[pos].value;
                categoryMap.put(PoetryCategory.values()[pos].value, PoetryCategory.values()[pos]);
            }
            return categoryList;
        }
        public static PoetryCategory valueOfCategoryName(String keyString) {
            allStories();
            return (PoetryCategory) categoryMap.get(keyString);
        }

        PoetryCategory(String value) {

            this.value = value;
        }
    }

    /**
     * ==================================================================================  Motivation
     */

    public static enum MotivationalCategory {
        quotes("quotes"),
        attitude("attitude"),
        NEW("new");

        public final String value;
        private final static HashMap<String,MotivationalCategory> categoryMap = new HashMap<String,MotivationalCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[MotivationalCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= MotivationalCategory.values()[pos].value;
                categoryMap.put(MotivationalCategory.values()[pos].value, MotivationalCategory.values()[pos]);
            }
            return categoryList;
        }
        public static MotivationalCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (MotivationalCategory) categoryMap.get(keyString);
        }

        MotivationalCategory(String value) {
            this.value = value;
        }
    }

    /**
     * =========================================================================================== Videos
     */
    public static enum VideosCategory {
        Facts("facts"),
        Science("science"),
        TECH("tech"),
        History("history"),
        Culture("culture"),
        Aware("aware"),
        Motivational("motivational"),
        kids("kids"),
        Learning("learning"),
        News("news"),
        Places("places"),
        Music("music"),
        ShortVideos("short");

        public final String value;
        private final static HashMap<String,VideosCategory> categoryMap = new HashMap<String,VideosCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosCategory.values()[pos].value;
                categoryMap.put(VideosCategory.values()[pos].value, VideosCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosCategory) categoryMap.get(keyString);
        }

        VideosCategory(String value) {

            this.value = value;
        }
    }

    /**
     * =========================================================================================== Videos Sub Category
     */
    public static enum VideosFactsSubCategory {
        Facts("facts");
        public final String value;
        private final static HashMap<String,VideosFactsSubCategory> categoryMap = new HashMap<String,VideosFactsSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosFactsSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosFactsSubCategory.values()[pos].value;
                categoryMap.put(VideosFactsSubCategory.values()[pos].value, VideosFactsSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosFactsSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosFactsSubCategory) categoryMap.get(keyString);
        }

        VideosFactsSubCategory(String value) {

            this.value = value;
        }
    }

    /**
     * ======================================= science
     */

    public static enum VideosScienceSubCategory {
        Science("science");
        public final String value;
        private final static HashMap<String,VideosScienceSubCategory> categoryMap = new HashMap<String,VideosScienceSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosScienceSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosScienceSubCategory.values()[pos].value;
                categoryMap.put(VideosScienceSubCategory.values()[pos].value, VideosScienceSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosScienceSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosScienceSubCategory) categoryMap.get(keyString);
        }

        VideosScienceSubCategory(String value) {

            this.value = value;
        }
    } /**
     * ======================================= tech
     */

    public static enum VideosTechSubCategory {
        Tech("tech");
        public final String value;
        private final static HashMap<String,VideosTechSubCategory> categoryMap = new HashMap<String,VideosTechSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosTechSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosTechSubCategory.values()[pos].value;
                categoryMap.put(VideosTechSubCategory.values()[pos].value, VideosTechSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosTechSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosTechSubCategory) categoryMap.get(keyString);
        }

        VideosTechSubCategory(String value) {

            this.value = value;
        }
    }

    /**
     * ===========================================  history
     */
    public static enum VideosHistorySubCategory {
        History("history");
        public final String value;
        private final static HashMap<String,VideosHistorySubCategory> categoryMap = new HashMap<String,VideosHistorySubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosHistorySubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosHistorySubCategory.values()[pos].value;
                categoryMap.put(VideosHistorySubCategory.values()[pos].value, VideosHistorySubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosHistorySubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosHistorySubCategory) categoryMap.get(keyString);
        }

        VideosHistorySubCategory(String value) {

            this.value = value;
        }
    }

    public static enum VideosCultureSubCategory {
        Culture("culture");
        public final String value;
        private final static HashMap<String,VideosCultureSubCategory> categoryMap = new HashMap<String,VideosCultureSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosCultureSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosCultureSubCategory.values()[pos].value;
                categoryMap.put(VideosCultureSubCategory.values()[pos].value, VideosCultureSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosCultureSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosCultureSubCategory) categoryMap.get(keyString);
        }

        VideosCultureSubCategory(String value) {

            this.value = value;
        }
    }

    public static enum VideosAwareSubCategory {
        Aware("aware");
        public final String value;
        private final static HashMap<String,VideosAwareSubCategory> categoryMap = new HashMap<String,VideosAwareSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosAwareSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosAwareSubCategory.values()[pos].value;
                categoryMap.put(VideosAwareSubCategory.values()[pos].value, VideosAwareSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosAwareSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosAwareSubCategory) categoryMap.get(keyString);
        }

        VideosAwareSubCategory(String value) {

            this.value = value;
        }
    }

    /**
     * ================================================= Motivational
     */
    public static enum VideosMotivationalSubCategory {
        Motivational("motivational");
        public final String value;
        private final static HashMap<String,VideosMotivationalSubCategory> categoryMap = new HashMap<String,VideosMotivationalSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosMotivationalSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosMotivationalSubCategory.values()[pos].value;
                categoryMap.put(VideosMotivationalSubCategory.values()[pos].value, VideosMotivationalSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosMotivationalSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosMotivationalSubCategory) categoryMap.get(keyString);
        }

        VideosMotivationalSubCategory(String value) {

            this.value = value;
        }
    }
    public static enum VideosKidsSubCategory {
        cartoon("cartoon");
        public final String value;
        private final static HashMap<String,VideosKidsSubCategory> categoryMap = new HashMap<String,VideosKidsSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosKidsSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosKidsSubCategory.values()[pos].value;
                categoryMap.put(VideosKidsSubCategory.values()[pos].value, VideosKidsSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosKidsSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosKidsSubCategory) categoryMap.get(keyString);
        }

        VideosKidsSubCategory(String value) {

            this.value = value;
        }
    }
    /**
     * ================================================= Learning
     */
    public static enum VideosLearningSubCategory {
        Italian("italian"),
        ItalianLicence("italianLicence"),
        Guitar("guitar");
        public final String value;
        private final static HashMap<String,VideosLearningSubCategory> categoryMap = new HashMap<String,VideosLearningSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosLearningSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosLearningSubCategory.values()[pos].value;
                categoryMap.put(VideosLearningSubCategory.values()[pos].value, VideosLearningSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosLearningSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosLearningSubCategory) categoryMap.get(keyString);
        }

        VideosLearningSubCategory(String value) {

            this.value = value;
        }
    }

    /**
     * ================================================= News
     */
    public static enum VideosNewsSubCategory {
        Italian("italian"),
        Hindi("hindi"),
        English("english"),
        Punjabi("punjabi");
        public final String value;
        private final static HashMap<String,VideosNewsSubCategory> categoryMap = new HashMap<String,VideosNewsSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosNewsSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosNewsSubCategory.values()[pos].value;
                categoryMap.put(VideosNewsSubCategory.values()[pos].value, VideosNewsSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosNewsSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosNewsSubCategory) categoryMap.get(keyString);
        }

        VideosNewsSubCategory(String value) {

            this.value = value;
        }
    }/**
     * ================================================= Places Live
     */
    public static enum VideosLiveCountrySubCategory {
        Italy("italy");
        public final String value;
        private final static HashMap<String,VideosLiveCountrySubCategory> categoryMap = new HashMap<String,VideosLiveCountrySubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosLiveCountrySubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosLiveCountrySubCategory.values()[pos].value;
                categoryMap.put(VideosLiveCountrySubCategory.values()[pos].value, VideosLiveCountrySubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosLiveCountrySubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosLiveCountrySubCategory) categoryMap.get(keyString);
        }

        VideosLiveCountrySubCategory(String value) {

            this.value = value;
        }
    }

    /**
     * ================================================= Music Category
     */
    public static enum VideosMusicSubCategory {
        Romantic("romantic");
        public final String value;
        private final static HashMap<String,VideosMusicSubCategory> categoryMap = new HashMap<String,VideosMusicSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosMusicSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosLiveCountrySubCategory.values()[pos].value;
                categoryMap.put(VideosMusicSubCategory.values()[pos].value, VideosMusicSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosMusicSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosMusicSubCategory) categoryMap.get(keyString);
        }

        VideosMusicSubCategory(String value) {

            this.value = value;
        }
    }
    /**
     * ================================================= Short videos Category
     */
    public static enum VideosShortSubCategory {
        Attitude("attitude");
        public final String value;
        private final static HashMap<String,VideosShortSubCategory> categoryMap = new HashMap<String,VideosShortSubCategory>();

        public static String[] allVideos() {
            String[] categoryList=new String[VideosShortSubCategory.values().length];
            for(int pos = 0; pos<categoryList.length; pos++)
            {
                categoryList[pos]= VideosLiveCountrySubCategory.values()[pos].value;
                categoryMap.put(VideosShortSubCategory.values()[pos].value, VideosShortSubCategory.values()[pos]);
            }
            return categoryList;
        }
        public static VideosShortSubCategory valueOfCategoryName(String keyString) {
            allVideos();
            return (VideosShortSubCategory) categoryMap.get(keyString);
        }

        VideosShortSubCategory(String value) {

            this.value = value;
        }
    }
}
