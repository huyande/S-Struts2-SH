package com.itheima.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itheima.dao.ILinkManDao;
import com.itheima.domain.LinkMan;

/**
 * 联系人的持久层实现类
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月16日
 */
@Repository("linkmanDao")
public class LinkManDaoImpl implements ILinkManDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(LinkMan linkman) {
		hibernateTemplate.save(linkman);
	}

	@Override
	public List<LinkMan> findAll(DetachedCriteria dCriteria) {
		return (List<LinkMan>) hibernateTemplate.findByCriteria(dCriteria);
	}

	@Override
	public void delete(Long lkmId) {
		hibernateTemplate.delete(findById(lkmId));
	}

	@Override
	public LinkMan findById(Long lkmId) {
		return hibernateTemplate.get(LinkMan.class, lkmId);
	}

	@Override
	public void update(LinkMan linkman) {
		hibernateTemplate.update(linkman);
	}

}
