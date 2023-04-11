package com.techelevator.dao;

import com.techelevator.model.Course;

import java.util.List;

public interface CourseDao {

    List<Course> showAllCourses();

    List<Course> showMyCourses(int id);

}
