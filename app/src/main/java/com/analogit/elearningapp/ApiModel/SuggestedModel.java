package com.analogit.elearningapp.ApiModel;

public class SuggestedModel {
    int id,topicId;
    String name,video,image,rounds;

    public SuggestedModel(int id, int topicId, String name, String video, String image, String rounds) {
        this.id = id;
        this.topicId = topicId;
        this.name = name;
        this.video = video;
        this.image = image;
        this.rounds = rounds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRounds() {
        return rounds;
    }

    public void setRounds(String rounds) {
        this.rounds = rounds;
    }
}
