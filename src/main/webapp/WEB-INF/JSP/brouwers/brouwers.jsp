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
        <jsp:include page="nav.jsp"/>
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
