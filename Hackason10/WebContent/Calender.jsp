<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>カレンダー</title>

<style type="text/css">
<!--
    *{padding:5px; margin:0px;}
    body{text-align:center;}
    table{margin:0 auto;width:800px; background:white; border:2px black solid; border-collapse:collapse;
    	}
    th{border:1px black solid; background:#CCFFFF;}
    td{border:1px black solid; text-align:right; padding:5px 20px 5px 20px;}
    br{line-height:1em;}
-->
</style>
</head>
<body>
<b><%= request.getAttribute("year") %>年<%=request.getAttribute("month") %>月のカレンダー</b>
<br/>
<br/>
<%= request.getAttribute("calender")%>
<br/>

<b>カレンダーの変更</b>
<br/>
<%= request.getAttribute("selectYearMonth") %>
<br/>


<b>日付選択</b>
<br/>
<%= request.getAttribute("selectDay") %>
<br/>

</body>
</html>