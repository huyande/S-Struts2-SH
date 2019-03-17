package com.itheima.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.LinkMan;

/**
 * 联系人的持久层接口
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月16日
 */
public interface ILinkManDao {
	
	/**
	 * 保存联系人
	 * @param linkman
	 */
	void save(LinkMan linkman);
	
	/**
	 * 查询所有联系人
	 * @param dCriteria
	 * @return
	 */
	List<LinkMan> findAll(DetachedCriteria dCriteria);
	
	/**
	 * 删除联系人
	 * @param lkmId
	 */
	void delete(Long lkmId);
	
	/**
	 * 根据Id查询联系人
	 * @return
	 */
	LinkMan findById(Long lkmId);
	
	/**
	 * 编辑联系人
	 * @param linkman
	 */
	void update(LinkMan linkman);

}
