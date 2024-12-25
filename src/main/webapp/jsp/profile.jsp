<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="mytag" uri="customtags" %>
       <!DOCTYPE html>
       <html>
       <head>
       <meta charset="utf-8">
       <title>My Page</title>
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
       <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
       <link href="../css/ads.css" rel="stylesheet">

      </head>

       <body>
       <a href = "#">Show info</a>
       <a href = "#">Show my advertisements</a>
       <h2>userName: ${user.nickName.value}</h1>
       <h2>firstName: ${user.firstName.value}</h1>
       <h2>lastName: ${user.lastName.value}</h1>
        <mytag:TimeTagDescription/>
       <br>
       <a href="/main">To main</a>
       <br>
       <button type="button" class="btn btn-primary open-modal-cls" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Create new Ads</button>
       <br>

       <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog" role="document">
           <div class="modal-content">
             <div class="modal-header">
               <h5 class="modal-title" id="exampleModalLabel">New advertisment</h5>
               <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                 <span aria-hidden="true">&times;</span>
               </button>
             </div>
             <div class="modal-body">
               <form method="POST" class="ads-form" action="advertisement">
                 <div class="form-group">
                   <label for="name" class="col-form-label">Advertisement name:</label>
                   <input type="text" class="form-control" id="name" name="name">
                 </div>
                 <div class="form-group">
                      <label for="category" class="col-form-label">Category:</label>
                      <select name="category" id="category">

                      </select>
                 </div>
                 <div class="form-group">
                   <label for="text" class="col-form-label">Message:</label>
                   <textarea class="form-control" id="text" name="text"></textarea>
                 </div>
                 <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Send message</button>
                 </div>
               </form>
             </div>

           </div>
         </div>
       </div>
       <script src = "../js/profile.js"></script>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
       </body>
       </html>