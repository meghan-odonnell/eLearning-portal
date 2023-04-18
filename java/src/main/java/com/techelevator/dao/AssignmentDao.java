package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Assignment;

import java.util.List;

public interface AssignmentDao {

    List<Assignment> getAllAssignments();

    List<Assignment> getAssignmentsByStudent(String studentId);

    Assignment getOneAssignment (String assignmentId);

    List<Assignment> createAssignment (Assignment assignment, String curriculumId);

    void editAssignment (Assignment assignment, String assignmentId);

    List<Integer> getStudentsInClass(String curriculumId);
//
//    Assignment createAssignments(Assignment assignment);

//    List<Assignment> getStudentsByCourse(String curriculumId);
}
