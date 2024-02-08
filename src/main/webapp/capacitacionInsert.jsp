<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capacitación</title>

        <!-- Agrega jQuery -->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

        <!-- Estilos y otros scripts van aquí -->
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

        <!-- Script para manejar la selección de filas en la tabla -->
        <script>
            $(document).ready(function () {
                // Agregar un listener al evento click en las filas de la tabla
                $('#tablaCapacitaciones tbody').on('click', 'tr', function () {
                    // Obtener los datos de la fila seleccionada
                    var rowData = $(this).children('td').map(function () {
                        return $(this).text();
                    }).get();

                    // Crear un formulario dinámico
                    var form = $('<form action="capacitacionInsert.jsp" method="post"></form>');

                    // Agregar campos ocultos con los datos de la fila seleccionada
                    form.append('<input type="hidden" name="idCapacitacion" value="' + rowData[0] + '">');
                    form.append('<input type="hidden" name="cedula" value="' + rowData[1] + '">');
                    form.append('<input type="hidden" name="nombreEvento" value="' + rowData[2] + '">');
                    form.append('<input type="hidden" name="tipoEvento" value="' + rowData[3] + '">');
                    form.append('<input type="hidden" name="auspiciante" value="' + rowData[4] + '">');
                    form.append('<input type="hidden" name="duracionHoras" value="' + rowData[5] + '">');
                    form.append('<input type="hidden" name="tipoCertificado" value="' + rowData[6] + '">');
                    form.append('<input type="hidden" name="certificadoPor" value="' + rowData[7] + '">');
                    form.append('<input type="hidden" name="fechaInicio" value="' + rowData[8] + '">');
                    form.append('<input type="hidden" name="fechaFin" value="' + rowData[9] + '">');
                    form.append('<input type="hidden" name="pais" value="' + rowData[10] + '">');

                    // Adjuntar el formulario al cuerpo del documento y enviarlo
                    form.appendTo('body').submit();
                });
            });
        </script>
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
                            <a class="nav-link" href="capacitacion.jsp">Regresar</a>
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
                            <h2 class="text-center mb-5">Agregar/Modificar Capacitaciones</h2>
                            <!-- Formulario de inicio de sesión con acción "Servlet1" y método POST -->
                            <form action="ServletInsertCapacitacion" method="post">
                                <!-- Campo de entrada para el nombre de usuario -->
                                <div class="form-group">
                                    <label for="idCapasitacion" class="form-label">Id Capacitacipón</label>
                                    <input name="idCapasitacion" type="text" class="form-control" id="idCapasitacion">
                                </div>
                                <div class="form-group">
                                    <label for="cedula" class="form-label">Cédula del docente</label>
                                    <input name="usuario_idCedula" type="text" class="form-control" id="cedula">
                                </div>
                                <div class="form-group">
                                    <label for="nombreEvento" class="form-label">Nombre del evento</label>
                                    <input name="nombreEvento" type="text" class="form-control" id="nombreEvento">
                                </div>
                                <div class="form-group">
                                    <label for="tipoEvento" class="form-label">Tipo de evento</label>
                                    <input name="tipoEvento" type="text" class="form-control" id="tipoEvento">
                                </div>
                                <div class="form-group">
                                    <label for="auspiciante" class="form-label">Auspiciante del evento</label>
                                    <input name="auspiciante" type="text" class="form-control" id="auspiciante">
                                </div>
                                <div class="form-group">
                                    <label for="duracionHoras" class="form-label">Duración del evento (horas)</label>
                                    <input name="duracionHoras" type="time" class="form-control" id="duracionHoras">
                                </div>
                                <div class="form-group">
                                    <label for="tipoCertificado" class="form-label">Tipo de certificado</label>
                                    <input name="tipoCertificado" type="text" class="form-control" id="tipoCertificado">
                                </div>
                                <div class="form-group">
                                    <label for="certificadoPor" class="form-label">Certificado por</label>
                                    <input name="certificadoPor" type="text" class="form-control" id="certificadoPor">
                                </div>
                                <div class="form-group">
                                    <label for="fechaInicio" class="form-label">Fecha de inicio</label>
                                    <input name="fechaInicio" type="date" class="form-control" id="fechaInicio">
                                </div>
                                <div class="form-group">
                                    <label for="fechaFin" class="form-label">Fecha fin</label>
                                    <input name="fechaFin" type="date" class="form-control" id="fechaFin">
                                </div>
                                <div class="form-group">
                                    <label for="pais" class="form-label">País</label>
                                    <input name="pais" type="text" class="form-control" id="pais">
                                </div>
                                <br>
                                <!-- Botón de envío para el formulario de inicio de sesión -->
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
