<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



		<jsp:include page="../template_superior.jsp"></jsp:include>
		
		<h2>Formulario alta de reclamo</h2>
		<form:form action="/reclamos/guardar" method="post" id="formReclamo" modelAttribute="reclamoForm">
		
			<div class="row">

		<div class="col-md-6">	
			<div class="mb-3">
			  <label class="form-label">Id</label>
			  <form:input cssClass="form-control" path="id" readonly="true"/>
			</div>
		
			<div class="mb-3">
			  <label class="form-label">Titulo</label>
			  <form:input cssClass="form-control required" path="titulo"/>
			  <form:errors path="titulo"></form:errors>
			</div>
		
			<div class="mb-3">
			  <label class="form-label">Descripcion</label>
			  <form:textarea cssClass="form-control required " path="descripcion" rows="5" cols="15" />
			  <form:errors path="descripcion"></form:errors>
			</div>
		
		
			<button class="btn btn-primary" id="buttonEnviar" type="button">Enviar</button>
			
			<button class="btn btn-warning" id="buttonCancelar" type="button">Cancelar</button>
		</div>
	
	
	
	</div>
	<script>
		$(document).ready(function() {
			
			$('#buttonEnviar').on('click', function() {
				//if($('#formReclamo').valid() == true) {
					$('#formReclamo').submit();
				//} else {
				//	bootbox.alert('For favor completar los campos que faltan....');
				//}
			});
			
			$('#buttonCancelar').on('click', function(){
				history.back()}
				);
		});
	</script>

</form:form>
		
		<jsp:include page="../template_inferior.jsp"></jsp:include>
