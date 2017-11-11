<%--
  Created by IntelliJ IDEA.
  User: AnTur
  Date: 11.11.2017
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<table class="list-table">
    <thead>
    <th>#</th>

    <th>НАЗВАНИЕ</th>

    <th>СОЗДАНО</th>


    </thead>
    <tbody>
    <c:forEach items="${quoteList}" var="list" step="1" varStatus="loopStatus">
        <tr class="${loopStatus.index % 2 == 0 ? 'alt' : ''}">

                <td><c:out value="${list.quoterId}"/></td>
                <td><a href="/department/${list.quoterId}"> <c:out value="${list.text}"/></a></td>
                <td><fmt:formatDate pattern = "dd-MM-yyyy HH:mm" value = "${list.createdDate}" /></td>


        </tr>
    </c:forEach>
    </tbody>
</table>


УРАААА
</body>
</html>
