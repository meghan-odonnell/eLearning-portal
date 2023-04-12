package com.techelevator.model;

public class Curriculum {

    private String curriculumId;
    private String curriculumName;
    private String courseId;
    private String reading;
    private String homework;
    private String resources;

    public Curriculum() {
    }

    public Curriculum(String curriculumId, String curriculumName, String courseId, String reading, String homework, String resources) {
        this.curriculumId = curriculumId;
        this.curriculumName = curriculumName;
        this.courseId = courseId;
        this.reading = reading;
        this.homework = homework;
        this.resources = resources;
    }

    public String getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(String curriculumId) {
        this.curriculumId = curriculumId;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }
}
