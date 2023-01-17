
<%@page import="com.petSmile.model.Mascota"%>
<%@page import="com.petSmile.model.Dueno"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../../template/menu.jsp" %>

        <div class="container mt-3 mb-5">
            <h3>DUEÑO: Registrar</h3>
            <hr>

            <%@include file="../../template/message.jsp" %>
            
            <% List<Mascota> mascotas = (List<Mascota>) request.getAttribute("listMascotas"); %>		 

            <form action="agenda" method="post">
                <div class="form-group">
                    <label for="">Mascota </label>
                    <select id="idMascota" name="idMascota" class="form-control" required>
                    <% for(Mascota item: mascotas){ %>
                    <option value="<%= item.getIdMascota() %>"><%=item %></option>
                    <%} %>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="">Fecha y Hora </label>
                    <input id="fecha" name="fecha" type="text" class="form-control" placeholder="yyyy-mm-dd hh:mm" required>
                </div>
                
                <input type="submit" class="btn btn-primary" id="registrar" name="accion" value="Registrar">
                <a class="btn btn-danger" href="agenda?accion=list">Cancelar</a>
            </form>
            

        </div>
    </body>
</html>
