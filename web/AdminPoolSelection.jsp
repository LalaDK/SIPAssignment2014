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
        <link rel="stylesheet" href="source/jquery.fancybox.css" type="text/css" media="screen" />
        <script type="text/javascript" src="source/jquery.fancybox.pack.js"></script>

        <script>
            $(document).ready(function(data) {
                drawChart();
                getSatisfaction();
                $(".fancybox").fancybox();
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
                var chart = $('#chart-container').highcharts();
                chart.series[0].setData([data["very_satisfied"]]);
                chart.series[1].setData([data["satisfied"]]);
                chart.series[2].setData([data["above_average"]]);
                chart.series[3].setData([data["below_average"]]);
                chart.series[4].setData([data["unsatisfied"]]);
                chart.series[5].setData([data["very_unsatisfied"]]);
            }

            function drawChart() {
                $('#chart-container').highcharts({
                    chart: {
                        type: 'column'
                    },
                    plotOptions: {
                        series: {
                            events: {
                                legendItemClick: function(event) {
                                    alert();
                                    return false;
                                }
                            }
                        }
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
                        },
                        allowDecimals: false
                    },
                    series: [{
                            name: 'Very Satisfied',
                            data: [0],
                            color: '#00FF00'

                        }, {
                            name: 'Satisfied',
                            data: [0],
                            color: '#BFFF00'
                        }, {
                            name: 'Above Average',
                            data: [0],
                            color: '#FFFF00'
                        }, {
                            name: 'Below Average',
                            data: [0],
                            color: '#FFBF00'
                        }, {
                            name: 'Unsatisfied',
                            data: [0],
                            color: '#FF8000'
                        }, {
                            name: 'Very Unsatisfied',
                            data: [0],
                            color: '#FF0000'
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
            <a class="fancybox" href="#data">Test</a>
            <div style="display:none"><div id="data"></div></div>
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
                            <li class="active"><a href="AdminPoolSelection">Pool Administration</a></li>
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
                        <c:set var="votes" value="${s.voteCollection}"></c:set>
                        <td class="td-subject-votes">${fn:length(votes)}</td>
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
