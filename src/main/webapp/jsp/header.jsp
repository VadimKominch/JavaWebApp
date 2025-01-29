<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <a class="navbar-brand" href="/main">LOGO</a>
         <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" data-toggle="dropdown">Categories</a>
                     <div class="dropdown-menu dropdown-menu-right">
                        <c:forEach var="category" items="${categories}">
                            <a href="/advertisements?category=${category.id.value}" class="dropdown-item">${category.name.value}</a>
                        </c:forEach>
                     </div>
                 </li>
             <li class="nav-item">
               <a class="nav-link" href="#">Contacts</a>
             </li>
             <li class="nav-item">
               <a class="nav-link" href="#">About us</a>
             </li>
          </ul>
             <ul class="navbar-nav">
                 <li class="navbar-item">
                     <li class="nav-item dropdown">
                              <a class="nav-link dropdown-toggle" data-toggle="dropdown">language</a>
                              <div class="dropdown-menu dropdown-menu">
                              <c:forEach var="lang" items="${langs}">
                                <a href="#" class="dropdown-item">${lang}</a>
                              </c:forEach>
                              </div>
                          </li>
                 </li>
                 <li class = "nav-item">
                    <c:choose>
                        <c:when test="${user!=null}">
                            <c:import url="LoggedInTab.jsp"/>
                        </c:when>
                        <c:otherwise>
                            <c:import url="LoginTab.jsp"/>
                        </c:otherwise>
                    </c:choose>
                </li>
             </ul>
       </nav>