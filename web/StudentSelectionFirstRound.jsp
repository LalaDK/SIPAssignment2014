<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            $("#bla :checkbox").click(function() {
                if ($("#bla :checkbox:checked").length >= 4) {
                    $("#bla :checkbox:not(:checked)").attr("disabled", "disabled");
                } else {
                    $("#bla :checkbox").attr("disabled", "");
                }
            });
        </script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style1.css" rel="stylesheet">
        <title>First round</title>
    </head>
    <body>
        <div>
            <h1>First Round Subject Election</h1>
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">CPHBusiness</a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="/SIPAssignment2014/StudentSelectionFirstRound">First Round</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <h3>Select student:</h3>
            <select name="studentid" class="dropdown-students">
                <c:forEach var="student" items="${students}">
                    <option value="${student.PId}">${student.name}</option>
                </c:forEach>
            </select>
            <input value="Select student" type="button" id="selectStudent" class="btn btn-primary"/>
            <br />
            <h3>Pool A:</h3>
            <div id="subjects">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Teacher</th>
                        <th>Description</th>
                        <th>1 P.</th>
                        <th>2 P.</th>
                    </tr>
                    <c:forEach var="s" items="${subjects}">
                        <tr>
                            <td class="td-subject-id">${s.SId}</td>
                            <td>${s.subjectname}</td>
                            <td></td>
                            <td>${fn:substring(s.description,0,65)}...</td>
                            <td><input type="checkbox"></td>
                            <td><input type="checkbox"></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
