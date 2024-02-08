<%-- 
    Document   : trayectoria
    Created on : 20/12/2023, 8:49:11
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trayectotia Laboral</title>
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
                            <a class="nav-link" href="index.jsp">Salir</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container mt-3 ">
            <div class="row ">
                <div class="col-md-20 offset-md-0">
                    <div class="card">
                        <div class="card-body">

                            <!-- Barra de búsqueda -->
                            <div class="mb-3">
                                <p> <b>DATOS TRAYECTORIA LABORAL</b></p>
                                <p>Selección el tipo de busqueda </p> 

                                <div class="container mt-4">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="checkbox" id="checkbox1" value="opcion1">
                                                <label class="form-check-label" for="checkbox1">Por cédula del docente</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="checkbox" id="checkbox4" value="opcion4">
                                                <label class="form-check-label" for="checkbox4">Por tipo de instrución</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="checkbox" id="checkbox2" value="opcion2">
                                                <label class="form-check-label" for="checkbox2">Por unidad administrativa</label>
                                            </div>

                                        </div>
                                    </div>
                                </div>


                                <input type="text" class="form-control" id="searchInput" placeholder="Buscar...">
                            </div>
                            <p> Generar reporte </p> 
                            <div class="row mt-1">
                                <div class="col-md-4">
                                    <button class="btn btn-dark text-white">WORD</button>
                                </div>
                                <div class="col-md-4">
                                    <button class="btn btn-dark text-white">EXCEL</button>
                                </div>
                                <div class="col-md-4">
                                    <button class="btn btn-dark text-white">PDF</button>
                                </div>
                            </div>

                            <br>
                            <p>Ingresar un nuevo registro</p> 
                            <div class="row mt-1">
                                <div class="col-md-4">
                                    <a href="trayectoriaLaboralInsert.jsp" class="btn btn-dark ">Ingresar</a>
                                </div>
                            </div>
                            <br>

                            <!-- Tabla para mostrar los elementos -->
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Cédula del docente</th>
                                        <th>Tipo de instrución</th>
                                        <th>Institución u organización</th>
                                        <th>Unidad administrativa</th>
                                        <th>Puesto</th>
                                        <th>Fecha ingreso</th>
                                        <th>Modalidad de ingreso</th>
                                        <th>Motivo salida</th>

                                        <th>Acciones</th>
                                    </tr>       <!-- Encabezados de la tabla -->

                                </thead>
                                <tbody id="tableBody">
                                    <!-- Aquí se mostrarán los elementos -->
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar/Editar Elemento</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form id="crudForm">
                            <div class="mb-3">
                                <label for="nameInput" class="form-label">Id</label>
                                <input type="text" class="form-control" id="nameInput">
                            </div>
                            <div class="mb-3">
                                <label for="cedula" class="form-label">Cédula</label>
                                <input type="text" class="form-control" id="cedula">
                            </div>
                            <div class="mb-3">
                                <label for="fechaAsistencia" class="form-label">Motivo</label>
                                <input type="text" class="form-control" id="fechaAsistencia">
                            </div>
                            <div class="mb-3">
                                <label for="horaEntrada" class="form-label">Fecha y hora de inicio</label>
                                <input type="time" class="form-control" id="horaEntrada">
                            </div>
                            <div class="mb-3">
                                <label for="horaSalida" class="form-label">Fecha y hora de finalización</label>
                                <input type="time" class="form-control" id="horaSalida">
                            </div>
                            <div class="mb-3">
                                <label for="obserbaciones" class="form-label">Obserbaciones</label>
                                <input type="text" class="form-control" id="obserbaciones">
                            </div>
                            <div class="mb-3">
                                <label for="obserbaciones" class="form-label">Valor a descontar</label>
                                <input type="text" class="form-control" id="obserbaciones">
                            </div>
                            <input type="hidden" id="itemId">
                            <button type="submit" class="btn btn-primary w-100">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>


        <!-- Modal de confirmación de eliminación -->
        <div class="modal" id="confirmDeleteModal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Confirmar eliminación</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        ¿Estás seguro de que quieres eliminar este elemento?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-danger" id="confirmDeleteButton">Eliminar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- Enlace a Bootstrap JS y Popper.js (requerido por Bootstrap) -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Tu script personalizado para manipular los datos y realizar operaciones CRUD -->
        <script>

            // Aquí puedes añadir tu lógica JavaScript para interactuar con la interfaz, realizar operaciones CRUD, etc.
            // Por ejemplo, puedes usar Fetch API o Axios para realizar peticiones AJAX y manipular los datos.

            // Ejemplo básico de manipulación de la tabla
            const tableBody = document.getElementById('tableBody');
            // Ejemplo de cómo agregar filas a la tabla
            const addItemToTable = (id, name) => {
                const newRow = document.createElement('tr');
                newRow.innerHTML = `
              <td>${id}</td>
              <td>${name}</td>
              <td>${name}</td>
              <td>${name}</td>
              <td>${name}</td>
              <td>${name}</td>
              <td>${name}</td>
       <td>${name}</td>


              <td>              

                <button class="btn btn-sm btn-primary" onclick="editItem(${id})">Modificar</button>
                <button class="btn btn-sm btn-danger" onclick="deleteItem(${id})">Eliminar</button>
              </td>
            `;
                tableBody.appendChild(newRow);
            };
            // Ejemplo de cómo eliminar filas de la tabla
            // Ejemplo de cómo eliminar filas de la tabla con modal de Bootstrap
            const deleteItem = (id) => {
                // Mostrar el modal de confirmación de eliminación
                const confirmDeleteModal = new bootstrap.Modal(document.getElementById('confirmDeleteModal'));
                // Obtener el botón de confirmación dentro del modal
                const confirmDeleteButton = document.getElementById('confirmDeleteButton');
                // Agregar un evento al botón de confirmación para eliminar el elemento
                confirmDeleteButton.addEventListener('click', () => {
                    // Aquí iría tu lógica para eliminar el elemento
                    // Por ejemplo:
                    // Realizar petición para eliminar el elemento mediante AJAX

                    // Eliminar la fila de la tabla (ejemplo visual)
                    const rowToDelete = document.querySelector(`#tableBody tr td:first-child:nth-child(1):contains('${id}')`).parentNode;
                    rowToDelete.remove();
                    // Cerrar el modal después de eliminar el elemento
                    confirmDeleteModal.hide();
                });
                // Mostrar el modal
                confirmDeleteModal.show();
            };
            // Ejemplo de cómo editar elementos de la tabla
            const editItem = (id) => {
                // Aquí iría tu lógica para obtener los datos del elemento con el ID proporcionado
                // Por ejemplo:
                // Realizar petición para obtener los datos del elemento mediante AJAX y rellenar el formulario

                // Llenar el formulario con los datos del elemento (ejemplo visual)
                const itemName = `  ${id}`;
                document.getElementById('itemId').value = id;
                document.getElementById('nameInput').value = itemName;
                // Mostrar el modal para editar el elemento
                const modal = new bootstrap.Modal(document.getElementById('exampleModal'));
                modal.show();
            };
            // Ejemplo de cómo agregar un nuevo elemento a la tabla
            const addNewItem = () => {
                // Aquí iría tu lógica para agregar un nuevo elemento
                // Por ejemplo:
                // Realizar petición para agregar un nuevo elemento mediante AJAX y obtener el nuevo ID asignado
                const itemName = `  ${id}`;
                document.getElementById('itemId').value = id;
                document.getElementById('nameInput').value = itemName;
                // Mostrar el modal para editar el elemento
                const modal = new bootstrap.Modal(document.getElementById('exampleModal'));
                modal.show();
            };
            // Ejemplo de cómo guardar los cambios del formulario
            const crudForm = document.getElementById('crudForm');
            crudForm.addEventListener('submit', (e) => {
                e.preventDefault();
                const itemId = document.getElementById('itemId').value;
                const itemName = document.getElementById('nameInput').value;
                if (itemId) {
                    // Aquí iría tu lógica para actualizar un elemento existente
                    // Por ejemplo:
                    // Realizar petición para actualizar el elemento mediante AJAX

                    // Ejemplo visual de actualización en la tabla
                    const rowToUpdate = document.querySelector(`#tableBody tr td:first-child:nth-child(1):contains('${itemId}')`).parentNode;
                    rowToUpdate.children[1].textContent = itemName;
                    // Cerrar el modal después de editar
                    const modal = bootstrap.Modal.getInstance(document.getElementById('exampleModal'));
                    modal.hide();
                } else {
                    // Agregar un nuevo elemento
                    addNewItem(itemName);
                    // Cerrar el modal después de agregar
                    const modal = bootstrap.Modal.getInstance(document.getElementById('exampleModal'));
                    modal.hide();
                }
            });
            // Ejemplo de búsqueda
            const searchInput = document.getElementById('searchInput');
            searchInput.addEventListener('input', () => {
                const searchText = searchInput.value.toLowerCase();
                // Aquí iría tu lógica para filtrar los elementos de la tabla según la búsqueda
                // Por ejemplo:
                // Recorrer las filas de la tabla y mostrar/ocultar según coincidan con el texto de búsqueda

                // Ejemplo visual de búsqueda en la tabla
                const rows = document.querySelectorAll('#tableBody tr');
                rows.forEach(row => {
                    const name = row.getElementsByTagName('td')[1].textContent.toLowerCase();
                    if (name.includes(searchText)) {
                        row.style.display = '';
                    } else {
                        row.style.display = 'none';
                    }
                });
            });
            // Ejemplo de llenado inicial de la tabla (simulación de datos)
            // Esto es solo para propósitos de demostración
            // Debes llenar la tabla con datos reales desde tu backend
            for (let i = 1; i <= 10; i++) {
                addItemToTable(i, `Elemento ${i}`);
            }
        </script>
    </body>
</html>
