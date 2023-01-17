
<%@page import="com.petSmile.utils.Utils"%>
<%@page import="com.petSmile.model.Agenda"%>
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
		List<Agenda> agendas = (List<Agenda>) request.getAttribute("listAgendas");
		%>

		<div class="text-right">
			<a id="add-agenda" class="btn btn-success" href="agenda?accion=add">Registrar
				nuevo</a>
		</div>

		<hr>

		<div class="table-responsive">
			<table class="table">
				<thead>
					<th>Mascota</th>
					<th>Dueño</th>
					<th>Fecha y hora</th>
					<th></th>
				</thead>
				<tbody>
					<%
					for (Agenda item : agendas) {
					%>
					<tr>
						<td><%=item.getMascota()%></td>
						<td><%=item.getDueno()%></td>
						<td><%=Utils.sdf.format(item.getFecha())%></td>
						<td class="text-right">
							<div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									id="dropdownMenuButton" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Opciones</button>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									<a class="dropdown-item"
										href="agenda?accion=delete&id=<%=item.getId()%>">Eliminar</a>
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
