<%-- 
    Document   : modificar
    Created on : 20/12/2023, 8:49:11
    Author     : Michael
--%>

<%@page import="java.util.List"%>
<%@page import="MODELO.Permiso"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
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
                            <a class="nav-link active" aria-current="page"  href="navegacionCrud.jsp">Continuar Registro</a>
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

        <div class="container mt-3 ">
            <div class="row ">
                <div class="col-md-20 offset-md-0">

                    <div class="mb-3">
                        <p style="font-size: larger; color: white;" ><b>PERMISOS</b></p>
                        <p style="color: white;">Ingresar un nuevo registro</p> 
                        <div class="row mt-1">
                            <div class="col-md-4">
                                <a href="permisosInsert.jsp" class="btn btn-dark ">Ingresar</a>
                            </div>                            
                        </div>
                    </div>
                </div>
                <!-- Formulario de control de asistencias -->
                <form action="MostrarDatosPermisos" method="post">
                    <div class="container-fluid">

                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="idCedula" class="form-label">Buscar docente</label>
                                <input name="idCedula" type="text" class="form-control" id="idCedula" placeholder="Ingresa la cédula">
                                <br>
                                <input name="operacion" type="submit" class="btn btn-dark"value="FILTRAR">
                                <input name="operacion" type="submit" class="btn btn-light text-dark border-dark" value="MOSTRAR TODOS LOS DATOS">

                            </div>
                            <div class="col-md-6">
                                <label for="deleteId" class="form-label">ID para eliminar su permiso</label>
                                <input name="deleteId" type="text" class="form-control" id="deleteId">
                                <br>
                                <input name="operacion" type="submit" class="btn btn-danger" value="ELIMINAR">
                            </div> 
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="idUpdate" class="form-label">ID para editar el motivo</label>
                                <input name="idUpdate" type="text" class="form-control" id="idUpdate">
                                <br>
                                <input name="operacion" type="submit" class="btn btn-dark" value="EDITAR">
                                <a href="permisosInsert.jsp" class="btn btn-light text-dark border-dark">EDITAR TODO</a>


                            </div>
                            <div class="col-md-6">
                                <label for="idUpdate" class="form-label">Seleccionar motivo:</label>
                                <select class="form-control" name="datos" id="motivoSelect">
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
                            </div>


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

            </div>
        </form>
        <%
            if (request.getAttribute("resultado") != null) {
                out.println("<strong>" + request.getAttribute("resultado") + "</strong>");

            }
        %>




        <div class="col-sm-18">
            <table class="table table-bordered table-hover table-thick-border">
                <thead>
                    <tr>

                        <th>ID</th>
                        <th>MOTIVO</th>                                     
                        <th>FECHA INICIO</th>
                        <th>FECHA FINALIZACIÓN</th>
                        <th>HORA DE INICIO</th>
                        <th>HORA DE FINALIZACIÓN</th>
                        <th>DIAS PERMISO</th>
                        <th>HORAS PERMISO</th>
                        <th>OBSERVACIONES</th>
                        <th>VALOR A DESCONTAR</th>
                        <th>CÉDULA</th>

                    </tr>
                </thead>
                <!---   ITERAR SOBRE LOS DATOS Y MOSTRAR CADA FILA EN ORDEN --->
                <%
                    if (request.getAttribute("cajitareporte") != null) {
                        List<Permiso> arrCapas = (List<Permiso>) request.getAttribute("cajitareporte");
                        for (Permiso capas : arrCapas) {
                %>

                <tr onclick="redirectToPermisosInsert('<%= capas.getIdPermiso()%>')">
                    <td><%= capas.getIdPermiso()%></td>
                    <td><%= capas.getMotivo()%></td>
                    <td><%= capas.getFechaInicioPermiso()%></td>
                    <td><%= capas.getFechaFinalPermiso()%></td>    
                    <td><%= capas.getHoraInicio()%></td>
                    <td><%= capas.getHoraFinal()%></td> 
                    <td><%= capas.getDiasPermiso()%></td>
                    <td><%= capas.getHorasPermiso()%></td>
                    <td><%= capas.getObservaciones()%></td>                    
                    <td><%= capas.getValordescontar()%></td> 
                    <td><%= capas.getUsuario_idCedula()%></td>


                    <td class="text-center">
                        <div class="btn-group">

                        </div>
                    </td>
                </tr>

                <%
                        }
                    }
                %>
                <%

                %>

                <script>
                    function redirectToPermisosInsert(id) {
                        window.location.href = "permisosInsert.jsp?id=" + id;
                    }
                </script>
        </div>
    </div>
</body>
</html>