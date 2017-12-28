package com.soft1611.manage.service.impl;

import com.soft1611.manage.dao.AssessmentDAO;
import com.soft1611.manage.factory.DAOFactory;
import com.soft1611.manage.model.Assessment;
import com.soft1611.manage.service.AssessmentService;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author honglei
 * @date 2017/12/26
 */
public class AssessmentServiceImpl implements AssessmentService {
    private AssessmentDAO assessmentDAO= DAOFactory.getAssessmentDAOInstance();
    @Override
    public List<Assessment> getAssessment(String account) {
        List<Assessment>assessments=null;
        try {
            assessments=assessmentDAO.getAssessment(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assessments;
    }

    @Override
    public List<Assessment> queryFilter(String condition) {
        List<Assessment> assessments = null;
        try {
           assessments = assessmentDAO.queryFilter(condition);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assessments;
    }

    @Override
    public List<Assessment> getAll() {
        List<Assessment> assessments = null;
        try {
            assessments = assessmentDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assessments;
    }

    @Override
    public int insert(Assessment assessment) {
        int n = 0 ;
        try {
            n = assessmentDAO.insert(assessment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int update(Assessment assessment) {
        int n = 0 ;
        try {
            n = assessmentDAO.update(assessment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public Assessment getA(int id) {
        Assessment assessment = null;
        try {
            assessment = assessmentDAO.getA(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assessment;
    }

    @Override
    public int[] batchDelete(List<Integer> ids) {
        int[] n = null;
        try {
            n = assessmentDAO.batchDelete(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  n;
    }

    @Override
    public List<Assessment> queryLike(String keywords) {
        List<Assessment> assessments = null;
        try {
            assessments = assessmentDAO.queryLike(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return assessments;
    }
}
