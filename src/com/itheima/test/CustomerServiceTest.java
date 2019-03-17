package com.itheima.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;

/**
 * 测试客户的业务层
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月13日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring/applicationContext.xml"})
public class CustomerServiceTest {

	@Autowired
	private ICustomerService cs;
	
	@Test
	public void testSaveCustomer() {
		Customer c = new Customer();
		c.setCustName("crm环境搭建");
		cs.saveCustomer(c);
	}

//	@Test
//	public void testFindAllCustomer() {
//		//获取离线对象
//		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
//		
//		List<Customer> list = cs.findAllCustomer(dCriteria);
//		for(Customer c : list){
//			System.out.println(c);
//		}
//	}

}
