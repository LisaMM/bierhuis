<%-- 
    Document   : bevestiging
    Created on : 16-jun-2014, 11:59:53
    Author     : dev13
--%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <title>Bevestiging</title>
        <link rel='stylesheet'
            href='${pageContext.servletContext.contextPath}/styles/default.css'>
    </head>
    <body>
        <jsp:include page="/WEB-INF/JSP/nav.jsp"/>
        <h1>Je winkelwagentje is bevestigd als bestelbon ${bonNr}</h1>
    </body>
</html>
