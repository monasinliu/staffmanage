package com.soft1611.manage.service;

import com.soft1611.manage.factory.ServiceFactory;
import com.soft1611.manage.model.Assessment;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mona on 2017/12/28.
 */
public class AssessmentServiceTest {
    AssessmentService assessmentService;
    @Before
    public void setUp() throws Exception {
        assessmentService = ServiceFactory.getAssessmentServiceInstance();
    }

    @Test
    public void getAll() throws Exception {
        List<Assessment> assessments  = assessmentService.getAll();
        System.out.println(assessments);
    }

}