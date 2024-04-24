<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Tank List</title>
	</head>
	
	<body>
	
	<h1>~~ List of Tanks ~~</h1>
	<p>-----------------------------------------------------</p>
		<form method="post" action="navigationServlet">
		
			<input type="submit" value="add" name="doToTank">
			<input type="submit" value="edit" name="doToTank">
			<input type="submit" value="delete" name="doToTank">
			
			<table>
				<h2>Country || Model || Caliber</h2>
				<c:forEach items="${requestScope.allTanks}" var="currenttank">
					<tr>
			 			<td><input type="radio" name="id" value="${currenttank.id}"></td>
			 			<td>|| ${currenttank.country}</td>
			 			<td>|| ${currenttank.model}</td>
			 			<td>|| ${currenttank.gunCaliber} ||</td>
			 		</tr>
			 		
				</c:forEach>
				
			</table>
		</form>
	</body>
</html>