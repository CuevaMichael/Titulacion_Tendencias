<%-- 
    Document   : asistenciasInsert
    Created on : 18/01/2024, 10:05:11
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formación Acadcemica</title>
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
                            <a class="nav-link" href="formacionAcademica.jsp">Regresar</a>
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
                            <h2 class="text-center mb-5">Agregar/Modificar Registro de Formacion Academica</h2>
                            <!-- Formulario de inicio de sesión con acción "Servlet1" y método POST -->
                            <form action="ServletInsertFormacionAcademica" method="post">
                                <!-- Campo de entrada para el nombre de usuario -->

                                <div class="form-group">
                                    <label for="idFormacionAcademica" class="form-label">Id Formación Academica</label>
                                    <input name="idFormacionAcademica" type="text" class="form-control" id="idFormacionAcademica">
                                </div>
                                
                                <div class="form-group">
                                    <label for="usuario_idCedula" class="form-label">Cédula del docente</label>
                                    <input name="usuario_idCedula" type="text" class="form-control" id="usuario_idCedula">
                                </div>
                                <div class="form-group">
                                    <label for="nivelInstrucion" class="form-label">Nivel de instrución</label>
                                    <input name="nivelInstrucion" type="text" class="form-control" id="nivelInstrucion">
                                </div>
                                <div class="form-group">
                                    <label for="numeroRegistroCertificado" class="form-label">Número de registro certificado</label>
                                    <input name="numeroRegistroCertificado" type="text" class="form-control" id="numeroRegistroCertificado">
                                </div>
                                <div class="form-group">
                                    <label for="institucionEducativa" class="form-label">Institución educativa</label>
                                    <input name="institucionEducativa" type="text" class="form-control" id="institucionEducativa">
                                </div>
                                <div class="form-group">
                                    <label for="numeroAniosAprobados" class="form-label">Número de años aprobados</label>
                                    <input name="numeroAniosAprobados" type="text" class="form-control" id="numeroAniosAprobados">
                                </div>
                                <div class="form-group">
                                    <label for="areaConocimiento" class="form-label">Área de Conocimiento</label>
                                    <input name="areaConocimiento" type="text" class="form-control" id="areaConocimiento">
                                </div>
                                <div class="form-group">
                                    <label for="egresadoOgraduado" class="form-label">Egresado o graduado</label>
                                    <input name="egresadoOgraduado" type="text" class="form-control" id="egresadoOgraduado">
                                </div>
                                <div class="form-group">
                                    <label for="tituloObtenido" class="form-label">Título obtenido</label>
                                    <input name="tituloObtenido" type="text" class="form-control" id="tituloObtenido">
                                </div>
                                <div class="form-group">
                                    <label for="pais" class="form-label">País</label>
                                    <input name="pais" type="text" class="form-control" id="pais">
                                </div>

                                <br>
                                <!-- Botón de envío para el formulario d -->
                                <input name="operacion" type="submit" class="btn btn-primary" value="Guardar">
                                <input name="operacion" type="submit" class="btn btn-primary" value="Editar">                                <br>
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
        </div>
    </body>
</html>