import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student s1 = new Student(1, "1", "1", 1.0);
        Student s2 = new Student(2, "2", "2", 2.0);
        Student s3 = new Student(3, "3", "3", 3.0);
        Student s4 = new Student(4, "4", "4", 4.0);
        Student s5 = new Student(5, "5", "5", 5.0);

        students.add(s3);
        students.add(s5);
        students.add(s2);
        students.add(s4);
        students.add(s1);

        Collections.sort(students);

        for (Student s : students) {
            System.out.println(s.toString());
        }

        PriorityQueue<Student> prioStudents = new PriorityQueue<>();
        prioStudents.addAll(students);

        HashMap<Student, LinkedList<String>> studentSubjects = new HashMap<>();

        LinkedList<String> subjects1 = new LinkedList<>();
        LinkedList<String> subjects2 = new LinkedList<>();
        LinkedList<String> subjects3 = new LinkedList<>();
        LinkedList<String> subjects4 = new LinkedList<>();
        LinkedList<String> subjects5 = new LinkedList<>();

        subjects1.add("Data Structures");
        subjects2.add("Numerical Methods");
        subjects3.add("Systems Theory");
        subjects4.add("Programming");
        subjects5.add("Algorithms");


        studentSubjects.put(s1, subjects1);
        studentSubjects.put(s2, subjects2);
        studentSubjects.put(s3, subjects3);
        studentSubjects.put(s4, subjects4);
        studentSubjects.put(s5, subjects5);

        System.out.println();

        for (Student s : studentSubjects.keySet()) {
            System.out.println(studentSubjects.get(s).get(0));
        }

        EvenNumbersList<Integer> list = new EvenNumbersList<>();

        Iterator<Integer> iterator = list.iterator();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
