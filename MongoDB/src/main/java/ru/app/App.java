package ru.app;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Iterator;

public class App {
  public static void main(String[] args) {
    MongoClient mClient = new MongoClient("localhost", 27017);
    MongoDatabase db = mClient.getDatabase("IVT");
    MongoCollection<Document> users = db.getCollection("IVT");

    users.updateMany(Filters.gt("age", 0), Updates.inc("age", 1));

    // Установка курсора
    FindIterable<Document> iterDoc = users.find();
    int i = 1;

    // Getting the iterator
    Iterator it = iterDoc.iterator();

    while (it.hasNext()) {
      System.out.println(it.next());
      i++;
    }
    /*
    Document user1 = new Document("name", "Mary");
    user1.append("age", 19);
    user.insertOne(user1);
    // user.insertMany(listUsers);
    */
  }
}
