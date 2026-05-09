// ===============================
// TASKMASTER - FUNCIONALIDAD WEB
// ===============================

// ===============================
// CARGA INICIAL
// ===============================

document.addEventListener("DOMContentLoaded", () => {

    // Botón crear
    const btnCrear = document.getElementById("btnCrear");

    // Botón editar
    const btnEditar = document.getElementById("btnEditar");

    // Eventos
    btnCrear.addEventListener("click", crearTarea);
    btnEditar.addEventListener("click", editarTarea);

    // Activar eliminar
    activarBotonesEliminar();

});

// ===============================
// CREAR TAREA
// ===============================

function crearTarea() {

    const titulo = document.getElementById("titulo").value;
    const descripcion = document.getElementById("descripcion").value;
    const estado = document.getElementById("estado").value;
    const categoria = document.getElementById("categoria").value;

    if (titulo === "" || descripcion === "") {

        alert("Completa todos los campos obligatorios");
        return;
    }

    const tabla = document.querySelector("tbody");

    const fila = document.createElement("tr");

    const nuevoID = tabla.rows.length + 1;

    fila.innerHTML = `
        <td>${nuevoID}</td>
        <td>${titulo}</td>
        <td>${estado}</td>
        <td>${categoria}</td>
        <td>Sergio</td>

        <td>
            <button class="btnEliminar">
                Eliminar
            </button>
        </td>
    `;

    tabla.appendChild(fila);

    // Activar eliminar nueva fila
    const botonEliminar = fila.querySelector(".btnEliminar");

    botonEliminar.addEventListener("click", () => {

        fila.remove();
    });

    // Limpiar formulario
    document.getElementById("titulo").value = "";
    document.getElementById("descripcion").value = "";

    alert("Tarea creada correctamente");
}

// ===============================
// ELIMINAR TAREAS
// ===============================

function activarBotonesEliminar() {

    const botones = document.querySelectorAll(".btnEliminar");

    botones.forEach((boton) => {

        boton.addEventListener("click", () => {

            const fila = boton.closest("tr");

            fila.remove();
        });
    });
}

// ===============================
// EDITAR TAREA
// ===============================

function editarTarea() {

    // Obtener datos formulario
    const id = document.getElementById("editarID").value;
    const nuevoTitulo = document.getElementById("editarTitulo").value;
    const nuevaDescripcion = document.getElementById("editarDescripcion").value;

    // Obtener filas tabla
    const filas = document.querySelectorAll("tbody tr");

    let encontrada = false;

    filas.forEach((fila) => {

        const idFila = fila.children[0].textContent;

        if (idFila === id) {

            // Editar título
            if (nuevoTitulo !== "") {
                fila.children[1].textContent = nuevoTitulo;
            }

            encontrada = true;
        }
    });

    if (encontrada) {

        alert("Tarea editada correctamente");

    } else {

        alert("No existe una tarea con ese ID");
    }

    // Limpiar formulario
    document.getElementById("editarID").value = "";
    document.getElementById("editarTitulo").value = "";
    document.getElementById("editarDescripcion").value = "";
}