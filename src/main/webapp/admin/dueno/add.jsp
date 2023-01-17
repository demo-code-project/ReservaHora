
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

            <form action="dueno" method="post">
                <div class="form-group">
                    <label for="">Rut </label>
                    <input name="rut" type="text" class="form-control" required>
                </div>
                
                <div class="form-group">
                    <label for="">Nombre </label>
                    <input name="nombre" type="text" class="form-control" required>
                </div>
                
                <div class="form-group">
                    <label for="">Apellido </label>
                    <input name="apellido" type="text" class="form-control" required>
                </div>                
                
                <div class="form-group">
                    <label for="">Dirección </label>
                    <input name="direccion" type="text" class="form-control" required>
                </div>                
                
                <div class="form-group">
                    <label for="">Correo </label>
                    <input name="correo" type="email" class="form-control" required>
                </div>                
                
                <div class="form-group">
                    <label for="">Teléfono </label>
                    <input name="telefono" type="text" class="form-control" required>
                </div>

                <div class="form-group">
                    <label for="">Nombre mascota </label>
                    <input name="nombreMascota" type="text" class="form-control">
                </div>
                
                <input type="submit" class="btn btn-primary" name="accion" value="Registrar">
                <a class="btn btn-danger" href="dueno?accion=list">Cancelar</a>
            </form>
            

        </div>
    </body>
</html>
