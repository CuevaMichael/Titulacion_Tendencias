<%-- 
    Document   : modificar
    Created on : 20/12/2023, 8:49:11
    Author     : Michael
--%>

<%@page import="java.util.List"%>
<%@page import="MODELO.InclucionLaboral"%>

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
                            <a class="nav-link active" aria-current="page"  href="navegacionUsuarioCrud.jsp">Continuar Registro</a>
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
                        <p style="font-size: larger; color: white;" ><b>INCLUSIÓN LABORAL</b></p>
                        <p style="color: white;">Ingresar un nuevo registro</p> 
                        <div class="row mt-1">
                            <div class="col-md-4">
                                <a href="inclucionLaboralInsert.jsp" class="btn btn-dark ">Ingresar</a>
                            </div>                               
                        </div>
                    </div>

                </div>

                <!-- Formulario de control de asistencias -->
                <form action="MostrarDatosLaboral" method="post">
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
                                <label for="deleteId" class="form-label">ID para eliminar la Inclusión Laboral</label>
                                <input name="deleteId" type="text" class="form-control" id="deleteId">
                                <br>
                                <input name="operacion" type="submit" class="btn btn-light text-dark border-dark" value="ELIMINAR">
                            </div> 
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="idUpdate" class="form-label">ID para editar su Nacionalidad</label>
                                <input name="idUpdate" type="text" class="form-control" id="idUpdate">
                                <br>
                                <input name="operacion" type="submit" class="btn btn-dark" value="EDITAR">
                                <a href="inclusionLaboralInsert.jsp" class="btn btn-light text-dark border-dark">EDITAR TODO</a>


                            </div>
                            <div class="col-md-6">
                                <label for="datos" class="form-label">Nacionalidad</label>
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

                            <th>ID</th>
                            <th>MIGRANTE</th>
                            <th>NACIONALIDAD</th>
                            <th>EMBARAZO</th>     
                            <th>MESES DE EMBARAZO</th>                                    
                            <th>LICENCIA</th>
                            <th>PORCENTAJE</th>
                            <th>CÉDULA DEL DOCENTE</th>

                        </tr>
                    </thead>
                    
                    <!---   ITERAR SOBRE LOS DATOS Y MOSTRAR CADA FILA EN ORDEN --->
                    <% 
                        if (request.getAttribute("cajitareporte") !=null) {
                            List<InclucionLaboral> arrCapas = (List<InclucionLaboral>) request.getAttribute("cajitareporte");
                            for (InclucionLaboral capas : arrCapas) {          
                    %>

                    <tr onclick="redirectToInclucionLaboralInsert('<%= capas.getIdInclucionLaboral() %>')">
                        <td><%= capas.getIdInclucionLaboral()%></td>
                        <td><%= capas.getMigrante()%></td>
                        <td><%= capas.getNacionalidad()%></td>
                        <td><%= capas.getEmbarazo()%></td>         
                        <td><%= capas.getMesesEmbarazo()%></td>
                        <td><%= capas.getLicencia()%></td>
                        <td><%= capas.getPorcentaje()%></td>
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
                        function redirectToInclucionLaboralInsert(id) {
                            window.location.href = "inclucionLaboralInsert.jsp?id=" + id;
                        }
                    </script>
            </div>
        </div>
    </div>
</body>
</html>
