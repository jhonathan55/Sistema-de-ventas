/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Personas;
import modelo.PersonasDao;
import modelo.Trabajadores;
import modelo.TrabajadoresDao;

/**
 *
 * @author Jhonathan
 */
public class Validar extends HttpServlet {

    Trabajadores t = new Trabajadores();
    TrabajadoresDao tDao = new TrabajadoresDao();
    Personas p=new Personas();
    PersonasDao pDAO=new PersonasDao();
    

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

        String ingresar = request.getParameter("btnIngresar");
        String res = "Ingresa tu Usuario y Contraseña";
        
        
        if (ingresar.equals("ingresar")) {
            int rut =Integer.parseInt(request.getParameter("txtRut"));
            String pass = request.getParameter("txtPass");
            t = tDao.validar(rut, pass);
            if (t.getRut() == 0) {
                res = "Usuario o Contraseña incorrectos";
                request.setAttribute("res", res);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                request.setAttribute("usuario", t);
                p=pDAO.listarRut(rut);
                request.setAttribute("personas", p);
                request.getRequestDispatcher("Controlador?menu=menu").forward(request, response);
               
                    
            }
            
        }

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
