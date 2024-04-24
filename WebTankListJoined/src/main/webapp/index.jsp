<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="ISO-8859-1">
		<title>Tanks!</title>
	</head>

	<body>
	
		<h1><a href="viewTanksServlet">View Tanks</a></h1>
		
		
		
		<br>
		
		<h2>Tank Input</h2>
		
		<form action="addTankServlet" method="post">
			Country: <input type="text" name = "country">
			<br>
			Tank Model: <input type="text" name="model">
			<br>
			Gun Caliber: <input type="text" name="gunCaliber">
			<br>
			<input type="submit" value="Add Tank">
		</form>
		
		<br>
		
		<h2>Edit Tank</h2>
		
		<form action="editTankServlet" method="post">
		 	Country: <input type="text" name="country" value="${tankToEdit.country}">
		 	<br>
		  	Tank Model: <input type="text" name="model" value="${tankToEdit.model}">
		  	<br>
		  	Gun Caliber: <input type="text" name="gunCaliber" value="${tankToEdit.gunCaliber}">
		  	<br>
			<input type="hidden" name="id" value="${tankToEdit.id}">
			<input type="submit" value="Save Tank Edit">
		</form>
	</body>
</html>