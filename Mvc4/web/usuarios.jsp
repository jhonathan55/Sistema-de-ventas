<%-- 
    Document   : usuarios
    Created on : 16-11-2020, 20:46:54
    Author     : Jhonathan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    </head>    
    <body>

        <div class="container-fluid">
            <div class="row">
                <div class="col-5">
                    <form action="Controlador?menu=usuarios" method="POST" name="frmUsuarios" id="frmUsuarios" >
                        <div class="form-row">
                            <div class="col-md-6 mb-6">
                                <label  for="txtCliente">Cliente</label>
                                <select class="custom-select" name="txtRutV" id="txtRutV">
                                    <option value="">Selecciona un cliente</option>
                                    <jsp:useBean class="modelo.PersonasDao" id="personasDao"></jsp:useBean>
                                    <c:forEach items="${personasDao.listar()}" var="personas">
                                        <option value="${personas.rut}">${personas.rut}- ${personas.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-6 mb-6">
                                <label for="txtPass">Pass</label>
                                <input type="text" class="form-control" id="txtPass" name="txtPass" required="">
                            </div>
                            <div class="col-md-6 mb-6">
                                <label for="txtCargo">Cargo</label>
                                <input type="text" class="form-control" id="txtCargo" name="txtCargo" required="">
                            </div> 
                        </div>
                        <button type="submit" class="btn btn-primary mt-3" name="accion" value="insertar">Guardar</button>
                        <button type="submit"  class="btn btn-secondary mt-3" name="accion" value="actualizar">Actualizar</button>

                    </form>
                </div>

                <div class="col-5">
                    <table class="table table-striped table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Rut</th>
                                <th scope="col">Pass</th>
                                <th scope="col">Cargo</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <!--//agregar libreri JSTL 1.2.1-->
                                <jsp:useBean class="modelo.TrabajadoresDao" id="trabajadoresDao"></jsp:useBean>
                                <c:forEach items="${trabajadoresDao.listar()}" var="trabajadores">
                                    <th>${trabajadores.rut}</th>
                                    <th>${trabajadores.pass}</th>
                                    <th>${trabajadores.cargo}</th>


                                    <td><a type="button" class="btn btn-outline-warning" href="#" onclick="editar(${personas.rut}, '${personas.dv}', '${personas.nombre}')">Editar <svg
                                                width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square"
                                                fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path
                                                d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                                            <path fill-rule="evenodd"
                                                  d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                                            </svg></a>
                                    </td>
                                    <td><a type="button" class="btn btn-outline-danger" href="#" onclick="eliminar(${personas.rut})">Eliminar <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
                                            </svg></a>
                                    </td>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>


            </div>
        </div>

    </body>
    <!-- main-->
    <script src="js/main.js" type="text/javascript"></script>
    <!-- CDN SWEETALERT2 -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    <!-- Option 2: jQuery, Popper.js, and Bootstrap JS
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    -->
</body>
</html>
