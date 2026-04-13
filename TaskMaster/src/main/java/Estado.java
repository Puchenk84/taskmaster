public class Estado {

    int id_estado;
    String nombre_estado;
    String descripcion;

    public Estado(int id, String nombre, String descripcion) {
        this.id_estado = id;
        this.nombre_estado = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "[" + id_estado + "] " + nombre_estado + " - " + descripcion;
    }
}