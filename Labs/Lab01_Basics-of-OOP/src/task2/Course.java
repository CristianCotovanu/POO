package task2;

import java.util.ArrayList;

public class Course {
    private String title;
    private String description;
    private ArrayList<Student> students;

    public Course() {
        students = new ArrayList<Student>();
    }

    ArrayList<Student> filterYear(Integer year) {
        ArrayList<Student> studentsList = new ArrayList<Student>();

        for(Student s : students) {
            if (s.getYear().equals(year)) {
                studentsList.add(s);
            }
        }
        return studentsList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Student> getStudents() {
        return  students;
    }

}
