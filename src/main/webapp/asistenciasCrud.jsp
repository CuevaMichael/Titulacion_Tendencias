<%@ page import="java.util.List" %>
<%@ page import="MODELO.Asistencia" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asistencia</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
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

            // Ejecutar la función después de que la página se haya cargado
            document.addEventListener('DOMContentLoaded', llenarCamposFormulario);
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
                            <a class="nav-link" href="#">DE LA CUEVA COYAGUILLO MICHAEL ANGHEL</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="navegacionCrud.jsp">Continuar Registro</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Generar reporte</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container mt-3">
            <div class="row">
                <div class="col-md-20 offset-md-0">
                    <div class="mb-3">
                        <p style="font-size: larger; color: white;"><b>ASISTENCIAS</b></p>
                        <p style="color: white;">Ingresar un nuevo registro</p>
                        <div class="row mt-1">
                            <div class="col-md-4">
                                <a href="asistenciasInsert.jsp" class="btn btn-dark">Ingresar</a>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Formulario de control de asistencias -->
                <form action="MostrarDatosAsistencia" method="post">
                    <div class="container-fluid">
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="idCedula" class="form-label">Buscar docente</label>
                                <input name="idCedula" type="text" class="form-control" id="idCedula"
                                       placeholder="Ingresa la cédula">
                                <br>
                                <input name="operacion" type="submit" class="btn btn-dark" value="FILTRAR">
                                <input name="operacion" type="submit" class="btn btn-light text-dark border-dark"
                                       value="MOSTRAR TODOS LOS DATOS">
                            </div>
                            <div class="col-md-6">
                                <label for="deleteId" class="form-label">ID para eliminar su asistencia</label>
                                <input name="deleteId" type="text" class="form-control" id="deleteId">
                                <br>
                                <input name="operacion" type="submit" class="btn btn-light text-dark border-dark"
                                       value="ELIMINAR">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="idUpdate" class="form-label">ID para editar las Observaciones</label>
                                <input name="idUpdate" type="text" class="form-control" id="idUpdate">
                                <br>
                                <input name="operacion" type="submit" class="btn btn-dark" value="EDITAR">
                                <a href="asistenciasInsert.jsp" class="btn btn-light text-dark border-dark">EDITAR TODO</a>
                            </div>
                            <div class="col-md-6">
                                <label for="datos" class="form-label">Observaciones</label>
                                <input name="datos" type="text" class="form-control" id="datos" placeholder="">
                                <br>
                            </div>
                        </div>
                </form>
            </div>

            <%
                if (request.getAttribute("resultado") != null) {
                    out.println(request.getAttribute("resultado"));
                    out.println(request.getAttribute("resultadoUpdate"));
                }
            %>

            <div class="col-sm-18">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID ASISTENCIA</th>
                            <th>FECHA</th>
                            <th>HORA DE ENTRADA</th>
                            <th>HORA DE SALIDA</th>
                            <th>OBSERVACIONES</th>
                            <th>CUMPLE OCHO HORAS</th>
                            <th>HOJA DE RUTA</th>
                            <th>HORA INICIO RUTA</th>
                            <th>HORA FIN RUTA</th>
                            <th>CÉDULA DEL DOCENTE</th>
                            <th>ACCIÓN</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (request.getAttribute("cajitareporte") != null) {
                                List<Asistencia> arrCapas = (List<Asistencia>) request.getAttribute("cajitareporte");
                                for (Asistencia capas : arrCapas) {
                        %>
                        <tr>
                            <td><%= capas.getIdAsistencia() %></td>
                            <td><%= capas.getFechaAsistencia() %></td>
                            <td><%= capas.getHoraEntrada() %></td>
                            <td><%= capas.getHoraSalida() %></td>
                            <td><%= capas.getObserbaciones() %></td>
                            <td><%= capas.getCumpleOchoHoras() %></td>
                            <td><%= capas.getHojaRuta() %></td>
                            <td><%= capas.getHoraInicioHojaRuta() %></td>
                            <td><%= capas.getHoraFinHojaRuta() %></td>
                            <td><%= capas.getUsuario_idCedula() %></td>
                            <td>
                                <!-- Agrega un botón de edición con un ícono de lápiz y datos asociados a cada fila -->
                                <a href="#" onclick="capturarDatos('<%= capas.getIdAsistencia() %>', '<%= capas.getUsuario_idCedula() %>',
                                            '<%= capas.getFechaAsistencia() %>', '<%= capas.getHoraEntrada() %>', '<%= capas.getHoraSalida() %>',
                                            '<%= capas.getObserbaciones() %>', '<%= capas.getCumpleOchoHoras() %>', '<%= capas.getHojaRuta() %>',
                                            '<%= capas.getHoraInicioHojaRuta() %>', '<%= capas.getHoraFinHojaRuta() %>')"
                                   class="btn btn-dark btn-sm">
                                    Editar
                                </a>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>

        <script type="text/javascript">
            // Función para capturar datos y redirigir al formulario de edición
            function capturarDatos(id, cedula, fecha, horaEntrada, horaSalida, observaciones, cumpleOchoHoras, hojaRuta,
                    inicioRuta, finRuta) {
                var url = "asistenciasInsert.jsp" +
                        "?id=" + id +
                        "&cedula=" + cedula +
                        "&fecha=" + fecha +
                        "&entrada=" + horaEntrada +
                        "&salida=" + horaSalida +
                        "&observaciones=" + observaciones +
                        "&cumplimiento=" + cumpleOchoHoras +
                        "&ruta=" + hojaRuta +
                        "&inicioRuta=" + inicioRuta +
                        "&finRuta=" + finRuta;
                window.location.href = url;
            }
        </script>
    </body>

</html>