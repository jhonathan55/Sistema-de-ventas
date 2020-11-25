<%-- 
    Document   : Clientes
    Created on : 12-11-2020, 0:09:21
    Author     : Jhonathan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Propiedades</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-ms-6">
                <div class="card-body">
                    <form  action="Controlador?menu=clientes" name="frmPersonas" id="frmPersonas" method="POST" 
                           onsubmit="return valInsertDes(this)" class="needs-validation" novalidate >
                        <div class="mb-6">
                            <label for="txtRut">Rut</label>
                            <div id="val" class="input-group is-invalid">
                                <input type="text" class="form-control is-invalid" 
                                       aria-describedby="validatedInputGroupPrepend" id="txtRut" name="txtRut"
                                       value="${personas.getRut()}">
                            </div>
                            <label for="txtDv">dv</label>
                            <div id="val" class="input-group is-invalid">
                                <input type="text" class="form-control is-invalid" 
                                       aria-describedby="validatedInputGroupPrepend" id="txtDv" name="txtDv"
                                       value="${personas.getDv()}">
                            </div>
                        </div>
                        <div class="mb-6">
                            <label for="txtNombre">Nombre</label>
                            <div class="input-group is-invalid">
                                <input type="text" class="form-control is-invalid" aria-describedby="validatedInputGroupPrepend" 
                                       id="txtNombre" name="txtNombre" value="${personas.getNombre()}">
                            </div>
                        </div>
                        <div class="mb-6">
                            <label for="txtDireccion">Direccion</label>
                            <div class="input-group is-invalid">
                                <input type="text" class="form-control is-invalid" aria-describedby="validatedInputGroupPrepend" 
                                       id="txtDireccion" name="txtDireccion" value="${personas.getDireccion()}">
                            </div>
                        </div>
                        <div class="mb-6">
                            <label for="txtCorreo">Correo</label>
                            <div class="input-group is-invalid">
                                <input type="text" class="form-control is-invalid" aria-describedby="validatedInputGroupPrepend" 
                                       id="txtCorreo" name="txtCorreo" value="${personas.getCorreo()}" >
                            </div>
                        </div>
                        <div class="mb-6">
                            <label for="txtFono">Fono</label>
                            <div class="input-group is-invalid">
                                <input type="text" class="form-control is-invalid" aria-describedby="validatedInputGroupPrepend" 
                                       id="txtFono" name="txtFono" value="${personas.getFono()}" >
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary mt-3" name="accion" value="insertar">Guardar</button>
                        <button type="submit"  class="btn btn-secondary mt-3" name="accion" value="actualizar">Actualizar</button>
                    </form>
                </div>
            </div>
            <div class="col-ms-10">
                <table class="table table-striped table-dark">
                    <thead>
                        <tr>
                            <th scope="col">Rut</th>
                            <th scope="col">Dv</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Direccion</th>
                            <th scope="col">E-mail</th>
                            <th scope="col">fono</th>
                            <th scope="col">Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <!--//agregar libreri JSTL 1.2.1-->
                            <jsp:useBean class="modelo.PersonasDao" id="personasDao"></jsp:useBean>
                            <c:forEach items="${personasDao.listar()}" var="personas">
                                <th>${personas.rut}</th>
                                <th>${personas.dv}</th>
                                <th>${personas.nombre}</th>
                                <th>${personas.direccion}</th>
                                <th>${personas.correo}</th>
                                <th>${personas.fono}</th>

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
                                <td><a type="button" class="btn btn-outline-info" href="#" onclick="direccion(${personas.rut}, '${personas.dv}', '${personas.nombre}')">Dirección
                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-building" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                        <path fill-rule="evenodd" d="M14.763.075A.5.5 0 0 1 15 .5v15a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5V14h-1v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V10a.5.5 0 0 1 .342-.474L6 7.64V4.5a.5.5 0 0 1 .276-.447l8-4a.5.5 0 0 1 .487.022zM6 8.694L1 10.36V15h5V8.694zM7 15h2v-1.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 .5.5V15h2V1.309l-7 3.5V15z"/>
                                        <path d="M2 11h1v1H2v-1zm2 0h1v1H4v-1zm-2 2h1v1H2v-1zm2 0h1v1H4v-1zm4-4h1v1H8V9zm2 0h1v1h-1V9zm-2 2h1v1H8v-1zm2 0h1v1h-1v-1zm2-2h1v1h-1V9zm0 2h1v1h-1v-1zM8 7h1v1H8V7zm2 0h1v1h-1V7zm2 0h1v1h-1V7zM8 5h1v1H8V5zm2 0h1v1h-1V5zm2 0h1v1h-1V5zm0-2h1v1h-1V3z"/>
                                        </svg>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <script src="js/main.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>                   
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
