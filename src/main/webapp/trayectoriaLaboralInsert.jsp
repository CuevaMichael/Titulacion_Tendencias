<%-- 
    Document   : trayectoria
    Created on : 18/01/2024, 10:05:11
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Trayectoria Laboral</title>
    </head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 70px;
            /* Establece la imagen de fondo y ajusta su tamaño para cubrir todo el cuerpo */
            background-image: linear-gradient(to right, #135058, #F1F2B5);
            background-size: cover;
            /* Posiciona la imagen de fondo en el centro y evita que se repita */
            background-position: center;
            background-repeat: no-repeat;          
            display: flex;
            align-items: center;
            justify-content: center;

        }
        .card {
            background-color: rgba(255, 255, 255, 0.8); /* Color de fondo semi-transparente para la tarjeta */
        }
    </style>
    <body>
        <!-- Barra de navegación -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="bienvenido.jsp">Bienvenido a Talentum</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">


                        <li class="nav-item">
                            <a class="nav-link" href="trayectoriaLaboralCrud.jsp.jsp">Regresar</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Contenedor principal con margen superior -->
        <div class="container mt-1">
            <!-- Fila en el sistema de grillas de Bootstrap -->
            <div class="row">
                <!-- Crear una columna centrada en Bootstrap con un ancho específico en dispositivos grandes -->
                <div class="col-lg-6 mx-auto">
                    <!-- Tarjeta para el formulario de inicio de sesión -->
                    <div class="card">
                        <!-- Cuerpo de la tarjeta con relleno -->
                        <div class="card-body p-5">
                            <!-- Encabezado para el formulario de inicio de sesión -->
                            <h2 class="text-center mb-5">Agregar/Modificar Registro de Trayectoria Laboral</h2>
                            <!-- Formulario de inicio de sesión con acción "Servlet1" y método POST -->
                            <form action="ServletInsertTrayectoriaLaboral" method="post">
                                <!-- Campo de entrada para el nombre de usuario -->

                                <div class="form-group">
                                    <label for="cedula" class="form-label">Cedula del docente</label>
                                    <input name="usuario_idCedula" type="text" class="form-control" id="cedula">
                                </div>
                                <div class="form-group">
                                    <label for="tipoInstrucion" class="form-label">Tipo de instrución</label>
                                    <input name="tipoInstrucion" type="text" class="form-control" id="tipoInstrucion">
                                </div>
                                <div class="form-group">
                                    <label for="institucionOrganizacion" class="form-label">Institución o organización</label>
                                    <input name="institucionOrganizacion" type="text" class="form-control" id="institucionOrganizacion">
                                </div>
                                <div class="form-group">
                                    <label for="unidadAdministrativa" class="form-label">Unidad Administrativa</label>
                                    <input name="unidadAdministrativa" type="text" class="form-control" id="unidadAdministrativa">
                                </div>
                                <div class="form-group">
                                    <label for="puesto" class="form-label">Puesto</label>
                                    <input name="puesto" type="text" class="form-control" id="puesto">
                                </div>
                                <div class="form-group">
                                    <label for="fechaIngreso" class="form-label">Fecha ingreso</label>
                                    <input name="fechaIngreso" type="text" class="form-control" id="fechaIngreso">
                                </div>
                                <div class="form-group">
                                    <label for="fechaSalida" class="form-label">Fecha salida</label>
                                    <input name="fechaSalida" type="text" class="form-control" id="fechaSalida">
                                </div>
                                <div class="form-group">
                                    <label for="modalidadIngreso" class="form-label">Modalidad de ingreso</label>
                                    <input name="modalidadIngreso" type="text" class="form-control" id="modalidadIngreso">
                                </div>
                                <div class="form-group">
                                    <label for="motivoSalida" class="form-label">Motivo salida</label>
                                    <input name="motivoSalida" type="text" class="form-control" id="motivoSalida">
                                </div>

                                <br>
                                <!-- Botón de envío para el formulario de inicio de sesión -->
                                <input name="operacion" type="submit" class="btn btn-primary" value="Guardar">                                <br>
                                <%
                                    if (request.getAttribute("cajitamensajesbd") != null) {
                                        out.println(request.getAttribute("cajitamensajesbd"));
                                    }
                                %>
                                         </form>
                        </div>
                    </div>       
                </div>
            </div> 
    </body>
</html>