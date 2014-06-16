<%-- 
    Document   : index
    Created on : 16-jun-2014, 11:03:40
    Author     : dev13
--%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <title>Welkom in het huis van de Belgische bieren</title>
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
        <h1>Welkom in het huis van de Belgische bieren</h1>
        <p>
            <img src='<c:url value='/images/bierhuis.jpg'/>' alt='bierhuis'>
            We hebben momenteel ${aantalBieren} bieren.
        </p>
    </body>
</html>
