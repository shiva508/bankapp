<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Uiew</title>
<spring:url var="jquery" value="components/js/jquery.min.js"></spring:url>
<spring:url var="bootstrapminjs" value="components/js/bootstrap.min.js"></spring:url>
<spring:url var="bootstrapjs" value="components/js/bootstrap.js"></spring:url>
<spring:url var="bootstrapdatepickerjs"
	value="components/js/bootstrap-datepicker.js"></spring:url>
<spring:url var="jqueryuijs" value="components/js/jquery-ui.js"></spring:url>
<spring:url var="jquerydataTablesminjs"
	value="components/js/jquery.dataTables.min.js"></spring:url>
<spring:url var="select2minjs" value="components/js/select2.min.js"></spring:url>
<spring:url var="sweetalertminjs"
	value="components/js/sweetalert.min.js"></spring:url>

<spring:url var="bootstrapthemecss"
	value="components/css/bootstrap-theme.css"></spring:url>
<spring:url var="bootstrapthememincss"
	value="components/css/bootstrap-theme.min.css"></spring:url>
<spring:url var="bootstrapcss" value="components/css/bootstrap.css"></spring:url>
<spring:url var="bootstrapcssmap"
	value="components/css/bootstrap.css.maps"></spring:url>
<spring:url var="bootstrapmincss"
	value="components/css/bootstrap.min.css"></spring:url>
<spring:url var="dataTablesbootstrapcss"
	value="components/css/dataTables.bootstrap.css"></spring:url>
<spring:url var="datepickercss" value="components/css/datepicker.css"></spring:url>
<spring:url var="select2mincss" value="components/css/select2.min.css"></spring:url>
<script src="${jquery}" type="text/javascript"></script>
<script src="${bootstrapminjs}" type="text/javascript"></script>
<script src="${bootstrapjs}" type="text/javascript"></script>
<script src="${bootstrapdatepickerjs}" type="text/javascript"></script>
<script src="${jqueryuijs}" type="text/javascript"></script>
<script src="${jquerydataTablesminjs}" type="text/javascript"></script>
<script src="${select2minjs}" type="text/javascript"></script>
<script src="${sweetalertminjs}" type="text/javascript"></script>

<link href="${bootstrapthemecss}" rel="stylesheet" type="text/css" />
<link href="${bootstrapthemecssmap}" rel="stylesheet" type="text/css" />
<link href="${bootstrapthememincss}" rel="stylesheet" type="text/css" />
<link href="${bootstrapcss}" rel="stylesheet" type="text/css" />
<link href="${bootstrapmincss}" rel="stylesheet" type="text/css" />
<link href="${dataTablesbootstrapcss}" rel="stylesheet" type="text/css" />
<link href="${datepickercss}" rel="stylesheet" type="text/css" />
<link href="${select2mincss}" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="container">
		<div class="row">
			<h1>Update user</h1>
		</div>
		<div class="row">
			<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFirstName">User Id</label> <c:out value="${user.userId}"></c:out>
					</div>
				</div>
				<form:hidden path="userId"/>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFirstName">First Name</label> <c:out value="${user.firstName}"></c:out>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputLastName">Last Name</label> <c:out value="${user.lastName}"></c:out> 
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Father Name</label><c:out value="${user.fatherName}"></c:out> 
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Mother Name</label> <c:out value="${user.motherName}"></c:out> 
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Adhar Number</label><c:out value="${user.adharNumber}"></c:out>  
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputFatherName">Phone Number</label><c:out value="${user.phoneNumber}"></c:out>   
					</div>
				</div>

				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <c:out value="${user.email}"></c:out>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label><c:out value="${user.password}"/>
							
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
					<label for="exampleInputPassword1">Gender</label> <c:out value="${user.gender}"></c:out>
					</div>
				</div>
				
				
			
		</div>
	</div>
</body>
</html>