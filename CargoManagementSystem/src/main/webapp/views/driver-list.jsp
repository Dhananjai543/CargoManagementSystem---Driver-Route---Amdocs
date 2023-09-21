<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver Record</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<!-- //cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css
 --><link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">


<script type="text/javascript">
$(document).ready(function () {
    $('#drvtab').DataTable({
        pagingType: 'full_numbers',
    });
});
</script>

</head>
<body>

<h3>Driver Record</h3>
<a href="/">AddDriver</a>
<table id="drvtab" class="table">
<thead class="thead-dark">
<tr>
<th>
Driver ID
</th>
<th>
Name
</th>
<th>
License Number
</th>
<th>
Age
</th>
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<tbody>

<c:forEach var="drv" items="${drivers}">
<tr>
<td>${drv.id}</td>
<td>${drv.name}</td>
<td>${drv.licenseNumber}</td>
<td>${drv.age}</td>

<td><a href="editDriver?id=${drv.id}">Edit</a></td>
<td><a href="deleteDriver?id=${drv.id}">Delete</a>

</tr>
</c:forEach>
</tbody>
</table>


</body>
</html>