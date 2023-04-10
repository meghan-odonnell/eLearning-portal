package com.techelevator.controller;


import com.techelevator.dao.CourseDao;
import com.techelevator.model.Course;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class LearningController {

    private CourseDao courseDao;

    public LearningController(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @RequestMapping(value="/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(){
        return courseDao.showAllCourses();
    }

}
