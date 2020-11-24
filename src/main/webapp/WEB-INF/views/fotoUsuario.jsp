<%-- 
    Document   : fotoUsuario
    Created on : 20 nov. 2020, 21:59:41
    Author     : Adminfoco
--%>
<%@page import="java.util.Base64"%> 
<%@page import="edu.cibertec.capitulo4.entity.UsuarioEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foto de usuario</title>
    </head>
    <body>
        <h1>Foto del Usuario</h1>         
        <% if (request.getAttribute("usuario") == null                     
                || ((UsuarioEntity) request.getAttribute("usuario")).getFoto() == null) { %>         
        <h2>Usuario aún sin foto</h2> 
         <% } else {%>              
        <img src="<%= "data:image/jpeg;base64," +                       
                 Base64.getEncoder().encodeToString(((UsuarioEntity)                          
                         request.getAttribute("usuario")).getFoto())%>" />         
        <% } %>         
        <br />         
        <form method="post" action="fotoGrabar.htm" enctype="multipart/form-data">             
            <table>                 
                <tr>                     
                    <td>Selecciona foto: </td>                     
                    <td><input type="file" name="archivo"></td>                 
                </tr>                 
                <tr>                 
                </tr>                 
                <tr><td colspan="2" align="center">                         
                        <input type="submit" value="Subir foto en jpg"></td>                 
                </tr>             
            </table>             
            <input type="hidden" name="codigoUsuario"                     
                value="<%= ((UsuarioEntity) request.getAttribute("usuario")).getUsuario() %>">         
        </form>  
    </body>
</html>
