<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="mytag" uri="customtags" %>
       <!DOCTYPE html>
       <html>
       <head>
       <meta charset="utf-8">
       <title>Users</title>
       <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
       <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
       <link href="css/ads.css" rel="stylesheet">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
       </head>

       <body>
       <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <a class="navbar-brand" href="#">LOGO</a>
         <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" data-toggle="dropdown">Categories</a>
                     <div class="dropdown-menu dropdown-menu-right">
                         <a href="get_page?page=profile" class="dropdown-item">Profile</a>
                         <a class="dropdown-item" href="logout">Logout</a>
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
            <c:choose>
                <c:when test="${userName!=null}">
                    <c:import url="LoggedInTab.jsp"/>
                </c:when>
                <c:otherwise>
                    <c:import url="LoginTab.jsp"/>
                </c:otherwise>
            </c:choose>

             </ul>
       </nav>

       <main role="main" class="container">
             <div class="row">
               <div class="col-md-8 blog-main">
               <c:forEach var="advertisment" items="${advertismentList}">
                   <jsp:include page="advertisment_tab.jsp" flush="true">
                   <jsp:param name="name" value="${advertisment.name}" />
                   <jsp:param name="date" value="${advertisment.date}" />
                   <jsp:param name="author" value="${advertisment.author}" />
                   <jsp:param name="text" value="${advertisment.text}" />
                   <jsp:param name="category" value="${advertisment.category}" />
                   </jsp:include>
               </c:forEach>

            <nav aria-label="...">
              <ul class="pagination justify-content-center">
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                  </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item">
                  <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                  </a>
                </li>
              </ul>
            </nav>
        </div>

        <aside class="col-md-4 blog-sidebar">
                <div class="card my-4 p-3">
                    <h5 class="card-header">Search</h5>
                    <div class="card-body">
                      <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn">
                          <button class="btn btn-secondary" type="button">Go!</button>
                        </span>
                      </div>
                    </div>
                  </div>



          <div class="p-3">
            <h4 class="font-normal">Archives</h4>
            <ol class="list-unstyled mb-0">
              <li><a href="#">March 2014</a></li>
              <li><a href="#">February 2014</a></li>
              <li><a href="#">January 2014</a></li>
              <li><a href="#">December 2013</a></li>
              <li><a href="#">November 2013</a></li>
              <li><a href="#">October 2013</a></li>
              <li><a href="#">September 2013</a></li>
              <li><a href="#">August 2013</a></li>
              <li><a href="#">July 2013</a></li>
              <li><a href="#">June 2013</a></li>
              <li><a href="#">May 2013</a></li>
              <li><a href="#">April 2013</a></li>
            </ol>
          </div>

          <div class="p-3">
            <h4 class="font-normal">Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="#">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </aside>

      </div><!-- /.row -->

    </main><!-- /.container -->

    <footer class="blog-footer">
      <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/luckmoshy">luckmoshy</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
       </body>
       </html>