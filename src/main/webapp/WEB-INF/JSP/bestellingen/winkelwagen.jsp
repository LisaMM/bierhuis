<%-- 
    Document   : winkelwagen
    Created on : 16-jun-2014, 11:45:51
    Author     : dev13
--%>

<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <title>Winkelwagen</title>
        <link rel='stylesheet'
            href='${pageContext.servletContext.contextPath}/styles/default.css'>
    </head>
    <body>
        <jsp:include page="/WEB-INF/JSP/nav.jsp"/>
        <h1>Winkelwagen</h1>
        <c:choose>
	        <c:when test="${not empty bestelbonlijnen}">
		        <table>
		            <thead>
		                <tr>
		                    <th>Bier</th>
		                    <th>Prijs</th>
		                    <th>Aantal</th>
		                    <th>Te betalen</th>
		                </tr>
		            </thead>
		            <tbody>
		                <c:forEach items="${bestelbonlijnen}" var="lijn">
		                    <tr>
		                        <td>${lijn.bier.naam}</td>
		                        <td>${lijn.bier.prijs}</td>
		                        <td>${lijn.aantal}</td>
		                        <td>${lijn.bier.prijs * lijn.aantal}</td>
		                    </tr>
		                </c:forEach>
		            </tbody>
		            <tfoot>
		            	<tr>
			            	<td>
			                	Totaal: ${totaal}
		                	</td>
	                	</tr>
		            </tfoot>
		        </table>
	        </c:when>
	        <c:otherwise>
	        	<p>U hebt momenteel nog geen bestellingen.</p>
	        </c:otherwise>
        </c:choose>
        <c:url value="/bestellingen/winkelwagen" var="url"/>
        <form:form method="post" action="${url}" id="bestelform" commandName="bestelbon">
            <form:label path='naam'>Naam:
            <form:errors path='naam' cssClass='fout'/></form:label>
            <form:input path='naam' autofocus='autofocus'/>
            <form:label path='adres.straat'>Straat:
            <form:errors path='adres.straat' cssClass='fout'/></form:label>
            <form:input path='adres.straat'/>
            <form:label path='adres.huisNr'>Huisnr.:
            <form:errors path='adres.huisNr' cssClass='fout'/></form:label>
            <form:input path='adres.huisNr' type='number'/>
            <form:label path='adres.postcode'>Postcode:
            <form:errors path='adres.postcode' cssClass='fout'/></form:label>
            <form:input path='adres.postcode' type='number'/>
            <form:label path='adres.gemeente'>Gemeente:
            <form:errors path='adres.gemeente' cssClass='fout'/></form:label>
            <form:input path='adres.gemeente'/>
            <input type="submit" value="Als bestelbon bevestigen" 
                id="bestelknop"/>
        </form:form>
        <script>
            document.getElementById('bestelform').onsubmit= function() {
                document.getElementById('bestelknop').disabled=true;
            };
        </script>
    </body>
</html>
