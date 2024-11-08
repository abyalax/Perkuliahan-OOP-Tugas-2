package data;
public class Grades {
    private Float grade;
    private Course course;

    public Grades(Course course, Float grade ) {
        this.grade = grade;
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
    
    public Float getGrade() {
        return grade;
    }
}
