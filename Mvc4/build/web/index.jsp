<%-- 
    Document   : index
    Created on : 09-11-2020, 17:31:16
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
        <title>Login!</title>
    </head>
    <body>

        <div class="col-md-5 mx-auto mt-5 ml-3">
            <div class="card">   
                <h5 class="card-header">Login</h5>
                <div class="card-body formulary">
                    <form action="Validar" method="POST" class="was-validated mt-5" name="frmLogin" id="frmLogin">
                        <div class="mb-6">
                            <label for="txtRut">Rut</label>
                            <div class="input-group is-invalid">
                                <input type="text" class="form-control is-invalid" aria-describedby="validatedInputGroupPrepend" 
                                       id="txtRut" name="txtRut"required>
                            </div>
                        </div>
                        <div class="mb-6">
                            <label for="txtpass">Password</label>
                            <div class="input-group is-invalid">
                                <input type="password" class="form-control is-invalid" aria-describedby="validatedInputGroupPrepend" id="txtPass" name="txtPass"required>
                            </div>
                        </div>
                        <p class="badge badge-pill badge-danger mt-3"><%= request.getAttribute("res")%></p><br>
                        <a href="registro" class="mt-3">Resgistrarse</a> <br>
                        <button type="submit" value="ingresar" name="btnIngresar" id="btnIngresar" class="btn btn-primary mt-3">Ingresar</button>
                    </form>
                </div>
            </div>
        </div>


             
        <script src="js/main.js" type="text/javascript"></script>                
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>                  
        <!--error desde el servlet c: se importa con el enter-->
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
