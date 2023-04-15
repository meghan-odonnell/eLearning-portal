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
                Course course = mapRowToCourse(results);
                courses.add(course);
            }
                return courses;
        }


    @Override
    public List<Course> showMyCourses(int id) {
            //select courses from courses table where id=?. join the student table

        return null;
    }

    @Override
    public Course showOneCourse (String courseId) {
            String sql = "SELECT course_id, course_name, course_description, difficulty, cost " +
                    " from course WHERE course_id= ? ";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
            if (results.next()) {
                return mapRowToCourse(results);
            } else {
                return null;
            }
    }


    @Override
    public Course createCourse(Course course){
        String sql = "INSERT INTO course " +
                " (course_id, course_name, course_description, difficulty, cost) " +
                " VALUES (?, ?, ?, ?, ?) RETURNING course_id; ";
        String newId = jdbcTemplate.queryForObject(sql, String.class, course.getCourseId(),course.getCourseName(),
                course.getCourseDescription(), course.getDifficulty(), course.getCost());
        return showOneCourse(newId);
    }


    @Override
    public Course editCourse(String courseId, Course course) {
        return null;
    }

    @Override
    public Course deleteCourse(String courseId) {
            String sql =
        return null;
    }

    private Course mapRowToCourse(SqlRowSet results) {
            Course course = new Course();
            course.setCourseId(results.getString("course_id"));
            course.setCourseName(results.getString("course_name"));
            course.setCourseDescription(results.getString("course_description"));
            course.setDifficulty(results.getString("difficulty"));
            course.setCost(results.getInt("cost"));
            return course;
    }


}
