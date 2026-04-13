// (imports y código inicial EXACTAMENTE igual que el tuyo)

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Tarea> tareas = new ArrayList<>();
    static ArrayList<Estado> estados = new ArrayList<>();
    static ArrayList<Categoria> categorias = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static int idUsuario = 1;
    static int idTarea = 1;

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        estados.add(new Estado(1, "Pendiente", "Tarea creada pero no iniciada"));
        estados.add(new Estado(2, "En progreso", "Tarea en ejecución"));
        estados.add(new Estado(3, "Completada", "Tarea finalizada correctamente"));
        estados.add(new Estado(4, "Cancelada", "Tarea cancelada"));

        categorias.add(new Categoria(1, "Personal", "Tareas personales"));
        categorias.add(new Categoria(2, "Estudios", "Tareas de estudio"));

        int opcion;

        do {
            System.out.println("\n--- TASKMASTER ---");
            System.out.println("1 Crear usuario");
            System.out.println("2 Ver usuarios");
            System.out.println("3 Crear tarea");
            System.out.println("4 Editar tarea");
            System.out.println("5 Eliminar tarea");
            System.out.println("6 Cambiar estado de tarea");
            System.out.println("7 Ver tareas");
            System.out.println("8 Filtrar tareas por categoría");
            System.out.println("9 Ver tareas por usuario");
            System.out.println("0 Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: crearUsuario(); break;
                case 2: verUsuarios(); break;
                case 3: crearTarea(); break;
                case 4: editarTarea(); break;
                case 5: eliminarTarea(); break;
                case 6: cambiarEstado(); break;
                case 7: verTareas(); break;
                case 8: filtrarPorCategoria(); break;
                case 9: verTareasPorUsuario(); break;
            }

        } while (opcion != 0);
    }

    // -------- USUARIOS --------

    static void crearUsuario() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Contrasenya: ");
        String contrasenya = sc.nextLine();

        usuarios.add(new Usuario(idUsuario++, nombre, email, contrasenya));
        System.out.println("Usuario creado ✔");
    }

    static void verUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios");
            return;
        }

        for (Usuario u : usuarios) System.out.println(u);
    }

    // -------- TAREAS --------

    static void crearTarea() {

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios");
            return;
        }

        System.out.println("\nUsuarios disponibles:");
        for (Usuario u : usuarios) System.out.println(u);

        System.out.print("ID usuario: ");
        int idU = sc.nextInt();
        sc.nextLine();

        Usuario usuario = buscarUsuario(idU);
        if (usuario == null) {
            System.out.println("Usuario no válido");
            return;
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Descripción: ");
        String desc = sc.nextLine();

        LocalDate fechaInicio;
        LocalDate fechaLimite;

        try {
            System.out.print("Fecha inicio (dd/MM/yyyy): ");
            fechaInicio = LocalDate.parse(sc.nextLine(), formatter);

            System.out.print("Fecha límite (dd/MM/yyyy): ");
            fechaLimite = LocalDate.parse(sc.nextLine(), formatter);

        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto");
            return;
        }

        System.out.print("Observaciones: ");
        String obs = sc.nextLine();

        System.out.println("\nEstados:");
        for (Estado e : estados) System.out.println(e);

        System.out.print("ID estado: ");
        int idE = sc.nextInt();

        Estado estado = buscarEstado(idE);
        if (estado == null) {
            System.out.println("Estado no válido");
            return;
        }

        System.out.println("\nCategorías:");
        for (Categoria c : categorias) System.out.println(c);

        System.out.print("ID categoría: ");
        int idC = sc.nextInt();

        Categoria categoria = buscarCategoria(idC);
        if (categoria == null) {
            System.out.println("Categoría no válida");
            return;
        }

        tareas.add(new Tarea(
                idTarea++,
                titulo,
                desc,
                fechaInicio,
                fechaLimite,
                obs,
                usuario,
                estado,
                categoria
        ));

        System.out.println("Tarea creada ✔");
    }

    static void verTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
            return;
        }

        for (Tarea t : tareas) System.out.println(t);
    }

    static void cambiarEstado() {

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
            return;
        }

        verTareas();

        System.out.print("ID tarea: ");
        int idT = sc.nextInt();

        Tarea t = buscarTarea(idT);
        if (t == null) {
            System.out.println("Tarea no válida");
            return;
        }

        System.out.println("Estados disponibles:");
        for (Estado e : estados) System.out.println(e);

        System.out.print("Nuevo estado: ");
        int idE = sc.nextInt();

        Estado nuevoEstado = buscarEstado(idE);
        if (nuevoEstado == null) {
            System.out.println("Estado no válido");
            return;
        }

        t.estado = nuevoEstado;

        System.out.println("Estado actualizado ✔");
    }

    // -------- NUEVOS MÉTODOS --------

    static void eliminarTarea() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
            return;
        }

        verTareas();

        System.out.print("ID tarea a eliminar: ");
        int id = sc.nextInt();

        Tarea t = buscarTarea(id);
        if (t == null) {
            System.out.println("Tarea no válida");
            return;
        }

        tareas.remove(t);
        System.out.println("Tarea eliminada ✔");
    }

    static void editarTarea() {

        if (tareas.isEmpty()) {
            System.out.println("No hay tareas");
            return;
        }

        verTareas();

        System.out.print("ID tarea a editar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Tarea t = buscarTarea(id);
        if (t == null) {
            System.out.println("Tarea no válida");
            return;
        }

        System.out.print("Nuevo título: ");
        t.titulo = sc.nextLine();

        System.out.print("Nueva descripción: ");
        t.descripcion = sc.nextLine();

        System.out.println("Categorías:");
        for (Categoria c : categorias) System.out.println(c);

        System.out.print("Nueva categoría: ");
        int idC = sc.nextInt();

        Categoria c = buscarCategoria(idC);
        if (c != null) t.categoria = c;

        System.out.println("Tarea editada ✔");
    }

    static void filtrarPorCategoria() {

        System.out.println("Categorías:");
        for (Categoria c : categorias) System.out.println(c);

        System.out.print("ID categoría: ");
        int id = sc.nextInt();

        for (Tarea t : tareas) {
            if (t.categoria.id_categoria == id) {
                System.out.println(t);
            }
        }
    }

    static void verTareasPorUsuario() {

        System.out.println("Usuarios:");
        for (Usuario u : usuarios) System.out.println(u);

        System.out.print("ID usuario: ");
        int id = sc.nextInt();

        for (Tarea t : tareas) {
            if (t.usuario.id_usuario == id) {
                System.out.println(t);
            }
        }
    }

    // -------- BUSCADORES --------

    static Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios)
            if (u.id_usuario == id) return u;
        return null;
    }

    static Estado buscarEstado(int id) {
        for (Estado e : estados)
            if (e.id_estado == id) return e;
        return null;
    }

    static Categoria buscarCategoria(int id) {
        for (Categoria c : categorias)
            if (c.id_categoria == id) return c;
        return null;
    }

    static Tarea buscarTarea(int id) {
        for (Tarea t : tareas)
            if (t.id_tarea == id) return t;
        return null;
    }
}