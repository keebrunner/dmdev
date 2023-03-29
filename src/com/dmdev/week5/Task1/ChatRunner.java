package com.dmdev.week5.Task1;

import com.dmdev.week5.Task1.utils.ChatComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatRunner {

    public static void main(String[] args) {
        List<Chat> chats = new ArrayList<>();
        chats.add(new Chat("Chat 1", 500));
        chats.add(new Chat("Chat 2", 1000));
        chats.add(new Chat("Chat 3", 2000));
        chats.add(new Chat("Chat 4", 750));
        chats.add(new Chat("Chat 5", 1500));

        chats.removeIf(chat -> chat.getNumUsers() < 1000);

        Collections.sort(chats, ChatComparator.byNumUsersThenByName);

        for (Chat chat : chats) {
            System.out.println(chat.getName() + " (" + chat.getNumUsers() + " users)");
        }

        Collections.sort(chats, ChatComparator.byName);
    }
}

