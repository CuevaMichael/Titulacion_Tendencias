<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menú Principal</title>
        <!-- Enlaces a Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha384-ez1FcZjXHPa8ytiNZdDPXz5CTA9C5y9Lxj5PKeIbBBZzga1bMP4ZVhq/5bMOl2mk" crossorigin="anonymous">
    </head>
    <body>
        <!-- Contenedor principal de la página -->
        <div class="container mt-5">
            <!-- Botón de cerrar sesión en la parte superior izquierda -->
            <div class="text-left mt-3" style="position: absolute; top: 0; left: 0; margin: 10px;">
                <a href="index.jsp" class="btn btn-secondary">Cerrar sesión</a>
            </div>

            <!-- Icono en la parte superior izquierda -->
            <div class="text-center mb-4">
                <img src="img/icono.png" alt="Icono" style="width: 150px; height: 150px; filter: invert(0%);">
            </div>
            <!-- Título principal del sistema -->
            <h1 class="text-center mb-4">SISTEMA DE GESTIÓN DE TALENTO HUMANO</h1>
            <!-- Sección de los servicios -->
            <div class="row justify-content-center">
                <!-- Columna para cada servicio -->
                <div class="col-md-4 mb-3">
                    <form method="post" action="navegacionUsuarioCrud.jsp">
                        <button type="submit" class="btn btn-primary" style="width: 100%;">
                            <img src="img/btnImagen.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Usuarios
                        </button>
                    </form>
                </div>
                <div class="col-md-4 mb-3">
                    <form method="post" action="permisosCrud.jsp">
                        <button type="submit" class="btn btn-primary" style="width: 100%;">
                            <img src="img/asistencia.png" alt="btnOne" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Permisos
                        </button>
                    </form>
                </div>
                <div class="col-md-4 mb-3">
                    <form method="post" action="asistenciasCrud.jsp">
                        <button type="submit" class="btn btn-primary" style="width: 100%;">
                            <img alt="btnOne" src="img/permisos.png" style="width: 50px; height: 50px; margin-bottom: 5px;">
                            Asistencias
                        </button>
                    </form>
                </div>
            </div>
            <!-- Pie de página -->
            <footer class="text-center mt-5" style="color: #135058;">
                <!-- Redes sociales -->
                <a href="https://www.facebook.com/intsuperior" target="_blank"><img src="img/Facebook.png" alt="Facebook" style="width: 40px; height: 40px; margin-right: 9px;"></a>
                <a href="https://twitter.com/Intsuperior" target="_blank"><img src="img/twitter.png" alt="Twitter" style="width: 40px; height: 40px; margin-right: 9px;"></a>
                <a href="https://instagram.com/intsuperior?igshid=vlxn34gs1z20" target="_blank"><img src="img/instagram.png" alt="Instagram" style="width: 40px; height: 40px; margin-right: 9px;"></a>
                <a href="https://www.youtube.com/channel/UCkVnmyd6WGq63ocWAMQrqjg" target="_blank"><img src="img/you.png" alt="YouTube" style="width: 40px; height: 40px; margin-right: 9px;"></a>
                <br><br>
                <!-- Información adicional -->
                Talentum, política de privacidad y de afiliación<br>
                Michael de la Cueva<br>
                <a><img src="img/Int.png" alt="YouTube" style="width: 160px; height: 80px; margin-right: 9px;"></a>
            </footer>
        </div>
    </body>
</html>
