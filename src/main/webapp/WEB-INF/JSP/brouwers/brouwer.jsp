<%-- 
    Document   : brouwer
    Created on : 16-jun-2014, 11:28:44
    Author     : dev13
--%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <title>${brouwer.naam}</title>
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
        <c:when test="${not empty brouwer}">
            <h1>${brouwer.naam} (${brouwer.gemeente})</h1>
            <ul>
                <li><c:forEach items="${brouwer.bieren}" var="bier">
                    <spring:url var="url" value="/bieren/{bierNr}">
                        <spring:param name="bierNr" value="${bier.bierNr}"/>
                    </spring:url>
                    <a href="${url}">
                        ${bier.naam})
                    </a>
                </c:forEach></li>
            </ul>
        </c:when>
        <c:otherwise>
            <div>Brouwer niet gevonden</div>
        </c:otherwise>
    </body>
</html>
