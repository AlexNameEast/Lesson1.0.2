package ru.geekbrainsLessonOne.lesson_1.Lesson5;

public class Сollaborator {
    //ФИО, должность, email, телефон, зарплата, возраст.
    private String fullName;
    private String post;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public int getAge() {
        return this.age;
    }

    public Сollaborator() {
        fullName = "Неизвестно";
        post = "Неизвестно";
        email = "Неизвестно";
        phone = "Неизвестно";
        salary = 0;
        age = 0;
    }

    public Сollaborator(String fullName) {
        this(fullName, "Неизвестно", "Неизвестно", "Неизвестно", 0, 0);

    }

    public Сollaborator(String fullName, String post) {
        this(fullName, post, "Неизвестно", "Неизвестно", 0, 0);

    }

    public Сollaborator(String fullName, String post, String email) {
        this(fullName, post, email, "Неизвестно", 0, 0);

    }

    public Сollaborator(String fullName, String post, String email, String phone) {
        this(fullName, post, email, phone, 0, 0);
    }

    public Сollaborator(String fullName, String post, String email, String phone, int salary) {
        this(fullName, post, email, phone, salary, 0);
    }

    public Сollaborator(String fullName, String post, String email, String phone, int salary, int age) {
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.printf("fullName - %s\npost - %s\nemail - %s\nphone - %s\nsalary - %d\nage - %d\n\n",
                fullName, post, email, phone, salary, age);
    }
}
