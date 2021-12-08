package ru.geekbrainsLessonOne.lesson_1.Leson8;

import java.util.Random;

public class H_w {
    // 4 задание не сделано(
    public static void main(String[] args) {

        Random random = new Random();
        Object[] participants = new Object[100];
        Object[] obstacles = new Object[100];


        String[] humans = {
                "Кира",
                "Артём",
                "Алёна",
                "Стефания",
                "Илья",
                "Марьям",
                "Аделина",
                "Даниил",
                "Филипп",
                "Алина",
                "Александр",
                "Владимир",
                "Марк",
                "Софья",
                "Константин"
        };
        String[] cats = {
               "Флеш",
               "Призрак",
               "Осип",
               "Центурион",
               "Эйнштейн",
               "Гангстер",
               "Хайд",
               "Билан",
               "Юзер",
               "Чанг",
               "Саймон",
               "Эскалибур",
               "Лорд",
               "Вирфольд",
               "Шалун"
        };
        String[] robots = {
                "TurboGlagiato",
                "MadKille",
                "FirstRaide",
                "FastWandere",
                "NeoFortres",
                "WheelBombe",
                "BattleBo",
                "MechaKin",
                "SteelKin",
                "MadUnbor",
                "SurrealKille",
                "WheelRaide",
                "NightNai",
                "StealthGlagiato",
                "ChainGlagiator"
        };

        //создаём участников и препятствия
        for (int i = 0; i < 15; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    participants[i] = new Human(humans[i], random.nextInt(200), random.nextInt(10));
                    break;
                case 1:
                    participants[i] = new Cat(cats[i], random.nextInt(500), random.nextInt(30));
                    break;
                case 2:
                    participants[i] = new Robot(robots[i], random.nextInt(2000), random.nextInt(1000));
                    break;
            }

            switch (random.nextInt(2)) {
                case 0:
                    obstacles[i] = new Treadmill(random.nextInt(2100));
                    break;
                case 1:
                    obstacles[i] = new Wall(random.nextInt(1100));
                    break;
            }
        }

// участники преодолевают препятствие (стену или дорожку)
        for (int i = 0; i < 15; i++) {
            if (obstacles[i].getClass() == Treadmill.class && participants[i].getClass() == Human.class) {
                ((Treadmill) obstacles[i]).run((Human) participants[i], random.nextInt(300));
            }
            if (obstacles[i].getClass() == Treadmill.class && participants[i].getClass() == Cat.class) {
                ((Treadmill) obstacles[i]).run((Cat) participants[i], random.nextInt(600));
            }
            if (obstacles[i].getClass() == Treadmill.class && participants[i].getClass() == Robot.class) {
                ((Treadmill) obstacles[i]).run((Robot) participants[i], random.nextInt(2500));
            }

            if (obstacles[i].getClass() == Wall.class && participants[i].getClass() == Human.class) {
                ((Wall) obstacles[i]).jump((Human) participants[i], random.nextInt(15));
            }
            if (obstacles[i].getClass() == Wall.class && participants[i].getClass() == Cat.class) {
                ((Wall) obstacles[i]).jump((Cat) participants[i], random.nextInt(40));
            }
            if (obstacles[i].getClass() == Wall.class && participants[i].getClass() == Robot.class) {
                ((Wall) obstacles[i]).jump((Robot) participants[i], random.nextInt(1200));
            }
        }

    }


    static class Treadmill {
        private int length;

        public Treadmill(int length) {
            this.length = length;
        }

        void run(Human x, int dist) {
            if (x.maxRun <= length) x.run(dist);
            else System.out.println(x.name + " Не смог пробежать");
        }

        void run(Cat x, int dist) {
            if (x.maxRun <= length) x.run(dist);
            else System.out.println(x.name + " Не смог пробежать");
        }

        void run(Robot x, int dist) {
            if (x.maxRun <= length) x.run(dist);
            else System.out.println(x.id + " Не смог пробежать");
        }

    }

    static class Wall {
        private int height;

        public Wall(int height) {
            this.height = height;
        }

        void jump(Human x, int dist) {
            if (x.maxJump <= height) x.jump(dist);
            else System.out.println("Человек " + x.name + " не смог перепрыгнуть");
        }

        void jump(Cat x, int dist) {
            if (x.maxJump <= height) x.jump(dist);
            else System.out.println("Кот " + x.name + " не смог перепрыгнуть");
        }

        void jump(Robot x, int dist) {
            if (x.maxJump <= height) x.jump(dist);
            else System.out.println("Робот " + x.id + " не смог перепрыгнуть");
        }
    }

    interface Runnable {
        void run(int dist);

        void jump(int dist);

    }

    static class Human implements Runnable {
        protected String name;
        protected int maxRun;
        protected int maxJump;


        public Human(String name, int maxRun, int maxJump) {
            this.name = name;
            this.maxRun = maxRun;
            this.maxJump = maxJump;
        }

        public void run(int dist) {
            if (maxRun <= dist) System.out.printf("Человек %s пробежал\n", name);
        }

        public void jump(int dist) {
            if (maxJump <= dist) System.out.printf("Человек %s прыгнул \n", name);
        }
    }

    static class Cat implements Runnable {
        protected String name;
        protected int maxRun;
        protected int maxJump;

        public Cat(String name, int maxRun, int maxJump) {
            this.name = name;
            this.maxRun = maxRun;
            this.maxJump = maxJump;
        }

        public void run(int dist) {
            if (maxRun <= dist) System.out.printf("Кот %s пробежал\n", name);
        }

        public void jump(int dist) {
            if (maxJump <= dist) System.out.printf("Кот %s прыгнул \n", name);
        }

    }

    static class Robot implements Runnable {
        protected String id;
        protected int maxRun;
        protected int maxJump;

        public Robot(String id, int maxRun, int maxJump) {
            this.id = id;
            this.maxRun = maxRun;
            this.maxJump = maxJump;
        }

        public void run(int dist) {
            if (maxRun < dist) System.out.printf("Робот %s пробежал\n", id);
        }

        public void jump(int dist) {
            if (maxJump < dist) System.out.printf("Робот %s прыгнул \n", id);
        }

    }
}