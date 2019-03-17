package com.itheima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.web.commons.Page;

/**
 * 客户的业务层接口
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月13日
 */
public interface ICustomerService {

	/**
	 * 保存客户
	 * @param customer
	 */
	void saveCustomer(Customer customer);
	
	/**
	 * 查询所有客户来源
	 * @return
	 */
	List<BaseDict> findAllCustomerSource();
	
	/**
	 * 查询所有客户级别
	 * @return
	 */
	List<BaseDict>  findAllCustomerLevel();
	
	/**
	 * 删除客户
	 * @param custId
	 */
	void removeCustomer(Long custId);

	/**
	 * 根据id查询客户信息
	 * @param custId
	 * @return
	 */
	Customer findCustomerById(Long custId);
	
	/**
	 * 修改客户信息
	 * @param model
	 */
	void updateCustomer(Customer model);

	/**
	 * 使用投影查询，查询客户列表
	 * @return
	 */
	List<Customer> findAllCustomer();
	
	/**
	 * 查询所有客户		
	 * @param dCriteria		查询条件
	 * @param num			当前页
	 * 
	 * @return				封装好的page对象 	
	 */
	Page findAllCustomer(DetachedCriteria dCriteria,Integer num);
}
