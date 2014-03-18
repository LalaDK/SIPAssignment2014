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
            $(document).ready(function() {
                $(':radio').click(function() {
                    $(this).parent().siblings().children(':radio').attr('checked', false);
                });

                $('#selectStudent').click(function() {
                    $("#pools").toggle("slow");
                    $("#selectStudent").prop("disabled", true);
                    $("#studentid").prop("disabled", true);
                });

                $("#errorPoolA").hide();
                $("#errorPoolB").hide();
                $("#success").hide();
                $("#pools").hide();
            });

            function checkRadiobuttons() {
                $("#errorPoolA").hide();
                $("#errorPoolB").hide();
                if (!$("input[name='priority1poola']:checked").val()) {
                    $("#errorPoolA").toggle("slow");
                    return false;
                }
                if (!$("input[name='priority2poola']:checked").val()) {
                    $("#errorPoolA").toggle("slow");
                    return false;
                }
                if (!$("input[name='priority1poolb']:checked").val()) {
                    $("#errorPoolB").toggle("slow");
                    return false;
                }
                if (!$("input[name='priority2poolb']:checked").val()) {
                    $("#errorPoolB").toggle("slow");
                    return false;
                }
                else {
                    $("#errorPoolA").hide();
                    $("#errorPoolB").hide();
                    $("#pools").toggle("slow");
                    $("#selectStudent").prop("disabled", false);
                    $("#studentid").prop("disabled", false);
                    return true;
                }
            }
        </script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style1.css" rel="stylesheet">
        <title>Second round</title>
    </head>
    <body>
        <div>
            <h1>Second Round Subject Election</h1>
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
                            <li class="active"><a href="StudentSelectionSecondRound">Second Round</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <div id="success" class="alert alert-success">Votes saved successfully!</div>
            <form name="studenSecondRoundVote" action="StudentSecondRoundVote" onsubmit="return checkRadiobuttons()">
                <h3>Select student:</h3>
                <select name="studentid" id="studentid" class="dropdown-students">
                    <c:forEach var="student" items="${students}">
                        <option value="${student.PId}">${student.name}</option>
                    </c:forEach>
                </select>
                <input value="Select student" type="button" id="selectStudent" class="btn btn-primary"/>
                <br />
                <div id="pools">
                    <h3>Pool A:</h3>
                    <div id="errorPoolA" class="alert alert-danger">Please choose a first and a second priority in pool A!</div>
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>1 P.</th>
                            <th>2 P.</th>
                        </tr>
                        <c:forEach var="s" items="${asubjects}">
                            <tr>
                                <td class="td-subject-id">${s.SId}</td>
                                <td class="td-subject-name">${s.subjectname}</td>
                                <td>${fn:substring(s.description,0,65)}...</td>
                                <td class="td-vote-priority"><input type="radio" name="priority1poola" value="${s.SId}"></td>
                                <td class="td-vote-priority"><input type="radio" name="priority2poola" value="${s.SId}"></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <br/>
                    <h3>Pool B:</h3>
                    <div id="errorPoolB" class="alert alert-danger">Please choose a first and a second priority in pool B!</div>
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>1 P.</th>
                            <th>2 P.</th>
                        </tr>
                        <c:forEach var="s" items="${bsubjects}">
                            <tr>
                                <td class="td-subject-id">${s.SId}</td>
                                <td class="td-subject-name">${s.subjectname}</td>

                                <td>${fn:substring(s.description,0,65)}...</td>
                                <td class="td-vote-priority"><input type="radio" name="priority1poolb" value="${s.SId}"></td>
                                <td class="td-vote-priority"><input type="radio" name="priority2poolb" value="${s.SId}"></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input id="submitVotes" type="submit" value="Submit" class="btn btn-primary">
                    </form>
                </div>
        </div>
    </body>
</html>
