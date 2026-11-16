package org.example.oopweek9gui1.model;

import java.sql.Date;
import java.util.EnumSet;

public class Student {
    private String name;
    private String sid;
    private Date dob;
    private String country;
    private EnumSet<COURSES> courses;

    public Student(String name, String sid, Date dob, String Country, EnumSet<COURSES> courses) {
        this.name = name;
        this.sid = sid;
        this.dob = dob;
        this.country = Country;
        this.courses = courses;
    }

    public Student(String name, String sid, Date dob, String Country, int courses) {
        this.name = name;
        this.sid = sid;
        this.dob = dob;
        this.country = Country;
        this.courses = COURSES.fromInt(courses);
    }

    public String getName() {
        return name;
    }

    public String getSid() {
        return sid;
    }

    public Date getDob() {
        return dob;
    }

    public String getCountry() {
        return country;
    }

    public EnumSet<COURSES> getCourses() {
        return courses;
    }

    public String toString() {
        return "Student [name=" + name + ", sid=" + sid + ", dob=" + dob + ", country=" + country+  ", courses=" + courses.toString() + "]";
    }
}
