package ru.geekbrainsLessonOne.lesson_1.Leson11;

public class Sample01 {
    public static void main(String[] args) {
        new Sample01().doWork();

    }


    public void doWork() {
        SimpleAccount simpleAccount = new SimpleAccount(122, 500.22);
        System.out.println(simpleAccount);

        UniversalAccount universalAccount01 = new UniversalAccount(111, 1000.25);
        int universalAccount01Id = (int)universalAccount01.getId();
        System.out.println("Id = " + universalAccount01Id);

//        UniversalAccount universalAccount02 = new UniversalAccount("AAA01", 1000.25);
//        int universalAccount02Id = (int)universalAccount02.getId();
//        System.out.println("Id = " + universalAccount02Id);

        Account<String> account01 = new Account<>("11", 100.12);
        String account01Id = account01.getId();
        System.out.println(account01Id);

        Account<Integer> account02 = new Account<>(11, 100.12);
        int account02Id = account02.getId();
        System.out.println(account02Id);

        SpeciallAccount speciallAccount = new SpeciallAccount("222", 222.5);
        System.out.println(speciallAccount);

        CreditAccount<Integer> creditAccount = new CreditAccount<Integer>();

        Printer printer = new Printer();
        Integer[] numbers = {23,5,2,5,6,-6};
        String[] users = {"Alex", "Ronald", "Elena"};
        printer.print(numbers);
        printer.<String>print(users);
    }

    class  Printer{

        public <TItem> void print(TItem[] items){
            for(TItem item: items){
                System.out.print(item + "\t");
            }
            System.out.println();
        }

    }

    class SimpleAccount {

        private int id;
        private double amount;

        public SimpleAccount(int id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format("Сумма средств на счете #%s : %f руб", id, amount);
        }
    }
    class SpeciallAccount implements Accountable<String>{

        public void setId(String id) {
            this.id = id;
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public void setAmount(double amount) {
            this.amount = amount;
        }

        private String id;
        private double amount;

        public String getId() {
            return id;
        }

        public SpeciallAccount(String id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format("Сумма средств на счете #%s : %f руб", id, amount);
        }
    }
    class UniversalAccount {

        private Object id;
        private double amount;

        public Object getId() {
            return id;
        }

        public UniversalAccount(Object id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format("Сумма средств на счете #%s : %f руб", id, amount);
        }
    }

    class Account<TId>{

        private TId id;
        private double amount;

        public TId getId() {
            return id;
        }

        public Account(TId id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format("Сумма средств на счете #%s : %f руб", id, amount);
        }
    }
    interface Accountable<T>{
        T getId();
        double getAmount();
        void setAmount(double amount);

    }

    class CreditAccount<T> implements Accountable<T>{

        private T id;
        private double amount;

        @Override
        public T getId() {
            return id;
        }

        @Override
        public double getAmount() {
            return amount;
        }

        @Override
        public void setAmount(double amount) {

        }
        public String toString() {
            return String.format("Сумма средств на кредитном счете #%s : %f руб", id, amount);
        }
    }

}

