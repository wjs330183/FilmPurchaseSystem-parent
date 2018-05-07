package com.ioe.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ioe.entity.Class;
import com.ioe.service.ClassService;
import com.ioe.utils.CommonUtils;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ClassServiceImplTest {
    private ClassPathXmlApplicationContext context;

    private ClassService classService;

    @BeforeClass
    public static void setUpBeforeClass()  {
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext(new String[] {"spring/spring-*.xml"});
        classService = (ClassServiceImpl) context.getBean(ClassServiceImpl.class);
    }

    @After
    public void tearDown()  {
    }
    @Test
    public void createClassTest()  {
        Class aClass = new Class();
        String operator = "001";
        aClass.setClassId("11");
        aClass.setClassName("黄金会员");
        aClass.setClassDiscount(new BigDecimal("0.8"));
        aClass.setClassIsactive(1);
        aClass.setSysUpdater(operator);
        aClass.setSysCreator(operator);
        List<Class> list = new ArrayList();
        list.add(aClass);
        String classJson = JSONObject.toJSONString(list);
        classService.saveClassBatch(classJson,operator);
    }
}