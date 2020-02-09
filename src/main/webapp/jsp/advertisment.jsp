<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
       <html>
       <head>
           <meta charset="utf-8">
           <title>My profile</title>
           <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
           <link rel="stylesheet" href="https://bootswatch.com/4/simplex/bootstrap.min.css"/>
        </head>
        <body>
               <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
                <a class="navbar-brand" href="#">LOGO</a>
                 <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown">
                             <a class="nav-link dropdown-toggle" data-toggle="dropdown">Categories</a>
                             <div class="dropdown-menu dropdown-menu-right">
                                 <a class="dropdown-item" href="get_page?page=profile">Profile</a>
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


<div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">

                    <div class="card-body">
                        <div class="card-title mb-4">
                            <div class="d-flex justify-content-start">
                                <div class="userData ml-3">
                                    <h2 class="d-block" style="font-size: 1.5rem; font-weight: bold"><a href="javascript:void(0);">Some Name</a></h2>
                                    <h6 class="d-block">Video Uploads</h6>
                                    <h6 class="d-block">Blog Posts</h6>
                                </div>
                                <div class="ml-auto">
                                    <input type="button" class="btn btn-primary d-none" id="btnDiscard" value="Discard Changes" />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-12">
                                <ul class="nav nav-tabs mb-4" id="myTab" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="basicInfo-tab" data-toggle="tab" href="#basicInfo" role="tab" aria-controls="basicInfo" aria-selected="true">Basic Info</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="connectedServices-tab" data-toggle="tab" href="#connectedServices" role="tab" aria-controls="connectedServices" aria-selected="false">Advertisments</a>
                                    </li>
                                </ul>
                                <div class="tab-content ml-1" id="myTabContent">
                                    <div class="tab-pane fade show active" id="basicInfo" role="tabpanel" aria-labelledby="basicInfo-tab">


                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Full Name</label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                Jamshaid Kamran
                                            </div>
                                        </div>
                                        <hr />

                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Birth Date</label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                March 22, 1994.
                                            </div>
                                        </div>
                                        <hr />


                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Something</label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                Something
                                            </div>
                                        </div>
                                        <hr />
                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Something</label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                Something
                                            </div>
                                        </div>
                                        <hr />
                                        <div class="row">
                                            <div class="col-sm-3 col-md-2 col-5">
                                                <label style="font-weight:bold;">Something</label>
                                            </div>
                                            <div class="col-md-8 col-6">
                                                Something
                                            </div>
                                        </div>
                                        <hr />

                                    </div>
       <div class="tab-pane fade" id="connectedServices" role="tabpanel" aria-labelledby="ConnectedServices-tab">
       <p>
       <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Create new Ads</button>
       </p>
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
                                <button type="submit" class="btn btn-primary" formaction= "add_adv">Save</button>
                 </div>
               </form>
             </div>

           </div>
         </div>
       </div> <!--end of modal window-->
       <br>
                                         <div class="blog-post">
                                                      <h2 class="blog-post-title">ADS123</h2>
                                                      <p class="blog-post-meta">2020-05-08</p>
                                                      <p class="text-break">Скачки. Клиент делает Ставки разных видов (победа, первая тройка, аутсайдер, точное место и пр.) на Скачки. Букмекер устанавливает уровень выигрыша. Администратор управляет Пользователями, создает (изменяет) Скачки, а также фиксирует (random генерация) их результаты.
                                                      </p>
                                                      <div class="row">
                                                            <p>
                                                                Category : <a href="#"><span class="badge badge-info">Select1</span></a>
                                                            </p>
                                                      </div>
                                         </div>

                                         <div class="blog-post">
                                                       <h2 class="blog-post-title">ADS123</h2>
                                                       <p class="blog-post-meta">2020-05-08</p>
                                                       <p class="text-break">Скачки. Клиент делает Ставки разных видов (победа, первая тройка, аутсайдер, точное место и пр.) на Скачки. Букмекер устанавливает уровень выигрыша. Администратор управляет Пользователями, создает (изменяет) Скачки, а также фиксирует (random генерация) их результаты.
                                                       </p>
                                                       <div class="row">
                                                             <p>
                                                                 Category : <a href="#"><span class="badge badge-info">Select1</span></a>
                                                             </p>
                                                       </div>
                                          </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
         </body>
        </html>
