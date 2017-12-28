package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.EducationDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Education;
import com.soft1611.manage.service.EducationService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by DELL on 2017/12/27.
 */
public class EducationServiceImpl implements EducationService {
    private EducationDAO educationDAO = DAOFactory.getEducationInstance();

    @Override
    public Education getEducation(int id) {
        Education education = null;
        try {
            education = educationDAO.get(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return education;
    }

    @Override
    public List<Education> getAll() {
        List<Education> educationList = null;
        try {
            educationList = educationDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationList;
    }

    @Override
    public int insert(Education education) {
        int n = 0 ;
        try {
            n = educationDAO.insert(education);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
