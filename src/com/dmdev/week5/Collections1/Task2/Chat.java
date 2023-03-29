package com.dmdev.week5.Collections1.Task2;

import java.util.List;

public class Chat {
    private String name;
    private List<User> users;

    public Chat(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }
}
