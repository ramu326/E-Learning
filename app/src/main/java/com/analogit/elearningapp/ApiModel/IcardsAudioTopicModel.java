package com.analogit.elearningapp.ApiModel;

public class IcardsAudioTopicModel {
    int id,icard;
    String audio_topic,image;

    public IcardsAudioTopicModel(int id, int icard, String audio_topic, String image) {
        this.id = id;
        this.icard = icard;
        this.audio_topic = audio_topic;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIcard() {
        return icard;
    }

    public void setIcard(int icard) {
        this.icard = icard;
    }

    public String getAudio_topic() {
        return audio_topic;
    }

    public void setAudio_topic(String audio_topic) {
        this.audio_topic = audio_topic;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
