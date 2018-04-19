package com.ioe.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ioe.entity.Customer;
import com.ioe.service.CustomerService;
import org.junit.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class CustomerServiceImplTest {
    private ClassPathXmlApplicationContext context;

    private CustomerService customerService;

    @BeforeClass
    public static void setUpBeforeClass()  {
    }

    @AfterClass
    public static void tearDownAfterClass() {
    }

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext(new String[] {"spring/spring-*.xml"});
        customerService= (CustomerServiceImpl) context.getBean(CustomerServiceImpl.class);

    }

    @After
    public void tearDown()  {
    }
    @Test
    @Ignore
    public void createCustomerTest()  {
        Customer customer = new Customer();
        customer.setClassId("12");
        customer.setCustomerEmail("dfsbjkl@163.com");
        customer.setCustomerId("123111");
        customer.setCustomerMobile("12343567865");
        customer.setCustomerName("mimi");

        String customerJson = JSONObject.toJSONString(customer);
        customerService.createCustomer(customerJson);
    }

}