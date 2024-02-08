/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import MODELO.ValidacionLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Servlet1", urlPatterns = {"/Servlet1"})
public class Servlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      private ValidacionLogin validacionLogin;

    public Servlet1() {
        this.validacionLogin = new ValidacionLogin();
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet1 at " + request.getContextPath() + "</h1>");
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
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
// Obtener el nombre de usuario y la contraseña de la solicitud
        String nick = request.getParameter("nick");
        String contrasenia = request.getParameter("contrasenia");
        // Verificar las credenciales usando el modelo de usuario
        if (validacionLogin.verificarCredenciales(nick, contrasenia)) {
            // Si las credenciales son correctas, establecer la sesión y mostrar la vista de bienvenida
            // Obtener la sesión actual o crear una nueva si no existe
            HttpSession session = request.getSession();
            // Establecer un atributo en la sesión con el nombre de usuario
            session.setAttribute("nick", nick);
            // Eliminar el atributo "numeroIntentos" de la sesión (si existe)
            session.removeAttribute("numeroIntentos");
            // Llamar al método para mostrar la vista de bienvenida y pasar la respuesta HTTP como parámetro
            redirigirBienvenida(request, response);
        } else {
            // Si las credenciales son incorrectas, manejar el inicio de sesión fallido
            datosIncorrectos(request, response);
                       //zona de devolucion de datos
       
    
        }
        
   
    }

    private void datosIncorrectos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Obtener el número de intentos de inicio de sesión fallidos de la sesión
        Integer numeroIntentos = (Integer) request.getSession().getAttribute("numeroIntentos");
        // Verificar si el número de intentos es nulo
        if (numeroIntentos == null) {
            // Si es nulo, asignar el valor 0 para inicializarlo
            numeroIntentos = 0;
        }
        // Manejar el inicio de sesión fallido
        if (numeroIntentos < 2) {
            // Si hay menos de 2 intentos fallidos, incrementar el contador y mostrar el mensaje de error
            numeroIntentos++;
            // Establecer el atributo "numeroIntentos" en la sesión con el número actual de intentos de inicio de sesión fallidos
            request.getSession().setAttribute("numeroIntentos", numeroIntentos);
            // Calcular el número de intentos restantes permitidos
            int intentosRestantes = 3 - numeroIntentos;
            // Llamar al método para mostrar la vista de mensaje de error y pasar la respuesta HTTP y el número de intentos restantes como parámetros
           
            mostrarMensajeError(response, intentosRestantes);
   
            // Actualizar el número de intentos en el modelo
            validacionLogin.almacenarIntentos(numeroIntentos);
        } else {
            // Si hay 2 o más intentos fallidos, reiniciar el contador y mostrar el bloqueo de la cuenta
            request.getSession().removeAttribute("numeroIntentos");  // Limpiar el atributo de la sesión
            redirigirBloqueoCuenta(response);
            // Actualizar el número de intentos en el modelo
            validacionLogin.almacenarIntentos(0);
        }
    }

    // Nuevos métodos para manejar la lógica de redirección
    private void mostrarMensajeError(HttpServletResponse response, int intentosRestantes) throws IOException {
        // Obtener un objeto PrintWriter para escribir en la respuesta
        PrintWriter out = response.getWriter();
        // Verificar si hay intentos restantes
        if (intentosRestantes > 0) {
            // Mostrar un mensaje de error con la cantidad de intentos restantes
            out.print("<p style='color:black;'>Intentos restantes: " + intentosRestantes + "</p>");

        }
        // Redirigir la respuesta a la página "index.jsp"
        response.sendRedirect("index.jsp");
    }

    private void mostrarBloqueoCuenta(HttpServletResponse response) throws IOException {
        // Obtener un objeto PrintWriter para escribir en la respuesta
        PrintWriter out = response.getWriter();
        // Mostrar un mensaje de bloqueo
        out.println("<p style='color:black;'>Sus intentos han agotado, su cuenta se ha bloqueado</p>");
    }

    private void redirigirBienvenida(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("nick", request.getParameter("nick"));
        session.removeAttribute("numeroIntentos");
        response.sendRedirect("navegacionCrud.jsp");
    }


    // Método para redirigir a la página de bloqueo de cuenta
    private void redirigirBloqueoCuenta(HttpServletResponse response) throws IOException {
        mostrarBloqueoCuenta(response);
        response.sendRedirect("bloqueo.jsp");
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
