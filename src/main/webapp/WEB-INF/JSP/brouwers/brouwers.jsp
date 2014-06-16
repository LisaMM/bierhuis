<%-- 
    Document   : brouwer
    Created on : 16-jun-2014, 11:17:29
    Author     : dev13
--%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <title>Brouwers</title>
        <link rel='stylesheet'
            href='${pageContext.servletContext.contextPath}/styles/default.css'>
    </head>
    <body>
        <nav class="zonderbolletjes">
            <ul>
                <li><a href="<c:url value='/'/>">Welkom</a></li>
                <li><a href="<c:url value='/brouwers'/>">
                    Bieren van een brouwer
                </a></li>
                <li><a href="<c:url value='/bestellingen/winkelwagen'/>">
                    Winkelwagen
                </a></li>
            </ul>
        </nav>
        <h1>Brouwers</h1>
        <ul>
            <li><c:forEach items="${brouwers}" var="brouwer">
                <c:url var="url" value="/brouwers">
                    <c:param name="brouwerNr" value="${brouwer.brouwerNr}"/>
                </c:url>
                <a href="${url}">
                    ${brouwer.naam} (${brouwer.gemeente})
                </a>
            </c:forEach></li>
        </ul>
    </body>
</html>
