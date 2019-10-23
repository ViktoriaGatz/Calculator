package ru.app;

import org.json.JSONException;
import org.json.JSONObject;
import ru.app.User;
import java.util.*;
import java.io.*;

public class App {
	public static void main(String[] args) {
		JsonParser jsonParser = new JsonParser();
		User user;

		user = jsonParser.getUser("{\n\"user\": [\n{\n\"name\": \"Viktoria\",\n\"lastName\": \"Gatsulia\",\n\"id\": 929\n},\n{\n\"name\": \"Viktoria\",\n\"lastName\": \"Gatsulia\",\n\"id\": 929\n}\n]\n}");
		System.out.println("name: " + user.getName() + "lastName: " + user.getLastName() + "id:" + user.getId());
	}
}
