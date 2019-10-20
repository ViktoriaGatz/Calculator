package ru.app;

import java.util.*;

public class User {
    private String name;
    private String lastName;
    private int id;

    User() {
        this.setName("User");
        this.setLastName("User");
        this.setId(0);
    }

    User(String name, String lastname, int id) {
        this.setName(name);
        this.setLastName(lastName);
        this.setId(id);
    }

    public void setName(String name) {
        this.name = new String(name);
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = new String(lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
