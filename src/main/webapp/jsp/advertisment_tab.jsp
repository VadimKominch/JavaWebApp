<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" uri="customtags" %>
  <div class="blog-post">
    <div class="blog-content">
      <h2 class="blog-post-title">${param.name}</h2>
      <p class="blog-post-meta"><custom:Time date="${param.date}"/></p>

      <p class="text-primary"><custom:Author authorId="${param.author}"/></p>
      <p class="text-break">${param.text}</p>
      <div class="">
        <p>
            Category : <a href="#"><span class="badge badge-info"><custom:Category categoryId="${param.category}"/></span></a>
        </p>
      </div>
    </div>
    <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
        <c:if test="${user != null && user.id.value != param.author}">
           <button class="btn btn-primary ads-edit-btn mx-1"><a href="/conversation?target_id=${param.author}">Write</a></button>
        </c:if>
        <c:if test="${param.isEditable}">
           <button class="btn btn-primary ads-edit-btn mx-1"><a href="/get_adv?id=${param.id}">Edit</a></button>
        </c:if>
        <c:if test="${param.isDeletable}">
            <button class="btn btn-primary ads-edit-btn mx-1"><a href="/delete_adv?id=${param.id}">Delete</a></button>
        </c:if>
    </div>
  </div>
  <hr>