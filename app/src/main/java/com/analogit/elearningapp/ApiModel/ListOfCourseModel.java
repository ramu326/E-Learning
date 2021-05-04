package com.analogit.elearningapp.ApiModel;

public class ListOfCourseModel {
    int id;
    String Name_Exam;

    public ListOfCourseModel(int id, String name_Exam) {
        this.id = id;
        Name_Exam = name_Exam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_Exam() {
        return Name_Exam;
    }

    public void setName_Exam(String name_Exam) {
        Name_Exam = name_Exam;
    }
}
