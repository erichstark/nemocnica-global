<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 4 MVC - HelloWorld Index Page</title>
<link type="text/css"
	href="<%=request.getContextPath() %>/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

<div class="container">
	<c:set var="msg" scope="session" value="Stranger"/>
  <h1>Hello <c:out value="${msg}"/>!</h1>
  <div class="row">
    <div class="col-sm-3 col-md-6 col-lg-4" style="background-color:lavender;">
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
      incididunt ut labore et dolore magna aliqua.</p>
      <p> Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
      aliquip ex ea commodo consequat.</p>
    </div>
    <div class="col-sm-9 col-md-6 col-lg-8" style="background-color:lavenderblush;">
      <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium
      doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore
      veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
    </div>
  </div>
  <div class="btn-group">
    <button type="button" class="btn btn-default btn-primary">Left</button>
    <button type="button" class="btn btn-default">Middle</button>
    <button type="button" class="btn btn-default">Right</button>
  </div>
</div>

<script src="<%=request.getContextPath() %>/js/jquery-1.11.2.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
</body>
</html>