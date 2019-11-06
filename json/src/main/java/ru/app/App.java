package ru.app;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        /*
        objectmapper mapper = new objectmapper();
        // В json
        String str = mapper.writeValutAsString(user1);
        // Обратно
        List<User>user2 = mapper.readValue(str, User.class);
        */
        User user = new User(1, "Viki", "89831208504", "student");
        System.out.println(user.toString());
        Converter converter = new Converter();
        try {
            converter.toJSON(user);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user1 = converter.toJavaObject();
            System.out.println(user1.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}