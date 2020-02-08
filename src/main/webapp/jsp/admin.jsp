<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin page</title>
</head>

<body>
<h1>Admin`s page</h1>
<a href = "/getAllUsers">Show users</a>
<a href = "/getAllAdvertisments">Show advertisments</a>
<c:forEach var="user" items="${Users}">
<div class="cell">
<c:out value="${user.firstName}"/>
<c:out value="${user.lastName}"/>
<c:out value="${user.nickName}"/>
<c:out value="${user.email}"/>
<c:out value="${user.login}"/>
<c:out value="${user.password}"/>
<hr><br>
</div>
</c:forEach>
</body>
</html>