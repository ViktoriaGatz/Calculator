package ru.app;

import ru.app.User;
import ru.app.JsonParser;
import java.util.*;
import java.io.*;

public class App {
	public static void main(String[] args) {
		User user = jsonParser.getUser(args[0]);
		System.out.println("name: " + getName() + "lastName: " + getLastName() + "id:" + getId());
	}
}
