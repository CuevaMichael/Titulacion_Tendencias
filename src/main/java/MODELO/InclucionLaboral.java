
package MODELO;

public class InclucionLaboral {
        //zona de variables
    int idInclucionLaboral;
    String migrante;
    String nacionalidad;
    String embarazo;
    String mesesEmbarazo;
    String licencia;
    String porcentaje;
    int usuario_idCedula;

    public InclucionLaboral(int idInclucionLaboral, String nacionalidad) {
        this.idInclucionLaboral = idInclucionLaboral;
        this.nacionalidad = nacionalidad;
    }

    public InclucionLaboral(int idInclucionLaboral, String migrante, String nacionalidad, String embarazo, String mesesEmbarazo, String licencia, String porcentaje, int usuario_idCedula) {
        this.idInclucionLaboral = idInclucionLaboral;
        this.migrante = migrante;
        this.nacionalidad = nacionalidad;
        this.embarazo = embarazo;
        this.mesesEmbarazo = mesesEmbarazo;
        this.licencia = licencia;
        this.porcentaje = porcentaje;
        this.usuario_idCedula = usuario_idCedula;
    }

    public InclucionLaboral(String migrante, String nacionalidad, String embarazo, String mesesEmbarazo, String licencia, String porcentaje, int usuario_idCedula) {
        this.migrante = migrante;
        this.nacionalidad = nacionalidad;
        this.embarazo = embarazo;
        this.mesesEmbarazo = mesesEmbarazo;
        this.licencia = licencia;
        this.porcentaje = porcentaje;
        this.usuario_idCedula = usuario_idCedula;
    }
    
    

    public int getIdInclucionLaboral() {
        return idInclucionLaboral;
    }

    public void setIdInclucionLaboral(int idInclucionLaboral) {
        this.idInclucionLaboral = idInclucionLaboral;
    }

    public String getMigrante() {
        return migrante;
    }

    public void setMigrante(String migrante) {
        this.migrante = migrante;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEmbarazo() {
        return embarazo;
    }

    public void setEmbarazo(String embarazo) {
        this.embarazo = embarazo;
    }

    public String getMesesEmbarazo() {
        return mesesEmbarazo;
    }

    public void setMesesEmbarazo(String mesesEmbarazo) {
        this.mesesEmbarazo = mesesEmbarazo;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getUsuario_idCedula() {
        return usuario_idCedula;
    }

    public void setUsuario_idCedula(int usuario_idCedula) {
        this.usuario_idCedula = usuario_idCedula;
    }

    @Override
    public String toString() {
        return "InclucionLaboral{" + "idInclucionLaboral=" + idInclucionLaboral + ", migrante=" + migrante + ", nacionalidad=" + nacionalidad + ", embarazo=" + embarazo + ", mesesEmbarazo=" + mesesEmbarazo + ", licencia=" + licencia + ", porcentaje=" + porcentaje + ", usuario_idCedula=" + usuario_idCedula + '}';
    }
    
    
}
