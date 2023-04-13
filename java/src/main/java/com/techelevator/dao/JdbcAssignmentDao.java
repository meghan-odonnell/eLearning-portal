package com.techelevator.dao;

import com.techelevator.model.Assignment;
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
    String sql = "SELECT assignment_id, curriculum_id, student_id, submission_date, status " +
            " FROM assignment " +
            " WHERE assignment_id = ? ;";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql, assignmentId);
    if (results.next()){
        return mapRowToAssignment(results);
    } else {
        return null;
    }
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        String sql = "INSERT INTO assignment (assignment_id, curriculum_id, student_id, submission_date, status) " +
                " VALUES (?, ?, ?, ?, ?) " +
                " RETURNING assignment_id";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                assignment.getAssignmentId(), assignment.getCurriculumId(),
                assignment.getStudentId(), assignment.getSubmittedDate(), assignment.isSubmitted());
        return getOneAssignment(newId);
    }

    @Override
    public void editAssignment(Assignment assignment, int assignmentId) {
        String sql = "UPDATE assignment " +
                "SET assignment_id = ?, curriculum_id = ?, student_id = ?, submission_date = ?, status = ? " +
                "WHERE assignment_id = ?";
        jdbcTemplate.update(sql, assignment.getAssignmentId(),
                assignment.getCurriculumId(), assignment.getStudentId(),
                assignment.getSubmittedDate(), assignment.isSubmitted(), assignmentId);
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
