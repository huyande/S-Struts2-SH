package com.itheima.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.itheima.dao.IBaseDictDao;
import com.itheima.domain.BaseDict;

/**
 * 字典表的持久层实现类
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月15日
 */
@Repository("baseDictDao")
public class BaseDictDaoImpl implements IBaseDictDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<BaseDict> findBaseDictByTypeCode(String typeCode) {
		return (List<BaseDict>) hibernateTemplate.find("from BaseDict where dictTypeCode = ? ", typeCode);
	}

}
