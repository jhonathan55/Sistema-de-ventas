let rutL = frmLogin.txtRut;
let rutP = frmPersonas.txtRut;

rutL.addEventListener('keypress', (event) => {
    event.preventDefault()
    let codigoKey = event.keyCode
    let valorKey = String.fromCharCode(codigoKey)
    let valor = parseInt(valorKey)
    if (valor) {
        rutL.value += valor
    }
    if (valor.value.length != 8) {
        alert("Solo ingresa los primeros 8 digitos de tu rut");
        // rutL.focus();
        //rutL.select();
        return false
    }
})

rutP.addEventListener('keypress', (event) => {
    event.preventDefault()
    var codigoKey = event.keyCode
    var valorKey = String.fromCharCode(codigoKey)
    var valor = parseInt(valorKey)
    if (valor) {
        rutP.value += valor
    }
    if (valor.value.length != 8) {
        alert("Solo ingresa los primeros 8 digitos de tu rut");
        //rutP.focus();
        //rutP.select();
        return false
    }
})

function valInsertPro(frmPersonas) {
    var rut = frmPersonas.txtRut;
    var nombre = frmPersonas.txtNombre;
    var direccion = frmPersonas.txtDireccion;
    var correo = frmPersonas.txtCorreo;
    var fono = frmPersonas.txtFono;


    if (rut.value == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Ingresa un rut!',
        })
        return false;
    } else
    if (dv.value == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Ingresa un digito verificador!',
        })
        return false;
    } else
    if (nombre.value == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Ingresa un nombre completo!',

        })
        return false;
    } else
    if (direccion.value == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'debes ingresar una direccion!',
        })
        return false;
    } else
    if (correo.value == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'debes ingresar un correo!',
        })
        return false;
    } else
    if (fono.value == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Ingresa un celular!',
        })
        return false;
    }
}

function eliminar(codigo) {
    Swal.fire({
        title: 'Deseas Eliminar el registro numero ' + codigo + '?',
        text: "",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Eliminar!'
    }).then((result) => {

        if (result.value) {
            Swal.fire(
                    'Registro eliminado!',
                    'success'
                    )

            window.location.href = "Controlador?menu=clientes&accion=eliminar&codigo=" + codigo;
        }
    })
}
function editar(rut, dv, nombre) {
    Swal.fire({
        title: 'Deseas Editar el registro numero ' + rut + "-" + dv + " " + nombre + '?',
        text: "",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Editar!'
    }).then((result) => {

        if (result.value) {
            Swal.fire(
                    'Registro Editado!',
                    'success'
                    )

            window.location.href = "Controlador?menu=clientes&accion=editar&rutE=" + rut;

        }
    })
}

function direccion(rut, dv, nombre) {
    Swal.fire({
        title: 'Deseas Ingresar una direccion de despacho a: ' + nombre + '?',
        text: "",
        icon: 'warning',
        position:'center',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Si!'
    }).then((result) => {

        if (result.value) {
            Swal.fire(
                    'Cargando...',
                    'success'
                    )

            window.location.href = "Controlador?menu=despachos&accion=listar";

        }
    })



}

function valInsertDes(frmDespachos) {
    var rutD = frmDespachos.txtRutD;
    var direccionD = frmDespachos.txtDireccion;
    


    if (rutD.value == "Selecciona un cliente") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Ingresa un rut!',
        })
        return false;
    } else
    if (direccionD.value == "") {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Ingresa una Dieccion!',
        })
        return false;
    } 
    
    
 
}


