<%-- 
    Document   : CursoBusqueda
    Created on : 27 nov. 2020, 20:49:51
    Author     : Adminfoco
--%>
<%@page import="java.util.List"%> 
<%@page import="edu.cibertec.capitulo4.entity.CursoEntity"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
        <title>Búsqueda de Cursos</title>         
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">         
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>         
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
    </head>
    <body>
        <h1>Búsqueda de Cursos</h1>         
        <br/>         
        <form action="cursoBusqueda.htm" method="post">             
            <table border="1" class="table table-dark table-bordered table-hover">                 
                <thead>                     
                    <tr class="success">                         
                        <th>Condición</th>                         
                        <th>Valor</th>                     
                    </tr>                 
                </thead>                 
                <tbody>                     
                    <tr>                         
                        <td><input type="radio" name="tipo" value = "estado" required="true"/>Por estado: </td>                         
                        <td><select name="estado">                                 
                                <option value="0">CREADO</option>                                  
                                <option value="1">EN PROCESO DE VENTA</option>                                 
                                <option value="2">COMPLETO</option>                             
                            </select></td>                     
                    </tr>                     
                    <tr>                         
                        <td><input type="radio" name="tipo" value = "incompleto"/>Incompletos</td>                         
                        <td></td>                     
                    </tr>                     
                    <tr>                         
                        <td><input type="radio" name="tipo" value = "porfecha"/>Por fecha: </td>                         
                        <td><input type="date" name="fecha" /></td>                     
                    </tr>                     
                    <tr>                         
                        <td><input type="radio" name="tipo" value = "faltante"/>Alumnos faltantes: </td>
                        <td><input type="number" name="numero" /></td>                     
                    </tr>                     
                    <tr>                         
                        <td colspan="2" style="align-content: center">                             
                            <input type="submit" value="Consultar" class="btn btn-primary btn-lg active"/>                         
                        </td>                     
                    </tr>                 
                </tbody>             
            </table>         
        </form> 

        <% if (request.getAttribute("lista") != null) { %>         
        <br/>         
        <div class="table-responsive">             
            <table class="table table-responsive table-sm table-dark table-striped tablebordered table-hover">             
                <thead>                 
                    <tr class="info">                     
                        <th>Código</th>                     
                        <th>Nombre</th>                     
                        <th>Fecha Inicio</th>                     
                        <th>Minimo alumnos</th>                     
                        <th>Inscritos</th>                     
                        <th>Estado</th>                 
                    </tr>             
                </thead>             
                <tbody>                 
                    <% List<CursoEntity> lista = (List<CursoEntity>) request.getAttribute("lista");                     
                    for (CursoEntity cursoEntity : lista) {%>                 
                    <tr>                     
                        <td><%= cursoEntity.getIdcurso()%></td>                     
                        <td><%= cursoEntity.getNomCurso()%></td>                     
                        <td><%= cursoEntity.getFechaInicio()%></td>                     
                        <td><%= cursoEntity.getAlumnosMin()%></td>                     
                        <td><%= cursoEntity.getAlumnosAct()%></td>                     
                        <td><%= cursoEntity.getEstado()%></td>                 
                    </tr>                 
                    <%     }   %>             
                </tbody>         
            </table>         
        </div>         
        <% }%>
    </body>
</html>
