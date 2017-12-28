package com.soft1611.manage.service;

import com.soft1611.manage.model.Assessment;

import java.util.List;

/**
 *
 * @author lenovo
 * @date 2017/12/26
 */
public interface AssessmentService {
    List<Assessment> getAssessment(String account);

    List<Assessment> queryFilter(String condition);

    List<Assessment> getAll();

    int insert(Assessment assessment);

    int update(Assessment assessment);

    Assessment getA(int id);

    int[] batchDelete(List<Integer> ids);

    List<Assessment> queryLike(String keywords);
}
