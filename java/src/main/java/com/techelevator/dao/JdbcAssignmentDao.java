package com.techelevator.dao;

import com.techelevator.model.Assignment;
import com.techelevator.model.Curriculum;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAssignmentDao implements AssignmentDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAssignmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Assignment> getAllAssignments() {
        List<Assignment> allAssignments = new ArrayList<>();
        String sql = "SELECT assignment_id, curriculum_id, student_id, submission_date, status\n" +
                "FROM assignment;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Assignment assignment = mapRowToAssignment(results);
            allAssignments.add(assignment);
        }
        return allAssignments;
    }

    @Override
    public List<Assignment> getAssignmentsByStudent(int studentId) {
        List<Assignment> oneAssignments = new ArrayList<>();
        String sql = "SELECT assignment_id, curriculum_id, student_id, submission_date, status\n" +
                "FROM assignment\n" +
                "WHERE student_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, studentId);
        while(results.next()) {
            Assignment assignment = mapRowToAssignment(results);
            oneAssignments.add(assignment);
        }
        return oneAssignments;

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

    private Assignment mapRowToAssignment(SqlRowSet results){
        Assignment assignment = new Assignment();
        assignment.setAssignmentId(results.getInt("assignment_id"));
        assignment.setCurriculumId(results.getString("curriculum_id"));
        assignment.setStudentId(results.getInt("student_id"));
        assignment.setSubmittedDate(results.getDate("submission_date"));
        assignment.setSubmitted(results.getBoolean("status"));

        return assignment;
    }
}
