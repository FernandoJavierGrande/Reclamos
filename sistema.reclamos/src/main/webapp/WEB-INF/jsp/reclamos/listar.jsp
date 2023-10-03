<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2>Listado de reclamos</h2>

<table class ="table table-bordered table-striped table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Ttitulo</th>
			<th>Descripcion</th>
			<th></th>
		</tr>	
	</thead>
	<tbody>
		<c:forEach items="${reclamos}" var="reclamo">
			<tr>
				<td>${reclamo.id}</td>
				<td>${reclamo.titulo}</td>
				<td>${reclamo.descripcion}</td>
				<td>
					<a class="btn btn-primary" href="/reclamos/${reclamo.id}"> Ver</a>
					<a class="btn btn-warning" href="/reclamos/${reclamo.id}/editar">Editar</a>
					<a class="btn btn-danger" onclick="borrarReclamo(${reclamo.id})" href="#">Borrar</a>
				</td>
			
			</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	function borrarReclamo(idReclamo) {
		bootbox.confirm("Desea eliminar el reclamo n°: " + idReclamo, function(result) {
        	if(result == true) {
        		window.location = '/reclamos/borrar/' + idReclamo;
        	}
		});
	}
</script>

<jsp:include page="../template_inferior.jsp"></jsp:include>