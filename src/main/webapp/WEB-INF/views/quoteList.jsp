<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<c:url var="root_url" value="/"/>

<div class="container">
    <div class="row">
        <p></p>
    </div>

    <div class="col-sm-9">
        <div class="row">
            <div class="table-wrapper">
                <%--<c:set var="p">${numberRandomQuote}</c:set>--%>
                <blockquote>
                    <p><c:out value="${quoteRandom.text}"/></p>
                </blockquote>
            </div>
        </div>

        <div class="row">
            <p></p>
        </div>

        <div class="row">
            <div class="table-wrapper">
                <p> Top <c:out value="${quotePosted.quoterId}"/> quote - <c:out value="${quotePosted.upvote + quotePosted.downvote}"/></p>
                <div class="col-sm-1">
                    <a href="${root_url}upVote?id=<c:out value="${quotePosted.quoterId}"/>&sign=1&numberQuotePosted=<c:out value="${quotePosted.quoterId}"/>"
                       class="create-btn btn-danger">+</a>
                </div>
                <div class="col-sm-1">
                    <a href="${root_url}upVote?id=<c:out value="${quotePosted.quoterId}"/>&sign=-1&numberQuotePosted=<c:out value="${quotePosted.quoterId}"/>"
                       class="create-btn btn-danger">-</a>
                </div>
                <div class="col-sm-offset-11">
                    <a href="${root_url}list2?postedNumber=<c:out value="${quotePosted.quoterId}"/>"> Posted </a>
                </div>
                <p></p>
                <blockquote>
                    <p><c:out value="${quotePosted.text}"/></p>
                </blockquote>
            </div>
        </div>

        <div class="row">
            <p></p>
        </div>
        <div class="row">
            <div class="table-wrapper">
                      <c:forEach items="${quoteList}" var="list" step="1" varStatus="loopStatus">
                            <p> Top <c:out value="${list.quoterId}"/> quote - <c:out value="${list.upvote + list.downvote}"/></p>
                            <div class="col-sm-1">
                            <a href="${root_url}upVote?id=<c:out value="${list.quoterId}"/>&sign=1&numberQuotePosted=<c:out value="${quotePosted.quoterId}"/>"
                                   class="create-btn btn-danger">+</a>
                            </div>
                            <div class="col-sm-1">
                                <a href="${root_url}upVote?id=<c:out value="${list.quoterId}"/>&sign=-1&numberQuotePosted=<c:out value="${quotePosted.quoterId}"/>"
                                   class="create-btn btn-danger">-</a>
                            </div>
                            <div class="col-sm-offset-11">
                            <a href="${root_url}list2?postedNumber=<c:out value="${list.quoterId}"/>"> Posted </a>

                            </div>
                            <p></p>
                            <div class="row">
                                <p></p>
                            </div>
                      </c:forEach>

            </div>
        </div>

   </div>

    <div class="col-sm-3">
        <div class="table-wrapper">
            <b>  Hello </b>
        </div>
    </div>

    <div class="row">
        <p></p>
    </div>

       <%--</sf:form>--%>
    <%--</div>--%>

</div>