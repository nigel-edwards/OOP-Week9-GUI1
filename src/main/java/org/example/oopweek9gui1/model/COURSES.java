package org.example.oopweek9gui1.model;

import java.util.EnumSet;

public enum COURSES {
    JAVA(1),
    C(2),
    PYTHON(4),
    SECURITY(8),
    DATABASE(16),
    NETWORK(32),
    AI(64);
    private final int value;

    COURSES(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static int toMask(EnumSet<COURSES> set) {
        int mask = 0;
        for (COURSES course : set) {
            mask |= course.getValue();
        }
        return mask;
    }

    public static EnumSet<COURSES> fromInt(int value) {
        EnumSet<COURSES> set = EnumSet.noneOf(COURSES.class);
        for (COURSES course : values()) {
            if ((course.getValue() & value) != 0) {
                set.add(course);
            }
        }
        return set;
    }
}
