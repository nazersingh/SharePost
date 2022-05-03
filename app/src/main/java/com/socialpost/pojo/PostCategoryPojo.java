package com.socialpost.pojo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


public class PostCategoryPojo implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    private int id;

    private String categoryText;

    private String category_list_id;

    public PostCategoryPojo(String categoryName)
    {
        this.categoryText =categoryName;
    }
    public String getCategoryText() {
        return categoryText;
    }

    public void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }

    public String getCategory_list_id() {
        return category_list_id;
    }

    public void setCategory_list_id(String category_list_id) {
        this.category_list_id = category_list_id;
    }
}
