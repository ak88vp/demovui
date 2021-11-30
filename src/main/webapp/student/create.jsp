<%--
  Created by IntelliJ IDEA.
  User: Tien Dung
  Date: 11/30/2021
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xoá</title>
</head>
<body>
<a href="/students"> Trở lại danh sách</a>
<p>
<%--    <c:if test='${massage != null}'>--%>
        <span class="massage">${massage}</span>
<%--    </c:if>--%>
</p>
<form method="post">
    <p>Tên</p>
<input type="text" name="name" >
    <p>Môn học</p>
<input type="text" name="subjects" >
    <p>Điểm</p>
<input type="text" name="score" >
    <button> Thêm</button>
</form>

</body>
</html>
