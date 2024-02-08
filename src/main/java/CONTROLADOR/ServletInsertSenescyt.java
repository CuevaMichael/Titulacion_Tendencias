package CONTROLADOR;

import MODELO.SituacionSenescyt;
import MODELO.SituacionSenescytDAO;
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

@WebServlet(name = "ServletInsertSenescyt", urlPatterns = {"/ServletInsertSenescyt"})
public class ServletInsertSenescyt extends HttpServlet {

    //variables de tipo global
    SituacionSenescytDAO test;
    String mensaje;

    //metodo para dar la orden para conectar a la base de datos
    public void init() throws ServletException {
        //recibo los datos para dar la orden de coneccion a la bd
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUSERName = getServletContext().getInitParameter("jdbcUSERName");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            test = new SituacionSenescytDAO(jdbcURL, jdbcUSERName, jdbcPassword);
            mensaje = "Conexión Exitosa";
        } catch (SQLException ex) {
            Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "Error de Conexión ";
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletInsertSenescyt</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletInsertSenescyt at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //zona de variables
        int idSituacionSenescyt;
        String fechaIngreso;
        String fechaSalida;
        String modalidad;
        String unidad;
        String puesto;
        String grupoOcupacional;
        int usuario_idCedula;

        //estas variables se usaran para recibir los datos 
        String op;

        //zona de captura de datos
        fechaIngreso = request.getParameter("fechaIngreso");
        fechaSalida = request.getParameter("fechaSalida");
        modalidad = request.getParameter("modalidad");
        unidad = request.getParameter("unidad");
        puesto = request.getParameter("puesto");
        grupoOcupacional = request.getParameter("grupoOcupacional");
        usuario_idCedula = Integer.parseInt(request.getParameter("usuario_idCedula"));

        String idSituacionSenescytParam = request.getParameter("idSituacionSenescyt");
        if (idSituacionSenescytParam != null && !idSituacionSenescytParam.isEmpty()) {
            idSituacionSenescyt = Integer.parseInt(idSituacionSenescytParam);
        } else {
            idSituacionSenescyt = 0;
        }

        op = request.getParameter("operacion");

        switch (op.toUpperCase()) {
            case "GUARDAR":
                SituacionSenescyt objInsert = new SituacionSenescyt(fechaIngreso,
                        fechaSalida, modalidad, unidad, puesto,
                        grupoOcupacional, usuario_idCedula);

                if (test.registrarSituacionSenescyt(objInsert)) {
                    mensaje = "Datos insertados correctamente";
                } else {
                    mensaje = "Error en la inserción de datos";
                }
                break;

            case "EDITAR":
                SituacionSenescyt objact = new SituacionSenescyt(idSituacionSenescyt,
                        fechaIngreso, fechaSalida, modalidad, unidad,
                        puesto, grupoOcupacional, usuario_idCedula);

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

        RequestDispatcher objdevuelve = request.getRequestDispatcher("senescytInsert.jsp");
        objdevuelve.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
