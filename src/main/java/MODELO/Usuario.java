package MODELO;

import java.sql.Date;

public class Usuario {
    //zona de variables
   
    int idCedula;
     String estado;
    String usuario;
    String contrasenia;
    String nacionalidad;
    String regimen;
    String nombres;
    String apellidos;
    String fechaNacimiento;
    String estadoCivil;
    String fechaAntecedentesServicioPublico;
    String fechaUltimaDeclaracionDeBienes;
    String tipoSangre;
    String sexo;
    String direccion;
    String etnia;

    public Usuario(int idCedula, String estado) {
        this.idCedula = idCedula;
        this.estado = estado;
    }

    
    public Usuario(int idCedula, String usuario, String contrasenia, String nacionalidad, String regimen, String nombres, String apellidos, String fechaNacimiento, String estadoCivil, String fechaAntecedentesServicioPublico, String fechaUltimaDeclaracionDeBienes, String tipoSangre, String sexo, String direccion, String etnia) {
        this.idCedula = idCedula;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nacionalidad = nacionalidad;
        this.regimen = regimen;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.fechaAntecedentesServicioPublico = fechaAntecedentesServicioPublico;
        this.fechaUltimaDeclaracionDeBienes = fechaUltimaDeclaracionDeBienes;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
        this.direccion = direccion;
        this.etnia = etnia;
    }

    public Usuario(int idCedula, String estado, String usuario, String contrasenia, String nacionalidad, String regimen, String nombres, String apellidos, String fechaNacimiento, String estadoCivil, String fechaAntecedentesServicioPublico, String fechaUltimaDeclaracionDeBienes, String tipoSangre, String sexo, String direccion, String etnia) {
        this.idCedula = idCedula;
        this.estado = estado;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nacionalidad = nacionalidad;
        this.regimen = regimen;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.fechaAntecedentesServicioPublico = fechaAntecedentesServicioPublico;
        this.fechaUltimaDeclaracionDeBienes = fechaUltimaDeclaracionDeBienes;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;
        this.direccion = direccion;
        this.etnia = etnia;
    }

    public int getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(int idCedula) {
        this.idCedula = idCedula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getRegimen() {
        return regimen;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
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

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFechaAntecedentesServicioPublico() {
        return fechaAntecedentesServicioPublico;
    }

    public void setFechaAntecedentesServicioPublico(String fechaAntecedentesServicioPublico) {
        this.fechaAntecedentesServicioPublico = fechaAntecedentesServicioPublico;
    }

    public String getFechaUltimaDeclaracionDeBienes() {
        return fechaUltimaDeclaracionDeBienes;
    }

    public void setFechaUltimaDeclaracionDeBienes(String fechaUltimaDeclaracionDeBienes) {
        this.fechaUltimaDeclaracionDeBienes = fechaUltimaDeclaracionDeBienes;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idCedula=" + idCedula + ", estado=" + estado + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", nacionalidad=" + nacionalidad + ", regimen=" + regimen + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", estadoCivil=" + estadoCivil + ", fechaAntecedentesServicioPublico=" + fechaAntecedentesServicioPublico + ", fechaUltimaDeclaracionDeBienes=" + fechaUltimaDeclaracionDeBienes + ", tipoSangre=" + tipoSangre + ", sexo=" + sexo + ", direccion=" + direccion + ", etnia=" + etnia + '}';
    }

}