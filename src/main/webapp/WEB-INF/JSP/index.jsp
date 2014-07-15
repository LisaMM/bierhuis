<%-- 
    Document   : index
    Created on : 16-jun-2014, 11:03:40
    Author     : dev13
--%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <title>Welkom in het huis van de Belgische bieren</title>
        <link rel='stylesheet'
            href='${pageContext.servletContext.contextPath}/styles/default.css'>
    </head>
    <body>
        <jsp:include page="nav.jsp"/>
        <h1>Welkom in het huis van de Belgische bieren</h1>
        <img src='<c:url value='/images/bierhuis.jpg'/>' alt='bierhuis'>
        <p>
            We hebben momenteel ${aantalBieren} bieren.
        </p>
    </body>
</html>
