package com.vdvc.reactivedemo.Users;

public class User {

    private final long id;
    private final String name;
    private final String externalInfo;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
        this.externalInfo = getExternalInfo();
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return name;
    }

    // Blocking
    public String getExternalInfo() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    return "blocking content";
    }
}