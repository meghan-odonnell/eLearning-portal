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
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class LearningController {

    private final CourseDao courseDao;
    private final CurriculumDao curriculumDao;
    private final AssignmentDao assignmentDao;


    public LearningController(CourseDao courseDao, CurriculumDao curriculumDao, AssignmentDao assignmentDao) {

        this.courseDao = courseDao;
        this.curriculumDao = curriculumDao;
        this.assignmentDao = assignmentDao;
    }

    //    @PreAuthorize("permitAll")
    @RequestMapping(path = "/course", method = RequestMethod.GET)
    public List<Course> getAllCourses() {
        if (courseDao.showAllCourses() == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't get all courses.");
        } else {
            return courseDao.showAllCourses();
        }

    }

    //    @PreAuthorize("permitAll")
    @RequestMapping(path = "/myCourses/{id}", method = RequestMethod.GET)
    public List<Course> showMyCourses(@PathVariable String id) {
        if (courseDao.showMyCourses(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found.");
        } else {
            return courseDao.showMyCourses(id);
        }
    }

    @RequestMapping(path = "/course/{courseId}", method = RequestMethod.GET)
    public Course showCourse(@PathVariable String courseId) {
        if (courseDao.showOneCourse(courseId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found.");
        } else {
            return courseDao.showOneCourse(courseId);
        }
    }

    @RequestMapping(path = "/curriculum", method = RequestMethod.GET)
    public List<Curriculum> showAllCurriculum() {
        if (curriculumDao.showAllCurriculum() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't get all curriculums.");
        } else {
            return curriculumDao.showAllCurriculum();
        }
    }

    @RequestMapping(path = "/courseCurriculum/{courseId}", method = RequestMethod.GET)
    public List<Curriculum> showCourseCurriculum(@PathVariable String courseId) {
        if (curriculumDao.showCourseCurriculum(courseId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found.");
        } else {
            return curriculumDao.showCourseCurriculum(courseId);
        }
    }

    @RequestMapping(path = "/singleCurriculum/{curriculumId}", method = RequestMethod.GET)
    public Curriculum showSingleCurriculum(@PathVariable String curriculumId) {
        if (curriculumDao.showSingleCurriculum(curriculumId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curriculum not found.");
        } else {
            return curriculumDao.showSingleCurriculum(curriculumId);
        }
    }

    @RequestMapping(path = "/assignment", method = RequestMethod.GET)
    public List<Assignment> getAllAssignments() {
        if (assignmentDao.getAllAssignments() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't get all assignments.");
        } else {
            return assignmentDao.getAllAssignments();
        }
    }

    @RequestMapping(path = "/studentAssignments/{studentId}", method = RequestMethod.GET)
    public List<Assignment> getAssignmentsByStudent(@PathVariable String studentId) {
        if (assignmentDao.getAssignmentsByStudent(studentId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found.");
        } else {
            return assignmentDao.getAssignmentsByStudent(studentId);
        }
    }

    @RequestMapping(path = "/assignment/{assignmentId}", method = RequestMethod.GET)
    public Assignment getOneAssignment(@PathVariable String assignmentId) {
        if (assignmentDao.getOneAssignment(assignmentId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Assignment not found.");
        } else {
            return assignmentDao.getOneAssignment(assignmentId);
        }
    }

    // @PreAuthorize("hasRole('admin')")
    @RequestMapping(path = "/course", method = RequestMethod.POST)
    public Course createCourse(@RequestBody Course course) {
        return courseDao.createCourse(course);
    }


    //@PreAuthorize("hasRole('admin')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/curriculum", method = RequestMethod.POST)
    public void createCurriculum(@RequestBody Curriculum curriculum) {
        curriculumDao.createCurriculum(curriculum);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/assignment", method = RequestMethod.POST)
    public void createAssignment(@RequestBody Assignment assignment) {
            assignmentDao.createAssignment(assignment);
        }

//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(path = "/assignment/{curriculumId}", method = RequestMethod.POST)
//    public void createAssignment(@RequestBody Assignment assignment,@PathVariable String curriculumId) {
//        assignmentDao.createAssignment(assignment);
//    }


    //@PreAuthorize("hasRole('admin')")
    @RequestMapping(path = "/curriculum/{curriculumId}", method = RequestMethod.PUT)
    public void updateCurriculum(@PathVariable String curriculumId, @RequestBody Curriculum curriculum) {
        curriculumDao.editCurriculum(curriculum, curriculumId);
    }

    @RequestMapping(path = "/assignment/{studentId}/{curriculumId}", method = RequestMethod.PUT)
    public void submitAssignment(@RequestBody Assignment assignment,@PathVariable String studentId,@PathVariable String curriculumId) {
        assignmentDao.submitAssignment(assignment,studentId,curriculumId);
    }


    @RequestMapping(path = "/assignment/{assignmentId}", method = RequestMethod.PUT)
    public void gradeAssignment(@PathVariable String assignmentId, @RequestBody Assignment assignment) {
        assignmentDao.gradeAssignment(assignment, assignmentId);
    }

}

