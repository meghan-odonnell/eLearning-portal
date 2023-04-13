package com.techelevator.dao;

import com.techelevator.model.Curriculum;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCurriculumDao implements CurriculumDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCurriculumDao(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Curriculum> showAllCurriculum(){
        List<Curriculum> allCurriculum = new ArrayList<>();
        String sql = "SELECT curriculum_id, curriculum_name, course_id, reading, homework, resources" +
                " FROM curriculum";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Curriculum curriculum = mapRowToCurriculum(results);
            allCurriculum.add(curriculum);
        }
        return allCurriculum;
    }

        @Override
    public List<Curriculum> showCourseCurriculum (String courseId) {
        List<Curriculum> courseCurr = new ArrayList<>();
        String sql = "(SELECT curriculum_id, curriculum_name, course_id, reading, homework, resources" +
                " FROM curriculum WHERE course_id= ? )";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        while(results.next()) {
            Curriculum curriculum = mapRowToCurriculum(results);
            courseCurr.add(curriculum);
        }
        return courseCurr;
    };


    //TODO Finish Curriculum methods


    @Override
    public Curriculum showSingleCurriculum (String curriculumId) {
      String sql = " SELECT curriculum_id, curriculum_name, course_id, reading, homework, resources " +
                   " FROM curriculum WHERE curriculum_id= ? ";
      SqlRowSet results = jdbcTemplate.queryForRowSet(sql, curriculumId);
      if (results.next()) {
          return mapRowToCurriculum(results);
      } else {
          return null;
      }
    }


    // FOR createCurriculum method below:
    // may need to do something with course_id as the error I get for
    // this is that the courseId isnt in the course table
    @Override
    public Curriculum createCurriculum (Curriculum curriculum) {
        String sql = "INSERT INTO curriculum (curriculum_id, curriculum_name, course_id, reading, homework, resources) " +
                " VALUES (?, ?, ?, ?, ?, ?) " ;
        String newId = jdbcTemplate.queryForObject(sql, String.class, curriculum.getCurriculumId(),
                curriculum.getCurriculumName(),curriculum.getCourseId(),
                curriculum.getReading(), curriculum.getHomework(), curriculum.getResources());
        return showSingleCurriculum(newId);
    }

//    START TRANSACTION;
//
//    INSERT INTO curriculum (curriculum_id, curriculum_name, course_id, reading, homework, resources)
//    VALUES ('S4C4', 'Chapter 4', 'M2', 'this is words', 'no', 'links');
//
//
//    INSERT INTO curriculum
//    SELECT curriculum_id, curriculum_name, course_id, reading, homework, resources
//    FROM course
//    LEFT JOIN curriculum
//    ON course.course_id = curriculum.curriculum_id ;
//
//    COMMIT TRANSACTION;

    @Override
    public Curriculum editCurriculum (String curriculumId){
        return null;
    }


    private Curriculum mapRowToCurriculum(SqlRowSet results){
        Curriculum curriculum = new Curriculum();
        curriculum.setCurriculumId(results.getString("curriculum_id"));
        curriculum.setCourseId(results.getString("course_id"));
        curriculum.setCurriculumName(results.getString("curriculum_name"));
        curriculum.setHomework(results.getString("homework"));
        curriculum.setReading(results.getString("reading"));
        curriculum.setResources(results.getString("resources"));
        return curriculum;
    }

}
