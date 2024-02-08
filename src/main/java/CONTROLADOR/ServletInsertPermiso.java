package CONTROLADOR;

import MODELO.Permiso;
import MODELO.PermisoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletInsertPermiso", urlPatterns = {"/ServletInsertPermiso"})
public class ServletInsertPermiso extends HttpServlet {

    PermisoDAO test;
    String mensaje;

    public void init() throws ServletException {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        try {
            test = new PermisoDAO(jdbcURL, jdbcUserName, jdbcPassword);
            mensaje = "Conexión Exitosa";
        } catch (SQLException ex) {
            Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "Error de Conexión";
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/permisosCrud.jsp");
            rd.forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
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
       int idPermiso;
        String motivo;
        String fechaInicioPermiso;
        String fechaFinalPermiso;
        String HoraInicio;
        String HoraFinal;
        String diasPermiso;
        String horasPermiso;
        String observaciones;
        String valordescontar;
        int usuario_idCedula;

        motivo = request.getParameter("motivo");
        fechaInicioPermiso = request.getParameter("fechaInicioPermiso");
        fechaFinalPermiso = request.getParameter("fechaFinalPermiso");
        HoraInicio = request.getParameter("HoraInicio");
        HoraFinal = request.getParameter("HoraFinal");
        diasPermiso = request.getParameter("diasPermiso");
        horasPermiso = request.getParameter("horasPermiso");
        observaciones = request.getParameter("observaciones");
        valordescontar = request.getParameter("valordescontar");
        usuario_idCedula = Integer.parseInt(request.getParameter("usuario_idCedula"));

        //estas variables se usaran para recibir los datos 
        String op;
        //zona de captura de datos
        //con esta linea de codigo podemos recibir cualquier dato que venga de la vista

        // Verificación de existencia de idPermiso en la solicitud
        String idPermisoParam = request.getParameter("idPermiso");
        if (idPermisoParam
                != null && !idPermisoParam.isEmpty()) {
            idPermiso = Integer.parseInt(idPermisoParam);
        } else {
            idPermiso = 0; // O asigna el valor que desees para indicar que no se proporcionó un id
        }

        op = request.getParameter("operacion");

        switch (op.toUpperCase()) {
            // Dentro del switch "GUARDAR" del método doPost

            case "GUARDAR":
        

                if (motivo.equals("Otros")) {
                    String otrosMotivo = request.getParameter("otrosMotivo");

                    // Crea un nuevo objeto Permiso con el motivo detallado
                    Permiso objInsertOtros = new Permiso(otrosMotivo, fechaInicioPermiso,
                            fechaFinalPermiso, HoraInicio, HoraFinal, diasPermiso, horasPermiso,
                            observaciones, valordescontar, usuario_idCedula);

                    // Llama al método de la clase PermisoDAO para insertar el permiso con motivo "Otros"
                    if (test.registrarPermiso(objInsertOtros)) {
                        mensaje = "Datos insertados correctamente'";
                    } else {
                        mensaje = "Error en la inserción de datos";
                    }
                } else {
                    // Crea un nuevo objeto Permiso con el motivo seleccionado
                    Permiso objInsert = new Permiso(motivo, fechaInicioPermiso, 
                            fechaFinalPermiso, HoraInicio, HoraFinal, diasPermiso,
                            horasPermiso, observaciones, valordescontar, usuario_idCedula);

                    // Llama al método de la clase PermisoDAO para insertar el permiso con motivo seleccionado
                    if (test.registrarPermiso(objInsert)) {
                        mensaje = "Datos insertados correctamente";
                    } else {
                        mensaje = "Error en la inserción de datos";
                    }
                }
                break;

           case "EDITAR":
    // ... (código existente)

    // Verifica si la opción seleccionada es "Otros" y captura el motivo detallado
    if (motivo.equals("Otros")) {
        String otrosMotivo = request.getParameter("otrosMotivo");

        // Crea un nuevo objeto Permiso con el motivo detallado
                    Permiso objEditOtros = new Permiso(otrosMotivo, fechaInicioPermiso, 
                            fechaFinalPermiso, HoraInicio, HoraFinal, diasPermiso,
                            horasPermiso, observaciones, valordescontar, usuario_idCedula);

        // Llama al método de la clase PermisoDAO para editar el permiso con motivo "Otros"
        if (test.EditarTODO(objEditOtros)) {
            mensaje = "Registro actualizado'";
        } else {
            mensaje = "Error al actualizar";
        }
    } else {
        // Crea un nuevo objeto Permiso con el motivo seleccionado
        Permiso objEdit = new Permiso(idPermiso, motivo, fechaInicioPermiso,
                fechaFinalPermiso, HoraInicio, HoraFinal,diasPermiso,horasPermiso, observaciones,
                valordescontar, usuario_idCedula);

        // Llama al método de la clase PermisoDAO para editar el permiso con motivo seleccionado
        if (test.EditarTODO(objEdit)) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar el registro";
        }
    }
    break;


            default:
                mensaje = "Operación no reconocida";
        }

        request.setAttribute("cajitamensajesbd", mensaje);
        request.getRequestDispatcher("/permisosCrud.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
