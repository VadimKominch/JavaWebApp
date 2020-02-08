<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
 <head>
 <title>AdvertismentTab</title>
 </head>

<body>
  <div class="blog-post">
              <h2 class="blog-post-title">${param.name}</h2>
              <p class="blog-post-meta">${param.date}</p>
              <p><a href="#">${param.author}</a></p>
              <p class="text-break">${param.text}</p>
              <div class="row">
                    <p>
                        Category : <a href="#"><span class="badge badge-info">${param.category}</span></a>
                    </p>
              </div>
  </div>
  <hr>
</body>
</html>