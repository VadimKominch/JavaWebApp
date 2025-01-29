<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 <head>
   <title>Advertisement</title>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
   <link href="../css/ads.css" rel="stylesheet">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
   <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
 </head>

<body>
    <c:import url="header.jsp"/>
    <h2>Edit Advertisement</h2>
     <form class="w-75 ads-form h-75 w-75 border mt-5 form">
        <input type="hidden" class="id-input" value="${advertisement.id}">
        <div class="form-group">
            <label for="title">Post title</label>
            <input type="text" class="form-control title" id="title" value="${advertisement.title}">
        </div>

        <div class="form-group">
            <label for="body">Post body</label>
            <textarea class="form-control body" id="text" name="text">${advertisement.body}</textarea>
        </div>
        <div class="row">
        <select class="category-select custom-select">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id.value}" ${category.name.value == advertisement.category ? 'selected="selected"' : ''}>${category.name.value}</option>
        </c:forEach>
        </select>
        </div>
        <button class="btn btn-primary" type="submit">Submit form</button>
    </form>
    <script src = "../js/edit_adv.js"></script>
</body>
</html>