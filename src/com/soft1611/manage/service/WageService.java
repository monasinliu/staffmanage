package com.soft1611.manage.service;

import com.soft1611.manage.model.Wage;

import java.sql.SQLException;
import java.util.List;

/**
 *  工资管理服务
 * @author sry
 * @date 2017/12/25
 */
public interface WageService {
    /**
     * 得到工资表
     * @return
     * @throws SQLException
     */
    List<Wage> readWage();

    int[] batchDelete(List<String> strings);

    List<Wage> queryLike(String keywords);
}
