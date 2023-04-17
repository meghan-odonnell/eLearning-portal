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
    public List<Course> showMyCourses(String studentId) {
            //select courses from courses table where id=?. join the student table
        Integer id = Integer.parseInt(studentId);
        List<Course> courses = new ArrayList<>();
       String sql = "SELECT course.course_id, course_name, course_description, user_id, username " +
               " FROM course " +
               " JOIN student_class ON student_class.course_id = course.course_id " +
               " JOIN users ON users.user_id = student_class.student_id " +
               " WHERE student_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            Course course = mapRowToStudentCourse(results);
            courses.add(course);
        }
        return courses;
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

        return null;
    }

    private Course mapRowToStudentCourse (SqlRowSet results){
            Course course = new Course();
            course.setCourseId(results.getString("course_id"));
            course.setCourseName(results.getString("course_name"));
            course.setCourseDescription(results.getString("course_description"));
            course.setStudentId(results.getInt("user_id"));
            course.setUsername(results.getString("username"));
            return course;
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
