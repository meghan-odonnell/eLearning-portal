package com.techelevator.model;

import java.util.Date;
import java.util.List;

public class Assignment {

    private int assignmentId;
    private String curriculumId;
    private int studentId;
    private Date submittedDate;
    private boolean isSubmitted;
    private String studentName;
    private Integer grade;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private String answer;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    private String curriculumName;

    public Assignment() {
    }

    public Assignment(int assignmentId, String curriculumId, int studentId, Date submittedDate, boolean isSubmitted, String studentName, String curriculumName) {
        this.assignmentId = assignmentId;
        this.curriculumId = curriculumId;
        this.studentId = studentId;
        this.submittedDate = submittedDate;
        this.isSubmitted = isSubmitted;
        this.studentName = studentName;
        this.curriculumName = curriculumName;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Date getSubmittedDate() {

        return submittedDate;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

}
