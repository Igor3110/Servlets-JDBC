<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>

    <head>
        <title>Добавить нового пользователя</title>
    </head>

    <body>
        <form action="/add-user" method="post">
            <h2>Введите информацию о пользователе:</h2>
            <label for="first_name">First name:
                 <input type="text" name="first_name" id="first_name" required>
            </label>
            <br>
            <label for="last_name">Last name:
                  <input type="text" name="last_name" id="last_name" required>
            </label>
            <br>
            <label for="age">Age:
                  <input type="text" name="age" id="age" required>
            </label>
            <br>
            <label for="company">Company:
                  <input type="text" name="company" id="company" required>
            </label>
            <br>
            <br>
            <button type="submit">Отправить</button>
            <br>
            <br>
            <div>
                <c:if test="${not empty requestScope.errors}">
                    <div style="color: red">
                        <c:forEach var="error" items="${requestScope.errors}">
                            <span>${error.message}</span>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
        </form>
    </body>

</html>
