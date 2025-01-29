<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <!DOCTYPE html>
       <html>
       <head>
            <meta charset="utf-8">
            <title>Ads of user ${user.nickName.value}</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
            <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

      </head>

       <body class="mh-100" style="height:100vh;">
       <c:import url="header.jsp"/>
       <main class="h-75 d-flex flex-column align-items-center">
           <form class="h-75 w-75 border mt-5 form" method="POST">
           <input type="hidden" class="user-id" value="${user.id.value}">
           <div class="mb-3 row mt-3">
               <label for="firstName" class="col-sm-2 col-form-label">FirstName</label>
               <div class="col-sm-10">
                 <input type="text" readonly class="form-control-plaintext border" id="firstName" value="${user.firstName.value}">
               </div>
             </div>
             <div class="mb-3 row">
                 <label for="lastName" class="col-sm-2 col-form-label">LastName</label>
                 <div class="col-sm-10">
                   <input type="text" readonly class="form-control-plaintext border" id="lastName" value="${user.lastName.value}">
                 </div>
               </div>
               <div class="mb-3 row">
                   <label for="nickName" class="col-sm-2 col-form-label">NickName</label>
                   <div class="col-sm-10">
                     <input type="text" class="form-control-plaintext border" id="nickName" value="${user.nickName.value}">
                   </div>
                 </div>
                 <button type="submit" class="btn btn-primary submit-btn">Submit</button>
            </form>

        <script src="http://localhost:8090/js/profile_info.js"></script>
       </body>
       </html>