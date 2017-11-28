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
                         <a href="#">Enter</a>
                    </li>

             </ul>
             <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <%--Главная--%>
                    <li><a href="#">PROFILE</a></li>
                        <li><a href="/decathlon/listTOP10">TOP10</a></li>
                        <li><a href="/decathlon/listFLOP10">FLOP10</a></li>
                        <li><a href="/decathlon/list">ALL</a></li>
                        <li><a href="/decathlon/LAST">LAST</a></li>
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
            <li>Quotes</li>
        </ul>
    </div>
</div>
<!-- /Header -->


