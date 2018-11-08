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
		<script type="text/javascript" src="<%=path%>/js/userajax.js"></script>
	
		<link href="<%=path%>/css/add.css" type="text/css" rel="stylesheet" />
<style type="text/css">
  .as {
	text-align: center;
}
 span{
	color:red;
  }
  </style>
  
  <script type="text/javascript">
$(document).ready(function(){ 

$("tr.btbj:odd").css({"background-color":"#F0F0F0","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
$("tr.btbj:even").css({"background-color":"#bfd3fc","font-family": "黑体","font-size": "14px","font-weight":"lighter" }); 
var city=document.getElementById("paracity").value;
var chu=document.getElementById("parachu").value;
var tuan=document.getElementById("paratuan").value;
var zu=document.getElementById("parazu").value;
var zhi=document.getElementById("parazhi").value;
var pos=document.getElementById("parapos").value;
var role=document.getElementById("pararole").value;
var authoE=document.getElementById("authoE").value;
var authoR=document.getElementById("authoR").value;
var authoS=document.getElementById("authoS").value;
var canscore=document.getElementById("paracanscore").value;
$('#city').attr('value',city);
 getchumodify(); 
 gettuanmodify(chu);
 getzumodify(chu,tuan); 
$('#chu').attr('value',chu);
$('#tuan').attr('value',tuan);
$('#zu').attr('value',zu);
$('#zhiwu').attr('value',zhi);
$('#canscore').attr('value',canscore);
if(authoE=="E"&&authoR!="R"&&authoS!="S")
{
	$('#role').attr('value',authoE);
}
if(authoR=="R")
{
	$('#role').attr('value',authoR);
}
if(authoS=="S")
{
	$('#role').attr('value',authoS);
}
//$('#role').attr('value',role);
$('#pos').attr('value',pos);
//$('#zhi').attr('value',x[1].value);  
//$('#chu').attr('value',x[2].value);
//$('#tuan').attr('value',x[3].value);  
//$('#zu').attr('value',x[4].value);  
//$('#pos').attr('value',x[5].value);  
//$('#role').attr('value',x[6].value);  
 });
 //var chu=document.getElementById("parachu").value;
 function getchu(){
    
    var chus="";
    var	city=document.getElementById('city').value;
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			
			chus=xmlhttp.responseText;
			//alert(yesorno);
			
				//document.getElementById("chutuan").innerHTML=arr[0];
			chuname(chus);
		}				
	} 
	xmlhttp.open("GET","getchuajax.action?city="+city+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

 function gettuan(){
    
    var tuans="";
    var	chu=document.getElementById('chu').value;
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			
			tuans=xmlhttp.responseText;
			//alert(yesorno);
			
				//document.getElementById("chutuan").innerHTML=arr[0];
			tuanname(tuans);
		}				
	} 
	xmlhttp.open("GET","gettuanajax.action?chu="+chu+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

 function getzu(){
    
    var zus="";
    var	chu=document.getElementById('chu').value;
    var	tuan=document.getElementById('tuan').value;
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			
			zus=xmlhttp.responseText;
			//alert(yesorno);
			
				//document.getElementById("chutuan").innerHTML=arr[0];
			zuname(zus);
		}				
	} 
	xmlhttp.open("GET","getzuajax.action?chu="+chu+"&tuan="+tuan+"&nowtime="+time,true);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

 function getchumodify(){
    
    var chus="";
    var	city=document.getElementById('city').value;
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			
			chus=xmlhttp.responseText;
			//alert(yesorno);
			
				//document.getElementById("chutuan").innerHTML=arr[0];
			chuname(chus);
		}				
	} 
	xmlhttp.open("GET","getchuajax.action?city="+city+"&nowtime="+time,false);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

function gettuanmodify(chu){
    
    var tuans="";
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
	
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			
			tuans=xmlhttp.responseText;
	
			tuannamemodify(tuans);
		}				
	} 
	xmlhttp.open("GET","gettuanajax.action?chu="+chu+"&nowtime="+time,false);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}

 function getzumodify(chu,tuan){
    
    var zus="";
    var xmlhttp;
    var time=new Date().getTime();
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}	
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
			
			zus=xmlhttp.responseText;
			//alert(yesorno);
			
				//document.getElementById("chutuan").innerHTML=arr[0];
			zuname(zus);
		}				
	} 
	xmlhttp.open("GET","getzuajax.action?chu="+chu+"&tuan="+tuan+"&nowtime="+time,false);
	//xmlhttp.open("GET","login.action",true);
	xmlhttp.send();
}
 
function chuname(chus){

var arry= new Array();
arry=chus.split("|"); //字符分割 
var obj=document.getElementById('chu'); 
obj.options.length=0;
obj.options.add(new Option("-请选择处室名称-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(chuidtoname(arry[i]),arry[i])); //这个兼容IE与firefox 
}
} 

function tuanname(tuans){

var arry= new Array();
arry=tuans.split("|"); //字符分割 
var obj=document.getElementById('tuan'); 
obj.options.length=0;
obj.options.add(new Option("-请选择团队名称-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(tuanidtoname(arry[i]),arry[i])); //这个兼容IE与firefox 
}
} 

function tuannamemodify(tuans){

var arry= new Array();
arry=tuans.split("|"); //字符分割 
var obj=document.getElementById('tuan'); 
obj.options.length=0;
obj.options.add(new Option("-请选择团队名称-","wu"));
for (var i=1;i<arry.length;i++){	

	obj.options.add(new Option(tuanidtonamemodify(arry[i]),arry[i])); //这个兼容IE与firefox 
}
} 
function zuname(zus){

var arry= new Array();
arry=zus.split("|"); //字符分割 
var obj=document.getElementById('zu'); 
obj.options.length=0;
obj.options.add(new Option("-请选择班组名称-","wu"));
for (var i=1;i<arry.length;i++){	
    
	obj.options.add(new Option(zuidtoname(arry[i]),arry[i])); //这个兼容IE与firefox 
}
}  


function tuanidtonamemodify(id)
{
 var chu=document.getElementById("parachu").value;
 var result="";
   if(chu=="A")
   { 
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="综合管理团队";
    }
    else if(id=="2")
    {
    	result="财务（采购）管理团队";
    }
    else if(id=="3")
    {
    	result="人力资源（党群）团队";
    }
    }
   else if(chu=="B")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="运营规划与外包管理团队";
    }
    else if(id=="2")
    {
    	result="质量控制与合规管理团队";
    }
    else if(id=="3")
    {
    	result="监控调度与参数运维团队";
    }
   }
   else if(chu=="C")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="需求分析团队";
    }
    else if(id=="2")
    {
    	result="推广响应团队";
    }
   
   }
   else if(chu=="D")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="本币支付结算团队";
    }
    else if(id=="2")
    {
    	result="代理签约团队";
    }
   
   }
    else if(chu=="E")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="柜面外汇团队";
    }
    else if(id=="2")
    {
    	result="外汇汇款清算团队";
    }
   
   }
    else if(chu=="F")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="稽核监督团队";
    }
    else if(id=="2")
    {
    	result="集中授权 团队";
    }
   
   }
   
   else if(chu=="G")
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="智慧银行业务团队";
    }
    else if(id=="2")
    {
    	result="集团子公司业务团队";
    }
   
   }

   else if(chu=="1")//综合与生产管理处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="综合与财务管理团队";
    }
    else if(id=="2")
    {
    	result="人力资源团队";
    }
    else if(id=="3")
    {
    	result="生产管理团队";
    }
   }
   else if(chu=="2")//合规与监督二处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="集中稽核团队";
    }
    else if(id=="2")
    {
    	result="集中业务处理团队";
    }
   }
   else if(chu=="3")//通用业务二处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="业务处理团队";
    }
   }
   else if(chu=="4")//专业处理二处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="专业处理团队";
    }
   }
   else if(chu=="5")//研发支持二处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="研发支持团队";
    }
   }
   else if(chu=="U")//物业服务处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="综合保障团队";
    }
    else if(id=="2")
    {
       result="物业服务团队";
    }
   }
   else if(chu=="V")//安保及基础设施运维处
   {
    if(id=="0")
    {
    	result="处室管理";
    }
    else if(id=="1")
    {
       result="安保团队";
    }
    else if(id=="2")
    {
       result="基础设施运维团队";
    }
    else if(id=="3")
    {
       result="商务及合规团队";
    }
    else if(id=="4")
    {
       result="基建团队";
    }
   }
    return result;
}

 </script>
	</head>
	<body>
		<form action="<%=path%>/userupdate.action" method="post">
			
				<div style="color: #1778C2; padding-top: 15px; padding-bottom: 15px; border: 0px; font-size: 26px; font-family: '黑体';" align="center" bordercolor="#FFFFFF">
					<b>员工信息修改</b>
				</div>
               <table width="500"  height="300" border="1" align="center" cellpadding="1" cellspacing="0">
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">新一代编号</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<input style="width:280px"  type="text" id="newnumber" name="newnumber" onkeyup="this.value=value.replace(/[^\d.]/g,'')"  onafterpaste="this.value=value.replace(/[^\d.]/g,'')" value="${ui.newnumber}" /> 
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">姓名</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<input style="width:280px"  type="text" id="name" name="name" value="${ui.name}" /> 
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">机构</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select style="width:280px"  id="city" name="city" onchange="getchu()">
										<option value="wu">请选择机构名称</option>
										<option value="1">业务处理中心</option>
										<option value="2">成都分中心</option>
										<option value="3">武汉生产园区管理办公室</option>
						</select>
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">职务</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select style="width:280px"  id="zhiwu" name="zhiwu" >
    				                   <option value="wu">-请选择职务-</option>
										<option value="0">主任</option>
										<option value="1">副主任</option>
										<option value="2">处室主要负责人</option>
										<option value="3">处室负责人</option>
										<option value="4">团队主管</option>
										<option value="5">班组长</option>
										<option value="6">经办岗</option>
										
						</select>
    				
    			</td>
    			
    		</tr>
    		
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">是否有权评分人</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select style="width:280px"  id="canscore" name="canscore" >
    				                   <option value="wu">-请选择是否有权评分人-</option>
										<option value="0">否</option>
										<option value="1">是</option>
																				
						</select>
    				
    			</td>
    			
    		</tr>
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">处室</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select style="width:280px"  id="chu" name="chu" onchange="gettuan()">
						 <option value="wu">-请选择处室名称-</option>			                        
					</select>
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">团队</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    			<select id="tuan" name="tuan" style="width: 280px" onchange="getzu()">
					  <option value="wu">-请选择团队名称-</option>				
				</select>
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">班组</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select id="zu" name="zu" style="width: 280px">
							<option value="wu">-请选择班组名称-</option>					
					</select>
    				
    			</td>
    			
    		</tr>
    		 <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">岗位</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select id="pos" name="pos" style="width: 280px">
						<option value="0">-请选择岗位名称-</option>
			            <c:forEach items="${listpos}" var="pos" varStatus="status">
        						<option value="${pos.id}">${pos.name}</option>
        				</c:forEach>
						</select>
    				
    			</td>
    			
    		</tr>
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">系统角色</span><span>*</span>
    			</td>
    			<td width="300" class="as">
    				<select id="role" name="role" style="width: 280px">
										<option value="wu">-请选择系统角色-</option>
										<option value="R">绩效管理员</option>
										<option value="S">数据管理员</option>
										<option value="E">普通用户</option>
						</select>
    				
    			</td>
    			
    		</tr>
    		  <tr>
    			<td width="200" class="as" >
    				<span style="font-size:12pt;color:black">操作</span><span></span>
    				<input type="hidden" id="paracity" name="paracity" value="${city}"/>
    				<input type="hidden" id="parazhi" name="parazhi" value="${zhi}"/>
					<input type="hidden" id="parachu" name="parachu" value="${chu}"/>
					<input type="hidden" id="paratuan" name="paratuan" value="${tuan}"/>
					<input type="hidden" id="parazu" name="parazu" value="${zu}"/>
					<input type="hidden" id="parapos" name="parapos" value="${pos}"/>
					<input type="hidden" id="pararole" name="pararole" value="${role}"/>
					<input type="hidden" id="authoE" name="authoE" value="${authoE}"/>
					<input type="hidden" id="authoR" name="authoR" value="${authoR}"/>
					<input type="hidden" id="authoS" name="authoS" value="${authoS}"/>
					<input type="hidden" id="paraid" name="paraid" value="${id}"/>
					<input type="hidden" id="paracanscore" name="paracanscore" value="${canscore}"/>
    			</td>
    			<td width="300" class="as">
    				<input style="width: 80px" type="button" onclick="javascript:history.go(-1);" value="返回" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				   <input style="width: 80px" type="submit" class="but" value="提交" />
    				
    			</td>
    			
    		</tr>
    		 <tr><td colspan="2"><div style="color:red"><s:fielderror></s:fielderror></div></td></tr>
    	</table>
				
					
			
		
		</form>
	</body>

</html>


