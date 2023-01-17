
<%@page import="com.petSmile.model.Dueno"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<%@include file="../../template/menu.jsp"%>

	<div class="container mt-3 mb-5">
		<h3>DUEÑOS</h3>
		<hr>

		<%@include file="../../template/message.jsp"%>

		<%
		List<Dueno> duenos = (List<Dueno>) request.getAttribute("listDuenos");
		%>

		
		<div class="text-right">
			<a class="btn btn-success" href="dueno?accion=add">Registrar
				nuevo</a>
		</div>
		
		<hr>

		<div class="table-responsive">
			<table class="table">
				<thead>
					<th>Rut</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Dirección</th>
					<th>Correo</th>
					<th>Teléfono</th>
					<th></th>
				</thead>
				<tbody>
					<%
					for (Dueno item : duenos) {
					%>
					<tr>
						<td><%=item.getRut()%></td>
						<td><%=item.getNombre()%></td>
						<td><%=item.getApellido()%></td>
						<td><%=item.getDireccion()%></td>
						<td><%=item.getCorreo()%></td>
						<td><%=item.getTelefono()%></td>
						<td class="text-right">
							<div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									id="dropdownMenuButton" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Opciones</button>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									<a class="dropdown-item"
										href="dueno?accion=delete&rut=<%=item.getRut()%>">Eliminar</a>
								</div>
							</div>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

		</div>

	</div>
</body>
</html>
