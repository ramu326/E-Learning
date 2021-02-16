package com.analogit.elearningapp.ApiModel;

public class PosterImageVideoModel {
    int id,subject;
    String image,video,name;

    public PosterImageVideoModel(int id, int subject, String image, String video, String name) {
        this.id = id;
        this.subject = subject;
        this.image = image;
        this.video = video;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
