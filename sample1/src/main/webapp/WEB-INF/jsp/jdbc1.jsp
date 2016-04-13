<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<c:url value="/resources/css/jdbc1.css" />" rel="stylesheet">
    <title>jdbc1</title>
</head>
<body>
    <table>
        <tr>
            <th>ID</th><th>ユーザ名</th>
        </tr>
        <c:forEach var="item" items="${modelUsers}">
            <tr>
                <td>${item.getId()} </td>
                <td>${item.getName()} </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
