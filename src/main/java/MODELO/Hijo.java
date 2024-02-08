package MODELO;

public class Hijo {
    //zona de variables

    int idHijo;
    String cedulaOpasaporte;
    String numeroHijo;
    String nombres;
    String apellidos;
    String fechaNacimiento;
    String nivelInstrucion;
    int usuario_idCedula;

    public Hijo(int idHijo, String nivelInstrucion) {
        this.idHijo = idHijo;
        this.nivelInstrucion = nivelInstrucion;
    }

    public Hijo(int idHijo, String cedulaOpasaporte, String numeroHijo, String nombres, String apellidos, String fechaNacimiento, String nivelInstrucion, int usuario_idCedula) {
        this.idHijo = idHijo;
        this.cedulaOpasaporte = cedulaOpasaporte;
        this.numeroHijo = numeroHijo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelInstrucion = nivelInstrucion;
        this.usuario_idCedula = usuario_idCedula;
    }

    public Hijo(String cedulaOpasaporte, String numeroHijo, String nombres, String apellidos, String fechaNacimiento, String nivelInstrucion, int usuario_idCedula) {
        this.cedulaOpasaporte = cedulaOpasaporte;
        this.numeroHijo = numeroHijo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nivelInstrucion = nivelInstrucion;
        this.usuario_idCedula = usuario_idCedula;
    }

    public int getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(int idHijo) {
        this.idHijo = idHijo;
    }

    public String getCedulaOpasaporte() {
        return cedulaOpasaporte;
    }

    public void setCedulaOpasaporte(String cedulaOpasaporte) {
        this.cedulaOpasaporte = cedulaOpasaporte;
    }

    public String getNumeroHijo() {
        return numeroHijo;
    }

    public void setNumeroHijo(String numeroHijo) {
        this.numeroHijo = numeroHijo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNivelInstrucion() {
        return nivelInstrucion;
    }

    public void setNivelInstrucion(String nivelInstrucion) {
        this.nivelInstrucion = nivelInstrucion;
    }

    public int getUsuario_idCedula() {
        return usuario_idCedula;
    }

    public void setUsuario_idCedula(int usuario_idCedula) {
        this.usuario_idCedula = usuario_idCedula;
    }

    @Override
    public String toString() {
        return "Hijo{" + "idHijo=" + idHijo + ", cedulaOpasaporte=" + cedulaOpasaporte + ", numeroHijo=" + numeroHijo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", nivelInstrucion=" + nivelInstrucion + ", usuario_idCedula=" + usuario_idCedula + '}';
    }

}
