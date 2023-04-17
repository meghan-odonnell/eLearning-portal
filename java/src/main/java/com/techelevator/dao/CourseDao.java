package com.techelevator.dao;

import com.techelevator.model.Course;

import java.util.List;

public interface CourseDao {

    List<Course> showAllCourses();

    List<Course> showMyCourses(String id);

    Course createCourse(Course course);

    Course showOneCourse (String courseId);

    Course editCourse (String courseId, Course course);

    Course deleteCourse (String courseId);
};
