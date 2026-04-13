import java.time.LocalDate;

public class Tarea {

    int id_tarea;
    String titulo;
    String descripcion;
    LocalDate fecha_inicio;
    LocalDate fecha_creacion;
    LocalDate fecha_limite;
    String observaciones;

    Usuario usuario;
    Estado estado;
    Categoria categoria;

    public Tarea(int id, String titulo, String descripcion,
                 LocalDate fechaInicio,
                 LocalDate fechaLimite,
                 String obs,
                 Usuario usuario, Estado estado, Categoria categoria) {

        this.id_tarea = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_inicio = fechaInicio;
        this.fecha_creacion = LocalDate.now();
        this.fecha_limite = fechaLimite;
        this.observaciones = obs;
        this.usuario = usuario;
        this.estado = estado;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "[" + id_tarea + "] " + titulo +
                " | Usuario: " + usuario.nombre +
                " | Estado: " + estado.nombre_estado +
                " | Categoría: " + categoria.nombre_categoria +
                " | Inicio: " + fecha_inicio +
                " | Límite: " + fecha_limite;
    }
}