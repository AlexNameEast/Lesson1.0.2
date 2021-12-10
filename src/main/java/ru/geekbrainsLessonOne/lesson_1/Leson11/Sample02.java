package ru.geekbrainsLessonOne.lesson_1.Leson11;

public class Sample02 {
    public static void main(String[] args) {
        new Sample02().doWork();
    }

    public void doWork(){
        SimpleAccount simpleAccountFrom = new SimpleAccount(1111, 4500);
        SimpleAccount simpleAccountTo = new SimpleAccount(2234, 100);

        Transaction<SimpleAccount> simpleAccountTransaction01 =
                new Transaction<>(simpleAccountFrom, simpleAccountTo, 2500);

        simpleAccountTransaction01.execute();
        System.out.println();
        simpleAccountTransaction01.execute();




    }

    class SimpleAccount {

        private int id;
        private double amount;

        public SimpleAccount(int id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format("Сумма средств на счете #%s : %f руб", id, amount);
        }
    }

    class Transaction<T extends SimpleAccount>{
        private T from;
        private T to;
        private double amount;

        public Transaction(T from, T to, double amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        public void execute(){
            if (from.getAmount() >= amount) {
                System.out.printf("Осуществлен перевод средств между счетами на сумму %f руб\n", amount);
                System.out.printf("Счет списания #%s: %f \nСчет зачисления #%s: %f",
                        from.getId(), from.getAmount(), to.getId(), to.getAmount());

                from.setAmount(from.getAmount()-to.getAmount());
            }
            else{
                System.out.println("Операция не возможна, недостаточно средств");
            }
        }


    }
}
