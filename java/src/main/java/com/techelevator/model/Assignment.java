package com.techelevator.model;

import java.util.Date;
import java.util.List;

public class Assignment {

    private int assignmentId;
    private String curriculumId;
    private int studentId;
    private Date submittedDate;
    private boolean isSubmitted;

    public Assignment() {
    }

    public Assignment(int assignmentId, String curriculumId, int studentId, Date submittedDate, boolean isSubmitted) {
        this.assignmentId = assignmentId;
        this.curriculumId = curriculumId;
        this.studentId = studentId;
        this.submittedDate = submittedDate;
        this.isSubmitted = isSubmitted;
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
