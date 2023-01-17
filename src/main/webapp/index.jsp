
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>        
        <%@include file="./template/menu.jsp" %>

        <div class="container mt-3">
            <h3>LOGIN</h3>
            <hr>

            <%@include file="../template/message.jsp" %>

            <form action="usuario" method="POST">
                <div class="form-group">                        
                    <div class="col-md-8">
                        <label>Username <b class="text-danger">*</b></label>
                        <input class="form-control" type="text" id="username" name="username"/>
                    </div>
                </div>  
                <div class="form-group">                        
                    <div class="col-md-8">
                        <label>Password <b class="text-danger">*</b></label>
                        <input class="form-control" type="password" id="password" name="password"/>
                    </div>
                </div> 
                <div class="col-md-8">
                    <input class="btn btn-primary" type="submit" id="login" name="accion" value="Login"/>
                </div>
            </form>
        </div>
    </body>
</html>
