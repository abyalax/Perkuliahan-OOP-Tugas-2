import data.Course;
import data.Student;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("You Are ready Bro!");

        Course pemrogramanOOP = new Course("Object Oriented Programming", "MKKPC13", 3);
        Course strukturData = new Course("Struktur Data", "MKKPC14", 2);
        Course pemrogramanWeb = new Course("Pemrograman Web", "MKKPC15", 3);
        Course statistikaData = new Course("Statistika Data", "MKKPC16", 3);

        Student reza = new Student("Reza Rahardi", "22347");
        Student memei = new Student("Memei Surti", "22348");
        Student galih = new Student("Galih Purnomo", "22349");

        reza.addGrade(pemrogramanOOP, 3.2f);
        memei.addGrade(pemrogramanOOP, 3.8f);
        galih.addGrade(pemrogramanOOP, 3.2f);
        pemrogramanOOP.addStudent(reza);
        pemrogramanOOP.addStudent(memei);
        pemrogramanOOP.addStudent(galih);
        pemrogramanOOP.addStudent(reza);

        reza.addGrade(strukturData, 3.1f);
        strukturData.addStudent(reza);

        reza.addGrade(statistikaData, 3.5f);
        memei.addGrade(statistikaData, 3.2f);
        statistikaData.addStudent(reza);
        statistikaData.addStudent(memei);

        reza.addGrade(pemrogramanWeb, 3.3f);
        pemrogramanWeb.addStudent(reza);

        System.out.println(pemrogramanOOP);
        System.out.println(reza);
        System.out.println(memei);

        System.out.println( "Rata-rata GPA Mata Kuliah Pemrograman OOP: " + pemrogramanOOP.calculateAverageGrade());
        System.out.println( "Rata-rata GPA Mata Kuliah Pemrograman Web: " + pemrogramanWeb.calculateAverageGrade());
    }
}