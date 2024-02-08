package MODELO;

public class Permiso {
    //zona de variables

    int idPermiso;
    String motivo;
    String fechaInicioPermiso;
    String fechaFinalPermiso;
    String HoraInicio;
    String HoraFinal;
    String diasPermiso;
    String horasPermiso;
    String observaciones;
    String valordescontar;
    int usuario_idCedula;
    
    String setOtrosMotivo;

    public void setOtrosMotivo(String otrosMotivo) {
        // Lógica para establecer el valor de otrosMotivo en el objeto Permiso
    }

    public Permiso(int idPermiso, String motivo) {
        this.idPermiso = idPermiso;
        this.motivo = motivo;
    }

    public Permiso(int idPermiso, String motivo, String fechaInicioPermiso, String fechaFinalPermiso, String HoraInicio, String HoraFinal, String diasPermiso, String horasPermiso, String observaciones, String valordescontar, int usuario_idCedula) {
        this.idPermiso = idPermiso;
        this.motivo = motivo;
        this.fechaInicioPermiso = fechaInicioPermiso;
        this.fechaFinalPermiso = fechaFinalPermiso;
        this.HoraInicio = HoraInicio;
        this.HoraFinal = HoraFinal;
        this.diasPermiso = diasPermiso;
        this.horasPermiso = horasPermiso;
        this.observaciones = observaciones;
        this.valordescontar = valordescontar;
        this.usuario_idCedula = usuario_idCedula;
    }



    public Permiso(String motivo, String fechaInicioPermiso, String fechaFinalPermiso, String HoraInicio, String HoraFinal, String diasPermiso, String horasPermiso, String observaciones, String valordescontar, int usuario_idCedula) {
        this.motivo = motivo;
        this.fechaInicioPermiso = fechaInicioPermiso;
        this.fechaFinalPermiso = fechaFinalPermiso;
        this.HoraInicio = HoraInicio;
        this.HoraFinal = HoraFinal;
        this.diasPermiso = diasPermiso;
        this.horasPermiso = horasPermiso;
        this.observaciones = observaciones;
        this.valordescontar = valordescontar;
        this.usuario_idCedula = usuario_idCedula;
    }

    public String getDiasPermiso() {
        return diasPermiso;
    }

    public void setDiasPermiso(String diasPermiso) {
        this.diasPermiso = diasPermiso;
    }

    public String getHorasPermiso() {
        return horasPermiso;
    }

    public void setHorasPermiso(String horasPermiso) {
        this.horasPermiso = horasPermiso;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaInicioPermiso() {
        return fechaInicioPermiso;
    }

    public void setFechaInicioPermiso(String fechaInicioPermiso) {
        this.fechaInicioPermiso = fechaInicioPermiso;
    }

    public String getFechaFinalPermiso() {
        return fechaFinalPermiso;
    }

    public void setFechaFinalPermiso(String fechaFinalPermiso) {
        this.fechaFinalPermiso = fechaFinalPermiso;
    }

    public String getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(String HoraInicio) {
        this.HoraInicio = HoraInicio;
    }

    public String getHoraFinal() {
        return HoraFinal;
    }

    public void setHoraFinal(String HoraFinal) {
        this.HoraFinal = HoraFinal;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getValordescontar() {
        return valordescontar;
    }

    public void setValordescontar(String valordescontar) {
        this.valordescontar = valordescontar;
    }

    public int getUsuario_idCedula() {
        return usuario_idCedula;
    }

    public void setUsuario_idCedula(int usuario_idCedula) {
        this.usuario_idCedula = usuario_idCedula;
    }

    @Override
    public String toString() {
        return "Permiso{" + "idPermiso=" + idPermiso + ", motivo=" + motivo + ", fechaInicioPermiso=" + fechaInicioPermiso + ", fechaFinalPermiso=" + fechaFinalPermiso + ", HoraInicio=" + HoraInicio + ", HoraFinal=" + HoraFinal + ", diasPermiso=" + diasPermiso + ", horasPermiso=" + horasPermiso + ", observaciones=" + observaciones + ", valordescontar=" + valordescontar + ", usuario_idCedula=" + usuario_idCedula + '}';
    }
}