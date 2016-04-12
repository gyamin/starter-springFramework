<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jstlを有効にするには以下の記述が必要--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello2</title>
</head>
<body>
    <h1>Hello2</h1>
    <p>名前: <c:out value="${modelUser}" /></p>
    <p>メッセージ: <c:out value="${modelMessage}" /></p>
</body>
</html>
