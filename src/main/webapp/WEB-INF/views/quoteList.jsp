<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<c:url var="root_url" value="/"/>
<div class="container">
    <div class="table-header">
        <c:set var="p">${numberRandomQuote}</c:set>

        <td><c:out value="${quoteList.get(p).text}"/></td>

    </div>

    <div class="table-wrapper">
        <%--<sf:form method="post" id="quoteForm" action="/upVote">--%>

            <table class="list-table">
                <tbody>


                    <td>Top <c:out value="${quoteList.get(p).quoterId}"/> quote - <c:out value="${quoteList.get(p).upvote + quoteList.get(p).downvote}"/></td>
                        <td><a href="${root_url}upVote?id=<c:out value="${quoteList.get(p).quoterId}"/>&sign=1"
                               class="create-btn btn-danger">+</a></td>
                        <td><a href="${root_url}upVote?id=<c:out value="${quoteList.get(p).quoterId}"/>&sign=-1"
                               class="create-btn btn-danger">-</a>
                        </td>
                        <td><a href="#"> Posted</a></td>

                </tbody>

            </table>

            <div class="table-header">
                <c:out value="${quoteList.get(p).text}"/>
            </div>


            <table class="list-table">
            <tbody>
            <c:forEach items="${quoteList}" var="list" step="1" varStatus="loopStatus">
                <tr class="${loopStatus.index % 2 == 0 ? 'alt' : ''}">
                    <td>Top <c:out value="${list.quoterId}"/> quote - <c:out value="${list.upvote + list.downvote}"/></td>
                    <td><a href="${root_url}upVote?id=<c:out value="${list.quoterId}"/>&sign=1"
                           class="create-btn btn-danger">+</a></td>
                    <td><a href="${root_url}upVote?id=<c:out value="${list.quoterId}"/>&sign=-1"
                           class="create-btn btn-danger">-</a>
                    </td>
                    <td><a href="#"> Posted</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <%--</sf:form>--%>
    </div>
</div>