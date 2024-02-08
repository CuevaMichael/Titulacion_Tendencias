<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nueva Asistencia</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                padding-top: 70px;
                background-image: linear-gradient(to right, #135058, #F1F2B5);
                background-size: cover;
                background-position: center;
                background-repeat: no-repeat;
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .card {
                background-color: rgba(255, 255, 255, 0.8);
            }
        </style>
        <script type="text/javascript">
            // Función para obtener un parámetro de la URL
            function obtenerParametroURL(nombre) {
                var url = new URL(window.location.href);
                return url.searchParams.get(nombre);
            }

            // Función para llenar los campos del formulario con los parámetros de la URL
            function llenarCamposFormulario() {
                var idAsistencia = obtenerParametroURL('id');
                var cedula = obtenerParametroURL('cedula');
                var fecha = obtenerParametroURL('fecha');
                var horaEntrada = obtenerParametroURL('entrada');
                var horaSalida = obtenerParametroURL('salida');
                var observaciones = obtenerParametroURL('observaciones');
                var cumpleOchoHoras = obtenerParametroURL('cumplimiento');
                var hojaRuta = obtenerParametroURL('ruta');
                var inicioRuta = obtenerParametroURL('inicioRuta');
                var finRuta = obtenerParametroURL('finRuta');

                // Comprobar si los parámetros están presentes antes de llenar los campos
                if (idAsistencia !== null && cedula !== null && fecha !== null) {
                    document.getElementById('idAsistencia').value = idAsistencia;
                    document.getElementById('usuario_idCedula').value = cedula;
                    document.getElementById('fechaAsistencia').value = fecha;
                    document.getElementById('horaEntrada').value = horaEntrada;
                    document.getElementById('horaSalida').value = horaSalida;
                    document.getElementById('observaciones').value = observaciones;
                    document.getElementById('cumpleOchoHoras').value = cumpleOchoHoras;
                    document.getElementById('hojaRuta').value = hojaRuta;
                    document.getElementById('horaInicioHojaRuta').value = inicioRuta;
                    document.getElementById('horaFinHojaRuta').value = finRuta;
                }
            }

            // Ejecutar la función después de que la página se haya cargado
            document.addEventListener('DOMContentLoaded', llenarCamposFormulario);

            // Función para verificar si se cumplen las ocho horas de trabajo y obtener la cantidad de horas trabajadas
            function verificarHorasTrabajo(horaEntrada, horaSalida) {
                // ... (tu código existente)
            }

            // Función para calcular la diferencia en horas y validar el formulario
            function calcularHorasTrabajo() {
                // Obtener las horas de inicio y fin
                var horaInicio = document.getElementById('horaEntrada').value;
                var horaFinal = document.getElementById('horaSalida').value;

                // Validar que las horas de entrada y salida estén presentes
                if (horaInicio && horaFinal) {
                    // Convertir las horas a objetos de fecha para facilitar el cálculo
                    var fechaInicio = new Date('2000-01-01T' + horaInicio + ':00');
                    var fechaFinal = new Date('2000-01-01T' + horaFinal + ':00');
                    // Calcular la diferencia en milisegundos
                    var diferenciaTiempo = fechaFinal - fechaInicio;
                    // Convertir la diferencia a horas
                    var diferenciaHoras = Math.floor(diferenciaTiempo / (1000 * 60 * 60));

                    // Mostrar el resultado en el campo de cumpleOchoHoras
                    document.getElementById('cumpleOchoHoras').value = diferenciaHoras;

                    // Verificar si cumple las ocho horas y mostrar el mensaje
                    var resultado = verificarHorasTrabajo(horaInicio, horaFinal);
                    document.getElementById('cumpleOchoHoras').value = resultado.horasTrabajadas;
                    if (resultado.cumpleOchoHoras) {
                        alert('SI CUMPLE LAS OCHO HORAS');
                    } else {
                        alert('NO CUMPLE LAS OCHO HORAS');
                    }
                }
            }

            // Asociar la función al evento de entrada (input) en las horas
            document.getElementById('horaEntrada').addEventListener('input', calcularHorasTrabajo);
            document.getElementById('horaSalida').addEventListener('input', calcularHorasTrabajo);
            // Llamar a la función inicialmente para mostrar un valor predeterminado
            calcularHorasTrabajo();
        </script>
    </head>

    <body>
        <!-- Barra de navegación -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="bienvenido.jsp">Bienvenido a Talentum</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="asistenciasCrud.jsp">Regresar</a>
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
                            <h2 class="text-center mb-5">Agregar/Modificar Asistencias</h2>
                            <!-- Formulario de inicio de sesión con acción "ServletInsertAsistencia" y método POST -->
                            <form action="ServletInsertAsistencia" method="post">
                                <!-- Campo de entrada para el nombre de usuario -->
                                <div class="form-group" id="idAsistenciaContainer">
                                    <label for="idAsistencia" class="form-label">Id Asistencia</label>
                                    <input name="idAsistencia" type="text" class="form-control" id="idAsistencia" required>
                                </div>
                                <div class="form-group">
                                    <label for="usuario_idCedula" class="form-label">Cédula</label>
                                    <input name="usuario_idCedula" type="text" class="form-control" id="usuario_idCedula"
                                           placeholder="cédula docente" required>
                                </div>
                                <div class="form-group">
                                    <label for="fechaAsistencia" class="form-label">Fecha de Asistencia</label>
                                    <input name="fechaAsistencia" type="date" class="form-control" id="fechaAsistencia"
                                           required>
                                </div>
                                <div class="form-group">
                                    <label for="horaEntrada" class="form-label">Hora de entrada</label>
                                    <input name="horaEntrada" type="time" class="form-control" id="horaEntrada" required>
                                </div>
                                <div class="form-group">
                                    <label for="horaSalida" class="form-label">Hora de salida</label>
                                    <input name="horaSalida" type="time" class="form-control" id="horaSalida" required>
                                </div>
                                <div class="form-group">
                                    <label for="observaciones" class="form-label">Observaciones</label>
                                    <input name="observaciones" type="text" class="form-control" id="observaciones"
                                           required>
                                </div>
                                <div class="form-group">
                                    <label for="cumpleOchoHoras" class="form-label">Cumple sus horas (ocho)</label>
                                    <input name="cumpleOchoHoras" type="text" class="form-control" id="cumpleOchoHoras"
                                           required>
                                </div>
                                <div class="form-group">
                                    <label for="hojaRuta" class="form-label">Hoja de ruta</label>
                                    <input name="hojaRuta" type="text" class="form-control" id="hojaRuta"
                                           placeholder="Si es necesario llena este campo caso contrario no">
                                </div>
                                <div class="form-group">
                                    <label for="horaInicioHojaRuta" class="form-label">Inicio hoja ruta</label>
                                    <input name="horaInicioHojaRuta" type="time" class="form-control"
                                           id="horaInicioHojaRuta" placeholder="Si es necesario llena este campo caso contrario no">
                                </div>
                                <div class="form-group">
                                    <label for="horaFinHojaRuta" class="form-label">Fin hoja ruta</label>
                                    <input name="horaFinHojaRuta" type="time" class="form-control" id="horaFinHojaRuta"
                                           placeholder="Si es necesario llena este campo caso contrario no">
                                </div>
                                <br>
                                <!-- Botón de envío para el formulario de inicio de sesión -->
                                <input name="operacion" type="submit" class="btn btn-primary" value="GUARDAR">
                                <input name="operacion" type="submit" class="btn btn-primary" value="EDITAR">
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