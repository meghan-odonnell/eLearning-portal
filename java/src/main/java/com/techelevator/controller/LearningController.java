package com.techelevator.controller;


import com.techelevator.dao.CourseDao;
import com.techelevator.model.Course;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LearningController {

    private CourseDao courseDao;

    public LearningController(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path="/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(){

        return courseDao.showAllCourses();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/myCourses", method = RequestMethod.GET)
    public List<Course> showMyCourses(@RequestParam int id) {
        return courseDao.showMyCourses(id);
    }

    //** TO DO: Teacher Create a course
    //** TO DO: Teacher create curriculum
    //** TO DO: Student sign up for a course
    //** TO DO:

}
