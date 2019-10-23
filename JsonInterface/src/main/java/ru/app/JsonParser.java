/*
Interface JSON
task datetime   +
vk.ip
    user.get-> class User
    (разобраться с readValue)
git
    ФИО и группа в README
    Удалить лишнее из репозитория +
    .gitignore +
*/
package ru.app;

import org.json.JSONException;
import org.json.JSONObject;
import ru.app.User;

public class JsonParser {
    public User getUser(String response) {
        JSONObject userJson = new JSONObject(response);

        String name = userJson.getString("name");
        String lastName = userJson.getString("lastName");
        long id = userJson.getLong("id");

        return new User(name, lastName, id);
    }
}
