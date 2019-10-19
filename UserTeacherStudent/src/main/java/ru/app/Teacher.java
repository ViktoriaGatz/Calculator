package ru.app;

import java.util.*;

public class Teacher extends User {
    private boolean scientificWork;

    Teacher() {
        this.setName("User");
        this.setLastName("User");
        this.setId(0);
        this.setScientificWork(false);
    }

    Teacher(String name, String lastName, int id, boolean scientificWork) {
        this.setName(name);
        this.setLastName(lastName);
        this.setId(id);
        this.setScientificWork(scientificWork);
    }

    public void setScientificWork(boolean scientificWork) {
        this.scientificWork = scientificWork;
    }

    public boolean getScientificWork() {
        return scientificWork;
    }
}
