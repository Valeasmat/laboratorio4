<%-- 
    Document   : usuarioLista
    Created on : 20 nov. 2020, 19:49:40
    Author     : Adminfoco
--%>

<%@page import="edu.cibertec.capitulo4.entity.UsuarioEntity"%> 
<%@page import="java.util.List"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">         
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>         
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
        <title>Mantenimiento de usuarios</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>         
        <br/>         
        <% List<UsuarioEntity> lista = (List<UsuarioEntity>)request.getAttribute("lista"); %>         
        <div class="table-responsive">
            <table class="table table-responsive table-sm table-dark table-striped table-bordered table-hover">             
                <thead>                 
                    <tr class="info">                     
                        <th>Usuario</th>                     
                        <th>Clave</th>                     
                        <th>Nombre completo</th> 
                        <th>Foto</th>
                    </tr>             
                </thead>             
                <tbody>                 
                    <% for (UsuarioEntity usuario:lista) {%>                 
                    <tr>                     
                        <td><%= usuario.getUsuario()%></td>                     
                        <td><%= usuario.getClave()%></td>                     
                        <td><%= usuario.getNombreCompleto()%></td>  
                        <td><a href="fotoMostrar.htm?codigoUsuario=<%= usuario.getUsuario()%>">foto</a></td>
                    </tr>                 
                    <% }%>             
                </tbody>         
            </table> 
        </div>
        <a href="usuarioCrear.htm" class="btn btn-primary btn-lg active">Crear Usuario</a>
        <h3>Se ha creado en esta sesion ${sessionScope.contador} usuarios!</h3>
    </body>
</html>
