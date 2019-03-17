package com.itheima.dao;

import java.util.List;

import com.itheima.domain.BaseDict;

/**
 * 字典表的持久层接口
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月15日
 */
public interface IBaseDictDao {
	
	/**
	 * 根据字典表的类型查询数据
	 * @param typeCode
	 * @return
	 */
	List<BaseDict> findBaseDictByTypeCode(String typeCode);

}
