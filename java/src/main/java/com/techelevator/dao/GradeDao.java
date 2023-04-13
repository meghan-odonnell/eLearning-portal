package com.techelevator.dao;

import com.techelevator.model.Grade;
import org.springframework.expression.spel.ast.Assign;

public interface GradeDao {

    Grade getGrade(int gradeId);

    void editGrade(int gradeId, Grade grade);


}
