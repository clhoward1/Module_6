<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit Tank Record</title>
	</head>
	
	<body>
		<form action = "editTankServlet" method="post">
 	 Country: <input type ="text" name = "country" value= "${tankToEdit.country}">
  	 Tank Model: <input type = "text" name = "model" value= "${tankToEdit.model}">
  	 Gun Caliber: <input type = "text" name = "model" value= "${tankToEdit.model}">
			<input type = "hidden" name = "id" value="${tankToEdit.id}">
			<input type = "submit" value="Save Tank">
		</form>
	</body>
</html>