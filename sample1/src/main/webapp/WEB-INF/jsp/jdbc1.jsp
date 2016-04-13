<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jdbc1</title>
</head>
<body>
    <table>
        <th>
            <td>ID</td>
            <td>ユーザ名</td>
        </th>
        <c:forEach var="item" items="${modelUsers}">
            <tr>
                <td>${item.getId()} </td>
                <td>${item.getName()} </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
