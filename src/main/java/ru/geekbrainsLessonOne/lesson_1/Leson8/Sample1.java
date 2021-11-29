package ru.geekbrainsLessonOne.lesson_1.Leson8;

public class Sample1 {
    public static void main(String[] args) {

        Freelancer freelancer01 = new Freelancer("Анатолий", "Иванов",2000);



    }
}

abstract class Employee{

    protected String name;
    protected String surname;
    protected double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    /**
     * Расчет среднемесячной заработной платы
     * @return среднемесячная  З/П
     */
    public abstract double calculateSalary();
}

class Worker extends Employee{

    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}

class Freelancer extends Employee {
    public Freelancer(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return (salary * 8 * 20);
    }
}