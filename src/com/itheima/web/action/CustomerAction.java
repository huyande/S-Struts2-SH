package com.itheima.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.service.ICustomerService;
import com.itheima.web.commons.Page;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 * 客户的动作类
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月13日
 */
@Controller("customerAction")
@Scope("prototype")
@ParentPackage("myDefault")
@Namespace("/customer")
@Results({
	@Result(name="addUICustomer",type="dispatcher",location="/jsp/customer/add.jsp"),
	@Result(name="findAllCustomer",type="dispatcher",location="/jsp/customer/list.jsp"),
	@Result(name="customerList",type="redirectAction",location="findAllCustomer"),
	@Result(name="editUICustomer",type="dispatcher",location="/jsp/customer/edit.jsp"),
})
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {


	private Customer model = new Customer();
	
	
	private List<BaseDict> custSources;
	private List<BaseDict> custLevels;
	private Integer num;//当前页
	private Page page ;

	public List<BaseDict> getCustSources() {
		return custSources;
	}

	public void setCustSources(List<BaseDict> custSources) {
		this.custSources = custSources;
	}

	public List<BaseDict> getCustLevels() {
		return custLevels;
	}

	public void setCustLevels(List<BaseDict> custLevels) {
		this.custLevels = custLevels;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	@Autowired
	private ICustomerService customerService;
	
	@Override
	public Customer getModel() {
		//System.out.println("模型驱动拦截器执行此方法时压栈："+model.hashCode());
		return model;
	}
	
	/**
	 * 获取添加客户页面
	 * @return
	 */
	@Action("addUICustomer")
	public String addUICustomer(){
		//1.查询所有客户来源
		custSources = customerService.findAllCustomerSource();
		//2.查询所有客户级别
		custLevels = customerService.findAllCustomerLevel();
		return "addUICustomer";
	}
	
	/**
	 * 查询所有客户
	 * @return
	 */
	@Action("findAllCustomer")
	public String findAllCustomer(){
		//1.创建离线对象
		DetachedCriteria dCriteria = DetachedCriteria.forClass(Customer.class);
		//2.拼装查询条件
		//判断是否输入了客户名称
		if(StringUtils.isNotBlank(model.getCustName())){
			//模糊查询
			dCriteria.add(Restrictions.like("custName", "%"+model.getCustName()+"%"));
		}
		//判断是否输入了客户行业
		if(StringUtils.isNotBlank(model.getCustIndustry())){
			//模糊查询
			dCriteria.add(Restrictions.like("custIndustry", "%"+model.getCustIndustry()+"%"));
		}
		//判断是否选择了客户来源
		if(model.getCustSource()!= null && StringUtils.isNotBlank(model.getCustSource().getDictId())){
			//精确查询
			dCriteria.add(Restrictions.eq("custSource",model.getCustSource()));
		}
		//判断是否选择了客户级别
		if(model.getCustLevel()!=null && StringUtils.isNotBlank(model.getCustLevel().getDictId())){
			//精确查询
			dCriteria.add(Restrictions.eq("custLevel.dictId",model.getCustLevel().getDictId()));
		}
		//3.查询客户列表
		page = customerService.findAllCustomer(dCriteria,num);
		//4.查询所有客户来源
		custSources = customerService.findAllCustomerSource();
		//5.查询所有客户级别
		custLevels = customerService.findAllCustomerLevel();
		return "findAllCustomer";
	}
	
	/**
	 * 保存客户
	 * @return
	 */
	@Action("addCustomer")
	public String addCustomer(){
		customerService.saveCustomer(model);
		return "customerList";
	}
	
	
	/**
	 * 删除客户
	 * @return
	 */
	@Action("removeCustomer")
	public String removeCustomer(){
		customerService.removeCustomer(model.getCustId());
		return "customerList";
	}
	
	/**
	 * 获取编辑客户页面
	 * @return
	 */
	@Action("editUICustomer")
	public String editUICustomer(){
		//1.根据id查询客户信息
		Customer c = customerService.findCustomerById(model.getCustId());
		
//		model = customerService.findCustomerById(model.getCustId());	
		//2.把查询结果压入栈顶
		ActionContext.getContext().getValueStack().push(c);
		//3.查询所有客户来源
		custSources = customerService.findAllCustomerSource();
		//4.查询所有客户级别
		custLevels = customerService.findAllCustomerLevel();
		return "editUICustomer";
	}
	
	/**
	 * 编辑客户
	 * @return
	 */
	@Action("editCustomer")
	public String editCustomer(){
		customerService.updateCustomer(model);
		return "customerList";
	}
}
