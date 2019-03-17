package com.itheima.web.action;//actions struts struts2


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

import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.service.ICustomerService;
import com.itheima.service.ILinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 联系人的动作类
 * @author zhy
 * @Company http://www.ithiema.com
 * @Version 1.0
 * @Data  2018年1月16日
 */
@Namespace("/linkman")
@ParentPackage("myDefault")
@Results({
	@Result(name="addUILinkMan",type="dispatcher",location="/jsp/linkman/add.jsp"),
	@Result(name="findAllLinkMan",type="dispatcher",location="/jsp/linkman/list.jsp"),
	@Result(name="linkmanList",type="redirectAction",location="findAllLinkMan"),
	@Result(name="editUILinkMan",type="dispatcher",location="/jsp/linkman/edit.jsp"),
})
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan model = new LinkMan();
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private ILinkManService linkmanService;
	
	private List<Customer> customers;
	
	private List<LinkMan> linkmans;

	public List<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public List<LinkMan> getLinkmans() {
		return linkmans;
	}

	public void setLinkmans(List<LinkMan> linkmans) {
		this.linkmans = linkmans;
	}

	@Override
	public LinkMan getModel() {
		return model;
	}
	
	
	/**
	 * 获取添加联系人页面
	 * @return
	 */
	@Action("addUILinkMan")
	public String addUILinkMan(){
		customers = customerService.findAllCustomer();
		return "addUILinkMan";
	}
	
	
	/**
	 * 添加联系人
	 * @return
	 */
	@Action("addLinkMan")
	public String addLinkMan(){
		linkmanService.saveLinkMan(model);
		return "linkmanList";
	}
	
	/**
	 * 查询所有联系人
	 * @return
	 */
	@Action("findAllLinkMan")
	public String findAllLinkMan(){
		//1.获取离线对象
		DetachedCriteria dCriteria = DetachedCriteria.forClass(LinkMan.class);
		//2.拼装查询条件
		//判断是否输入了联系人名称
		if(StringUtils.isNotBlank(model.getLkmName())){
			//模糊查询
			dCriteria.add(Restrictions.like("lkmName","%"+model.getLkmName()+"%"));
		}
		//判断是否输入了联系人职位
		if(StringUtils.isNotBlank(model.getLkmPosition())){
			//模糊查询
			dCriteria.add(Restrictions.like("lkmPosition","%"+model.getLkmPosition()+"%"));
		}
		//判断是否选择了所属客户
		if(model.getCustomer()!= null && model.getCustomer().getCustId() != null){
			//精确查询
			dCriteria.add(Restrictions.eq("customer",model.getCustomer()));
		}
		//判断是否选择了联系人性别
		if(StringUtils.isNotBlank(model.getLkmGender())){
			//精确查询
			dCriteria.add(Restrictions.eq("lkmGender",model.getLkmGender()));
		}
		//3.根据离线对象查询联系人
		linkmans = linkmanService.findAllLinkMan(dCriteria);
		//4.查询所有客户
		customers = customerService.findAllCustomer();
		return "findAllLinkMan";
	}
	
	/**
	 * 删除联系人
	 * @return
	 */
	@Action("removeLinkMan")
	public String removeLinkMan(){
		linkmanService.removeLinkMan(model.getLkmId());
		return "linkmanList";
	}
	
	
	/**
	 * 前往编辑联系人页面
	 * @return
	 */
	@Action("editUILinkMan")
	public String editUILinkMan(){
		//1.根据id查询联系人
		LinkMan linkman = linkmanService.findLinkManById(model.getLkmId());
		//2.把查询结果压栈
		ActionContext.getContext().getValueStack().push(linkman);
		//3.查询所有客户（投影查询）
		customers = customerService.findAllCustomer();
		return "editUILinkMan";
	}
	
	/**
	 * 编辑联系人
	 * @return
	 */
	@Action("editLinkMan")
	public String editLinkMan(){
		linkmanService.updateLinkMan(model);
		return "linkmanList";
	}
}
