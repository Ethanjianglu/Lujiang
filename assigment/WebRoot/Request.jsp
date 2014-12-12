<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Request.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <P>Fibonacci Sequence Length:</P>
    <FORM  method="post" action="Servlet">
    <input type="hidden" value="Add" name="rType">
    <input onkeyup="value=value.replace(/[^\d]/g,'') "   
onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"   
ID="Text2" NAME="max" type="text"> 
	<!-- <P><INPUT name="max" type="text"></P> -->
	<P>value[0-100]</P>
	<INPUT type="submit" value="submit">
  </FORM>
  </body>
</html>
