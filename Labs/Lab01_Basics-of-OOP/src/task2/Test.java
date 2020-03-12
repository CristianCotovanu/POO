package task2;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();

        Course c = new Course();
        Student s1 = new Student("s1", 1);
        Student s2 = new Student("s2", 2);
        Student s3 = new Student("s3", 3);
        Student s4 = new Student("s4", 4);

        c.getStudents().add(s1);
        c.getStudents().add(s2);
        c.getStudents().add(s3);
        c.getStudents().add(s4);

        System.out.println(Arrays.toString(c.getStudents().toArray()));
    }
}