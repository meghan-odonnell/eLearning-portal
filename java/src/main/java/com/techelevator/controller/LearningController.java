package com.techelevator.controller;


import com.techelevator.dao.AssignmentDao;
import com.techelevator.dao.CourseDao;

import com.techelevator.dao.CurriculumDao;
import com.techelevator.model.Assignment;
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
    private AssignmentDao assignmentDao;


    public LearningController(CourseDao courseDao, CurriculumDao curriculumDao, AssignmentDao assignmentDao) {

        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.assignmentDao = assignmentDao;
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

    @RequestMapping(path = "/course/{courseId}", method = RequestMethod.GET)
    public Course showCourse(@PathVariable String courseId){
        return courseDao.showOneCourse(courseId);
    }

    @RequestMapping(path = "/course", method = RequestMethod.POST)
    public Course createCourse(@RequestBody Course course){
        return courseDao.createCourse(course);
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
    public void createCurriculum(@RequestBody Curriculum curriculum){
        curriculumDao.createCurriculum(curriculum);
    }

    @RequestMapping(path = "/curriculum/{curriculumId}", method = RequestMethod.PUT)
    public void updateCurriculum(@PathVariable String curriculumId, @RequestBody Curriculum curriculum) {
        curriculumDao.editCurriculum(curriculum, curriculumId);
    }

    @RequestMapping(path = "/assignment", method = RequestMethod.GET)
    public List<Assignment> getAllAssignments() {

        return assignmentDao.getAllAssignments();
    }

    @RequestMapping(path = "/studentAssignments/{studentId}", method = RequestMethod.GET)
    public List<Assignment> getAssignmentsByStudent(@PathVariable int studentId){
        return assignmentDao.getAssignmentsByStudent(studentId);
    }

    @RequestMapping(path = "/assignment/{assignmentId}", method = RequestMethod.GET)
    public Assignment getOneAssignment(@PathVariable int assignmentId){
        return assignmentDao.getOneAssignment(assignmentId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/assignment", method = RequestMethod.POST)
    public void createAssignment(@RequestBody Assignment assignment){

        assignmentDao.createAssignment(assignment);
    }

    @RequestMapping(path = "/assignment/{assignmentId}", method = RequestMethod.PUT)
    public void editAssignment(@PathVariable int assignmentId, @RequestBody Assignment assignment){
        assignmentDao.editAssignment(assignment, assignmentId);
    }

}

