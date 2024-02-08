import CONTROLADOR.Servlet1;
import MODELO.Asistencia;
import MODELO.AsistenciaDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletInsertAsistencia", urlPatterns = {"/ServletInsertAsistencia"})
public class ServletInsertAsistencia extends HttpServlet {

    AsistenciaDAO test;
    String mensaje;

    public void init() throws ServletException {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        try {
            test = new AsistenciaDAO(jdbcURL, jdbcUserName, jdbcPassword);
            mensaje = "Conexión Exitosa";
        } catch (SQLException ex) {
            Logger.getLogger(Servlet1.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "Error de Conexión ";
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Obtén los parámetros del formulario
        String fechaAsistencia = request.getParameter("fechaAsistencia");
        String horaEntrada = request.getParameter("horaEntrada");
        String horaSalida = request.getParameter("horaSalida");
        String obserbaciones = request.getParameter("obserbaciones");
        String hojaRuta = request.getParameter("hojaRuta");
        String horaInicioHojaRuta = request.getParameter("horaInicioHojaRuta");
        String horaFinHojaRuta = request.getParameter("horaFinHojaRuta");
        int usuario_idCedula = Integer.parseInt(request.getParameter("usuario_idCedula"));

        String idAsistenciaParam = request.getParameter("idAsistencia");
        int idAsistencia = (idAsistenciaParam != null && !idAsistenciaParam.isEmpty())
                ? Integer.parseInt(idAsistenciaParam) : 0;

        String op = request.getParameter("operacion");

        // Calcula las horas y minutos
        int horasTrabajadas = calcularHorasTrabajadas(horaEntrada, horaSalida);
        int minutosTrabajados = calcularMinutosTrabajados(horaEntrada, horaSalida);

        // Determina si se cumplen las ocho horas
        String cumpleOchoHoras = (horasTrabajadas >= 8) ? "Sí" : "No";

        // Guarda los resultados en el objeto Asistencia
        Asistencia objInsert = new Asistencia(fechaAsistencia, 
                horaEntrada, horaSalida, obserbaciones, 
                cumpleOchoHoras, hojaRuta, horaInicioHojaRuta,
                horaFinHojaRuta, usuario_idCedula);

        // Llama al método registrarAsistecia en tu AsistenciaDAO
        if (test.registrarAsistecia(objInsert)) {
            mensaje = "Datos insertados correctamente";
        } else {
            mensaje = "Error en la inserción de datos";
        }

        request.setAttribute("cajitamensajesbd", mensaje);

        // Redirige a la página de destino
        RequestDispatcher objdevuelve = request.getRequestDispatcher("asistenciasInsert.jsp");
        objdevuelve.forward(request, response);
    }

    // Métodos auxiliares para calcular horas y minutos
    private int calcularHorasTrabajadas(String horaEntrada, String horaSalida) {
        try {
            // Parsea las horas de entrada y salida al formato Time
            Time entrada = Time.valueOf(horaEntrada);
            Time salida = Time.valueOf(horaSalida);

            // Calcula la diferencia en milisegundos
            long diferencia = salida.getTime() - entrada.getTime();

            // Convierte la diferencia a horas
            int horasTrabajadas = (int) (diferencia / (60 * 60 * 1000));

            return horasTrabajadas;
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // Manejar la excepción apropiadamente según tus necesidades
        }
    }

    private int calcularMinutosTrabajados(String horaEntrada, String horaSalida) {
        try {
            // Parsea las horas de entrada y salida al formato Time
            Time entrada = Time.valueOf(horaEntrada);
            Time salida = Time.valueOf(horaSalida);

            // Calcula la diferencia en milisegundos
            long diferencia = salida.getTime() - entrada.getTime();

            // Convierte la diferencia a minutos
            int minutosTrabajados = (int) (diferencia / (60 * 1000));

            return minutosTrabajados;
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // Manejar la excepción apropiadamente según tus necesidades
        }
    }

}
