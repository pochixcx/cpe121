package lectures.Lecture5.examples.enrollmentSystem;

class Course {
    private String code;
    private String title;

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getDescription() {
        return code + " - " + title;
    }
}
