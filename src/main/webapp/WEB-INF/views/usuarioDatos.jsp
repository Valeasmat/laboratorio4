<%-- 
    Document   : usuarioDatos
    Created on : 20 nov. 2020, 19:57:52
    Author     : Adminfoco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %> 
<!DOCTYPE html> 
<html>     
    <head>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>Datos del Usuario</title>         
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">         
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>         
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>         
        <style type="text/css">             
            .formFieldError { background-color: #FFC; }         
        </style>     
    </head>     
    <body>       
        <div class="container">             
            <div class="row d-flex justify-content-center mx-auto">
                <h1>Datos del usuario</h1>
                <div class="col-md-6 col-xs-12 div-style">
                     <mvc:form modelAttribute="usuarioBean" action="usuarioGrabar.htm" enctype="multipart/form-data">                          
                        <table>                             
                            <tr>                                 
                                <td><mvc:label  path="usuario">Usuario: </mvc:label></td>                                 
                                <td><mvc:input  path="usuario" cssErrorClass="form-control textbox formFieldError"                                              
                                    cssClass="form-control text-box" /></td>                                 
                                <td><mvc:errors path="usuario" /></td>                             
                            </tr>                             
                            <tr>                                 
                                <td><mvc:label  path="clave">Clave: </mvc:label></td>                                 
                                <td><mvc:input  path="clave" cssErrorClass="form-control text-box formFieldError"                                              
                                    cssClass="form-control text-box"/></td>                                 
                                <td><mvc:errors path="clave" /></td>                             
                            </tr>                             
                            <tr>                                 
                                <td><mvc:label  path="nombreCompleto">Nombre Completo: </mvc:label></td>                                 
                                <td><mvc:input  path="nombreCompleto" cssErrorClass="formcontrol text-box formFieldError"                                              
                                    cssClass="form-control text-box"/></td>                                 
                                <td><mvc:errors path="nombreCompleto" /></td>                             
                            </tr>                             
                            <tr>                                 
                                <td colspan="3" style="align-content: center">                                 
                                </td>                             
                            </tr>
                            <tr>                                 
                                <td><label>Subir Foto: </label></td>                                 
                                <td><input type="file" name="archivo" class="form-control text-box" /></td>                                 
                                <td></td>                             
                            </tr>                             
                            <tr>                                 
                                <td>                                     
                                    <input type="submit" value="${accion}" class="btn btn-primary button-submit"/>                                 
                                </td>                                 
                                <td>                                     
                                    <a href="usuarioListar.htm" class="btn btn-primary buttonsubmit">Cancelar</a>                                 
                                </td>                             
                            </tr>   
                        </table>                     
                    </mvc:form>                 
                </div>             
            </div>         
        </div>     
    </body> 
</html>
