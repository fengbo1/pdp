<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>	
<script language="javascript" type="text/javascript" src="<%=path%>/js/DatePicker.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<title>指标库导入</title>
</head>
<body>
	<div style="color: #1778C2; padding-top: 0px; padding-bottom: 5px; border: 0px; font-size: 26px; font-family: '黑体';"
			colspan="14" align="center" bordercolor="#FFFFFF"><b>指标库导入</b>
	</div>
	<div class="layout">
		<form name="filename" method="post" action="normimport.action"
			enctype="multipart/form-data">
			<div class="title" ><b>指标库导入,选择上传文件</b></div>
			<div id="content" >
				<div class="four_columns">
					
					<div class="four_columns_input">
						<input type="file" name="file" />
				
						 <input type="submit" name="submit"value="上传">
					</div>
						<br/>
					<div class="four_columns_input" >
						<a href="<%=path%>/templet/zhibiaoku.xls">下载【指标库】模板</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<br/>
	
	
</body>
</html>