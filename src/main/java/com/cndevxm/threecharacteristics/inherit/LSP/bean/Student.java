package com.cndevxm.threecharacteristics.inherit.LSP.bean;

/**
 * Created by Yulin Ma
 * Date 2019/2/28
 * Description
 */
public class Student extends People{

    private String schoolName;

    public Student() {
    }

    public Student(String schoolName) {
        this.schoolName = schoolName;
    }

    public Student(String name, int age, String schoolName) {
        super(name, age);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
