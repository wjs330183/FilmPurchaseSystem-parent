package com.ioe.service.impl;

import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ClassServiceImplTest {
    private ClassPathXmlApplicationContext context;

    @BeforeClass
    public static void setUpBeforeClass()  {
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext(new String[] {"spring/spring-*.xml"});
    }

    @After
    public void tearDown()  {
    }
    @Test
    @Ignore
    public void createClassTest()  {
        HashMap hashMap = new HashMap();
    }
}