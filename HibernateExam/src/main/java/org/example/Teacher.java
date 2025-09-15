package org.example;

public class Teacher {

    private int teacherId;
    private String teacherName;
    private String teacherQualification;
    private String experienceOfTeaching;

    public Teacher(String teacherName, String teacherQualification, String experienceOfTeaching) {
        this.teacherName = teacherName;
        this.teacherQualification = teacherQualification;
        this.experienceOfTeaching = experienceOfTeaching;
    }

    // Getters and Setters
    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }

    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    public String getTeacherQualification() { return teacherQualification; }
    public void setTeacherQualification(String teacherQualification) { this.teacherQualification = teacherQualification; }

    public String getExperienceOfTeaching() { return experienceOfTeaching; }
    public void setExperienceOfTeaching(String experienceOfTeaching) { this.experienceOfTeaching = experienceOfTeaching; }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherQualification='" + teacherQualification + '\'' +
                ", experienceOfTeaching='" + experienceOfTeaching + '\'' +
                '}';
    }
}
