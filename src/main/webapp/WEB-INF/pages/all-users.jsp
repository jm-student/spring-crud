<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список</title>
    <style type="text/css">
        TABLE {
            width: 300px; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
        }
        TD, TH {
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid darkseagreen; /* Параметры рамки */
        }
        TH {
            background: #b0e0e6; /* Цвет фона */
        }
    </style>

</head>
<body>
<div align="center">

<br><br>
<a href="${pageContext.request.contextPath}/add-user">Добавить нового пользователя</a>
<br>

<h3>Список пользователей:</h3>
${message}
<br>

<table border="3px" cellpadding="0" cellspacing="0">
    <thead>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Отчество</th>
        <th>[изменить]</th>
        <th>[удалить]</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.userName}</td>
            <td><a href="${pageContext.request.contextPath}/edit-user/${user.id}">Edit</a></td>
            <td><a href="${pageContext.request.contextPath}/delete-user/${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>

<h3>На главную:</h3>
<a href="<c:url value='/home' />">Главная страница</a>

</div>
</body>
</html>
