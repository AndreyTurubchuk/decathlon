<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<sec:authentication var="user" property="principal"/>


<!-- Header -->
<c:url var="root_url" value="/"/>
<nav class="navbar navbar-default navbar-static-top topnav header" role="navigation">
    <div class="container topnav">
        <!-- Brand and toggle get grouped for better mobile display -->
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">

                    <li>
                         <a href="${root_url}login">Enter</a>
                    </li>

             </ul>
             <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <%--Главная--%>
                    <li><a href="/">PROFILE</a></li>
                        <li><a href="/">TOP10</a></li>
                        <li><a href="/">FLOP10</a></li>
                        <li><a href="/">LAST</a></li>


 <%--                   <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                        <li class="dropdown">
                            &lt;%&ndash;Настройки&ndash;%&gt;
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><s:message code="settings"/><b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                &lt;%&ndash;Департаменты&ndash;%&gt;
                                <li><a href="/department/list"><s:message code="departments"/></a></li>
                                &lt;%&ndash;Пользователи&ndash;%&gt;
                                <li><a href="/users/list"><s:message code="users"/></a></li>
                                &lt;%&ndash;Типы запросов&ndash;%&gt;
                                <li><a href="/requestType/list"><s:message code="request_types"/></a></li>
                            </ul>
                        </li>
                    </sec:authorize>--%>
                </ul>
            </div>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="info-line">

    <div class="container topnav caption">
        <ul class="nav navbar-nav">
            <li>User</li>
        </ul>
    </div>
</div>
<!-- /Header -->


