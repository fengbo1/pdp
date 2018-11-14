<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fb" uri="http://template.fb.com/article/taglib"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>acceptance_data</title>
		<script type="text/javascript" src="<%=path%>/js/jquery-1.2.6.js" charset= "gbk"></script>
		<script language="javascript" type="text/javascript" src="<%=path%>/js/My97DatePicker/WdatePicker.js"></script>
		<link href="<%=path%>/css/add.css" type="text/css"
			rel="stylesheet" />
	</head>
	<body>
		<form action="<%=path%>/stmodify.action" method="post">
			<div class="layout">
				<div class="title">
					有权评分人设置
				</div>

				<div id="content">
					<div class="four_columns">
						<div class="four_columns_text">
							处室:
						</div>
						<div class="four_columns_input">
						 	研发支持二处
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							<b style="color:red">*</b>有权评分人:
						</div>
						<div>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[0]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[1]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[2]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[3]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[4]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[5]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[6]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[7]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[8]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[9]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[10]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[11]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[12]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[13]}"/>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							有权评分人:
						</div>
						<div>
							<input type="text" name="member" style="width:40px" maxlength="3" value="${member[14]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[15]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[16]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[17]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[18]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[19]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[20]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[21]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[22]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[23]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[24]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[25]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[26]}"/>
						 	<input type="text" name="member" style="width:40px" maxlength="3" value="${member[27]}"/>
						</div>
					<div class="clear"></div>
				</div>
				<div class="four_columns">
						<div class="four_columns_text">
							剩余人员:
						</div>
						<div>
						 	${unpaiban}
						</div>
					<div class="clear"></div>
				</div>
					<div class="button">
						<input type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="submit" class="but" value="提交" />
					</div>
				</div>
			</div>
		</form>
	</body>
</html>


