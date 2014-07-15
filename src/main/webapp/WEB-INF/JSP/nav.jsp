
<%@page contentType="text/html" pageEncoding="UTF-8" session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
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