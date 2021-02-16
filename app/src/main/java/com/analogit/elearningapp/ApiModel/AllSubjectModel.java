package com.analogit.elearningapp.ApiModel;

public class AllSubjectModel {
    int id;
    String category,name,code,statusCreated,updated;

    public AllSubjectModel(int id, String category, String name, String code, String statusCreated, String updated) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.code = code;
        this.statusCreated = statusCreated;
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatusCreated() {
        return statusCreated;
    }

    public void setStatusCreated(String statusCreated) {
        this.statusCreated = statusCreated;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
