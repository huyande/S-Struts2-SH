package com.itheima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.LinkMan;

/**
 * 联系人的业务层接口
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月16日
 */
public interface ILinkManService {
	
	/**
	 * 保存联系人
	 * @param linkman
	 */
	void saveLinkMan(LinkMan linkman);
	
	/**
	 * 查询联系人
	 * @param dCriteria
	 * @return
	 */
	List<LinkMan> findAllLinkMan(DetachedCriteria dCriteria);
	
	/**
	 * 删除联系人
	 * @param lkmId
	 */
	void removeLinkMan(Long lkmId);
	
	/**
	 * 根据id查询联系人
	 * @param lkmId
	 * @return
	 */
	LinkMan findLinkManById(Long lkmId);
	
	/**
	 * 编辑联系人
	 * @param linkman
	 */
	void updateLinkMan(LinkMan linkman);

}
