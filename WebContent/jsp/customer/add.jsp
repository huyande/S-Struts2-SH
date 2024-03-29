﻿<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
<s:debug></s:debug>
<%--html的表单标签和struts2的表单标签选择问题：
html的执行效率高，但是都需要自己设置一些属性和取值
struts2的执行需要通过服务器，没有html执行快，但是它使用起来比html方便
 --%>
	<s:form action="addCustomer" namespace="/customer">
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg" height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_022.jpg" border=0>
					</TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 添加客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
									<s:textfield name="custName" class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50" />
								</td>
								<td>所属行业 ：</td>
								<td>
									<s:textfield name="custIndustry" class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50" />
								</td>
							</TR>							
							<TR>	
								<td>信息来源 ：</td>
								<td>
									<s:select name="custSource.dictId" list="custSources" listKey="dictId" listValue="dictItemName" headerKey="" headerValue="---请选择---" class="textbox" id="sChannel2" style="WIDTH: 180px"></s:select>
								</td>
								<td>客户级别：</td>
								<td>
									<s:select name="custLevel.dictId" list="custLevels" listKey="dictId" listValue="dictItemName" headerKey="" headerValue="---请选择---" class="textbox" id="sChannel2" style="WIDTH: 180px"></s:select>
								
									<%-- <select name="custLevel" class=textbox id=sChannel2 style="WIDTH: 180px">
										<option value="non">---请选择---</option>
										<s:iterator value="custLevels">
											<option value="${dictId}">${dictItemName }</option>
										</s:iterator>
									</select> --%>								
								</td>
							</TR>
							<TR>
								<td>联系地址 ：</td>
								<td>
									<s:textfield name="custAddress" class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50" />
								</td>
								<td>联系电话 ：</td>
								<td>
									<s:textfield name="custPhone" class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50" />
								</td>
							</TR>
							<tr>
								<td rowspan=2>
									<INPUT class=button id=sButton2 type=submit value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
						<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg" border=0></TD>
					<TD align="center" width="100%" background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"	border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</s:form>
</BODY>
</HTML>
