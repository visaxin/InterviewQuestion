<%--
  Created by IntelliJ IDEA.
  User: jason-zhang
  Date: 4/23/2015
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <style>
      body {
        font: 13px/20px 'Lucida Grande', Tahoma, Verdana, sans-serif;
        color: #404040;
        background: #0ca3d2;
      }
      .container{
        margin:80px auto;
        width:640px;
      }
      .search form{
        position:relative;
        margin:0 auto;
        padding:20px 20px 20px;
        width:310px;
        background:white;
        border-radius:3px;
      }

      p{
        margin:20px 0 0;
      }
      .submit{
        border-radius:3px;
        text-align:right;
      }

      input[type=text]{
        border-radius:3px;
      }

    </style>
    <title></title>
  </head>
  <body>

  <div class="container">
    <div class="search form">
      <form action="/SearchServlet" type="post">

        <p>Please Input A Tag :<input type="text" name="tag"></p>

        <p><input class="submit" type="submit" name="submit" value="Submit"></p>
      </form>
    </div>
  </div>
  </body>
</html>
