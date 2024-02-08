package MODELO;

public class DiscapacidadOenfermedad {
    //zona de variables

    private int idDiscapacidadOenfermedad;
    private String situacion;
    private String numeroCarnetConadis;
    private String certificadoEnfermedadCarastrofica;
    private String tipoDiscapacidad;
    private String porcentaje;
    private String tipoEnfermedad;
    private String tipoRelacion;
    private int usuario_idCedula;

    public DiscapacidadOenfermedad(int idDiscapacidadOenfermedad, String tipoEnfermedad) {
        this.idDiscapacidadOenfermedad = idDiscapacidadOenfermedad;
        this.tipoEnfermedad = tipoEnfermedad;
    }
    
    

    public DiscapacidadOenfermedad(int idDiscapacidadOenfermedad, String situacion, String numeroCarnetConadis, String certificadoEnfermedadCarastrofica, String tipoDiscapacidad, String porcentaje, String tipoEnfermedad, String tipoRelacion, int usuario_idCedula) {
        this.idDiscapacidadOenfermedad = idDiscapacidadOenfermedad;
        this.situacion = situacion;
        this.numeroCarnetConadis = numeroCarnetConadis;
        this.certificadoEnfermedadCarastrofica = certificadoEnfermedadCarastrofica;
        this.tipoDiscapacidad = tipoDiscapacidad;
        this.porcentaje = porcentaje;
        this.tipoEnfermedad = tipoEnfermedad;
        this.tipoRelacion = tipoRelacion;
        this.usuario_idCedula = usuario_idCedula;
    }

    public DiscapacidadOenfermedad(String situacion, String numeroCarnetConadis, String certificadoEnfermedadCarastrofica, String tipoDiscapacidad, String porcentaje, String tipoEnfermedad, String tipoRelacion, int usuario_idCedula) {
        this.situacion = situacion;
        this.numeroCarnetConadis = numeroCarnetConadis;
        this.certificadoEnfermedadCarastrofica = certificadoEnfermedadCarastrofica;
        this.tipoDiscapacidad = tipoDiscapacidad;
        this.porcentaje = porcentaje;
        this.tipoEnfermedad = tipoEnfermedad;
        this.tipoRelacion = tipoRelacion;
        this.usuario_idCedula = usuario_idCedula;
    }

    public int getUsuario_idCedula() {
        return usuario_idCedula;
    }

    public void setUsuario_idCedula(int usuario_idCedula) {
        this.usuario_idCedula = usuario_idCedula;
    }

    public int getIdDiscapacidadOenfermedad() {
        return idDiscapacidadOenfermedad;
    }

    public void setIdDiscapacidadOenfermedad(int idDiscapacidadOenfermedad) {
        this.idDiscapacidadOenfermedad = idDiscapacidadOenfermedad;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getNumeroCarnetConadis() {
        return numeroCarnetConadis;
    }

    public void setNumeroCarnetConadis(String numeroCarnetConadis) {
        this.numeroCarnetConadis = numeroCarnetConadis;
    }

    public String getCertificadoEnfermedadCarastrofica() {
        return certificadoEnfermedadCarastrofica;
    }

    public void setCertificadoEnfermedadCarastrofica(String certificadoEnfermedadCarastrofica) {
        this.certificadoEnfermedadCarastrofica = certificadoEnfermedadCarastrofica;
    }

    public String getTipoDiscapacidad() {
        return tipoDiscapacidad;
    }

    public void setTipoDiscapacidad(String tipoDiscapacidad) {
        this.tipoDiscapacidad = tipoDiscapacidad;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getTipoEnfermedad() {
        return tipoEnfermedad;
    }

    public void setTipoEnfermedad(String tipoEnfermedad) {
        this.tipoEnfermedad = tipoEnfermedad;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    @Override
    public String toString() {
        return "DiscapacidadOenfermedad{" + "idDiscapacidadOenfermedad=" + idDiscapacidadOenfermedad + ", situacion=" + situacion + ", numeroCarnetConadis=" + numeroCarnetConadis + ", certificadoEnfermedadCarastrofica=" + certificadoEnfermedadCarastrofica + ", tipoDiscapacidad=" + tipoDiscapacidad + ", porcentaje=" + porcentaje + ", tipoEnfermedad=" + tipoEnfermedad + ", tipoRelacion=" + tipoRelacion + ", usuario_idCedula=" + usuario_idCedula + '}';
    }
    
}
