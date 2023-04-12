package com.techelevator.dao;

import com.techelevator.model.Assignment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcAssignmentDao implements AssignmentDao{

    public JdbcAssignmentDao() {
    }

    @Override
    public List<Assignment> getAllAssignments() {
        return null;
    }

    @Override
    public List<Assignment> getAssignmentsByStudent(int studentId) {
        return null;
    }

    @Override
    public Assignment getOneAssignment(int assignmentId) {
        return null;
    }

    @Override
    public Assignment createAssignment() {
        return null;
    }

    @Override
    public Assignment editAssignment(int assignmentId) {
        return null;
    }
}
