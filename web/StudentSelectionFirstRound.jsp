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
                $("#subjects").hide();
                $("#errorsubjectselection").hide();

                $('#selectStudent').click(function() {
                    $("#subjects").toggle("slow");
                    $("#selectStudent").prop("disabled", true);
                    $("#studentid").prop("disabled", true);
                });

                $(':checkbox').change(function() {
                    $(this).parent().siblings().children(':checkbox').attr('checked', false);
                    disableFirstCheckboxes();
                    disableSecondCheckboxes();
                });

                $("input[type=checkbox][name=firstpriority]").change(function() {
                    disableFirstCheckboxes();
                });
                $("input[type=checkbox][name=secondpriority]").change(function() {
                    disableSecondCheckboxes();
                });
            });

            function disableFirstCheckboxes() {
                var bol = $("input[type=checkbox][name=firstpriority]:checked").length >= 2;
                $("input[type=checkbox][name=firstpriority]").not(":checked").attr("disabled", bol);
            }

            function disableSecondCheckboxes() {
                var bol = $("input[type=checkbox][name=secondpriority]:checked").length >= 2;
                $("input[type=checkbox][name=secondpriority]").not(":checked").attr("disabled", bol);
            }

            function checkboxes() {
                if ($("input[type=checkbox][name=firstpriority]:checked").length < 2) {
                    $("#errorsubjectselection").toggle("slow");
                    return false;
                }
                if ($("input[type=checkbox][name=secondpriority]:checked").length < 2) {
                    $("#errorsubjectselection").toggle("slow");
                    return false;
                }
                $("#selectStudent").prop("disabled", false);
                $("#studentid").prop("disabled", false);
                return true;
            }
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
                            <li class="active"><a href="StudentSelectionFirstRound">First Round</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <form name="studenFirstRoundVote" action="StudentFirstRoundSaveVote" onsubmit="return checkboxes()">
                <h3>Select student:</h3>
                <select name="studentid" id="studentid" class="dropdown-students">
                    <c:forEach var="student" items="${students}">
                        <option value="${student.PId}">${student.name}</option>
                    </c:forEach>
                </select>
                <input value="Select student" type="button" id="selectStudent" class="btn btn-primary"/>
                <br />
                <div id="subjects">
                    <h3>Subjects:</h3>
                    <div id="errorsubjectselection" class="alert alert-danger">You have to select 2 first priorities and 2 second priorities</div>
                    <table class="table table-striped table-bordered">
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>1 P.</th>
                            <th>2 P.</th>
                        </tr>
                        <c:forEach var="s" items="${subjects}">
                            <tr>
                                <td class="td-subject-id">${s.SId}</td>
                                <td>${s.subjectname}</td>
                                <td>${fn:substring(s.description,0,65)}...</td>
                                <td><input type="checkbox" id="firstpriority" name="firstpriority" value="${s.SId}"></td>
                                <td><input type="checkbox" id="secondpriority" name="secondpriority" value="${s.SId}"></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input id="submitVotes" type="submit" value="Submit" class="btn btn-primary">
                </div>
            </form>
        </div>
    </body>
</html>
