package com.itheima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.IBaseDictDao;
import com.itheima.dao.ICustomerDao;
import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.web.commons.Page;

/**
 * 客户的业务层实现类
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月13日
 */
@Service("customerService")
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)//只读型
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;
	
	@Autowired
	private IBaseDictDao baseDictDao;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<BaseDict> findAllCustomerSource() {
		return baseDictDao.findBaseDictByTypeCode("002");
	}

	@Override
	public List<BaseDict> findAllCustomerLevel() {
		return baseDictDao.findBaseDictByTypeCode("006");
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void removeCustomer(Long custId) {
		customerDao.delete(custId);
	}

	@Override
	public Customer findCustomerById(Long custId) {
		return customerDao.findById(custId);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return customerDao.findAll();
	}

	@Override
	public Page findAllCustomer(DetachedCriteria dCriteria, Integer num) {
		//1.定义一个默认的当前页
		int currentPageNum = 1;
		//2.判断是否传入了当前页，如果传入了使用传入，否则使用默认的
		if(num != null){
			currentPageNum = num;
		}
		//3.根据查询条件，获取总记录条数
		int totalRecords = customerDao.findTotalRecords(dCriteria);
		//4.使用当前页和总记录条数创建Page对象
		Page page = new Page(currentPageNum,totalRecords);
		//5.使用page对象中提供的参数，查询带有分页的结果集
		List<Customer> records = customerDao.findAll(dCriteria, page.getStartIndex(), page.getPageSize());
		//6.给page对象设置结果集
		page.setRecords(records);
		//7.返回page
		return page;
	}

}
