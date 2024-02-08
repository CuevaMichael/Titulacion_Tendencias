package MODELO;

import java.sql.Date;
import java.sql.Time;

public class Capasitacion {
    //zona de variables
    int idCapasitacion;
    String nombreEvento;
    String tipoEvento;
    String auspiciante;
    String duracionHoras;
    String tipoCertificado;
    String certificadoPor;
    String fechaInicio;
    String fechaFin;
    String pais;
    int usuario_idCedula;
//zona de constructor

    public Capasitacion(int idCapasitacion, String nombreEvento) {
        this.idCapasitacion = idCapasitacion;
        this.nombreEvento = nombreEvento;
    }

    public Capasitacion(int idCapasitacion, String nombreEvento, String tipoEvento, String auspiciante, String duracionHoras, String tipoCertificado, String certificadoPor, String fechaInicio, String fechaFin, String pais, int usuario_idCedula) {
        this.idCapasitacion = idCapasitacion;
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.auspiciante = auspiciante;
        this.duracionHoras = duracionHoras;
        this.tipoCertificado = tipoCertificado;
        this.certificadoPor = certificadoPor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pais = pais;
        this.usuario_idCedula = usuario_idCedula;
    }

    public Capasitacion(String nombreEvento, String tipoEvento, String auspiciante, String duracionHoras, String tipoCertificado, String certificadoPor, String fechaInicio, String fechaFin, String pais, int usuario_idCedula) {
        this.nombreEvento = nombreEvento;
        this.tipoEvento = tipoEvento;
        this.auspiciante = auspiciante;
        this.duracionHoras = duracionHoras;
        this.tipoCertificado = tipoCertificado;
        this.certificadoPor = certificadoPor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pais = pais;
        this.usuario_idCedula = usuario_idCedula;
    }

    public int getIdCapasitacion() {
        return idCapasitacion;
    }

    public void setIdCapasitacion(int idCapasitacion) {
        this.idCapasitacion = idCapasitacion;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getAuspiciante() {
        return auspiciante;
    }

    public void setAuspiciante(String auspiciante) {
        this.auspiciante = auspiciante;
    }

    public String getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(String duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public String getTipoCertificado() {
        return tipoCertificado;
    }

    public void setTipoCertificado(String tipoCertificado) {
        this.tipoCertificado = tipoCertificado;
    }

    public String getCertificadoPor() {
        return certificadoPor;
    }

    public void setCertificadoPor(String certificadoPor) {
        this.certificadoPor = certificadoPor;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getUsuario_idCedula() {
        return usuario_idCedula;
    }

    public void setUsuario_idCedula(int usuario_idCedula) {
        this.usuario_idCedula = usuario_idCedula;
    }

    @Override
    public String toString() {
        return "Capasitacion{" + "idCapasitacion=" + idCapasitacion + ", nombreEvento=" + nombreEvento + ", tipoEvento=" + tipoEvento + ", auspiciante=" + auspiciante + ", duracionHoras=" + duracionHoras + ", tipoCertificado=" + tipoCertificado + ", certificadoPor=" + certificadoPor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", pais=" + pais + ", usuario_idCedula=" + usuario_idCedula + '}';
    }  
}