package ru.geekbrainsLessonOne.lesson_1.Leson8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample1 {

    private static Random random = new Random();

    static Employee generateEmployee() {
        String[] names = new String[]{
                "Семён",
                "Константин",
                "Артём",
                "Владислав",
                "Али",
                "Давид",
                "Фёдор",
                "Даниил",
                "Дмитрий",
                "Мирослав" };
        String[] surnames = new String[]{
                "Карпов",
                "Макаров",
                "Успенский",
                "Никитин",
                "Соколов",
                "Белов",
                "Захаров",
                "Захаров",
                "Васильев",
                "Авдеев" };

        int typeIndex = random.nextInt(2);
        int salary = random.nextInt(501 - 200) + 200;
        int salaryIndex = random.nextInt(160 - 100) + 100;

        switch (typeIndex) {
            case 0:
                return new Freelancer(names[random.nextInt(10)], surnames[random.nextInt(10)], salary);
            case 1:
                return new Worker(names[random.nextInt(10)], surnames[random.nextInt(10)], salary * salaryIndex);
        }
        return null;

    }

    public static void main(String[] args) {

        Freelancer freelancer01 = new Freelancer("Анатолий", "Иванов", 2000);

        Employee[] employees = new Employee[10];

        for (int i = 0; i < employees.length; i++)
            employees[i] = generateEmployee();

        for (Employee employee : employees)
            System.out.println(employee);

        Arrays.sort(employees, new SalaryComparer());
        System.out.println("*** ***");

        for (Employee employee : employees)
            System.out.println(employee);


    }
}

abstract class Employee {

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
     *
     * @return среднемесячная  З/П
     */
    public abstract double calculateSalary();
}

class SalaryComparer implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.calculateSalary(), o2.calculateSalary());
    }
}

class Worker extends Employee {

    public Worker(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; Среднемесячная заработная:(фиксированная месячная оплата); Почасовая ставка %.2f (руб.)",
                surname, name, salary);
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

    @Override
    public String toString() {
        return String.format("%s %s; Фрилансер; Среднемесячная заработная: %.2f (руб.); Почасовая ставка %.2f (руб.)",
                surname, name, calculateSalary(), salary);
    }
}