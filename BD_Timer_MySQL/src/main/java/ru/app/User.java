package ru.app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
  @JsonProperty("Number") private long id;

  @JsonProperty("First Name") private String name;

  @JsonProperty("Phone Number") private String phone;

  @JsonIgnore private String status;

  public User() {}

  public User(long id, String name, String phone, String status) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.status = status;
  }

  public long getId() { return id; }

  public void setId(long id) { this.id = id; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getPhone() { return phone; }

  public void setPhone(String phone) { this.phone = phone; }

  public String getStatus() { return status; }

  public void setStatus(String status) { this.status = status; }

  @Override
  public String toString() {
    return id + name + phone;
  }
}
// GP08097266
