<%--
  Created by IntelliJ IDEA.
  User: Tien Dung
  Date: 11/30/2021
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xóa</title>
</head>
<body>
<a href="/students"> Trở lại</a>
<span class="massage">${massage}</span>
<form method="post">
<p> ${student.getName()}</p>
<p> ${student.getSubjects()}</p>
<p> ${student.getScore()}</p>
    <button> Xóa</button>
</form>
</body>
</html>
