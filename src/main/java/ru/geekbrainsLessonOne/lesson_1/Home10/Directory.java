package ru.geekbrainsLessonOne.lesson_1.Home10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Directory {
    private Map<String, ArrayList<String>> directory_hm = new HashMap<>();
    private ArrayList<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory_hm.containsKey(surname)) {
            phone_number_list = directory_hm.get(surname);
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        }
    }

    public ArrayList<String> get(String surname) {
        return directory_hm.get(surname);
    }
}
