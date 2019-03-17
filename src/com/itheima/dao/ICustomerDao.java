package com.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;

/**
 * 客户的持久层接口
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月13日
 */
public interface ICustomerDao {
	
	/**
	 * 保存客户
	 * @param customer
	 */
	void save(Customer customer);	
	
	/**
	 * 删除客户
	 * @param custId
	 */
	void delete(Long custId);

	/**
	 * 根据id查询客户信息
	 * @param custId
	 * @return
	 */
	Customer findById(Long custId);
	
	/**
	 * 更新客户信息
	 * @param customer
	 */
	void update(Customer customer);
	
	/**
	 * 查询所有客户，使用投影查询
	 * @return
	 */
	List<Customer> findAll();
	
	/**
	 * 查询所有客户
	 * @param dCriteria		查询的条件
	 * @param firstResult	查询的开始记录索引
	 * @param maxResults	查询的最大结果集
	 * @return
	 */
	List<Customer> findAll(DetachedCriteria dCriteria,int firstResult,int maxResults);
	
	
	/**
	 * 查询总记录条数
	 * @param dCriteria	查询的条件
	 * @return
	 */
	int findTotalRecords(DetachedCriteria dCriteria);
}
