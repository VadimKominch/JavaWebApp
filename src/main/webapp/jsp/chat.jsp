<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="customtags" %>

<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <title>Messages</title>
      <link href="../css/chat.css" rel="stylesheet">
      <link href="../css/ads.css" rel="stylesheet">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
       <c:import url="header.jsp"/>
        <div class="container">
            <div class="dialog-list">

                <c:forEach var="conversation" items="${conversation_list}">
                    <c:if test="${user != null && user.id.value == conversation.first.value}">
                       <div class="dialog">
                           <a href="/conversation?target_id=${conversation.second.value}">
                                <custom:Author authorId="${conversation.second.value}"/>
                           </a>
                       </div>
                    </c:if>
                    <c:if test="${user != null && user.id.value == conversation.second.value}">
                      <div class="dialog">
                          <a href="/conversation?target_id=${conversation.first.value}">
                               <custom:Author authorId="${conversation.first.value}"/>
                          </a>
                      </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="active-dialog">
                <input type="hidden" class="conv-id" value="${conversation_id}">
                <input type="hidden" class="sender-id" value="${user.id.value}">
                <div class="messages">
                    <c:forEach var="message" items="${messages}">
                        <div class="message">
                        <c:if test="${user != null && user.id.value != message.senderId}">
                            <p class ="incoming">${message.message}</p>
                        </c:if>
                        <c:if test="${user != null && user.id.value == message.senderId}">
                            <p class ="outgoing">${message.message}</p>
                        </c:if>
                        </div>
                    </c:forEach>
                </div>
                <div class="input-group mt-2">
                <input type="text" class="form-control txt-message w-75 mr-sm-5">
                <button class="btn btn-primary" type="submit">Submit</button>
            </div>
        </div>
        <script src="../js/chat.js"></script>
</body>
</html>