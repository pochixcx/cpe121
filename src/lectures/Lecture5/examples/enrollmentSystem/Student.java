package lectures.Lecture5.examples.enrollmentSystem;

class Student {
    private String name;
    private Course enrolledCourse;

    public Student(String name) {
        this.name = name;
    }

    public void enroll(Course course) {
        this.enrolledCourse = course;
        System.out.println(name + " enrolled in " + course.getDescription());
    }
}
