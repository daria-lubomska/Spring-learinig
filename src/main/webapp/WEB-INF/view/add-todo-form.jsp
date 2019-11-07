<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <div class="col-md-offset-2 col-md-7">
        <h3 class="text-center">TODO'S Management</h3>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Add TODO</div>
            </div>
            <div class="panel-body">
                <form:form action="save" cssClass="form-horizontal"
                           method="post" modelAttribute="toDoToProcess">

                    <!-- need to associate data from ModelAttribute with todo id -->
                    <form:hidden path="id" />

                    <div class="form-group">
                        <label for="title" class="col-md-3 control-label">Title</label>
                        <div class="col-md-9">
                            <form:input path="title" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="details" class="col-md-3 control-label">Details</label>
                        <div class="col-md-9">
                            <form:textarea path="details" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="deadline" class="col-md-3 control-label">Deadline</label>
                        <div class="col-md-9">

                            <form:input path="deadline" cssClass="form-control" placeholder="yyyy-MM-dd HH:mm"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>