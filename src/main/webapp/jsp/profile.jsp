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
       <link href="css/ads.css" rel="stylesheet">

      </head>

       <body>
       <a href = "#">Show info</a>
       <a href = "#">Show my advertisments</a>
       <h1>${user.nickName}</h1>
       <h1>${user.firstName}</h1>
       <h1>${user.lastName}</h1>
       <h1>${user.role}</h1>
       <h1>${user.login}</h1>
       <h1>${user.email}</h1>
        <mytag:TimeTagDescription/>
       //insert for tag
                   <c:choose>
                       <c:when test="${userName!=null}">
                           ${userName}
                       </c:when>
                       <c:otherwise>
                          null
                       </c:otherwise>
                   </c:choose>
       <br>
       <a href="get_page?page=main">To main</a>
       <br>
       <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Create new Ads</button>
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
               <form method="POST">
                 <div class="form-group">
                   <label for="name" class="col-form-label">Advertisment name:</label>
                   <input type="text" class="form-control" id="name" name="Name">
                 </div>
                 <div class="form-group">
                      <label for="Category" class="col-form-label">Category:</label>
                      <select name="Category" id="Category">
                           <option selected value="Select1">Select1</option>
                           <option value="Select2">Select2</option>
                           <option value="Select3">Select3</option>
                           <option value="Select4">Select4</option>
                      </select>
                 </div>
                 <div class="form-group">
                   <label for="text" class="col-form-label">Message:</label>
                   <textarea class="form-control" id="text" name="Text"></textarea>
                 </div>
                 <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary" formaction= "add_adv">Send message</button>
                 </div>
               </form>
             </div>

           </div>
         </div>
       </div>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
       </body>
       </html>