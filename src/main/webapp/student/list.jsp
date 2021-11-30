
<%--
  Created by IntelliJ IDEA.
  User: Tien Dung
  Date: 11/30/2021
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách học sinh</title>
</head>
<body>
<h1> Danh sách học sinh</h1>
<a href="/students?action=create"> Thêm học sinh</a>
<br>

<form method="post">
    <input type="hidden" name="action" value="find">
    <input type="text" name="findName" >
    <button>Tìm</button>
</form>
<c:forEach items='${student}' var="st">
    <table>
        <tr>
            <td><a href="/students?action=view&id=${st.getId()}">${st.getName()}</a></td>
            <td><a>${st.getSubjects()}</a></td>
            <td><a>${st.getScore()}</a></td>
            <td><a href="/students?action=delete&id=${st.getId()}" onclick="hienThongBao()">Xóa</a></td>
            <td><a href="/students?action=edit&id=${st.getId()}">Sửa</a></td>
        </tr>
    </table>
</c:forEach>

</body>
<script >
    function hienThongBao(){
        let kq=confirm("Bạn muốn xóa?")
        if(kq){
            kq="xóa thành công";

            alert(kq)
        }else {
            kq="."
            alert(kq)
        }

    }
</script>
</html>
