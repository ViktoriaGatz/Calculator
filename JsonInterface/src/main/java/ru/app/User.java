package ru.app;

import java.util.*;

public class User {
    private String name;
    private String lastName;
    private long id;

    User() {
        this.setName("User");
        this.setLastName("User");
        this.setId(0);
    }

    User(String name, String lastname, long id) {
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

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
