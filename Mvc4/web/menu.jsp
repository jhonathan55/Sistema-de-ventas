<%-- 
    Document   : menu
    Created on : 09-11-2020, 17:34:51
    Author     : Jhonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>AppWeb</title>
    </head>
    <body>


        <div class="bg-dark p-4">
            <h5 class="text-white h4">Ventas</h5>
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="navbar-collapse" id="navbarTogglerDemo02">
                    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=clientes&accion=listar" target="myFrame">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=despachos&accion=listar" target="myFrame">Despachos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=usuarios" target="myFrame">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=sucursales&accion=listar" target="myFrame">Sucursales</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=productos&accion=listar" target="myFrame">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=venta&accion=listar" target="myFrame">Ingresar Venta</a>
                        </li>
                        
                    </ul>

                </div>
                <div class="btn-group" role="group">
                    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" 
                            aria-haspopup="true" aria-expanded="false">
                        Nombre: ${personas.getNombre()}
                    </button>
                    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                        
                        <p class="dropdown-item">Position: ${usuario.getCargo()}</p>
                        <p class="dropdown-item">Rut: ${personas.getRut()}-${personas.getDv()}</p>
                        <a class="dropdown-item alert alert-danger" href="index.jsp">Exit</a>
                    </div>
                </div>
            </nav>
        </div>



        <div class="m-4 iframeOp" id="iframeOp" name="iframeOp" >
            <iframe id="myFrame" name="myFrame"  ></iframe>
        </div>
        <script src="js/main.js" type="text/javascript"></script>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>