public class Usuario {

    int id_usuario;
    String nombre;
    String email;
    String contrasenya; // ← CAMBIO AQUÍ

    public Usuario(int id, String nombre, String email, String contrasenya) {
        this.id_usuario = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasenya = contrasenya;
    }

    @Override
    public String toString() {
        return "[" + id_usuario + "] " + nombre + " (" + email + ")";
    }
}