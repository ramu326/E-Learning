package com.analogit.elearningapp.Model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class NewIcardsModel {
    int id,icard;
    String subject,image;

    public NewIcardsModel(int id, int icard, String subject, String image) {
        this.id = id;
        this.icard = icard;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
