package MODELO;

public class Asistencia {

    //zona de variables
    private int idAsistencia;
    private String fechaAsistencia;
    private String horaEntrada;
    private String horaSalida;
    private String obserbaciones;
    private String cumpleOchoHoras;
    private String hojaRuta;
    private String horaInicioHojaRuta;
    private String horaFinHojaRuta;
    private int usuario_idCedula;

    public Asistencia(int idAsistencia, String obserbaciones) {
        this.idAsistencia = idAsistencia;
        this.obserbaciones = obserbaciones;
    }

    public Asistencia(String fechaAsistencia, String horaEntrada, String horaSalida, String obserbaciones, String cumpleOchoHoras, String hojaRuta, String horaInicioHojaRuta, String horaFinHojaRuta, int usuario_idCedula) {
        this.fechaAsistencia = fechaAsistencia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.obserbaciones = obserbaciones;
        this.cumpleOchoHoras = cumpleOchoHoras;
        this.hojaRuta = hojaRuta;
        this.horaInicioHojaRuta = horaInicioHojaRuta;
        this.horaFinHojaRuta = horaFinHojaRuta;
        this.usuario_idCedula = usuario_idCedula;
    }
    
    

    public Asistencia(int idAsistencia, String fechaAsistencia, String horaEntrada, String horaSalida, String obserbaciones, String cumpleOchoHoras, String hojaRuta, String horaInicioHojaRuta, String horaFinHojaRuta, int usuario_idCedula) {
        this.idAsistencia = idAsistencia;
        this.fechaAsistencia = fechaAsistencia;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.obserbaciones = obserbaciones;
        this.cumpleOchoHoras = cumpleOchoHoras;
        this.hojaRuta = hojaRuta;
        this.horaInicioHojaRuta = horaInicioHojaRuta;
        this.horaFinHojaRuta = horaFinHojaRuta;
        this.usuario_idCedula = usuario_idCedula;
    }

    public int getUsuario_idCedula() {
        return usuario_idCedula;
    }

    public void setUsuario_idCedula(int usuario_idCedula) {
        this.usuario_idCedula = usuario_idCedula;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public String getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(String fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getObserbaciones() {
        return obserbaciones;
    }

    public void setObserbaciones(String obserbaciones) {
        this.obserbaciones = obserbaciones;
    }

    public String getCumpleOchoHoras() {
        return cumpleOchoHoras;
    }

    public void setCumpleOchoHoras(String cumpleOchoHoras) {
        this.cumpleOchoHoras = cumpleOchoHoras;
    }

    public String getHojaRuta() {
        return hojaRuta;
    }

    public void setHojaRuta(String hojaRuta) {
        this.hojaRuta = hojaRuta;
    }

    public String getHoraInicioHojaRuta() {
        return horaInicioHojaRuta;
    }

    public void setHoraInicioHojaRuta(String horaInicioHojaRuta) {
        this.horaInicioHojaRuta = horaInicioHojaRuta;
    }

    public String getHoraFinHojaRuta() {
        return horaFinHojaRuta;
    }

    public void setHoraFinHojaRuta(String horaFinHojaRuta) {
        this.horaFinHojaRuta = horaFinHojaRuta;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "idAsistencia=" + idAsistencia + ", fechaAsistencia=" + fechaAsistencia + ", horaEntrada=" + horaEntrada + ", horaSalida=" + horaSalida + ", obserbaciones=" + obserbaciones + ", cumpleOchoHoras=" + cumpleOchoHoras + ", hojaRuta=" + hojaRuta + ", horaInicioHojaRuta=" + horaInicioHojaRuta + ", horaFinHojaRuta=" + horaFinHojaRuta + ", usuario_idCedula=" + usuario_idCedula + '}';
    }
}
