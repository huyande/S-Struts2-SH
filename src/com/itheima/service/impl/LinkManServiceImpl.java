package com.itheima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.ILinkManDao;
import com.itheima.domain.LinkMan;
import com.itheima.service.ILinkManService;

/**
 * 联系人的业务层实现类
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月16日
 */
@Service("linkmanService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)//读写型
public class LinkManServiceImpl implements ILinkManService {

	@Autowired
	private ILinkManDao linkmanDao;
	
	@Override
	public void saveLinkMan(LinkMan linkman) {
		linkmanDao.save(linkman);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public List<LinkMan> findAllLinkMan(DetachedCriteria dCriteria) {
		return linkmanDao.findAll(dCriteria);
	}

	@Override
	public void removeLinkMan(Long lkmId) {
		linkmanDao.delete(lkmId);
	}

	@Override
	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public LinkMan findLinkManById(Long lkmId) {
		return linkmanDao.findById(lkmId);
	}

	@Override
	public void updateLinkMan(LinkMan linkman) {
		linkmanDao.update(linkman);
	}

}
