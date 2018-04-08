package com.ioe.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ioe.entity.Class;
import com.ioe.service.ClassService;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

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
    @Ignore
    public void createClassTest()  {
        Class aClass = new Class();
        aClass.setClassId("11");
        aClass.setClassName("黄金会员");
        aClass.setClassDiscount(0.8);
        aClass.setClassIsActive("使用");
        aClass.setClassdisabled(0);
        String classJson = JSONObject.toJSONString(aClass);
        classService.createClass(classJson);
    }
}