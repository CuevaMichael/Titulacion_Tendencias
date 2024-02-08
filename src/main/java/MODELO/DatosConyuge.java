package MODELO;

public class DatosConyuge {

    //zona de variables
    private int idDatosDelConyuge;
    private String cedulaOpasaporte;
    private String nombres;
    private String apellidos;
    private String tipoRelacion;
    private int usuario_idCedula;

    public DatosConyuge(int idDatosDelConyuge, String tipoRelacion) {
        this.idDatosDelConyuge = idDatosDelConyuge;
        this.tipoRelacion = tipoRelacion;
    }

    public DatosConyuge(int idDatosDelConyuge, String cedulaOpasaporte, String nombres, String apellidos, String tipoRelacion, int usuario_idCedula) {
        this.idDatosDelConyuge = idDatosDelConyuge;
        this.cedulaOpasaporte = cedulaOpasaporte;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoRelacion = tipoRelacion;
        this.usuario_idCedula = usuario_idCedula;
    }

    public DatosConyuge(String cedulaOpasaporte, String nombres, String apellidos, String tipoRelacion, int usuario_idCedula) {
        this.cedulaOpasaporte = cedulaOpasaporte;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoRelacion = tipoRelacion;
        this.usuario_idCedula = usuario_idCedula;
    }

    public int getUsuario_idCedula() {
        return usuario_idCedula;
    }

    public void setUsuario_idCedula(int usuario_idCedula) {
        this.usuario_idCedula = usuario_idCedula;
    }

    public int getIdDatosDelConyuge() {
        return idDatosDelConyuge;
    }

    public void setIdDatosDelConyuge(int idDatosDelConyuge) {
        this.idDatosDelConyuge = idDatosDelConyuge;
    }

    public String getCedulaOpasaporte() {
        return cedulaOpasaporte;
    }

    public void setCedulaOpasaporte(String cedulaOpasaporte) {
        this.cedulaOpasaporte = cedulaOpasaporte;
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

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    @Override
    public String toString() {
        return "DatosConyuge{" + "idDatosDelConyuge=" + idDatosDelConyuge + ", cedulaOpasaporte=" + cedulaOpasaporte + ", nombres=" + nombres + ", apellidos=" + apellidos + ", tipoRelacion=" + tipoRelacion + ", usuario_idCedula=" + usuario_idCedula + '}';
    }

}
