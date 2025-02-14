<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.4/css/bootstrap.min.css" />
<link rel='stylesheet' type='text/css' href="css/registerpage.css"/>
</head>

<body>
<div class="container">
<div class="p-x-1 p-y-3 ">
 <form class="card card-block m-x-auto form-width register-form" action="register" method="POST">
 <legend class="m-b-1 text-xs-center">Регистрация</legend>
 <div class="form-group input-group">
 <span class="has-float-label">
 <label for="first">Имя</label>
 <input class="form-control firstName" id="first" type="text" placeholder="Имя" name="firstname" />
 </span>
 </div>
 <div class="form-group input-group">
 <span class="has-float-label">
 <label for="last">Фамилия</label>
 <input class="form-control lastName" id="last" type="text" placeholder="Фамилия" name="lastname"/>
 </span>
 </div>
  <div class="form-group input-group">
  <span class="has-float-label">
  <label for="last">NickName</label>
  <input class="form-control nickName" id="last" type="text" placeholder="Nickname" name="nickName"/>
  </span>
  </div>
 <div class="form-group input-group">
 <span class="has-float-label">
 <label for="email">E-mail</label>
 <input class="form-control email" id="email" type="email" placeholder="name@example.com" name="email"/>
 </span>
 </div>
  <div class="form-group input-group">
  <span class="has-float-label">
  <label for="login">Login</label>
  <input class="form-control login" id="login" type="login" name="login" class=""/>
  </span>
  </div>
 <div class="form-group input-group">
 <label for="password">Пароль</label>
 <input class="form-control password" id="password" type="password" placeholder="••••••••" name="password"/>
 </div>
 <div class="form-group input-group">
 <label for="password">Пароль повторно</label>
 <input class="form-control re-password" id="password" type="password" placeholder="••••••••"/>
 </div>
 <div class="text-xs-center">
 <button class="btn btn-block btn-primary" type="submit">Регистрация</button>
 </div>
 </form>
</div>
</div>
<script src = "js/register.js"></script>
</body>
</html>