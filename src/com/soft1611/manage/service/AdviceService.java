package com.soft1611.manage.service;

import com.soft1611.manage.model.Advice;

import java.util.List;

/**
 * Created by lenovo on 2017/12/20.
 */
public interface AdviceService {
    List<Advice> getAdvice(String account);

    List<Advice> queryFilter(String content);

    int insert(Advice advice);
}
