package model;

public class Student {
    private int id;
    private String name;
    private String subjects;
    private double score;

    public Student(int id, String name, String subjects, double score) {
        this.id = id;
        this.name = name;
        this.subjects = subjects;
        this.score = score;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
