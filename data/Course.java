package data;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private Integer sks;
    private List<Student> studentList;

    public Course(String courseName, String courseCode, Integer sks) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.sks = sks;
        this.studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        for (Student s : studentList) {
            if (s.getNpm().equals(student.getNpm())) {
                throw new DuplicateFormatFlagsException( "\n" + s.getName() + " has the same npm as the others : " + student.getNpm());
            }
        }
        studentList.add(student);
    }

    public String getNameStudentList() {
        String name = "";
        for (Student student : studentList) {
            name += student.getName() + "\n - ";
        }
        return name;
    }

    public Float calculateAverageGrade() {
        Float averageGPA = 0f;
        for (Student student : studentList) {
            averageGPA += student.getGPA();
        }
        return averageGPA / studentList.size();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Integer getSKS() {
        return sks;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        return String.format("""
                Course Name  : %s
                Course Code  : %s
                Total SKS    : %d
                List Student : 
                 - %s
                """, courseName, courseCode, sks, getNameStudentList());
    }
}
