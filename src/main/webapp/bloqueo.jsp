<%-- 
    Document   : bloqueo
    Created on : 29/11/2023, 20:11:10
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuenta Bloqueada</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                text-align: center;
                margin: 50px;
            }
            h1 {
                color: #FF0000; /* Color rojo para destacar el mensaje de bloqueo */
            }
            .button-container {
                margin-top: 20px;
            }
            .retry-button {
                padding: 10px 20px;
                font-size: 16px;
                text-decoration: none;
                background-color: #4CAF50; /* Color verde para el botón de reintentar */
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <h1>Lo siento, tu cuenta ha sido bloqueada</h1>
        <div class="button-container">
            <a href="index.jsp" class="retry-button">¿Deseas intentar nuevamente?</a>
        </div>
    </body>
</html>

