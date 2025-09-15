package org.example;

public class Student {

    private int studentId;
    private String studName;
    private int studRollNumber;

    public Student(String studName, int studRollNumber) {
        this.studName = studName;
        this.studRollNumber = studRollNumber;
    }

    // Getters and Setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getStudName() { return studName; }
    public void setStudName(String studName) { this.studName = studName; }

    public int getStudRollNumber() { return studRollNumber; }
    public void setStudRollNumber(int studRollNumber) { this.studRollNumber = studRollNumber; }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studName='" + studName + '\'' +
                ", studRollNumber=" + studRollNumber +
                '}';
    }
}
