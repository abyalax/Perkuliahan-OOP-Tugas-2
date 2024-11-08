package data;
import java.util.ArrayList;

/**
 * Student
 */
public class Student extends Person {
    private String npm;
    private ArrayList<Grades> grades;
    private ArrayList<Course> courses;

    public Student(String name, String npm) {
        super(name, "");
        this.npm = npm;
        this.grades = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public Float getGPA() {
        Float gpa = 0f;
        Integer sks = 0;
        for (Grades grade : grades) {
            gpa += grade.getGrade() * grade.getCourse().getSKS();
            sks += grade.getCourse().getSKS();
        }
        return Math.round((gpa / sks) * 100) / 100f;
    }

    private String getCourseStudent() {
        String courseStudent = "";
        for (Course course : this.courses) {
            courseStudent += course.getCourseName() + "\n - ";
        }
        return courseStudent;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address);
    }

    public ArrayList<Grades> getGrades() {
        return grades;
    }

    public String getNpm() {
        return npm;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public void addGrade(Course course, Float grade) {
        this.courses.add(course);
        this.grades.add(new Grades(course, grade));
    }

    @Override
    public String toString() {
        return String.format("""
                Name    : %s
                NPM     : %s
                GPA     : %.2f
                Courses : 
                 - %s
                """, super.getName(), npm, getGPA(), getCourseStudent());
    }
}