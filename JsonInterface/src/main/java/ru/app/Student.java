package ru.app;

import java.util.*;

public class Student extends User {
    private boolean offset;

    Student() {
        this.setName("User");
        this.setLastName("User");
        this.setId(0);
        this.setOffset(false);
    }

    Student(String name, String lastName, int id, boolean offset) {
        this.setName(name);
        this.setLastName(lastName);
        this.setId(id);
        this.setOffset(offset);
    }

    public void setOffset(boolean offset) {
        this.offset = offset;
    }

    public boolean getOffset() {
        return offset;
    }
}
