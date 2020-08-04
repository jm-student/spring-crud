<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Редактировать</title>
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

<h2>${headerMessage}</h2>

<form:form method="POST" action="edit-user" modelAttribute="user">

    <form:hidden path="id" />
    <table>
        <tr>
            <td><form:label path="firstName">Имя</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Фамилия</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="userName">Отчество</form:label></td>
            <td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Отправить"/></td>
        </tr>
    </table>
</form:form>
<br>

<h3>На главную:</h3>
<a href="<c:url value='/home' />">Главная страница</a>

</div>
</body>
</html>
