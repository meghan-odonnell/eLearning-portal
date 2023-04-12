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
        String sql = "SELECT curriculum_id, curriculum_name, course_id, reading, homework, resources" +
                " FROM curriculum WHERE course_id=?";
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
      return null;
    }

    @Override
    public Curriculum createCurriculum () {
        return null;
    }

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
