package com.busra.user;

public class User {
    private long id;
    private String name;
    private String email;

   public User( String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
