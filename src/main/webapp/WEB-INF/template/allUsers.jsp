<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>

    <head>
        <title>Список всех работников:</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <style>
            <%@ include file="/WEB-INF/css/style.css" %>
        </style>
    </head>

    <body>
        <br>
        <b>Все работники:</b>
        <br><br>
        <table class = "table">
            <tr>
                <th>Id</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Возраст</th>
                <th>Компания</th>
            </tr>
            <c:forEach var = "user" items = "${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>
                    <td>${user.company}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href = "/add-user">Добавить нового пользователя</a>
    </body>

</html>