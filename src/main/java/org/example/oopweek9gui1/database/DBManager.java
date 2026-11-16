package org.example.oopweek9gui1.database;

import org.example.oopweek9gui1.model.COURSES;
import org.example.oopweek9gui1.model.Student;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.EnumSet;

public class DBManager {
    private DBConnection db;

    public DBManager(String url, String username, String password) {
        db = new DBConnection(url, username, password);
    }

    public void connect() throws SQLException {
        db.connect();
    }

    public void disconnect() throws SQLException {
        db.disconnect();
    }

    public void init() throws SQLException {
        db.sqlUpdate("DROP TABLE IF EXISTS student;");
        db.sqlUpdate("CREATE TABLE student (sid VARCHAR(10) PRIMARY KEY, name VARCHAR(30), dob date, country VARCHAR(30), courses INTEGER);");
    }

    public int addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO student VALUES (?, ?, ?, ?, ?);";
        PreparedStatement prep = db.prepareStatement(sql);
        prep.setString(1, student.getSid());
        prep.setString(2, student.getName());
        prep.setString(3, student.getDob().toString());
        prep.setString(4, student.getCountry());
        prep.setInt(5, COURSES.toMask(student.getCourses()));
        return prep.executeUpdate();
    }


}
