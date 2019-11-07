<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="udemy.spring.util.Mappings" %>
<%@ page import="udemy.spring.util.AttributeNames" %>
<html>
<head>
    <title>Todo Items</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"
          rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
    <div class="container">
        <div class="col-md-offset-1 col-md-10">
            <h3 class="text-center">TODO'S Management</h3>
            <hr/>

            <input type="button" value="Add TODO"
                   onclick="window.location.href='${Mappings.ADD_TODO_FORM}'; return false;"
                   class="btn btn-primary"/> <br/>
            <br/>
            <input type="button" value="HOME"
                        onclick="window.location.href='/todo-list'; return false;"
                        class="btn btn-primary"/> <br/>
            <br/>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">TODO List</div>
                </div>
                <div class="panel-body">
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>Id</th>
                            <th>Title</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach var="items" items="${todos}">
                            <c:url var="updateLink" value="${Mappings.UPDATE_TODO_FORM}">
                                <c:param name="${AttributeNames.TODO_ID}" value="${items.id}" />
                            </c:url>
                            <!-- construct an "delete" link with todo request parameter -->
                            <c:url var="deleteLink" value="delete">
                                <c:param name="${AttributeNames.TODO_ID}" value="${items.id}"/>
                            </c:url>
                            <c:url var="viewLink" value="${Mappings.VIEW_TODO}">
                                <c:param name="${AttributeNames.TODO_ID}" value="${items.id}" />
                            </c:url>

                            <tr>
                                <td>${items.id}</td>
                                <td>${items.title}</td>

                                <td>
                                    <!-- display the view/update/delete link -->
                                    <a href="${viewLink}">View</a> |
                                    <a href="${updateLink}">Update</a>
                                    | <a href="${deleteLink}"
                                         onclick="if (!(confirm('Are you sure you want to delete this todo item?'))) return false">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <h5 class="text-center">&copy; Copyright 2019 spring.learning.wildpig</h5>
    </div>
</body>
</html>