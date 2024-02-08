/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.DiscapacidadOenfermedad;
import MODELO.DiscapacidadOenfermedadDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "ServletInsertEnfermedad", urlPatterns = {"/ServletInsertEnfermedad"})
public class ServletInsertEnfermedad extends HttpServlet {

        //variables de tipo global
    DiscapacidadOenfermedadDAO test;
    String mensaje;

    //metodo para dar la orden para conectar a la base de datos
    public void init() throws ServletException {
        //recibo los datos para dar la orden de coneccion a la bd
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSERName = getServletContext().getInitParameter("jdbcUSERName");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            test = new DiscapacidadOenfermedadDAO(jdbcURL, jdbcUSERName, jdbcPassword);
            mensaje = "Conexión Exitosa";
        } catch (SQLException ex) {
            Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "Error de Conexión ";
        }
    }
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletInsertEnfermedad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInsertEnfermedad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        
              //zona de variables
    int idDiscapacidadOenfermedad;
    String situacion;
    String numeroCarnetConadis;
    String certificadoEnfermedadCarastrofica;
    String tipoDiscapacidad;
    String porcentaje;
    String tipoEnfermedad;
    String tipoRelacion;
    int usuario_idCedula;
    
     //estas variables se usaran para recibir los datos 
        String op;

        //zona de captura de datos
        //con esta linea de codigo podemos recibir cualquier dato que venga de la vista
        situacion = request.getParameter("situacion");
        numeroCarnetConadis = request.getParameter("numeroCarnetConadis");
        certificadoEnfermedadCarastrofica = request.getParameter("certificadoEnfermedadCarastrofica");
        tipoDiscapacidad = request.getParameter("tipoDiscapacidad");
        porcentaje = request.getParameter("porcentaje");
        tipoRelacion = request.getParameter("tipoRelacion");
        tipoEnfermedad = request.getParameter("tipoEnfermedad");
        usuario_idCedula = Integer.parseInt(request.getParameter("usuario_idCedula"));

        // Verificación de existencia de idAsistencia en la solicitud
        String idDiscapacidadOenfermedadParam = request.getParameter("idDiscapacidadOenfermedad");
        if (idDiscapacidadOenfermedadParam != null && !idDiscapacidadOenfermedadParam.isEmpty()) {
            idDiscapacidadOenfermedad = Integer.parseInt(idDiscapacidadOenfermedadParam);
        } else {
            idDiscapacidadOenfermedad = 0; // O asigna el valor que desees para indicar que no se proporcionó un id
        }

        op = request.getParameter("operacion");

        switch (op.toUpperCase()) {
            case "GUARDAR":
                DiscapacidadOenfermedad objInsert = new DiscapacidadOenfermedad(situacion, 
                        numeroCarnetConadis, certificadoEnfermedadCarastrofica,
                        tipoDiscapacidad, porcentaje, tipoEnfermedad, tipoRelacion, 
                        usuario_idCedula);

                if (test.registrarDiscapacidadOenfermedad(objInsert)) {
                    mensaje = "Datos insertados correctamente";
                } else {
                    mensaje = "Error en la inserción de datos";
                }
                break;

            case "EDITAR":
                DiscapacidadOenfermedad objact = new DiscapacidadOenfermedad(idDiscapacidadOenfermedad,
                        situacion, numeroCarnetConadis, 
                        certificadoEnfermedadCarastrofica, tipoDiscapacidad, 
                        porcentaje, tipoEnfermedad, tipoRelacion, usuario_idCedula);

                if (test.EditarTODO(objact)) {
                    mensaje = "Registro actualizado";
                } else {
                    mensaje = "Error al actualizar el registro";
                }
                break;

            default:
                mensaje = "Operación no reconocida";
        }

        request.setAttribute("cajitamensajesbd", mensaje);


        RequestDispatcher objdevuelve = request.getRequestDispatcher("enfermedadInsert.jsp");
        objdevuelve.forward(request, response);
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
