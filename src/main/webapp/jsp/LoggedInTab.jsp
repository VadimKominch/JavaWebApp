<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
 <head>
 <title>LoggedInTab</title>
 </head>
 <body>
           <ul class="nav navbar-nav ml-auto">
                 <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" data-toggle="dropdown">${user.nickName.value}</a>
                     <div class="dropdown-menu dropdown-menu-right">
                         <a href="/profile" class="dropdown-item">Profile</a>
                         <div class="dropdown-divider"></div>
                         <a class="dropdown-item" href="/logout">Logout</a>
                     </div>
                 </li>
             </ul>
 </body>
</html>