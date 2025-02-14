<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<link rel='stylesheet' type='text/css' href='bootstrap/css/bootstrap.min.css'>
<link rel='stylesheet' type='text/css' href='css/loginpage.css'>
<link rel="stylesheet" type='text/css' href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<body class = "bg-dark">
 <div class="login-form-container">
 <form class=" my-margin-bottom form-horizontal" method="POST">
 <span class="heading">АВТОРИЗАЦИЯ</span>
 <div class="form-group">
 <input type="text" class="form-control login" id="inputEmail" placeholder="Login" name="login">
 <i class="fa fa-user"></i>
 </div>
 <div class="form-group help">
 <input type="password" class="form-control password" id="inputPassword" placeholder="Password" name="password">
 <i class="fa fa-lock"></i>
 </div>
 <div class="form-group">
     <div class="main-checkbox">
         <input type="checkbox" value="none" id="checkbox1" name="check"/>
         <label for="checkbox1"></label>
     </div>
     <span class="text">Remember me</span>
 </div>
  <div class="btn-group">
      <a href="/register" class="btn btn-default">REGISTRATION</a>
      <button type="submit" class="btn btn-default" formaction="login">ENTER</button>
  </div>
 </form>
 </div>
<script src="js/login.js"></script>
</body>
</html>

