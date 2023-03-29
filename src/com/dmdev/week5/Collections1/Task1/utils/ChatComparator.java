package com.dmdev.week5.Collections1.Task1.utils;

import com.dmdev.week5.Collections1.Task1.Chat;

import java.util.Comparator;

public class ChatComparator {

    public static Comparator<Chat> byNumUsers = Comparator.comparing(Chat::getNumUsers).reversed();

    public static Comparator<Chat> byName = Comparator.comparing(Chat::getName);

    public static Comparator<Chat> byNumUsersThenByName = byNumUsers.thenComparing(byName);
}
