<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<ul class="nav navbar-nav ml-auto">
     <li class="nav-item dropdown">
         <a class="nav-link dropdown-toggle" data-toggle="dropdown">${user.nickName.value}</a>
         <div class="dropdown-menu dropdown-menu-right">
             <a href="/profile-info" class="dropdown-item">Profile</a>
             <a href="/profile" class="dropdown-item">Advertisements</a>
             <a href="/conversation" class="dropdown-item">Messages</a>
             <div class="dropdown-divider"></div>
             <a class="dropdown-item" href="/logout">Logout</a>
         </div>
     </li>
 </ul>