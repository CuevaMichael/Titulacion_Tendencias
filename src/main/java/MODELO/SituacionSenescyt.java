package MODELO;

import java.sql.Date;

public class SituacionSenescyt {
    //zona de variables

    private int idSituacionSenescyt;
    private String fechaIngreso;
    private String fechaSalida;
    private String modalidad;
    private String unidad;
    private String puesto;
    private String grupoOcupacional;
    private int usuario_idCedula;

    public SituacionSenescyt(int idSituacionSenescyt, String modalidad) {
        this.idSituacionSenescyt = idSituacionSenescyt;
        this.modalidad = modalidad;
    }

    public SituacionSenescyt(int idSituacionSenescyt, String fechaIngreso, String fechaSalida, String modalidad, String unidad, String puesto, String grupoOcupacional, int usuario_idCedula) {
        this.idSituacionSenescyt = idSituacionSenescyt;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.modalidad = modalidad;
        this.unidad = unidad;
        this.puesto = puesto;
        this.grupoOcupacional = grupoOcupacional;
        this.usuario_idCedula = usuario_idCedula;
    }

    public SituacionSenescyt(String fechaIngreso, String fechaSalida, String modalidad, String unidad, String puesto, String grupoOcupacional, int usuario_idCedula) {
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.modalidad = modalidad;
        this.unidad = unidad;
        this.puesto = puesto;
        this.grupoOcupacional = grupoOcupacional;
        this.usuario_idCedula = usuario_idCedula;
    }

    public int getIdSituacionSenescyt() {
        return idSituacionSenescyt;
    }

    public void setIdSituacionSenescyt(int idSituacionSenescyt) {
        this.idSituacionSenescyt = idSituacionSenescyt;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getGrupoOcupacional() {
        return grupoOcupacional;
    }

    public void setGrupoOcupacional(String grupoOcupacional) {
        this.grupoOcupacional = grupoOcupacional;
    }

    public int getUsuario_idCedula() {
        return usuario_idCedula;
    }

    public void setUsuario_idCedula(int usuario_idCedula) {
        this.usuario_idCedula = usuario_idCedula;
    }

    @Override
    public String toString() {
        return "SituacionSenescyt{" + "idSituacionSenescyt=" + idSituacionSenescyt + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida + ", modalidad=" + modalidad + ", unidad=" + unidad + ", puesto=" + puesto + ", grupoOcupacional=" + grupoOcupacional + ", usuario_idCedula=" + usuario_idCedula + '}';
    }
}
   