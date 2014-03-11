<%-- 
    Document   : AdminPoolSelection
    Created on : 05-03-2014, 22:25:41
    Author     : Thomas
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery-1.11.0.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="http://code.highcharts.com/highcharts.js"></script>
        <script>
            $(document).ready(function(data) {
                getSatisfaction();
            });

            function getSatisfaction() {
                $.ajax({
                    url: "UpdateSatisfaction",
                    cache: false,
                    dataType: "json",
                    success: updateChart
                });
            }

            function poolsChanged(pool) {
                var subject = {id: pool.name, pool: pool.value};
                updatePool(subject);
                getSatisfaction();
            }

            function updatePool(subject) {
                $.ajax({
                    url: "SavePoolSelection",
                    data: subject,
                    async: false,
                    type: 'POST',
                    cache: false,
                    dataType: "json",
                });
            }

            function updateChart(data) {
                $('#chart-container').highcharts({
                    chart: {
                        type: 'column'
                    },
                    title: {
                        text: 'Student Satisfaction'
                    },
                    xAxis: {
                        categories: ['Satisfaction']
                    },
                    yAxis: {
                        title: {
                            text: 'Students'
                        }
                    },
                    series: [{
                            name: 'Very Satisfied',
                            data: [data["very_satisfied"]]
                        }, {
                            name: 'Satisfied',
                            data: [data["satisfied"]]
                        }, {
                            name: 'Above Average',
                            data: [data["above_average"]]
                        }, {
                            name: 'Below Average',
                            data: [data["below_average"]]
                        }, {
                            name: 'Unsatisfied',
                            data: [data["unsatisfied"]]
                        }, {
                            name: 'Very Unsatisfied',
                            data: [data["very_unsatisfied"]]
                        }]
                });
            }

        </script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style1.css" rel="stylesheet">
        <title>Subject Administration</title>
    </head>
    <body>
        <div>
            <h1>Subject Administration</h1>
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
                            <li class="active"><a href="/SIPAssignment2014/AdminPoolSelectionController">Pool Administration</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
            <!--TODO!! Iterate subjects and pools-->
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Votes</th>
                    <th colspan="3">Pool</th>
                </tr>
                <c:forEach var="s" items="${subjects}">
                    <tr>
                        <td class="td-subject-id">${s.SId}</td>
                        <td>${s.subjectname}</td>

                        <td>${fn:substring(s.description,0,65)}...</td>
                        <td class="td-subject-votes">0</td>
                        <td class="td-subject-pool">A:<input type="radio" onchange="poolsChanged(this)" name="${s.SId}" value="a" <c:if test="${s.pool == 'a'}">CHECKED</c:if>></td>
                        <td class="td-subject-pool">B:<input type="radio" onchange="poolsChanged(this)" name="${s.SId}" value="b" <c:if test="${s.pool == 'b'}">CHECKED</c:if>></td>
                        <td class="td-subject-pool">C:<input type="radio" onchange="poolsChanged(this)" name="${s.SId}" value="c" <c:if test="${s.pool == 'c'}">CHECKED</c:if>></td>
                        </tr>
                </c:forEach>
            </table>
            <div id="chart-container" style="width:100%; height:400px;"></div>
        </div>
    </body>
</html>
