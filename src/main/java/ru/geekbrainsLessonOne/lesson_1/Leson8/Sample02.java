package ru.geekbrainsLessonOne.lesson_1.Leson8;

public class Sample02 {
    public static void main(String[] args) {

    }

    static void processStudents(String[] students){
        Students[] stud = new Students[100];
        for (int i=0; i<stud.length;i++){
            stud[i] = new Students(0);
        }

        for(int i=0; i<students.length;i++){
            String[] words = students[i].split(" ");
        }
    }
}




class Students {
    StringBuilder names;
    float rating;

    public Students( float rating) {
        this.rating = rating;
    }


}
