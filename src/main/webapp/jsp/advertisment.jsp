<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mytag" uri="customtags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Advertisment</title>
<link rel="stylesheet"  type='text/css' href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
</head>

<body>
<form method="POST" action="add_adv" >
<p><input type="text" name="Name" size=40></p>
  <p><select  name="Category">
   <option disabled>Choose category</option>
   <option selected value="Select1">Select1</option>
   <option value="Select2">Select2</option>
   <option value="Select3">Select3</option>
   <option value="Select4">Select4</option>
  </select></p>
<p><textarea class="form-control" name="Text" rows="10" cols="45" ></textarea></p>
<input type="submit" value="add_adv">
</form>
<br>
<a href="get_page?page=main">To main</a>
</body>
</html>