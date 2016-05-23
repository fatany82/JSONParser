<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSON Parser</title>
</head>
<body>
<form action="/Starmobile/JSONParserServlet" method="GET">
<c:if test="${not empty list}">
    <c:forEach var="item" items="${list}">
        <c:set var="viewType" scope="session" value="${item.viewType}"/>
        <c:set var="value" scope="session" value="${item.value}"/>
       <c:choose>
	    	<c:when test="${viewType.equals('editBox')}">
  			<br> <div> <input type="text" value="${value}"> </div><br>
	    	</c:when>
	    	<c:when test="${viewType.equals('button')}">
	    	<br><div> <button type="button" onclick="alert('Hello World!')"> ${value}</button></div><br>
	    	</c:when>
		    <c:when test="${viewType.equals('hyperlink')}"> 
		    	<br><div> <a href="${item.value}">${value}</a> </div><br>
		    </c:when>
		    <c:when test="${viewType.equals('checkbox') and value.equals('Selected')}">
				<br> <div> <input type="checkbox" name="checkbox" value="checkbox" checked> JSON Checkbox </div><br>
			</c:when> 
			 <c:when test="${viewType.equals('checkbox') and value.equals('NotSelected')}">
				 <br><div> <input type="checkbox" name="checkbox" value="checkbox"> JSON Checkbox </div><br>
		    </c:when>
		   	<c:when test="${viewType.equals('radioButton') and value.equals('Yes')}">
				<br><div> <input type="radio"  checked> Yes<br>
				 <input type="radio"> No </div><br>
			</c:when>
			<c:when test="${viewType.equals('radioButton') and value.equals('No')}">  
				<br><div><input type="radio"> Yes <br>
				     <input type="radio" checked> No </div>  <br>
		    </c:when>
	    	<c:otherwise>
	    	</c:otherwise>
		</c:choose>
    </c:forEach>
</c:if>
<br>
<br> 
<br>
<div> <input type="submit" value="Refresh" style="font-size:7pt;color:white;background-color:green;border:2px solid #336600;padding:3px" /> </div>
</form>


</body>
</html>