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
        String sql = "SELECT assignment_id, curriculum.curriculum_id, student_id, submission_date, status, grade, " +
                " users.username, curriculum.curriculum_name " +
                " FROM assignment " +
                " JOIN users ON assignment.student_id = users.user_id " +
                " JOIN curriculum ON curriculum.curriculum_id = assignment.curriculum_id " +
                " ; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Assignment assignment = mapRowToAssignment(results);
            allAssignments.add(assignment);
        }
        return allAssignments;
    }

    @Override
    public List<Assignment> getAssignmentsByStudent(String studentId) {
        List<Assignment> oneAssignments = new ArrayList<>();
        Integer id = Integer.parseInt(studentId);
        String sql = "SELECT assignment_id, curriculum.curriculum_id, student_id, submission_date, status, grade, " +
                " users.username, curriculum.curriculum_name " +
                " FROM assignment " +
                " JOIN users ON assignment.student_id = users.user_id " +
                " JOIN curriculum ON curriculum.curriculum_id = assignment.curriculum_id " +
                " WHERE student_id = ?; ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while(results.next()) {
            Assignment assignment = mapRowToAssignment(results);
            oneAssignments.add(assignment);
        }
        return oneAssignments;

    }

    @Override
    public Assignment getOneAssignment(String assignmentId) {
        Integer id = Integer.parseInt(assignmentId);
        String sql = "SELECT assignment_id, curriculum.curriculum_id, student_id, submission_date, status, grade, " +
                " users.username, curriculum.curriculum_name " +
                " FROM assignment " +
                " JOIN users ON assignment.student_id = users.user_id " +
                " JOIN curriculum ON curriculum.curriculum_id = assignment.curriculum_id " +
            " WHERE assignment_id = ? ;";
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
    if (results.next()){
        return mapRowToAssignment(results);
    } else {
        return null;
    }
    }

    @Override
    public Assignment createAssignment(Assignment assignment) {
        String sql = "INSERT INTO assignment (assignment_id, curriculum_id, student_id, submission_date, status, grade) " +
                " VALUES (?, ?, ?, ?, ?, ?) " +
                " RETURNING assignment_id";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                assignment.getAssignmentId(), assignment.getCurriculumId(),
                assignment.getStudentId(), assignment.getSubmittedDate(), assignment.isSubmitted());
        String stringId = Integer.toString(newId);
        return getOneAssignment(stringId);
    }

//    @Override
//    public Assignment createAssignments(Assignment assignment) {
//        List<Assignment> students = new ArrayList<>();
//        String getStudent = "select student_id \n" +
//                "from student_class\n" +
//                "JOIN course \n" +
//                "ON student_class.course_id = course.course_id\n" +
//                "JOIN curriculum \n" +
//                "ON curriculum.course_id = course.course_id\n" +
//                "where curriculum_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(getStudent);
//        while( results.next()){
//            Assignment assignment1 = mapRowToAssignment
//            students.add(results);
//        }
//
//        for (student in students){
//
//        String sql = "INSERT INTO assignment (assignment_id, curriculum_id, student_id, submission_date, status) " +
//                " VALUES (?, ?, ?, ?, ?) " +
//                " RETURNING assignment_id";
//        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
//                assignment.getAssignmentId(), assignment.getCurriculumId(),
//                student, assignment.getSubmittedDate(), assignment.isSubmitted());
//        return getOneAssignment(newId);
//    }

    @Override
    public void editAssignment(Assignment assignment, String assignmentId) {

        String sql = "UPDATE assignment " +
                "SET assignment_id = ?, curriculum_id = ?, student_id = ?, submission_date = ?, status = ?, grade = ? " +
                "WHERE assignment_id = ?";
        jdbcTemplate.update(sql, assignment.getAssignmentId(),
                assignment.getCurriculumId(), assignment.getStudentId(),
                assignment.getSubmittedDate(), assignment.isSubmitted(), assignment.getGrade(), assignmentId);
    }

    private Assignment mapRowToAssignment(SqlRowSet results){
        Assignment assignment = new Assignment();
        assignment.setAssignmentId(results.getInt("assignment_id"));
        assignment.setCurriculumId(results.getString("curriculum_id"));
        assignment.setStudentId(results.getInt("student_id"));
        assignment.setSubmittedDate(results.getDate("submission_date"));
        assignment.setSubmitted(results.getBoolean("status"));
        assignment.setStudentName(results.getString("username"));
        assignment.setCurriculumName(results.getString("curriculum_name"));
        assignment.setGrade(results.getInt("grade"));


        return assignment;
    }
}
