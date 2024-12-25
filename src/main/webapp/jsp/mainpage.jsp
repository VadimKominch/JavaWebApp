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
       <link href="../css/ads.css" rel="stylesheet">
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
       <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
       </head>

       <body>
       <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <a class="navbar-brand" href="/main">LOGO</a>
         <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" data-toggle="dropdown">Categories</a>
                     <div class="dropdown-menu dropdown-menu-right">
                        <c:forEach var="category" items="${categories}">
                            <a href="#" class="dropdown-item">${category.name.value}</a>
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

       <main role="main" class="container">
             <div class="row">
               <div class="col-md-12">
               <c:forEach var="advertisement" items="${advertisementList}">
                   <jsp:include page="advertisment_tab.jsp" flush="true">
                   <jsp:param name="name" value="${advertisement.title.value}" />
                   <jsp:param name="date" value="${advertisement.createdDate.value}" />
                   <jsp:param name="author" value="${advertisement.authorId.value}" />
                   <jsp:param name="text" value="${advertisement.body.value}" />
                   <jsp:param name="category" value="Common" />
                   </jsp:include>
               </c:forEach>

            <nav aria-label="...">
              <ul class="pagination justify-content-center">
                <li class="page-item">
                  <a class="page-link" href="/main?pageNumber=${currentPageNumber-1<1?1:currentPageNUmber+1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                    <span class="sr-only">Previous</span>
                  </a>
                </li>
                <li class="page-item"> <a class="page-link" href="javascript:void(0)">${currentPageNumber}</li></a>
                <li class="page-item">
                  <a class="page-link" href="/main?pageNumber=${currentPageNumber+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                    <span class="sr-only">Next</span>
                  </a>
                </li>
              </ul>
            </nav>
        </div>

      </div><!-- /.row -->

    </main><!-- /.container -->

    <footer class="blog-footer">
      <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/luckmoshy">luckmoshy</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
       </body>
       </html>