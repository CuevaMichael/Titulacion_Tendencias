/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.EvaluacionDesempenio;
import MODELO.EvaluacionDesempenioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
@WebServlet(name = "ServletInsertEvaluacionDesempenio", urlPatterns = {"/ServletInsertEvaluacionDesempenio"})
public class ServletInsertEvaluacionDesempenio extends HttpServlet {

            //variables de tipo global
    EvaluacionDesempenioDAO test;
    String mensaje;

    //metodo para dar la orden para conectar a la base de datos
    public void init() throws ServletException {
        //recibo los datos para dar la orden de coneccion a la bd
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSERName = getServletContext().getInitParameter("jdbcUSERName");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            test = new EvaluacionDesempenioDAO(jdbcURL, jdbcUSERName, jdbcPassword);
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
            out.println("<title>Servlet ServletInsertEvaluacionDesempenio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInsertEvaluacionDesempenio at " + request.getContextPath() + "</h1>");
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
    int idEvaluacionDesempenio;
    Date periodoEvaluacionDesde;
    Date periodoEvaluacionHasta;
    String nombreInstitucion;
    String puntaje;
    String calificacion;
    String observaciones;
    int usuario_idCedula;
    
    //estas variables se usaran para recibir los datos 
        String op;

        //zona de captura de datos
        //con esta linea de codigo podemos recibir cualquier dato que venga de la vista
        periodoEvaluacionDesde = Date.valueOf(request.getParameter("periodoEvaluacionDesde"));
        periodoEvaluacionHasta = Date.valueOf(request.getParameter("periodoEvaluacionHasta"));
        nombreInstitucion = request.getParameter("nombreInstitucion");
        puntaje = request.getParameter("puntaje");
        calificacion = request.getParameter("calificacion");
        observaciones = request.getParameter("observaciones");
        usuario_idCedula = Integer.parseInt(request.getParameter("usuario_idCedula"));

        String idEvaluacionDesempenioParam = request.getParameter("idEvaluacionDesempenio");
        if (idEvaluacionDesempenioParam != null && !idEvaluacionDesempenioParam.isEmpty()) {
            idEvaluacionDesempenio = Integer.parseInt(idEvaluacionDesempenioParam);
        } else {
            idEvaluacionDesempenio = 0;
        }

        op = request.getParameter("operacion");

        switch (op.toUpperCase()) {
            case "GUARDAR":
                EvaluacionDesempenio objInsert = new EvaluacionDesempenio(periodoEvaluacionDesde,
                        periodoEvaluacionHasta, nombreInstitucion,
                        puntaje, calificacion, observaciones, usuario_idCedula);

                if (test.registrarEvaluacionDesempenio(objInsert)) {
                    mensaje = "Datos insertados correctamente";
                } else {
                    mensaje = "Error en la inserción de datos";
                }
                break;

            case "EDITAR":
                EvaluacionDesempenio objact = new EvaluacionDesempenio(idEvaluacionDesempenio,
                        periodoEvaluacionDesde, periodoEvaluacionHasta,
                        nombreInstitucion, puntaje, calificacion, observaciones,
                        usuario_idCedula);

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

        RequestDispatcher objdevuelve = request.getRequestDispatcher("evaluacionDesempenioInsert.jsp");
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
