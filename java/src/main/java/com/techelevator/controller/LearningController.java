package com.techelevator.controller;


import com.techelevator.dao.CourseDao;
import com.techelevator.model.Course;
import org.springframework.security.access.prepost.PreAuthorize;
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


 //   @PreAuthorize("hasAnyRole('USER')")
    @PreAuthorize("permitAll")
    @RequestMapping(path="/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(){
        return courseDao.showAllCourses();
    }

}
