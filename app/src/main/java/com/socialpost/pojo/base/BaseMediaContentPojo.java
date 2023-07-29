package com.socialpost.pojo.base;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.socialpost.manager.database.DataBaseUtility;

import java.io.Serializable;

@Entity
public class BaseMediaContentPojo implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String mediaContentId;
//    private DataBaseUtility.MediaType mediaType= DataBaseUtility.MediaType.MEDIA_TEXT;
    private String mediaText;
    private String likeCount;
    private String tagName;
    private String imageUrl;
    private String storyName;
    private String storyMorel;
    private String storyDetail;
    private String author;
    private String text;

    @ColumnInfo(name = "youTubeVideoId")
    private String youTubeVideoId;

    @ColumnInfo(name = "category_list_id")
    private String category_list_id;


    public String getCategory_list_id() {
        return category_list_id;
    }

    public void setCategory_list_id(String category_list_id) {
        this.category_list_id = category_list_id;
    }


    public String getYouTubeVideoId() {
        return youTubeVideoId;
    }

    public void setYouTubeVideoId(String youTubeVideoId) {
        this.youTubeVideoId = youTubeVideoId;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getStoryName() {
        return storyName;
    }

    public void setStoryName(String storyName) {
        this.storyName = storyName;
    }

    public String getStoryMorel() {
        return storyMorel;
    }

    public void setStoryMorel(String storyMorel) {
        this.storyMorel = storyMorel;
    }

    public String getStoryDetail() {
        return storyDetail;
    }

    public void setStoryDetail(String storyDetail) {
        this.storyDetail = storyDetail;
    }

//    public DataBaseUtility.MediaType getMediaType() {
//        return mediaType;
//    }
//
//    public void setMediaType(DataBaseUtility.MediaType mediaType) {
//        this.mediaType = mediaType;
//    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(String writtenBy) {
        this.writtenBy = writtenBy;
    }

    private String writtenBy;

    public String getMediaContentId() {
        return mediaContentId;
    }

    public void setMediaContentId(String mediaContentId) {
        this.mediaContentId = mediaContentId;
    }



    public String getMediaText() {
        return mediaText;
    }

    public void setMediaText(String mediaText) {
        this.mediaText = mediaText;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }
}
