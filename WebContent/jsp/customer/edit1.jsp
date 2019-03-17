<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>编辑客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<%--由于模型被拦截器压栈了，所以在栈顶。为了我们取值方便，用模型接收可以直接写属性获取数据 --%>
	<s:debug></s:debug>
	
	EL表达式：${custName}
	<br/>
	OGNL表达式：<s:property value="custName"/>
	<hr/>
	HTML<input name="custName" value="${custName}">
	<br/>
	struts2<s:textfield name="custName" value="%{custName}"/>
	<hr/>
	<s:textfield name="custName" />
</BODY>
</HTML>
