package com.analogit.elearningapp.ApiModel;

public class IcardsPastExamsTopicsPagesModel {
    int id;
    String page;

    public IcardsPastExamsTopicsPagesModel(int id, String page) {
        this.id = id;
        this.page = page;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
