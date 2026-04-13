public class Categoria {

    int id_categoria;
    String nombre_categoria;
    String descripcion;

    public Categoria(int id, String nombre, String descripcion) {
        this.id_categoria = id;
        this.nombre_categoria = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "[" + id_categoria + "] " + nombre_categoria + " - " + descripcion;
    }
}