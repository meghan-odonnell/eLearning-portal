package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Assignment;

import java.util.List;

public interface AssignmentDao {

    List<Assignment> getAllAssignments();

    List<Assignment> getAssignmentsByStudent(String studentId);

    Assignment getOneAssignment(String assignmentId);

    List<Integer> getStudentsInClass(String curriculumId);

    List<Assignment> createAssignment(Assignment assignment);

    Integer queryForAssignmentId(String studentId, String curriculumId);

    void editAssignment(Assignment assignment, String studentId, String curriculumId);

}

