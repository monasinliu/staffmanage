package com.soft1611.manage.service;

import com.soft1611.manage.model.Education;

import java.util.List;

/**
 * @author yangmeng
 * Created by DELL on 2017/12/27.
 */
public interface EducationService {
    /**
     * 获取培训信息
     * @param id
     * @return
     */
    Education getEducation(int id);

    List<Education> getAll();

    int insert(Education education);

}
