<%-- 
    Document   : bier
    Created on : 16-jun-2014, 11:32:08
    Author     : dev13
--%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <title>${bier.naam}</title>
        <link rel='stylesheet'
            href='${pageContext.servletContext.contextPath}/styles/default.css'>
    </head>
    <body>
        <jsp:include page="/WEB-INF/JSP/nav.jsp"/>
        <c:choose>
	        <c:when test="${not empty bier}">
	            <h1>${bier.naam}</h1>
	            <p>
	                <label>Alcohol</label>
	                <br/>${bier.alcohol} %
                </p>
                <p>
	                <label>Prijs</label>
	                <br/>€ ${bier.prijs}
                </p>
                <p>
	                <label>Soort</label>
	                <br/>${bier.soort.naam}
                </p>
                <p>
	                <label>Brouwer</label>
	                <br/>${bier.brouwer.naam}
	            </p>
            	<c:url var="url" value="/bieren"/>
 	            <form:form method="get" action='${url}' id="toevoegform" commandName="bestelbonlijn">
	 	            <form:label path='aantal'>Aantal:
	            	<form:errors path='aantal' cssClass='fout'/></form:label>
	            	<form:input path='aantal' autofocus='autofocus'/>
	                <form:input type="hidden" path="bier.bierNr" value="${bier.bierNr}"/>
	                <input type="submit" value="Toevoegen" id="toevoegknop"/> 
	            </form:form>
	            <span class="fout">${error}</span>
 	            <script>
	                document.getElementById('toevoegform').onsubmit= function() {
	                    document.getElementById('toevoegknop').disabled=true;
	                };
	            </script>
	        </c:when>
	        <c:otherwise>
	            <div>Bier niet gevonden</div>
	        </c:otherwise>
        </c:choose>
    </body>
</html>
