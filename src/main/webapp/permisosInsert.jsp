<%@page import="java.util.List"%>
<%@page import="MODELO.Permiso"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Permisos</title>
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

        <script>
            // Función para obtener un parámetro de la URL
            function obtenerParametroURL(nombre) {
                var url = new URL(window.location.href);
                return url.searchParams.get(nombre);
            }

            // Función para ocultar el campo "Id Asistencia" si la acción es "agregar"
            function ocultarCampoIdAsistencia() {
                var accion = obtenerParametroURL('accion');
                console.log("Valor de accion:", accion);

                if (accion === 'agregar') {
                    console.log("Ocultando el campo 'Id Asistencia'");
                    document.getElementById("idAsistenciaContainer").style.display = "none";
                }
            }

            // Ejecutar la función después de que la página se haya cargado
            document.addEventListener('DOMContentLoaded', ocultarCampoIdAsistencia);
        </script>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                // Función para calcular el valor a descontar y la diferencia en días
                function calcularValorDescontarYDias() {
                    // Obtener el motivo seleccionado
                    var motivoSelect = document.getElementById('motivoSelect');
                    var motivoSeleccionado = motivoSelect.options[motivoSelect.selectedIndex].value;

                    // Obtener las fechas y horas de inicio y fin
                    var fechaInicio = new Date(document.getElementById('fechaInicioPermiso').value + 'T' + document.getElementById('HoraInicio').value + ':00');
                    var fechaFinal = new Date(document.getElementById('fechaFinalPermiso').value + 'T' + document.getElementById('HoraFinal').value + ':00');

                    // Calcular la diferencia en milisegundos
                    var diferenciaTiempo = fechaFinal - fechaInicio;

                    // Convertir la diferencia a días
                    var diferenciaDias = Math.floor(diferenciaTiempo / (1000 * 60 * 60 * 24));

                    // Mostrar el resultado en el campo de díasPermiso
                    document.getElementById('diasPermiso').value = diferenciaDias;

                    // Inicializar el campo de valordescontar en 0
                    var valorDescontar = 0;

                    // Calcular el valor a descontar solo si el motivo es "Permiso de días con cargo a vacaciones"
                    if (motivoSeleccionado === 'Permiso de dias con cargo a vacaciones') {
                        valorDescontar = diferenciaDias * 1.36;
                    }

                    // Mostrar el resultado en el campo de valor a descontar
                    document.getElementById('valordescontar').value = valorDescontar.toFixed(2);
                }

                // Asociar la función al evento de cambio en las fechas, horas y motivo
                document.getElementById('fechaInicioPermiso').addEventListener('change', calcularValorDescontarYDias);
                document.getElementById('fechaFinalPermiso').addEventListener('change', calcularValorDescontarYDias);
                document.getElementById('HoraInicio').addEventListener('change', calcularValorDescontarYDias);
                document.getElementById('HoraFinal').addEventListener('change', calcularValorDescontarYDias);
                document.getElementById('motivoSelect').addEventListener('change', calcularValorDescontarYDias);

                // Llamar a la función inicialmente para mostrar un valor predeterminado
                calcularValorDescontarYDias();
            });
        </script>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                // Función para calcular la diferencia en horas
                function calcularHorasPermiso() {
                    // Obtener las horas de inicio y fin
                    var horaInicio = document.getElementById('HoraInicio').value;
                    var horaFinal = document.getElementById('HoraFinal').value;

                    // Convertir las horas a objetos de fecha para facilitar el cálculo
                    var fechaInicio = new Date('2000-01-01T' + horaInicio + ':00');
                    var fechaFinal = new Date('2000-01-01T' + horaFinal + ':00');

                    // Calcular la diferencia en milisegundos
                    var diferenciaTiempo = fechaFinal - fechaInicio;

                    // Convertir la diferencia a horas
                    var diferenciaHoras = Math.floor(diferenciaTiempo / (1000 * 60 * 60));

                    // Mostrar el resultado en el campo de horasPermiso
                    document.getElementById('horasPermiso').value = diferenciaHoras;
                }

                // Asociar la función al evento de entrada (input) en las horas
                document.getElementById('HoraInicio').addEventListener('input', calcularHorasPermiso);
                document.getElementById('HoraFinal').addEventListener('input', calcularHorasPermiso);

                // Llamar a la función inicialmente para mostrar un valor predeterminado
                calcularHorasPermiso();
            });

        </script>
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
                            <a class="nav-link" href="asistenciasCrud.jsp">Regresar</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
            <h3>Gestion de permisos</h3>
            <div class ="row justify-content-md-center">
                <div class="card" style=
                     "width: 50rem;">
                    <div class="card-body">
                        <form action="ServletPermiso" method="post">
                            <!-- Campo de entrada para el nombre de usuario -->
                            <div class="form-group" id="idAsistenciaContainer">
                                <label for="idPermiso" class="form-label">Id Permiso</label>
                                <input name="idPermiso" type="text" class="form-control" id="idPermiso">
                            </div>

                            <div class="form-group">
                                <label for="usuario_idCedula" class="form-label">Cédula del docente</label>
                                <input name="usuario_idCedula" type="text" class="form-control" id="usuario_idCedula" required>
                            </div>
                            <div class="form-group">
                                <label for="idUpdate" class="form-label">Seleccionar motivo:</label>
                                <select class="form-control" name="motivo" id="motivoSelect" required>
                                    <!-- Opción predeterminada -->
                                    <option value="" selected disabled>Seleccione un motivo</option>

                                    <!-- Opciones de motivo -->
                                    <option value="Licencia por calamidad domestica">Licencia por calamidad domestica</option>
                                    <option value="Licencia por enfermedad">Licencia por enfermedad</option>
                                    <option value="Licencia por maternidad">Licencia por maternidad</option>
                                    <option value="Licencia por matrimonio o union de hecho">Licencia por matrimonio o union de hecho</option>
                                    <option value="Licencia por paternidad">Licencia por paternidad</option>
                                    <option value="Permiso para estudios regulares">Permiso para estudios regulares</option>
                                    <option value="Permiso de dias con cargo a vacaciones">Permiso de dias con cargo a vacaciones</option>
                                    <option value="Permiso por asuntos oficiales">Permiso por asuntos oficiales</option>
                                    <option value="Permiso para atencion medica">Permiso para atencion medica</option>
                                    <option value="Otros">Otros</option>
                                </select>
                                <!-- Formulario adicional para la opción "Otros" -->
                                <div id="otrosFormulario" style="display: none;">
                                    <div class="col-md-6">
                                        <label for="otrosMotivo" class="form-label">Motivo detallado:</label>
                                        <input type="text" class="form-control" name="otrosMotivo" id="otrosMotivo">
                                    </div>
                                    <!-- Otros campos que desees agregar -->
                                </div>
                                <script>
                                    document.getElementById("motivoSelect").addEventListener("change", function () {
                                        var otrosFormulario = document.getElementById("otrosFormulario");
                                        if (this.value === "Otros") {
                                            otrosFormulario.style.display = "block";
                                        } else {
                                            otrosFormulario.style.display = "none";
                                        }
                                    });

                                </script>


                            </div>
                            <div class="form-group">
                                <label for="fechaInicioPermiso" class="form-label">Fecha inicio</label>
                                <input name="fechaInicioPermiso" type="date" class="form-control" id="fechaInicioPermiso" onchange="calcularValorDescontar()" required>
                            </div>
                            <div class="form-group">
                                <label for="fechaFinalPermiso" class="form-label">Fecha fin</label>
                                <input name="fechaFinalPermiso" type="date" class="form-control" id="fechaFinalPermiso" onchange="calcularValorDescontar()" required>
                            </div>
                            <div class="form-group">
                                <label for="HoraInicio" class="form-label">Hora inicio</label>
                                <input name="HoraInicio" type="time" class="form-control" id="HoraInicio" required>
                            </div>
                            <div class="form-group">
                                <label for="HoraFinal" class="form-label">Hora fin</label>
                                <input name="HoraFinal" type="time" class="form-control" id="HoraFinal" required>
                            </div>
                            <div class="form-group">
                                <label for="valordescontar" class="form-label">Valor a descontar</label>
                                <input name="valordescontar" type="text" class="form-control" id="valordescontar" readonly>
                            </div>
                            <div class="form-group">
                                <label for="diasPermiso" class="form-label">Días de permiso</label>
                                <input name="diasPermiso" type="text" class="form-control" id="diasPermiso" required>
                            </div>

                            <div class="form-group">
                                <label for="horasPermiso" class="form-label">Horas de permiso</label>
                                <input name="horasPermiso" type="text" class="form-control" id="horasPermiso" required>
                            </div>
                            <div class="form-group">
                                <label for="observaciones" class="form-label">Observaciones</label>
                                <input name="observaciones" type="text" class="form-control" id="observaciones" required>
                            </div>

                            <br>
                            <!-- Botón de envío para el formulario de inicio de sesión -->
                            <input name="operacion" type="submit" class="btn btn-dark" value="Guardar"> 
                            <input name="operacion" type="submit" class="btn btn-light text-dark border-dark" value="Editar"> 
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
    </body>
</html>