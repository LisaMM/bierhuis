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
        <h1>Je winkelwagentje is bevestigd als bestelbon ${bestelbon.bonNr}</h1>
    </body>
</html>
