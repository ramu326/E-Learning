package com.analogit.elearningapp.ApiModel;

public class IcardsSubjectTopics {
    int id,icard;
    String subject;

    public IcardsSubjectTopics(int id, int icard, String subject) {
        this.id = id;
        this.icard = icard;
        this.subject = subject;
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
}
