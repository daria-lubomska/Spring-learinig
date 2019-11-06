<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            <input type="button" value="Add Customer"
                   onclick="window.location.href='add-toDo-form'; return false;"
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
                            <th>Details</th>
                            <th>Deadline</th>
                        </tr>
                        <c:forEach var="items" items="${todos}">

                            <!-- construct an "update" link with todo request parameter -->
                            <c:url var="UPDATE" value="/todos/update-todo-form">
                                <c:param name="todoId" value="${items.id}"/>
                            </c:url>

                            <!-- construct an "delete" link with todo request parameter -->
                            <c:url var="DELETE" value="/todos/delete">
                                <c:param name="todoId" value="${items.id}"/>
                            </c:url>

                            <tr>
                                <td>${items.id}</td>
                                <td>${items.title}</td>
                                <td>${items.details}</td>
                                <td>${items.deadline}</td

                                <td>
                                    <!-- display the update link --> <a href="${DELETE}">Update</a>
                                    | <a href="${DELETE}"
                                         onclick="if (!(confirm('Are you sure you want to delete this todo item?'))) return false">DELETE</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <h5 class="text-center">&copy; Copyright 2019 spring.learning.damon</h5>
    </div>
</body>
</html>