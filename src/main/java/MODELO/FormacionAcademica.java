
package MODELO;

public class FormacionAcademica {
        //zona de variables
    int idFormacionAcademica;
    String nivelInstrucion;
    String numeroRegistroCertificado;
    String institucionEducativa;
    String numeroAniosAprobados;
    String areaConocimiento;
    String egresadoOgraduado;
    String tituloObtenido;
    String pais;
    int usuario_idCedula;

    public FormacionAcademica(int idFormacionAcademica, String numeroAniosAprobados) {
        this.idFormacionAcademica = idFormacionAcademica;
        this.numeroAniosAprobados = numeroAniosAprobados;
    }
    
    public FormacionAcademica(int idFormacionAcademica, String nivelInstrucion, String numeroRegistroCertificado, String institucionEducativa, String numeroAniosAprobados, String areaConocimiento, String egresadoOgraduado, String tituloObtenido, String pais, int usuario_idCedula) {
        this.idFormacionAcademica = idFormacionAcademica;
        this.nivelInstrucion = nivelInstrucion;
        this.numeroRegistroCertificado = numeroRegistroCertificado;
        this.institucionEducativa = institucionEducativa;
        this.numeroAniosAprobados = numeroAniosAprobados;
        this.areaConocimiento = areaConocimiento;
        this.egresadoOgraduado = egresadoOgraduado;
        this.tituloObtenido = tituloObtenido;
        this.pais = pais;
        this.usuario_idCedula = usuario_idCedula;
    }

    public FormacionAcademica(String nivelInstrucion, String numeroRegistroCertificado, String institucionEducativa, String numeroAniosAprobados, String areaConocimiento, String egresadoOgraduado, String tituloObtenido, String pais, int usuario_idCedula) {
        this.nivelInstrucion = nivelInstrucion;
        this.numeroRegistroCertificado = numeroRegistroCertificado;
        this.institucionEducativa = institucionEducativa;
        this.numeroAniosAprobados = numeroAniosAprobados;
        this.areaConocimiento = areaConocimiento;
        this.egresadoOgraduado = egresadoOgraduado;
        this.tituloObtenido = tituloObtenido;
        this.pais = pais;
        this.usuario_idCedula = usuario_idCedula;
    }
    
    

    public int getIdFormacionAcademica() {
        return idFormacionAcademica;
    }

    public void setIdFormacionAcademica(int idFormacionAcademica) {
        this.idFormacionAcademica = idFormacionAcademica;
    }

    public String getNivelInstrucion() {
        return nivelInstrucion;
    }

    public void setNivelInstrucion(String nivelInstrucion) {
        this.nivelInstrucion = nivelInstrucion;
    }

    public String getNumeroRegistroCertificado() {
        return numeroRegistroCertificado;
    }

    public void setNumeroRegistroCertificado(String numeroRegistroCertificado) {
        this.numeroRegistroCertificado = numeroRegistroCertificado;
    }

    public String getInstitucionEducativa() {
        return institucionEducativa;
    }

    public void setInstitucionEducativa(String institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

    public String getNumeroAniosAprobados() {
        return numeroAniosAprobados;
    }

    public void setNumeroAniosAprobados(String numeroAniosAprobados) {
        this.numeroAniosAprobados = numeroAniosAprobados;
    }

    public String getAreaConocimiento() {
        return areaConocimiento;
    }

    public void setAreaConocimiento(String areaConocimiento) {
        this.areaConocimiento = areaConocimiento;
    }

    public String getEgresadoOgraduado() {
        return egresadoOgraduado;
    }

    public void setEgresadoOgraduado(String egresadoOgraduado) {
        this.egresadoOgraduado = egresadoOgraduado;
    }

    public String getTituloObtenido() {
        return tituloObtenido;
    }

    public void setTituloObtenido(String tituloObtenido) {
        this.tituloObtenido = tituloObtenido;
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
        return "FormacionAcademica{" + "idFormacionAcademica=" + idFormacionAcademica + ", nivelInstrucion=" + nivelInstrucion + ", numeroRegistroCertificado=" + numeroRegistroCertificado + ", institucionEducativa=" + institucionEducativa + ", numeroAniosAprobados=" + numeroAniosAprobados + ", areaConocimiento=" + areaConocimiento + ", egresadoOgraduado=" + egresadoOgraduado + ", tituloObtenido=" + tituloObtenido + ", pais=" + pais + ", usuario_idCedula=" + usuario_idCedula + '}';
    }
    
    
}
