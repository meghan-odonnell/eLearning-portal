package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Assignment;

import java.util.List;

public interface AssignmentDao {

    List<Assignment> getAllAssignments();

    List<Assignment> getAssignmentsByStudent(String studentId);

    Assignment getOneAssignment (int assignmentId);

    Assignment createAssignment (Assignment assignment);

    void editAssignment (Assignment assignment, int assignmentId);
//
//    Assignment createAssignments(Assignment assignment);

//    List<Assignment> getStudentsByCourse(String curriculumId);
}
