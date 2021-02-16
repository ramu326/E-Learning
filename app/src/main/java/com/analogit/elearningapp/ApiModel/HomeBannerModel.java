package com.analogit.elearningapp.ApiModel;

public class HomeBannerModel {

    int id;
    String frontbanner,image,created;
    Boolean status;

    public HomeBannerModel(int id, String frontbanner, String image, String created, Boolean status) {
        this.id = id;
        this.frontbanner = frontbanner;
        this.image = image;
        this.created = created;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrontbanner() {
        return frontbanner;
    }

    public void setFrontbanner(String frontbanner) {
        this.frontbanner = frontbanner;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
