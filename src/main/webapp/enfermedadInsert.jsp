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
        <title>Nuevo Registro</title>
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
                            <a class="nav-link" href="enfermedadCrud.jsp">Regresar</a>
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
                            <h2 class="text-center mb-5">Agregar/Modificar Registro de Discapacidad o Enfermedad</h2>
                            <!-- Formulario de inicio de sesión con acción "Servlet1" y método POST -->
                            <form action="ServletInsertEnfermedad" method="post">
                                <!-- Campo de entrada para el nombre de usuario -->

                                <div class="form-group">
                                    <label for="idDiscapacidadOenfermedad" class="form-label">Id Enfermedad/Discapacidas</label>
                                    <input name="idDiscapacidadOenfermedad" type="text" class="form-control" id="idDiscapacidadOenfermedad">
                                </div>
                                
                                <div class="form-group">
                                    <label for="usuario_idCedula" class="form-label">Cédula del Docente</label>
                                    <input name="usuario_idCedula" type="text" class="form-control" id="usuario_idCedula">
                                </div>
                                <div class="form-group">
                                    <label for="situacion" class="form-label">Situación</label>
                                    <input name="situacion" type="text" class="form-control" id="situacion">
                                </div>
                                <div class="form-group">
                                    <label for="numeroCarnetConadis" class="form-label">Número del carnet de conadis</label>
                                    <input name="numeroCarnetConadis" type="text" class="form-control" id="numeroCarnetConadis">
                                </div>
                                <div class="form-group">
                                    <label for="certificadoEnfermedadCarastrofica" class="form-label">Certificado de enfermedad carastrofica</label>
                                    <input name="certificadoEnfermedadCarastrofica" type="text" class="form-control" id="certificadoEnfermedadCarastrofica">
                                </div>
                                <div class="form-group">
                                    <label for="tipoDiscapacidad" class="form-label">Tipo de discapacidad</label>
                                    <input name="tipoDiscapacidad" type="text" class="form-control" id="tipoDiscapacidad">
                                </div>
                                <div class="form-group">
                                    <label for="porcentaje" class="form-label">Porcentaje</label>
                                    <input name="porcentaje" type="text" class="form-control" id="porcentaje">
                                </div>
                                <div class="form-group">
                                    <label for="tipoEnfermedad" class="form-label">Tipo de enfermedad</label>
                                    <input name="tipoEnfermedad" type="text" class="form-control" id="tipoEnfermedad">
                                </div>
                                <div class="form-group">
                                    <label for="tipoRelacion" class="form-label">Tipo de relación</label>
                                    <input name="tipoRelacion" type="text" class="form-control" id="tipoRelacion">
                                </div>

                                <br>
                                <!-- Botón de envío para el formulario d -->
                                <input name="operacion" type="submit" class="btn btn-primary" value="Guardar"> 
                                <input name="operacion" type="submit" class="btn btn-primary" value="Editar"> 
                                <br>
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
