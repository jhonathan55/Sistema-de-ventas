<%-- 
    Document   : venta
    Created on : 14-11-2020, 18:20:35
    Author     : Jhonathan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    </head>    
    <body>
        <div class="container-fluid">
            <div class="row">
                <!--1ra mitar-->
                <div class="col-5                                                                                                                                                                                                                                                   " >
                    <!--Inicio form-->

                    <form action="Controlador?menu=venta" name="frmBuscarCli" id="frmBuscarCli" method="POST">
                        <div class="form-row">

                            <div class="col-md-5 mb-5">
                                <label  for="txtRutCli">Cliente</label>
                                <select class="custom-select" name="txtRutCli" id="txtRutCli">
                                    <option value="">Selecciona un Cliente</option>
                                    <jsp:useBean class="modelo.PersonasDao" id="personasDao1"></jsp:useBean>
                                    <c:forEach items="${personasDao1.listar()}" var="personas1">
                                        <option value="${personas1.rut}">${personas1.rut}- ${personas1.nombre}</option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class="col-md-5 mb-5">
                                <button type="submit" class="btn btn-primary mt-4" name="accion" value="BuscarCli" >Buscar</button>
                            </div>
                        </div>
                        <div class="form-row">

                        </div>  
                        <div class="form-row">          
                            <div class="col-md-5 mb-5">
                                <label  for="txtProducto">Producto</label>
                                <select class="custom-select" name="txtProducto" id="txtProducto">
                                    <option value="">Selecciona un producto</option>
                                    <jsp:useBean class="modelo.ProductosDao" id="productosDao"></jsp:useBean>
                                    <c:forEach items="${productosDao.listar()}" var="productos">
                                        <option value="${productos.id}">${productos.nombre}</option>
                                    </c:forEach>
                                </select>


                            </div>  
                            <div class="col-md-5 mb-5">
                                <button type="submit" class="btn btn-primary mt-4" name="accion" value="buscarPro" >Buscar</button>
                            </div>
                        </div>
                        <div class="form-row">         
                            <div class="col-md-4 mb-4">
                                <label for="txtPrecio">Precio</label>
                                <input type="number" class="form-control" id="txtPrecio" name="txtPrecio"  value="${productos.bruto}"readonly >

                            </div>
                            <div class="col-md-4 mb-4">
                                <label for="txtNombre">Nombre</label>
                                <input type="text" class="form-control" id="txtNombre" name="txtNombre"  value="${productos.nombre}"readonly >
                            </div>
                            <div class="col-md-2 mb-2">
                                <label for="txtCantidad">Cantidad</label>
                                <input type="number" class="form-control" id="txtCantidad" name="txtCantidad"  value="1">

                            </div>  
                            
                                <input type="hidden" class="form-control" id="txtId" name="txtId"  value="${productos.id}" readonly>


                            <div class="col-md-5 mb-5">
                                <button type="submit" class="btn btn-primary mt-4" name="accion" value="agregarPro" >Agregar</button>
                            </div>
                    </form>

                </div>
            </div>

            <div class="col-7">
                <form action="Controlador?menu=venta" name="frmVenta" id="frmVenta" method="POST">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">

                                <div class="col-md-6 mb-6">
                                    <label for="txtBoleta">N° Boleta</label>
                                    <input type="text" class="form-control" id="txtBoleta" name="txtBoleta"
                                           value="<%= request.getAttribute("boleta")%>" readonly>
                                </div>
                                <div class="col-md-6 mb-6">
                                    <label for="">Fecha</label>
                                    <input type="date" class="form-control" id="txtFecha" name="txtFecha">
                                </div> 
                                <div class="col-md-6 mb-6">
                                    <label for="txtCliente">Rut Cliente</label>
                                    <input type="text" class="form-control" id="txtCliente" name="txtCliente"  value="${personas.getRut()}"
                                           readonly>
                                </div>
                                <div class="col-md-6 mb-6">
                                    <label for="txtNombre">Nombre</label>
                                    <input type="text" class="form-control" id="txtNombre" name="txtNombre"  value="${personas.getNombre()}"
                                           readonly>
                                </div>
                                <div class="col-md-6 mb-6">
                                    <label for="txtNombre">Direccion</label>
                                    <input type="text" class="form-control" id="txtNombre" name="txtNombre"  value="${personas.getDireccion()}"
                                           readonly>
                                </div>
                                <input id="txtIdDespacho" name="txtIdDespacho" type="hidden" value="${personas.getIdDespachos()}">          
                                <div class="col-md-6 mb-6">
                                    <label for="txtVendedor">Seleccione Vendedor</label>
                                    <select class="custom-select" name="txtVendedor" id="txtVendedor">
                                        <option value="">Selecciona un vendedor</option>
                                        <jsp:useBean class="modelo.TrabajadoresDao" id="trabajadoresDao"></jsp:useBean>
                                        <c:forEach items="${trabajadoresDao.listar()}" var="trabajadores">
                                            <option value="${trabajadores.rut}">${trabajadores.nombre}-${trabajadores.cargo}</option>
                                        </c:forEach>
                                    </select>
                                </div>  
                                <div class="col-md-6 mb-6">
                                    <label for="txtFechaDes">Fecha Despacho</label>
                                    <input type="date" class="form-control" id="txtFechaDes" name="txtFechaDes">
                                </div> 
                                <div class="col-md-6 mb-6">
                                    <label  for="txtSucursal">Sucursal</label>
                                    <select class="custom-select" name="txtSucursal" id="txtSucursal">
                                        <option value="">Selecciona una Sucursal</option>
                                        <jsp:useBean class="modelo.SucursalesDao" id="sucursalesDao"></jsp:useBean>
                                        <c:forEach items="${sucursalesDao.listar()}" var="sucursales">
                                            <option value="${sucursales.id}">${sucursales.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>  

                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Num</th>
                                <th scope="col">ID</th>
                                <th scope="col">Producto</th>
                                <th scope="col">Precio</th>
                                <th scope="col">cantidad</th>
                                <th scope="col">SubTotal</th>
                                <th scope="col">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="list" items="${lista}">
                                <tr>
                                    <th scope="col">${list.getNum()}</th>
                                    <th scope="col">${list.getId()}</th>
                                    <th scope="col">${list.getNombrePro()}</th>
                                    <th scope="col">${list.getPrecio()}</th>
                                    <th scope="col">${list.getCantidad()}</th>
                                    <th scope="col">${list.getSubTotal()}</th>

                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="card-footer d-flex">

                        <div class="col-sm-4 ml-auto">
                            <label  for="txtDescuento">descuento 10%</label>
                            <input type="text" name="txtDescuento" class="form-control"readonly 
                                   value="<%=request.getAttribute("des")%>" >
                        </div>
                        <div class="col-sm-4 ml-auto">
                            <label  for="txtTotal">total</label>
                            <input type="text" name="txtTotal" id="txtTotal" class="form-control"
                                    value="<%=request.getAttribute("total")%>" >
                        </div>
                        <div class="col-sm-4">
                            <button type="submit" name="accion" value="generarVenta" class="btn btn-success">Generar Venta</button>
                            <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">
                        </div>
                    </div>
                </form >
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
