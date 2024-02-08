/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.Usuario;
import MODELO.UsuarioDAO;
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
@WebServlet(name = "ServletInsertUsuario", urlPatterns = {"/ServletInsertUsuario"})
public class ServletInsertUsuario extends HttpServlet {

    //variables de tipo global
    UsuarioDAO test;
    String mensaje;

    //metodo para dar la orden para conectar a la base de datos
    public void init() throws ServletException {
        //recibo los datos para dar la orden de coneccion a la bd
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSERName = getServletContext().getInitParameter("jdbcUSERName");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            test = new UsuarioDAO(jdbcURL, jdbcUSERName, jdbcPassword);
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
            out.println("<title>Servlet ServletInsertUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInsertUsuario at " + request.getContextPath() + "</h1>");
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
        int idCedula;
        String estado;
        String usuario;
        String contrasenia;
        String nacionalidad;
        String regimen;
        String nombres;
        String apellidos;
        String fechaNacimiento;
        String fechaUltimaDeclaracionDeBienes;
        String tipoSangre;
        String sexo;
        String direccion;
        String etnia;

        //estas variables se usaran para recibir los datos 
        String op;

        //zona de captura de datos
        //con esta linea de codigo podemos recibir cualquier dato que venga de la vista
        idCedula = Integer.parseInt(request.getParameter("idCedula"));
        estado = request.getParameter("estado");
        usuario = request.getParameter("usuario");
        contrasenia = request.getParameter("contrasenia");
        nacionalidad = request.getParameter("nacionalidad");
        regimen = request.getParameter("regimen");
        nombres = request.getParameter("nombres");
        apellidos = request.getParameter("apellidos");
        fechaNacimiento = request.getParameter("fechaNacimiento");
        fechaUltimaDeclaracionDeBienes = request.getParameter("fechaUltimaDeclaracionDeBienes");
        tipoSangre = request.getParameter("tipoSangre");
        sexo = request.getParameter("sexo");
        direccion = request.getParameter("direccion");
        etnia = request.getParameter("etnia");

        // Verificación de existencia de idAsistencia en la solicitud
        String idAsistenciaParam = request.getParameter("idCedula");
        if (idAsistenciaParam != null && !idAsistenciaParam.isEmpty()) {
            idCedula = Integer.parseInt(idAsistenciaParam);
        } else {
            idCedula = 0; // O asigna el valor que desees para indicar que no se proporcionó un id
        }

        op = request.getParameter("operacion");

        switch (op.toUpperCase()) {
            case "GUARDAR":
                Usuario objInsert = new Usuario(idCedula, estado, usuario, contrasenia, nacionalidad,
                        regimen, nombres, apellidos, fechaNacimiento, estado,
                        fechaUltimaDeclaracionDeBienes, fechaUltimaDeclaracionDeBienes,
                        tipoSangre, sexo, direccion, etnia);

                if (test.registrarUsuario(objInsert)) {
                    mensaje = "Datos insertados correctamente";
                } else {
                    mensaje = "Error en la inserción de datos";
                }
                break;

            case "EDITAR":
                Usuario objact = new Usuario(idCedula, estado, usuario, contrasenia, nacionalidad,
                        regimen, nombres, apellidos, fechaNacimiento, estado,
                        fechaUltimaDeclaracionDeBienes, fechaUltimaDeclaracionDeBienes,
                        tipoSangre, sexo, direccion, etnia);

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

        RequestDispatcher objdevuelve = request.getRequestDispatcher("usuarioInsert.jsp");
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
