<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/recursos" var="urlrecursos"></spring:url>
<link href="${urlrecursos}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>












<div class="container" style="max-width: 400px">
<h2>Lista de Usuarios</h2>
<br>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Crear usuario
</button>

<!-- Modal -->
     <form method="post" action="save">

<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      
     <div class="form-group">
      <label for = "nomuser">Usuario: </label>
      <input path="nomuser" name="usu" class="form-control"/>
     </div>
     <div class="form-group">
      <label for = "clave">Contraseña: </label>
		<input type="text" path="clave" name="pass"  class="form-control" />
     </div>
     
    
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      <input type="submit" value="Guardar" class="btn btn-success"/>
      </div>
    </div>
  </div>
</div>

    </form>

<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Usuario</th>
      <th scope="col">Clave</th>
      <th scope="col">Estado</th>
     <th scope="col">Botones</th>
      
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${lista}" var="user">
    <tr>
      <th scope="row">1</th>
      <td>${user.nomuser}</td>
      <td>${user.clave}</td>
      <td>${user.estado}</td>
      <td><a href="delete/${user.iduser}">Delete</a></td>
            <td><a href="read/${user.iduser}" ><button   type="button" value="${user.iduser}" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal1">Modificar</button></a></td>
      

    </tr>
</c:forEach>
  </tbody>
</table>
</div>



<!-- Button trigger modal -->


<!-- Modal -->
     <form method="post" action="save">

<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
      
      
      
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      <input type="submit" value="Guardar" class="btn btn-success"/>
      </div>
      
    </div>
  </div>
</div>

    </form>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
<script type="text/javascript" src="${urlrecursos}/js/bootstrap.min.js"></script>

</body>
</html>