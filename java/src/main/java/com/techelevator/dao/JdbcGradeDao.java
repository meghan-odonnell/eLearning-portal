package com.techelevator.dao;

import com.techelevator.model.Assignment;
import com.techelevator.model.Grade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcGradeDao implements GradeDao{

 private final JdbcTemplate jdbcTemplate;
    public JdbcGradeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Grade getGrade(int gradeId) {
        String sql = "SELECT grade_id, assignment_id, student_id, grade\n" +
                "FROM grade\n" +
                "WHERE grade_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, gradeId);
        if(results.next()) {
            return mapRowToGrade(results);
        } else {
            return null;
        }
    }

    @Override
    public void editGrade(int gradeId, Grade grade) {
    String sql = "UPDATE grade\n" +
            "SET grade_id = ?, assignment_id = ?, student_id, grade\n" +
            "WHERE grade_id = ?;";
    jdbcTemplate.update(sql, grade.getGradeId(), grade.getAssignmentId(),
            grade.getStudentId(), grade.getGrade());

    }



    private Grade mapRowToGrade(SqlRowSet results){
        Grade grade = new Grade();
        grade.setGradeId(results.getInt("grade_id"));
        grade.setAssignmentId(results.getInt("assignment_id"));
        grade.setStudentId(results.getInt("student_id"));
        grade.setGrade(results.getString("grade"));
        return grade;
    }

}

