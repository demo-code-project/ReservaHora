
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
            
            <% List<Dueno> duenos = (List<Dueno>) request.getAttribute("listDuenos"); %>		 

            <form action="mascota" method="post">
                <div class="form-group">
                    <label for="">Dueño </label>
                    <select name="rutDueno" class="form-control" required>
                    <% for(Dueno item: duenos){ %>
                    <option value="<%= item.getRut() %>"><%=item %></option>
                    <%} %>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="">Tipo de mascota </label>
                    <input name="tipoMascota" type="text" class="form-control" required>
                </div>
                
                <div class="form-group">
                    <label for="">Edad </label>
                    <input name="edad" type="number" class="form-control" required>
                </div>                
                
                <div class="form-group">
                    <label for="">Nombre de mascota </label>
                    <input name="nombreMascota" type="text" class="form-control" required>
                </div> 
                
                <input type="submit" class="btn btn-primary" name="accion" value="Registrar">
                <a class="btn btn-danger" href="mascota?accion=list">Cancelar</a>
            </form>
            

        </div>
    </body>
</html>
