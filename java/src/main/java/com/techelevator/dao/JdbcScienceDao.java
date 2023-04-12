package com.techelevator.dao;

import com.techelevator.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcScienceDao implements ScienceDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcScienceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Course> showAllScienceCourses() {
        List<Course> scienceCourses = new ArrayList<>();
        String sql = "SELECT curriculum_id, curriculum_name, course_id, reading " +
                " FROM curriculum " +
                " WHERE curriculum_id IN ('S2C1', 'S2C2', 'S2C3');";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Course scienceCourse = mapRowToUser(results);
            scienceCourses.add(scienceCourse);
        }
        return scienceCourses;
    }


    private Course mapRowToUser(SqlRowSet results) {
        Course scienceCourse = new Course();
        scienceCourse.setCourseId(results.getString("course_id"));
        scienceCourse.setCourseName(results.getString("course_name"));
        scienceCourse.setCourseDescription(results.getString("course_description"));
        scienceCourse.setDifficulty(results.getString("difficulty"));
        scienceCourse.setCost(results.getInt("cost"));
        return scienceCourse;
    }
}
