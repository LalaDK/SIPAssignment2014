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
        <table class="table table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Votes</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>
                        <c:out value="${student}" />
                    </td>

                    <c:forEach var="vote" items="${student.votes}">
                        <td>
                            <c:out value="${vote}" />
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    </div>
</html>
