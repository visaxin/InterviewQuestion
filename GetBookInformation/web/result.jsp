<%@ page import="java.util.ArrayList,java.lang.Iterable" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: jason-zhang
  Date: 4/23/2015
  Time: 6:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<%
  ArrayList book_name_list = (ArrayList)session.getAttribute("book_name_list");
  if(book_name_list == null){
  System.out.println("No result");
}else{
%>
Book Name:
<%for(int i=0;i<book_name_list.size();i++){%>
<%=book_name_list.get(i)%><br>
<%}}%>
</body>
</html>
