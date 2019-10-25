<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.time.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OneDay</title>
<style>
ul{
	margin:5px;
	width:500px;

}
li{
	list-style:none;
	font-size:30px;
	position: relative;
}
input.henshu{
	position: absolute;
    right: 0;
    bottom: 0;
}
</style>
</head>
<body>
<%
	String year = (String)request.getParameter("year");
	String month = (String)request.getParameter("month");
	String day = (String)request.getAttribute("day");
	LocalDateTime ld = LocalDateTime.now();
	if(year == null){
		year=String.valueOf(ld.getYear());
		month=String.valueOf(ld.getMonthValue());
		day=String.valueOf(ld.getDayOfMonth());
	}
%>
<h1><%=year %>年<%=month %>月<%=day %>日のタスク</h1>
<%
	String[][] strs = {{"task1","30","1"},{"task2","60","2"},{"task3","90","3"},{"task4","120","2"}};
	request.setAttribute("tasks", strs);
	String[] backgroundcolors = {"green" , "blue" , "red"};
%>
<%
String[][] taskTable = (String[][])request.getAttribute("tasks");

for(String[] tasks: taskTable){
%>
<ul>
<li style="padding-bottom:<%= tasks[1]%>px;
background-color:<%=backgroundcolors[Integer.parseInt(tasks[2])-1]%>;"><%=tasks[0]%>
<input class="henshu" type="submit" id="<%=tasks[0]%>"name="<%=tasks[0]%>"value="編集"></input>
</li>
</ul>
<%
}
%>
<div>
<%
%>

<form action="TaskAdd" method="get">
	<input type="hidden"id="year"name="year" value="<%=year%>">
	<input type="hidden"id="month"name="month" value="<%=month%>">
	<input type="hidden"id="day"name="day" value="<%=day%>">
	<input type="submit"id="ok"name="ok"value="タスク追加"></input>
</form>
<br/>
<form action="CalenderAccess" method="get">
	<input type="hidden"id="year"name="year" value="<%=year%>">
	<input type="hidden"id="month"name="month" value="<%=month%>">
	<input type="hidden"id="day"name="day" value="<%=day%>">
	<input type="submit"id="ok"name="ok"value="月の表示"></input>
</form>
</div>
</body>
</html>