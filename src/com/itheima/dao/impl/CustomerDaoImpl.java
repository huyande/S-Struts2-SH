package com.itheima.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itheima.dao.ICustomerDao;
import com.itheima.domain.Customer;
/**
 * 客户的持久层实现类
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月13日
 */
@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(Customer customer) {
		hibernateTemplate.save(customer);
	}

	@Override
	public void delete(Long custId) {
		hibernateTemplate.delete(findById(custId));
	}

	public Customer findById(Long custId) {
		Customer c =  hibernateTemplate.load(Customer.class, custId);
		//System.out.println("dao执行查询后的客户："+c.hashCode());
		return c;
	}

	@Override
	public void update(Customer customer) {
		hibernateTemplate.update(customer);
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) hibernateTemplate.find("select new com.itheima.domain.Customer(custId,custName) from Customer ");
	}

	@Override
	public List<Customer> findAll(DetachedCriteria dCriteria, int firstResult, int maxResults) {
		dCriteria.setProjection(null);//清除之前的设置
		return (List<Customer>) hibernateTemplate.findByCriteria(dCriteria, firstResult, maxResults);
	}

	@Override
	public int findTotalRecords(DetachedCriteria dCriteria) {
		//把select * 变成select count(*)
		dCriteria.setProjection(Projections.rowCount());
		//查询结果
		List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(dCriteria);//select count(*)
		
		return list.isEmpty()?0:list.get(0).intValue();
	}

}
