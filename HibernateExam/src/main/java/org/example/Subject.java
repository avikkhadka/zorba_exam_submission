package org.example;

public class Subject {

    private int subjectId;
    private String subName;

    // No-arg constructor
    public Subject() {}

    // Constructor without ID
    public Subject(String subName) {
        this.subName = subName;
    }

    // Getters and Setters
    public int getSubjectId() { return subjectId; }
    public void setSubjectId(int subjectId) { this.subjectId = subjectId; }

    public String getSubName() { return subName; }
    public void setSubName(String subName) { this.subName = subName; }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subName='" + subName + '\'' +
                '}';
    }
}
