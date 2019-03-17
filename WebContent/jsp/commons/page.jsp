<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
function topage(num){
	//给隐藏域赋值
	document.getElementById("pagenum").value = num;
	//提交表单
	document.forms[0].submit();
}
</script>

<style type="text/css">
	div a{
		border:1px solid lightblue;
		padding:3px 3px 3px 3px;
		border-radius:25%;
	}
	
	div{
		margin-top:15px;
	}
	
	a:active{
		border-top:3px solid lightblue;
		border-left:3px solid lightblue;
		border-rigth:0px solid white;
		border-bottom:0px solid white;
	}
</style>
<div>
<a href="javascript:topage(1)">首页</a>
<a href="javascript:topage('${page.prePageNum}')">上一页</a>
<s:iterator begin="%{page.beginPageNum}" end="%{page.endPageNum}" var="snum">
	<a href="javascript:topage('${snum}')">${snum}</a>
</s:iterator>
<a href="javascript:topage('${page.nextPageNum}')">下一页</a>
<a href="javascript:topage('${page.totalPageNum}')">末页</a>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
第${page.currentPageNum}页/共${page.totalPageNum}页
</div>