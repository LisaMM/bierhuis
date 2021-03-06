<%-- 
    Document   : brouwer
    Created on : 16-jun-2014, 11:17:29
    Author     : dev13
--%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <title>Brouwers</title>
        <link rel='stylesheet'
            href='${pageContext.servletContext.contextPath}/styles/default.css'>
    </head>
    <body>
        <jsp:include page="/WEB-INF/JSP/nav.jsp"/>
        <h1>Brouwers</h1>
        <ul>
           <c:forEach items="${brouwers}" var="brouwer">
                <li><spring:url var="url" value="/brouwers/{brouwerNr}">
                    <spring:param name="brouwerNr" value="${brouwer.brouwerNr}"/>
                </spring:url>
                <a href="${url}">
                    ${brouwer.naam} (${brouwer.adres.gemeente})
                </a><li>
            </c:forEach>
        </ul>
    </body>
</html>
