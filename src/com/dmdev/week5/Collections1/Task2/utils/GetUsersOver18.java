package com.dmdev.week5.Collections1.Task2.utils;


import com.dmdev.week5.Collections1.Task2.Chat;
import com.dmdev.week5.Collections1.Task2.User;

import java.util.ArrayList;
import java.util.List;

public class GetUsersOver18 {

    public static List<User> getUsersOver18(List<Chat> chats) {
        List<User> users = new ArrayList<>();
        for (Chat chat : chats) {
            for (User user : chat.getUsers()) {
                if (user.getAge() > 18) {
                    users.add(user);
                }
            }
        }
        return users;
    }
}
