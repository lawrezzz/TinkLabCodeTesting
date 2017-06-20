package com.lawrence.tinklabcodetesting.model.bean;

/**
 * Created by Kit on 19/6/2017.
 */

public class CityGuide {

    public static String TYPE_DESC = "desc";
    public static String TYPE_IMAGE = "image";

    String id;
    String type;
    String title;
    String description;
    String image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
