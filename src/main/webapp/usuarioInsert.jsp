<%-- 
    Document   : usuario
    Created on : 18/01/2024, 10:05:11
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nuevo Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-image: linear-gradient(to right, #135058, #F1F2B5);
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;          
            display: flex;
            align-items: center;
            justify-content: center;
            padding-top: 70px;
            margin-bottom: 0; /* Evita el espacio en blanco en la parte inferior */
        }

        .navbar {
            background-color: #343a40 !important; /* Cambia el color de fondo de la barra de navegación */
        }

        .card {
            background-color: rgba(255, 255, 255, 0.8);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Agrega una sombra a la tarjeta */
        }

        .form-group {
            margin-bottom: 15px; /* Añade espacio entre los campos del formulario */
        }

        .btn-primary {
            background-color: #000000; /* Cambia el color de fondo del botón primario a negro */
            border-color: #000000; /* Cambia el color del borde del botón primario a negro */
        }

        .footer {
            background-color: transparent; /* Cambia el color de fondo del pie de página a transparente */
        }
    </style>
</head>

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
                        <a class="nav-link" href="modificar.jsp">Regresar</a>
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
                        <h2 class="text-center mb-5">Agregar/Modificar registro del Docente</h2>
                        <!-- Formulario de inicio de sesión con acción "Servlet1" y método POST -->
                        <form action="ServletInsertUsuario" method="post">
                            <!-- Campo de entrada para el nombre de usuario -->
                            <div class="form-group">
                                <label for="idCedula" class="form-label">Cedula del docente</label>
                                <input name="idCedula" type="text" class="form-control" id="idCedula">
                            </div>
                            <div class="form-group">
                                <label for="estado" class="form-label">Estado</label>
                                <input name="estado" type="text" class="form-control" id="estado">
                            </div>
                            <div class="form-group">
                                <label for="usuario" class="form-label">Usuario</label>
                                <input name="usuario" type="text" class="form-control" id="usuario">
                            </div>
                            <div class="form-group">
                                <label for="contrasenia" class="form-label">Contraseña</label>
                                <input name="contrasenia" type="text" class="form-control" id="contrasenia">
                            </div>
                            <div class="form-group">
                                <label for="nacionalidad" class="form-label">Nacionalidad</label>
                                <input name="nacionalidad" type="text" class="form-control" id="nacionalidad">
                            </div>
                            <div class="form-group">
                                <label for="regimen" class="form-label">Regimen</label>
                                <input name="regimen" type="text" class="form-control" id="regimen">
                            </div>
                            <div class="form-group">
                                <label for="nombres" class="form-label">Nombres</label>
                                <input name="nombres" type="text" class="form-control" id="nombres">
                            </div>
                            <div class="form-group">
                                <label for="apellidos" class="form-label">Apellidos</label>
                                <input name="apellidos" type="text" class="form-control" id="apellidos">
                            </div>
                            <div class="form-group">
                                <label for="fechaNacimiento" class="form-label">Fecha de nacimiento</label>
                                <input name="fechaNacimiento" type="date" class="form-control" id="fechaNacimiento">
                            </div>
                            <div class="form-group">
                                <label for="estadoCivil" class="form-label">Estado civil</label>
                                <input name="estadoCivil" type="text" class="form-control" id="estadoCivil">
                            </div>
                            <div class="form-group">
                                <label for="fechaAntecedentesServicioPublico" class="form-label">Fecha antecedentes de servicio publico</label>
                                <input name="fechaAntecedentesServicioPublico" type="date" class="form-control" id="fechaAntecedentesServicioPublico">
                            </div>
                            <div class="form-group">
                                <label for="fechaUltimaDeclaracionDeBienes" class="form-label">Fecha de la ultima declaracion de bienes</label>
                                <input name="fechaUltimaDeclaracionDeBienes" type="date" class="form-control" id="fechaUltimaDeclaracionDeBienes">
                            </div>
                            <div class="form-group">
                                <label for="tipoSangre" class="form-label">Tipo de sangre</label>
                                <input name="tipoSangre" type="text" class="form-control" id="usuario">
                            </div>
                            <div class="form-group">
                                <label for="sexo" class="form-label">Sexo</label>
                                <input name="sexo" type="text" class="form-control" id="sexo">
                            </div>
                            <div class="form-group">
                                <label for="direccion" class="form-label">Direccion</label>
                                <input name="direccion" type="text" class="form-control" id="direccion">
                            </div>
                            <div class="form-group">
                                <label for="etnia" class="form-label">Etnia</label>
                                <input name="etnia" type="text" class="form-control" id="etnia">
                            </div>

                            <br>
                            <!-- Botones de envío para el formulario de inicio de sesión -->
                            <div class="text-center">
                                <input name="operacion" type="submit" class="btn btn-primary" value="Guardar"> 
                                <input name="operacion" type="submit" class="btn btn-primary" value="Editar"> 
                            </div>

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
