/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Despachos;
import modelo.DespachosDao;
import modelo.Personas;
import modelo.PersonasDao;
import modelo.Personas_has_despachos;
import modelo.Personas_has_despachosDao;
import modelo.Productos;
import modelo.ProductosDao;
import modelo.ProductosPrecios;
import modelo.ProductosPreciosDao;
import modelo.Sucursales;
import modelo.SucursalesDao;
import modelo.Trabajadores;
import modelo.TrabajadoresDao;
import modelo.Ventas;
import modelo.VentasDao;

/**
 *
 * @author Jhonathan
 */
public class Controlador extends HttpServlet {

    Despachos d = new Despachos();
    DespachosDao dDao = new DespachosDao();
    Personas p = new Personas();
    PersonasDao pDao = new PersonasDao();
    Personas_has_despachos pd = new Personas_has_despachos();
    Personas_has_despachosDao pdDao = new Personas_has_despachosDao();
    Productos pr = new Productos();
    ProductosDao prDao = new ProductosDao();
    ProductosPrecios prp = new ProductosPrecios();
    ProductosPreciosDao prpDao = new ProductosPreciosDao();
    Trabajadores t = new Trabajadores();
    TrabajadoresDao tDao = new TrabajadoresDao();
    Sucursales s = new Sucursales();
    SucursalesDao sDao = new SucursalesDao();
    Ventas v = new Ventas();
    VentasDao vDao = new VentasDao();

    List<Ventas> lista = new ArrayList<>();
    int rutE;
    int rutD;
    int num = 0;
    int idP;
    String nombre;
    int boleta;
    double precioBruto, subtotal, descuento, total, subTotal;
    int cant;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //Almacena la accion del bonton enviada desde Clientes.jsp
            String accion = request.getParameter("accion");
            //Almacena el menu enviados desde frmClientes (action) enviado desde Clientes.jsp
            String menu = request.getParameter("menu");
            //carga el menu desde Validar.java 
            if (menu.equals("menu")) {
                request.getRequestDispatcher("menu.jsp").forward(request, response);

            }
            //pregunta por el menu seleccionada y carga el switch con la accion correspondiente
            if (menu.equals("clientes")) {
                switch (accion) {
                    case "listar":
                        request.getRequestDispatcher("Clientes.jsp").forward(request, response);
                        break;
                    case "insertar":
                        int rut = Integer.parseInt(request.getParameter("txtRut").trim());
                        String dv = request.getParameter("txtDv").trim();
                        String nombre = request.getParameter("txtNombre").trim();
                        String direccion = request.getParameter("txtDireccion").trim();
                        String correo = request.getParameter("txtCorreo").trim();
                        String fono = request.getParameter("txtFono").trim();
                        if (rut == 0 || !nombre.equals("") || !direccion.equals("") || !correo.equals("") || !fono.equals("")) {
                            p = pDao.ingresar(rut, dv, nombre, direccion, correo, fono);
                            request.getRequestDispatcher("Controlador?menu=clientes&accion=listar").forward(request, response);
                        } else {
                            String error = "Error al Registrar por favor intente nuevamente";
                            request.setAttribute("error", error);
                            request.getRequestDispatcher("error.jsp").forward(request, response);
                        }
                        break;
                    case "eliminar":
                        rut = Integer.parseInt(request.getParameter("codigo"));
                        pDao.eliminar(rut);
                        request.getRequestDispatcher("Controlador?menu=clientes&accion=listar").forward(request, response);
                        break;
                    case "editar":
                        rutE = Integer.parseInt(request.getParameter("rutE"));
                        p = pDao.listarRut(rutE);
                        request.setAttribute("personas", p);
                        request.getRequestDispatcher("Clientes.jsp").forward(request, response);

                        break;

                    case "actualizar":
                        int rut1 = Integer.parseInt(request.getParameter("txtRut").trim());
                        String dv1 = request.getParameter("txtDv").trim();
                        String nombre1 = request.getParameter("txtNombre").trim();
                        String direccion1 = request.getParameter("txtDireccion").trim();
                        String correo1 = request.getParameter("txtCorreo").trim();
                        String fono1 = request.getParameter("txtFono").trim();
                        if (rut1 == 0 || !nombre1.equals("") || !direccion1.equals("") || !correo1.equals("")
                                || !fono1.equals("")) {
                            p = pDao.actualizar(dv1, nombre1, direccion1, correo1, fono1, rut1);
                            request.getRequestDispatcher("Controlador?menu=clientes&accion=listar").forward(request, response);
                        } else {
                            String error = "Error al Actualizar por favor intente nuevamente";
                            request.setAttribute("error", error);
                            request.getRequestDispatcher("error.jsp").forward(request, response);
                        }
                        break;
                    case "direccion":
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }

            }
            if (menu.equals("usuarios")) {
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                switch (accion) {
                    case "listar":
                        request.getRequestDispatcher("venta.jsp").forward(request, response);
                        break;
                    case "editar":
                        break;
                    case "eliminar":
                        break;
                    case "insertar":
                        int rutV = Integer.parseInt(request.getParameter("txtRutV"));
                        String pass = request.getParameter("txtPass");
                        String cargo = request.getParameter("txtCargo");
                        t = tDao.ingresar(rutV, pass, cargo);
                        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                        break;

                    default:
                        throw new AssertionError();

                }

            }
            if (menu.equals("reportes")) {
                request.getRequestDispatcher("reportes.jsp").forward(request, response);

            }
            if (menu.equals("venta")) {

                switch (accion) {
                    case "listar":
                        request.getRequestDispatcher("venta.jsp").forward(request, response);
                        lista.clear();
                        break;
                    case "editar":
                        break;
                    case "eliminar":
                        break;
                    case "buscarPro":
                        int idPro = Integer.parseInt(request.getParameter("txtProducto"));
                        pr = prDao.listarId(idPro);
                        request.setAttribute("personas", p);
                        request.setAttribute("productos", pr);
                        request.setAttribute("lista", lista);
                        request.setAttribute("total", total);

                        request.getRequestDispatcher("venta.jsp").forward(request, response);
                        break;
                    case "BuscarCli":
                        int rutCli = Integer.parseInt(request.getParameter("txtRutCli"));
                        p = pDao.listarDespachosRut(rutCli);
                        request.setAttribute("personas", p);

                        request.getRequestDispatcher("venta.jsp").forward(request, response);
                        break;
                    case "agregarPro":
                        request.setAttribute("personas", p);
                        total = 0.0;
                        num = num + 1;
                        int idProducto = Integer.parseInt(request.getParameter("txtId").trim());
                        nombre = request.getParameter("txtNombre");
                        precioBruto = Double.parseDouble(request.getParameter("txtPrecio"));
                        cant = Integer.parseInt(request.getParameter("txtCantidad"));
                        subTotal = precioBruto * cant;
                        v = new Ventas();
                        v.setNum(num);
                        v.setId(idProducto);
                        v.setNombrePro(nombre);
                        v.setPrecio(precioBruto);
                        v.setCantidad(cant);
                        v.setSubTotal(subTotal);
                        lista.add(v);
                        request.setAttribute("lista", lista);
                        for (int i = 0; i < lista.size(); i++) {
                            total = total + lista.get(i).getSubTotal();
                        }

                        double descuento = total * 0.10;
                        total = total - descuento;
                        request.setAttribute("total", total);
                        request.setAttribute("des", descuento);
                        Ventas ve = new Ventas();
                        int idVentas = vDao.numBolera() + 1;
                        request.setAttribute("boleta", idVentas);
                        request.getRequestDispatcher("venta.jsp").forward(request, response);

                        break;
                    case "generarVenta":

                        String fecha = request.getParameter("txtFecha").trim();
                        String fechaDes = request.getParameter("txtFechaDes").trim();
                        int idSuc = Integer.parseInt(request.getParameter("txtSucursal").trim());
                        int rutVen = Integer.parseInt(request.getParameter("txtVendedor").trim());
                        int rutCliente = Integer.parseInt(request.getParameter("txtCliente").trim());
                        int idDes = Integer.parseInt(request.getParameter("txtIdDespacho").trim());
                        double tot = Double.parseDouble(request.getParameter("txtTotal").trim());
                        double des = Double.parseDouble(request.getParameter("txtDescuento").trim());
                        v = vDao.ingresar(fecha, idSuc, rutVen, rutCliente, idDes, tot, fechaDes, des);

                        for (int i = 0; i < lista.size(); i++) {
                            Ventas ven = new Ventas();
                             idVentas = vDao.numBolera();
                            int idProd = lista.get(i).getId();
                            int can = lista.get(i).getCantidad();
                            ven = vDao.ingresar_vp(idVentas, idProd, can);
                          
                        }

                        request.getRequestDispatcher("venta.jsp").forward(request, response);
                        break;
                    default:
                        boleta = vDao.numBolera();
                        request.setAttribute("boleta", boleta);

                }

            }
            if (menu.equals("despachos")) {
                switch (accion) {
                    case "listar":
                        request.getRequestDispatcher("despachos.jsp").forward(request, response);

                        break;
                    case "editar":
                        break;
                    case "eliminar":
                        break;
                    case "insertar":
                        rutD = Integer.parseInt(request.getParameter("txtRutD").trim());
                        String direccion = request.getParameter("txtDireccion").trim();
                        d = dDao.ingresar(direccion);

                        int idD = Integer.parseInt(dDao.idDespachos());
                        pd = pdDao.ingresar(rutD, idD);

                        request.getRequestDispatcher("Controlador?menu=despachos&accion=listar").forward(request, response);

                        break;

                    default:
                        throw new AssertionError();

                }

            }
            if (menu.equals("productos")) {
                switch (accion) {
                    case "listar":
                        request.getRequestDispatcher("productos.jsp").forward(request, response);

                        break;
                    case "editar":
                        break;
                    case "eliminar":
                        break;
                    case "insertar":

                        String nombre = request.getParameter("txtNomPro");
                        int sku = Integer.parseInt(request.getParameter("txtSKU"));
                        String fecha = request.getParameter("txtFecha");
                        double neto = Double.parseDouble(request.getParameter("txtPreNeto"));
                        double iva = neto * 0.19;
                        double bruto = neto + iva;
                        pr = prDao.ingresar(nombre, sku);
                        int id = Integer.parseInt(prDao.idProductos());
                        prp = prpDao.ingresar(id, fecha, neto, iva, bruto);
                        request.getRequestDispatcher("productos.jsp").forward(request, response);

                        break;

                    default:
                        throw new AssertionError();

                }

            }
            if (menu.equals("sucursales")) {
                switch (accion) {
                    case "listar":
                        request.getRequestDispatcher("sucursales.jsp").forward(request, response);

                        break;
                    case "editar":
                        break;
                    case "eliminar":
                        break;
                    case "insertar":

                        String nombre = request.getParameter("txtNombre");
                        String direccion = request.getParameter("txtDireccion");
                        String fecha = request.getParameter("txtFecha");
                        String tipo = request.getParameter("txtTipo");
                        s = sDao.ingresar(nombre, direccion, fecha, tipo);
                        request.getRequestDispatcher("sucursales.jsp").forward(request, response);

                        break;

                    default:
                        throw new AssertionError();

                }

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
