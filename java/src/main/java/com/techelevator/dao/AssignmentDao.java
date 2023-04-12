package com.techelevator.dao;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.techelevator.model.Assignment;

import java.util.List;

public interface AssignmentDao {

    List<Assignment> getAllAssignments();

    List<Assignment> getAssignmentsByStudent(int studentId);

    Assignment getOneAssignment (int assignmentId);

    Assignment createAssignment ();

    Assignment editAssignment (int assignmentId);
}
