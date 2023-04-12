package com.techelevator.dao;

import com.techelevator.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcCourseDao implements CourseDao {

        private final JdbcTemplate jdbcTemplate;

        public JdbcCourseDao(JdbcTemplate jdbcTemplate) {

            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        public List<Course> showAllCourses(){
            List<Course> courses = new ArrayList<>();
            String sql = "SELECT course_id, course_name, course_description, difficulty, cost FROM course";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Course course = mapRowToUser(results);
                courses.add(course);
            }
                return courses;
        }
    @Override
    public List<Course> showAllScienceCourses() {
        List<Course> scienceCourses = new ArrayList<>();
        String sql = "SELECT curriculum_id, curriculum_name, course_id, reading\n" +
                "FROM curriculum";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Course scienceCourse = mapRowToUser(results);
            scienceCourses.add(scienceCourse);
        }
        return scienceCourses;
    }

    @Override
    public List<Course> showMyCourses(int id) {
            //select courses from courses table where id=?. join the student table

        return null;
    }

    private Course mapRowToUser(SqlRowSet results) {
            Course course = new Course();
            course.setCourseId(results.getString("course_id"));
            course.setCourseName(results.getString("course_name"));
            course.setCourseDescription(results.getString("course_description"));
            course.setDifficulty(results.getString("difficulty"));
            course.setCost(results.getInt("cost"));
            return course;
    }


}
