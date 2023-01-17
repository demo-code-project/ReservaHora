
<%@page import="com.petSmile.model.Mascota"%>
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
		List<Mascota> mascotas = (List<Mascota>) request.getAttribute("listMascotas");
		%>

		
		<div class="text-right">
			<a class="btn btn-success" href="mascota?accion=add">Registrar
				nuevo</a>
		</div>
		
		<hr>

		<div class="table-responsive">
			<table class="table">
				<thead>
					<th>Dueño</th>
					<th>Tipo mascota</th>
					<th>Edad</th>
					<th>Nombre</th>
					<th></th>
				</thead>
				<tbody>
					<%
					for (Mascota item : mascotas) {
					%>
					<tr>
						<td><%=item.getDueno()%></td>
						<td><%=item.getTipoMascota()%></td>
						<td><%=item.getEdad()%></td>
						<td><%=item.getNombreMascota()%></td>
						<td class="text-right">
							<div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									id="dropdownMenuButton" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Opciones</button>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									<a class="dropdown-item"
										href="mascota?accion=delete&id=<%=item.getIdMascota()%>">Eliminar</a>
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
