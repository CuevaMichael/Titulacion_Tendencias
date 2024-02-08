<%-- 
    Document   : bienvenido
    Created on : 21/11/2023, 16:04:51
    Author     : anton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Página de Inicio</title>
        <!-- Enlaces a Bootstrap CSS -->
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
                /* Establece la altura del cuerpo para ocupar el 100% de la altura de la ventana (viewport height) */
                height: 100vh;
                /* Utiliza flexbox para centrar vertical y horizontalmente el contenido */
                display: flex;
                align-items: center;
                justify-content: center;
                /* Elimina márgenes y rellenos predeterminados del cuerpo */
                margin: 0;
                padding: 0;
            }
            .card {
                background-color: rgba(255, 255, 255, 0.8); /* Color de fondo semi-transparente para la tarjeta */
            }
        </style>
    </head>
    <body>
        <!-- Barra de navegación 
        class="navbar":  dar estilo y comportamiento a la barra de navegación.
        class="navbar-expand-lg": barra de navegación se expandirá en dispositivos.
        class="navbar-dark": color claro para contrastar con el fondo oscuro.
        class="bg-dark": color de fondo oscuro para la barra de navegación.
        class="fixed-top": fija la barra de navegación en la parte superior.-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <!--  contenedor que centraliza y controla el diseño en un ancho específico.-->
            <div class="container">
                <!-- Enlace del logo/inicio -->
                <a class="navbar-brand" href="bienvenido.jsp">Talentum</a>
                <!-- Botón para dispositivos móviles
                class="navbar-toggler":  estilizar el botón y está asociado con la apertura o cierre de un menú de navegación.
                data-bs-toggle="collapse": alternar una clase colapsable, en este caso, para la navegación.
                data-bs-target="#navbarNav": Especifica el objetivo que se colapsará o mostrará al hacer clic en este botón.  "navbarNav".
                aria-controls="navbarNav": Este atributo ARIA indica que este botón controla el elemento con el ID "navbarNav".
                aria-expanded="false": Este atributo ARIA indica que el elemento controlado por el botón no está expandido inicialmente.
                aria-label="Toggle navigation": Es un atributo ARIA que proporciona una etiqueta descriptiva para el botón, en este caso, "Alternar navegación".
                Dentro del botón, <span class="navbar-toggler-icon"></span> representa el icono muestra o se oculta según el estado de la navegación.-->
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <!-- Contenido de la barra de navegación 
                La clase collapse define el contenedor como colapsable, mientras que navbar-collapse proporciona estilos específicos
                 "id" proporciona un identificador único al contenedor colapsable.
                Se utiliza para asociar (navbar-toggler) para que al hacer clic en el botón, este contenedor se colapse o se expanda.-->
                <div class="collapse navbar-collapse" id="navbarNav">
                    <!--alinear los elementos de la lista a la derecha dentro de la barra de navegación-->
                    <ul class="navbar-nav ms-auto">
                        <!-- Elementos de la barra de navegación
                        nav-item" = estilizarlo como un elemento de navegación
                        nav-link= estilizarlo como un enlace dentro de la barra de navegación-->
                          
                              <li class="nav-item">
                                  <a class="nav-link" href="navegacionCrud.jsp">Modifcar datos y reportes</a>
                        </li>
 
                         <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Salir</a>
                        </li>
                     
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Contenido principal
        mt-4 añade un margen superior
        row=crear una fila
        col-md-8 offset-md-2= representa una columna de tamaño medio-->
        <div class="container mt-4">
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <div class="card text-center">
                        <div class="card-body">
                            <!-- Título principal -->
                            <h1 class="card-title">SISTEMA DE GESTIÓN DE TALENTO HUMANO</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script>
            // JavaScript para manejar el despliegue del menú al hacer clic
            const submenuItems = document.querySelectorAll('.has-submenu');

            submenuItems.forEach(item => {
                item.addEventListener('click', (event) => {
                    event.preventDefault();
                    const submenu = item.querySelector('.submenu');
                    submenu.classList.toggle('active');
                });
            });
        </script>
        <!-- Enlaces a Bootstrap JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>

</html>