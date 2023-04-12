package com.techelevator.dao;

import com.techelevator.model.Grade;
import org.springframework.stereotype.Component;

@Component
public class JdbcGradeDao implements GradeDao{

    public JdbcGradeDao() {
    }

    @Override
    public Grade getGrade(int gradeId) {
        return null;
    }

    @Override
    public Grade editGrade(int gradeId, Grade grade) {
        return null;
    }
}
