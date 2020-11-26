<%-- 
    Document   : usuarioLista
    Created on : 20 nov. 2020, 19:49:40
    Author     : Adminfoco
--%>

<%@page import="edu.cibertec.capitulo4.entity.UsuarioEntity"%> 
<%@page import="java.util.List"%> 
<%@page import="java.util.Base64"%>
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
            <table class="table table-responsive table-sm table-dark table-striped tablebordered table-hover">                 
                <thead>                     
                    <tr class="info">                         
                        <th><a href="usuarioListarPag.htm?pag=0&orden=usuario">Usuario</a></th>                         
                        <th><a href="usuarioListarPag.htm?pag=0&orden=clave">Clave</a></th>                         
                        <th><a href="usuarioListarPag.htm?pag=0&orden=nombreCompleto">Nombre completo</a></th>                         
                        <th>Foto</th>                         
                        <th>Eliminar</th>                     
                    </tr>                 
                </thead>                 
                <tbody>                     
                    <% for (UsuarioEntity usuario : lista) {%>                     
                    <tr>                         
                        <td><a href="usuarioMod.htm?codigoUsuario=<%= usuario.getUsuario()%>"><%= usuario.getUsuario()%></a></td>                         
                        <td><%= usuario.getClave()%></td>                         
                        <td><%= usuario.getNombreCompleto()%></td>                         
                        <td>                             
                            <% if (usuario.getFoto() != null && usuario.getFoto().length > 0) {%>                             
                            <img src="<%= "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(usuario.getFoto())%>" height="25" width="25" />                             
                            <% } else { %>                             
                            Sin foto                             
                            <% }%>                         
                        </td>                         
                        <td><a href="usuarioEli.htm?codigoUsuario=<%= usuario.getUsuario()%>">Eliminar</a></td>                     
                    </tr>                     
                    <% }%>                 
                </tbody>             
            </table>         
        </div>
        <br/>
         <a href="usuarioListarPag.htm?pag=0&orden=<%= request.getParameter("orden") %>">Primera página</a> &nbsp;&nbsp;         
         <a href="usuarioListarPag.htm?pag=1&orden=<%= request.getParameter("orden") %>">Segunda página</a>         
         <br/><br/>  
        <a href="usuarioCrear.htm" class="btn btn-primary btn-lg active">Crear Usuario</a>
        <h3>Se ha creado en esta sesion ${sessionScope.contador} usuarios!</h3>
    </body>
</html>
