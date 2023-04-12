package com.techelevator.controller;


import com.techelevator.dao.CourseDao;

import com.techelevator.dao.CurriculumDao;
import com.techelevator.model.Course;
import com.techelevator.model.Curriculum;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class LearningController {

    private CourseDao courseDao;
    private CurriculumDao curriculumDao;


    public LearningController(CourseDao courseDao, CurriculumDao curriculumDao) {

        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
    }

//    @PreAuthorize("permitAll")
    @RequestMapping(path="/course", method = RequestMethod.GET)
    public List<Course> getAllCourses(){

        return courseDao.showAllCourses();
    }

//    @PreAuthorize("permitAll")
    @RequestMapping(path = "/myCourses", method = RequestMethod.GET)
    public List<Course> showMyCourses(@RequestParam int id) {

        return courseDao.showMyCourses(id);
    }


    @RequestMapping(path="/curriculum", method = RequestMethod.GET)
    public List<Curriculum> showAllCurriculum(){
        return curriculumDao.showAllCurriculum();
    }

    @RequestMapping(path="/courseCurriculum/{courseId}", method = RequestMethod.GET)
    public List<Curriculum> showCourseCurriculum(@PathVariable String courseId){
        return curriculumDao.showCourseCurriculum(courseId);
    }

    @RequestMapping(path = "/singleCurriculum/{curriculumId}", method = RequestMethod.GET)
    public Curriculum showSingleCurriculum(@PathVariable String curriculumId){
        return curriculumDao.showSingleCurriculum(curriculumId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/curriculum", method = RequestMethod.POST)
    public void createCurriculum(@Valid @RequestBody Curriculum curriculum){
        curriculumDao.createCurriculum(curriculum);
    }

    //** TO DO: Teacher Create a course
    //** TO DO: Teacher create curriculum
    //** TO DO: Student sign up for a course
    //** TO DO:


}

