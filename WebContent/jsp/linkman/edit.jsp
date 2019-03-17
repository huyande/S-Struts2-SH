﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>编辑联系人</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<s:form action="editLinkMan" namespace="/linkman">
		<s:hidden name="lkmId" value="%{lkmId}"></s:hidden>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg" border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"  height=20></TD>
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
								<TD class=manageHead>当前位置：联系人管理 &gt; 编辑联系人</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<tr>
								<td>所属客户：</td>
								<td colspan="3">
									<s:select list="customers" name="customer.custId" listKey="custId" listValue="custName" headerKey="" headerValue="---请选择---" style="WIDTH: 180px"/>
								</td>
							</tr>
							<TR>
								<td>联系人名称：</td>
								<td>
									<s:textfield name="lkmName" class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50" />
								</td>
								<td>联系人性别：</td>
								<td>
									<s:radio list="#{'male':'男','female':'女'}" name="lkmGender"></s:radio>
								</td>
							</TR>
							<TR>
								<td>联系人办公电话 ：</td>
								<td>
									<s:textfield name="lkmPhone" class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50" />
								</td>
								<td>联系人手机 ：</td>
								<td>
									<s:textfield name="lkmMobile" class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50" />
								</td>
							</TR>
							<TR>
								<td>联系人邮箱 ：</td>
								<td>
									<s:textfield name="lkmEmail" class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50" />
								</td>
								<td>联系人职位 ：</td>
								<td>
									<s:textfield name="lkmPosition" class="textbox" id="sChannel2" style="WIDTH: 180px" maxLength="50" />
								</td>
							</TR>
							<TR>
								<td>联系人简介 ：</td>
								<td colspan="2">
									<s:textarea name="lkmMemo"  cols="27"  rows="5"></s:textarea>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
									<s:submit value="保存"/>
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
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</s:form>
</BODY>
</HTML>
