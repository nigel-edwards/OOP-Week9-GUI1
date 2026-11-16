package org.example.oopweek9gui1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.oopweek9gui1.database.DBManager;
import org.example.oopweek9gui1.model.COURSES;
import org.example.oopweek9gui1.model.Student;

import java.sql.Date;
import java.sql.SQLException;
import java.util.EnumSet;

public class HelloController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField sidField;
    @FXML
    private DatePicker dobField;
    @FXML
    private ComboBox<String> countryField;
    @FXML
    private CheckBox chk_java;
    @FXML
    private CheckBox chk_c;
    @FXML
    private CheckBox chk_python;
    @FXML
    private CheckBox chk_security;
    @FXML
    private CheckBox chk_database;
    @FXML
    private CheckBox chk_network;
    @FXML
    private CheckBox chk_ai;

    private DBManager db;

    @FXML
    public void initialize() {
        db = new DBManager("jdbc:sqlite:libdatabase.db", null, null);
        try {
            db.connect();
            db.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void onOK(ActionEvent actionEvent) {
        String name = nameField.getText();
        String sid = sidField.getText();
        Date dob = Date.valueOf(dobField.getValue());
        String country = countryField.getSelectionModel().getSelectedItem().toString();
        boolean java = chk_java.isSelected();
        boolean c = chk_c.isSelected();
        boolean python = chk_python.isSelected();
        boolean security = chk_security.isSelected();
        boolean database = chk_database.isSelected();
        boolean network = chk_network.isSelected();
        boolean ai = chk_ai.isSelected();

        System.out.println("The user entered the following data:");
        System.out.println(name);
        System.out.println(sid);
        System.out.println(dob);
        System.out.println(country);
        System.out.println(java);
        System.out.println(c);
        System.out.println(python);
        System.out.println(security);
        System.out.println(database);
        System.out.println(network);
        System.out.println(ai);

        EnumSet course = enumtest();
        Student student = new Student(name, sid, dob, country, course);
        System.out.println(student);
        try {
            db.addStudent(student);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int mask = COURSES.toMask(course);
        System.out.println("The mask value is " + mask);
        EnumSet<COURSES> fromMask = COURSES.fromInt(mask);
        System.out.println(fromMask);
    }
    private EnumSet enumtest() {
        EnumSet<COURSES> courses = EnumSet.noneOf(COURSES.class);

        if (chk_java.isSelected()) {
            courses.add(COURSES.JAVA);
        }
        if (chk_c.isSelected()) {
            courses.add(COURSES.C);
        }
        if (chk_python.isSelected()) {
            courses.add(COURSES.PYTHON);
        }
        if (chk_security.isSelected()) {
            courses.add(COURSES.SECURITY);
        }
        if (chk_database.isSelected()) {
            courses.add(COURSES.DATABASE);
        }
        if (chk_network.isSelected()) {
            courses.add(COURSES.NETWORK);
        }
        if (chk_ai.isSelected()) {
            courses.add(COURSES.AI);
        }

        System.out.println("The user entered the following data:");
        System.out.println(courses);

        return courses;
    }

    public void onExit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
