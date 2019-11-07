<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="udemy.spring.util.Mappings" %>
<%@ page import="udemy.spring.util.AttributeNames" %>
<!DOCTYPE html>
<html>
<head>
    <title>TODOs</title>
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
        <input type="button" value="BACK"
               onclick="window.location.href='${Mappings.TODO_ITEMS}'; return false;"
               class="btn btn-primary"/> <br/>
        <br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">VIEW TODO</div>
            </div>
            <div class="panel-body">
                <table class="table table-responsive-lg table-striped table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Details</th>
                        <th>Deadline</th>
                        <th>Action</th>
                    </tr>
                        <c:url var="updateLink" value="${Mappings.UPDATE_TODO_FORM}">
                            <c:param name="${AttributeNames.TODO_ID}" value="${todo.id}" />
                        </c:url>
                        <!-- construct an "delete" link with todo request parameter -->
                        <c:url var="deleteLink" value="delete">
                            <c:param name="${AttributeNames.TODO_ID}" value="${todo.id}"/>
                        </c:url>
                        <c:url var="backLink" value="${Mappings.TODO_ITEMS}">
                        </c:url>

                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.title}</td>
                            <td>${todo.details}</td>
                            <td>${todo.deadline}</td>

                            <td>
                                <!-- display the update link -->
                                <a href="${updateLink}">Update</a>
                                | <a href="${deleteLink}"
                                     onclick="if (!(confirm('Are you sure you want to delete this todo item?'))) return false">Delete</a>
                            </td>
                        </tr>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>