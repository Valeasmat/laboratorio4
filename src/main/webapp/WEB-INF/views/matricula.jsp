<%-- 
    Document   : matricula
    Created on : 27 nov. 2020, 22:09:21
    Author     : Adminfoco
--%>
<%@page import="edu.cibertec.capitulo4.entity.CursoEntity"%> 
<%@page import="edu.cibertec.capitulo4.entity.UsuarioEntity"%> 
<%@page import="java.util.List"%> 
<%@page import="edu.cibertec.capitulo4.entity.MatriculaEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
         <title>Matrículas</title>         
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">         
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>         
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
    </head>
    <body>
         <h1>Matrículas</h1> 
 
        <div class="table-responsive">             
            <table class="table table-responsive table-sm table-dark table-striped tablebordered table-hover">             
                <thead>                 
                    <tr class="info">                     
                        <th>Código</th>                     
                        <th>Fecha</th>                     
                        <th>Usuario</th>                     
                        <th>Curso</th>                     
                        <th>Estado</th>                 
                    </tr>             
                </thead>             
                <tbody>                 
                    <% if (request.getAttribute("listaMat") != null) {                         
                        List<MatriculaEntity> lista = (List<MatriculaEntity>) request.getAttribute("listaMat");
                        for (MatriculaEntity matriculaEntity : lista) {                 
                        %>    
                    <tr>                     
                        <td><%= matriculaEntity.getIdmatricula()%></td>                     
                        <td><%= matriculaEntity.getFechaMat()%></td>                     
                        <td><%= matriculaEntity.getUsuario() == null ? "Sin usuario" : matriculaEntity.getUsuario().getNombreCompleto()%></td>                     
                        <td><%= matriculaEntity.getCurso() == null ? "sin curso" : matriculaEntity.getCurso().getNomCurso()%></td>                     
                        <td><%= matriculaEntity.getEstado()%></td>                 
                    </tr> 
                    <%      }
                    }%> 
                </tbody>         
            </table>         
        </div>         
        <br /><br />         
        <div class="container">             
            <div class="row d-flex justify-content-center mx-auto">                 
                <div class="col-md-6 col-xs-12 div-style">                     
                    <form action="matriculaGrabar.htm" method="post">                         
                        <div class="form-group">                             
                            Fecha: <input type="date" name="fechaMat" class="form-control textbox"                                              
                                          required placeholder="Fecha">                         
                        </div>                         
                        <div class="form-group">                             
                            Usuario: <select name="cmbUsuario" class="form-control text-box">                                 
                                <% List<UsuarioEntity> lisUsu = (List<UsuarioEntity>)request.getAttribute("listaUsu");                                  
                                for (UsuarioEntity usuarioEntity : lisUsu) { %>                                 
                                <option value="<%= usuarioEntity.getUsuario() %>"><%= usuarioEntity.getNombreCompleto()%></option>                                 
                                <% } %>                             
                            </select>                         
                        </div>                         
                        <div class="form-group">                             
                            Curso: <select name="cmbCurso" class="form-control text-box">                                 
                                <% List<CursoEntity> lisCur = (List<CursoEntity>)request.getAttribute("listaCur");                                  
                                for (CursoEntity cursoEntity : lisCur) { %>                                 
                                <option value="<%= cursoEntity.getIdcurso() %>"><%= cursoEntity.getNomCurso() %></option>                                 
                                <% } %>                             
                            </select>                         
                        </div>                         
                        <div class="form-group">                             
                            Estado: <input type="radio" name="estado" value="0"/>Inscrito &nbsp;&nbsp;                                 
                            <input type="radio" name="estado" value="1"/>Pagado                         
                        </div>                         
                        <div class="form-group justify-content-center d-flex">                             
                            <input type="submit" value="Insertar" class="btn btn-primary buttonsubmit">                         
                        </div>                     
                    </form>                 
                </div>             
            </div>         
        </div>
    </body>
</html>
