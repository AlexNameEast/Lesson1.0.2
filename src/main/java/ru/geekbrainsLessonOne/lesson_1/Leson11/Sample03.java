package ru.geekbrainsLessonOne.lesson_1.Leson11;

public class Sample03 {
    public static void main(String[] args) {
        new Sample03().doWork();

    }

    public void doWork() {

        DepositAccount<Integer, String> depositAccount01 =
                new DepositAccount<>(1122, 5000.25, "10000025");
        System.out.println(depositAccount01);

        CreditAccount<Integer> creditAccount01 = new CreditAccount<>(4444,200);
        System.out.println(creditAccount01);

        Transaction<Account<Integer>> transaction01 =
                new Transaction<>(depositAccount01, creditAccount01, 3000);

        transaction01.execute();


        System.out.println();
        transaction01.execute();



    }

    class Transaction<T extends Account<Integer>>{
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

    abstract class Account<T>{

        protected T id;
        private double amount;

        public Account(T id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return String.format("%f руб\n",amount);
        }

        public T getId() {
            return id;
        }

        public void setId(T id) {
            this.id = id;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }

    class CreditAccount <T> extends Account<T>{
        public CreditAccount(T id, double amount) {
            super(id, amount);
        }

        @Override
        public String toString() {
            return String.format("Сумма средств на кредитном счете #%s : %s", id, super.toString());
        }
    }

    class DepositAccount<T, N> extends Account<T>{
        private N no ;

        public N getNo() {
            return no;
        }

        public DepositAccount(T id, double amount, N no) {
            super(id, amount);
            this.no = no;
        }

        @Override
        public String toString() {
            return String.format("Сумма средств на депозитном счете #%s : %s", id, super.toString());
        }

    }

    class SpicialAccount extends Account<String>{

        public SpicialAccount(String id, double amount) {
            super(id, amount);
        }

        @Override
        public String toString() {
            return String.format("Сумма средств на специальном счете #%s : %s", id, super.toString());
        }


    }
}
