<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registro de Empleados</title>

        <!-- Bootstrap CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- Estilos personalizados -->
        <link href="css/menu.css" rel="stylesheet" type="text/css" />
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
              integrity="sha384-ez1FcZjXHPa8ytiNZdDPXz5CTA9C5y9Lxj5PKeIbBBZzga1bMP4ZVhq/5bMOl2mk"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="row">
            <div class="col-md-11 text-center mb-4">
                <h2>Registrar Usuarios</h2>
            </div>
        </div>
        <!-- Imagen del logotipo -->
        <div style="position: absolute; top: -17px; left: 50px;">
            <img src="img/icono.png" alt="Icono" style="width: 150px; height: 150px; filter: invert(0%);">
        </div>

        <!-- Contenedor principal -->
        <div class="container">
            <div class="row">
                <!-- Módulo 1: Ingresar Docente -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="modificar.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/btnImagen.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Registro de Usuario
                        </button>
                    </form>
                </div>

                <!-- Módulo 2: Hijos -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="contactoEmergencia.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/sos.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Contacto de emergencia
                        </button>
                    </form>
                </div>

                <!-- Módulo 3: Conyuge -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="datosConyuge.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/conyugue.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Datos del Conyuge
                        </button>
                    </form>
                </div>

                <!-- Módulo 4: Evaluación Desempeño -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="evalucionDesempe.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/desem.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Evaluación desempeño
                        </button>
                    </form>
                </div>

                <!-- Módulo 5: Formación Académica -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="formacionAcademica.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/academica.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Formación academica
                        </button>
                    </form>
                </div>

                <!-- Módulo 6: Hijos -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="hijos.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/hijo.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Hijos
                        </button>
                    </form>
                </div>

                <!-- Módulo 7: Información Bancaria -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="infomacionBancaria.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/bank.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Información Bancaria
                        </button>
                    </form>
                </div>

                <!-- Módulo 8: Situación del Senescyt -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="senescytCrud.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/senes.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Situación del senescyt
                        </button>
                    </form>
                </div>

                <!-- Módulo 9: Discapacidad o Enfermedad -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="enfermedadCrud.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/dicapacidad.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Discapacidad o Enfermedad
                        </button>
                    </form>
                </div>

                <!-- Módulo 10: Capacitaciones -->
                <div class="col-md-3">
                    <form method="post" action="capacitacion.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;"
                                 src="img/capacitaciones.png" alt="Modificar datos de la asistencias"
                                 onclick="window.location.href = 'asistenciasCrud.jsp'">
                            Capacitación
                        </button>
                    </form>
                </div>

                <!-- Módulo 11: Inclusión Laboral -->
                <div class="col-md-3 mb-4">
                    <form method="post" action="inclucionLaboralCrud.jsp">
                        <button type="submit" class="btn btn-primary mb-2"
                                style="width: 210px; display: flex; flex-direction: column; align-items: center;">
                            <img src="img/expe.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Inclusión Laboral
                        </button>
                    </form>
                </div>
            </div>

            <!-- Botón Menú -->
            <div class="col-md-2 mb-4">
                <button type="button" class="btn btn-secondary" onclick="window.location.href = 'navegacionCrud.jsp';">
                    MENÚ
                </button>
            </div>
        </div>
        <!-- Pie de página -->
        <footer class="mt-5">
            <p class="text-center" style="color: #135058;">
                <a href="https://www.facebook.com/intsuperior" target="_blank">
                    <img src="img/Facebook.png" alt="Facebook" style="width: 40px; height: 40px; margin-right: 9px;">
                </a>
                <a href="https://twitter.com/Intsuperior" target="_blank">
                    <img src="img/twitter.png" alt="Twitter" style="width: 40px; height: 40px; margin-right: 9px;">
                </a>
                <a href="https://instagram.com/intsuperior?igshid=vlxn34gs1z20" target="_blank">
                    <img src="img/instagram.png" alt="Instagram" style="width: 40px; height: 40px; margin-right: 9px;">
                </a>
                <a href="https://www.youtube.com/channel/UCkVnmyd6WGq63ocWAMQrqjg" target="_blank">
                    <img src="img/you.png" alt="YouTube" style="width: 40px; height: 40px; margin-right: 9px;">
                </a><br><br>
                Talentum, política de privacidad y de afiliación<br>
                Michael de la Cueva<br>
                <a><img src="img/Int.png" alt="YouTube" style="width: 160px; height: 80px; margin-right: 9px;">
                </a>
            </p>
        </footer>
    </body>
</html>