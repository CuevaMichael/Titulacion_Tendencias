
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TALENTUM INT</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <style>
            body {
                background: #F1F2B5;  /* fallback for old browsers */
                background: -webkit-linear-gradient(to right, #135058, #F1F2B5);  /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to right, #135058, #F1F2B5); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                font-family: 'Consolas', sans-serif;
                color: #000;
                margin: 0;
                display: flex;
                align-items: flex-start;
                justify-content: flex-start;
                height: 100vh;
            }

            .container {
                text-align: center;
                margin-top: 68px;
                padding: 15px;
                max-width: 400px;
                background-color: #f1f2b5, #135058; 
                border-radius: 5px;
                box-shadow: 0 0 40px rgba(0, 0, 0, 0.8);
                border: 2px solid #135058; 
                position: relative;
                margin-left: auto; /* Alinea a la derecha */
                margin-right: 370px; /* Puedes ajustar la separación según tus necesidades */
            }


            .rounded-imagenes {
                border-radius: 50%;
                transition: transform 0.1s ease;
            }

            .rounded-imagenes {
                transform: scale(1.20);
            }

            .login-form {
                margin-top: 20px;
            }

            .input-group {
                margin-bottom: 10px;
            }

            input.form-control {
                border-radius: 5px;
                background-color: #000; /* Negro */
                color: #000; /* Blanco */
                transition: background-color 0.3s ease;
            }

            input.form-control::placeholder {
                color: #135058;
            }

            input.form-control,
            .input-group-text {
                background-color: #fff;
            }

            .btn-secondary,
            .custom-btn {
                background: linear-gradient(to bottom, #135058, #fff); /* Rojo oscuro */
                color: #fff; /* Blanco */
                border: 1px solid #000; /* Rojo oscuro */
                transition: background-color 0.5s;
            }

            .btn-secondary:hover,
            .custom-btn:hover {
                background: linear-gradient(to bottom, #fff, #135058);
                border-color: #000; /* Negro */
                transform: scale(1.12);
                color: #fff; /* Blanco */
            }


            h1 {
                color: #fff; /* Color blanco para el texto */
            }


            .error-message {
                color: #fff; /* Rojo oscuro */
                position: fixed;
                bottom: 20px; /* Ajusta la distancia desde la parte inferior */
                left: 50%; /* Coloca en el centro horizontalmente */
                transform: translateX(-50%); /* Centra horizontalmente */
                font-size: 22px;
                text-shadow: 2px 2px 4px rgba(128, 128, 128, 0.5);
                font-family: 'Consolas', sans-serif;
            }

        </style>
    </head>
    <body>
        <!-- Icono en la parte superior izquierda -->
        <div style="position: absolute; top: 10px; left: 188px;">            
            <img src="img/icono.png" alt="Icono" style="width: 500px; height: 500px;">          
        </div>
        <div class="container">    

            <div class="col-md-11 text-center mb-4">
                <!-- Título principal del sistema -->
                <h1>Iniciar Sesión</h1>
            </div>
            <form action="Servlet1" method="post" id="loginForm">
                <!-- Campo de entrada para el nombre de usuario -->
                <div class="form-group">
                    <label for="username">Usuario</label>
                    <input type="text" id="nick" class="form-control" name="nick">
                </div>

                <!-- Campo de entrada para la contraseña -->
                <div class="form-group">
                    <label for="password">Contraseña</label>
                    <input type="password" id="contrasenia" class="form-control" name="contrasenia">
                </div>

                <!-- Botón de envío para el formulario de inicio de sesión -->
                <button type="submit" class="btn btn-secondary m-3">Ingresar</button>
                <p><a href="https://www.google.com/intl/es/gmail/about/" target="_blank" style="color: #135058;"> </p>
                ¿Olvidaste tu contraseña?
                <br>
                <!-- Código JSP para mostrar intentos restantes de inicio de sesión -->
                <%
                    Integer numeroIntentos = (Integer) request.getSession().getAttribute("numeroIntentos");
                    if (numeroIntentos != null && numeroIntentos > 0) {
                        out.print("<p style='color:black;'>Intentos restantes: " + (3 - numeroIntentos) + "</p>");
                    }
                %>
            </form>
            <br>
            <%
     if (request.getAttribute("cajitamensajesbd") != null) {
         out.println(request.getAttribute("cajitamensajesbd"));
     }
            %>
        </div>       
    </div>
</div>
</div>
</div>
</body>
</html>