package com.techelevator.dao;

import com.techelevator.model.Assignment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
        String sql = "SELECT assignment_id, curriculum.curriculum_id, student_id, submission_date, status, grade, answer, " +
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
        String sql = "SELECT assignment_id, curriculum.curriculum_id, student_id, submission_date, status, grade, answer," +
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
        String sql = "SELECT assignment_id, curriculum.curriculum_id, student_id, submission_date, status, grade, answer, " +
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
    public List <Assignment> createAssignment(Assignment assignment) {
        List<Integer> students = getStudentsInClass(assignment.getCurriculumId());
        List<Assignment> newAssignments = new ArrayList<>();

        String sql = "INSERT INTO assignment (curriculum_id, student_id) " +
                " VALUES (?, ?) " +
                " RETURNING assignment_id";

        for (Integer student : students) {
            Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                    assignment.getCurriculumId(),student);

            String stringId = Integer.toString(newId);
            newAssignments.add(getOneAssignment(stringId));
        }
        return newAssignments;
    }


    @Override
    public List<Integer> getStudentsInClass(String curriculumId) {
        List<Integer> students = new ArrayList<>();
        Integer id;
        String getStudent = "select student_id " +
                " from student_class " +
                " JOIN course " +
                " ON student_class.course_id = course.course_id " +
                " JOIN curriculum " +
                " ON curriculum.course_id = course.course_id " +
                " where curriculum_id = ? ;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(getStudent, curriculumId);
        while (results.next()) {
            id = results.getInt("student_id");
            students.add(id);
        }
        return students;
    }


//    @Override
//    public Assignment createAssignment(Assignment assignment) {
//        String sql = "INSERT INTO assignment (assignment_id, curriculum_id, student_id, submission_date, status, grade) " +
//                " VALUES (?, ?, ?, ?, ?, ?) " +
//                " RETURNING assignment_id";
//        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
//                assignment.getAssignmentId(), assignment.getCurriculumId(),
//                assignment.getStudentId(), assignment.getSubmittedDate(), assignment.isSubmitted(), assignment.getGrade());
//        String stringId = Integer.toString(newId);
//        return getOneAssignment(stringId);
//    }


//
//    @Override
//    public List<Integer> getStudentsInClass() {
//        List<Integer> students = new ArrayList<>();
//        Integer id;
//        String getStudent = "select student_id \n" +
//                "from student_class\n" +
//                "JOIN course \n" +
//                "ON student_class.course_id = course.course_id\n" +
//                "JOIN curriculum \n" +
//                "ON curriculum.course_id = course.course_id\n" +
//                "where curriculum_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(getStudent);
//        while (results.next()) {
//            id = results.getInt("student_id");
//            students.add(id);
//        }
//        return students;
//    }
    @Override
    public Integer queryForAssignmentId(String studentId, String curriculumId){
        Integer studentIntId = Integer.parseInt(studentId);
        String sql = "SELECT assignment_id FROM assignment WHERE student_id = ? AND curriculum_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, studentIntId, curriculumId);
        if (results.next()){
            return results.getInt("assignment_id");
        } else {
            return null;
        }
    }
    @Override
    public void submitAssignment(Assignment assignment,String studentId, String curriculumId) {
//        Integer id = Integer.parseInt(assignmentId);
        Integer assignmentId = queryForAssignmentId(studentId,curriculumId);
        String sql = "UPDATE assignment " +
                "SET assignment_id = ?, curriculum_id = ?, student_id = ?, submission_date = ?, status = ?, grade = ? , answer = ? " +
                "WHERE assignment_id = ?";
        jdbcTemplate.update(sql,
                assignmentId,
                assignment.getCurriculumId(),
                assignment.getStudentId(),
                LocalDate.now(),
                true,
                assignment.getGrade(),
                assignment.getAnswer(),
                assignmentId );
    }


    @Override
    public void gradeAssignment(Assignment assignment, String assignmentId) {
        Integer id = Integer.parseInt(assignmentId);
        String sql = "UPDATE assignment " +
                "SET assignment_id = ?, curriculum_id = ?, student_id = ?, status = ?, grade = ? " +
                "WHERE assignment_id = ?";
        jdbcTemplate.update(sql, id,
                assignment.getCurriculumId(), assignment.getStudentId(),
                assignment.isSubmitted(), assignment.getGrade(), id);
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
        assignment.setAnswer(results.getString("answer"));


        return assignment;
    }
}
