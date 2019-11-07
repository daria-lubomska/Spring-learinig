<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="udemy.spring.util.Mappings" %>
<html>
<head>
    <title>Todo Application</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
    <div class="container">
        <div class="col-md-offset-1 col-md-10">
            <h3 class="text-center">Welcome TODO'S Application</h3>
            <hr/>
            <div class="panel panel-info">
                <div align="center" class="panel-heading">
                    <c:url var="itemsLink" value="${Mappings.TODO_ITEMS}" />
                    <a href="${itemsLink}">Show TODO items</a>
                </div>

            </div>
        </div>
    </div>
    <div class="footer">
        <h5 class="text-center">&copy; Copyright 2019 spring.learning.wildpig</h5>
    </div>
</body>
</html>