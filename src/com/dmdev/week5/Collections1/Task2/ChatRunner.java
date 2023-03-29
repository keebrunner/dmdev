package com.dmdev.week5.Collections1.Task2;

import com.dmdev.week5.Collections1.Task2.utils.GetUsersOver18;

import java.util.LinkedList;
import java.util.List;

public class ChatRunner {

    public static void main(String[] args) {
        List<Chat> chats = new LinkedList<>();
        List<User> users1 = new LinkedList<>(List.of(new User(1, "John", 20), new User(2, "Alice", 25), new User(3, "Bob", 30)));
        chats.add(new Chat("Chat 1", users1));
        List<User> users2 = new LinkedList<>(List.of(new User(4, "Carol", 15), new User(5, "Dave", 18), new User(6, "Eve", 21)));
        chats.add(new Chat("Chat 2", users2));
        List<User> users3 = new LinkedList<>(List.of(new User(7, "Frank", 16), new User(8, "Grace", 50), new User(9, "Henry", 60)));
        chats.add(new Chat("Chat 3", users3));

        List<User> usersOver18 = GetUsersOver18.getUsersOver18(chats);
        System.out.println("Users over 18:");
        for (User user : usersOver18) {
            System.out.println(user);
        }
    }
}
