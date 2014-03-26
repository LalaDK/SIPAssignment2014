<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="js/jquery-1.11.0.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style1.css" rel="stylesheet">
    <div id="persontable">
        <table class="table table-striped table-bordered table-lightbox">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Vote</th>
                <th>Vote</th>
                <th>Vote</th>
                <th>Vote</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td class="td-subject-id">${student.pId}</td>
                    <td class="td-subject-name">${student.name}</td>
                    <c:forEach var="subject" items="${student.firstRoundFirstPriority}">
                        <td>${subject}</td>
                    </c:forEach>
                    <c:forEach var="subject" items="${student.firstRoundSecondPriority}">
                        <td>${subject}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </div>
</html>
