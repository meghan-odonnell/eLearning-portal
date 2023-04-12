package com.techelevator.dao;

import com.techelevator.model.Curriculum;

import java.util.List;

public interface CurriculumDao {

    List<Curriculum> showAllCurriculum ();

    List<Curriculum> showCourseCurriculum (String courseId);

//    Curriculum showCourseCurriculum (String courseId);

    Curriculum showSingleCurriculum (String curriculumId);

    Curriculum createCurriculum (Curriculum curriculum);

    Curriculum editCurriculum (String curriculumId);
}
