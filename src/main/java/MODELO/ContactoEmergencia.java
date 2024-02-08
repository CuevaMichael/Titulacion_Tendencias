
package MODELO;

import java.sql.Date;
import java.sql.Time;

public class ContactoEmergencia {
        //zona de variables
    int idcontactoEmergencia;
    String nombres;
    String apellidos;
    String telefonoCelular;
    String telefonoConvencional;
    int usuario_idCedula;

    public ContactoEmergencia(int idcontactoEmergencia, String telefonoCelular) {
        this.idcontactoEmergencia = idcontactoEmergencia;
        this.telefonoCelular = telefonoCelular;
    }
    
    public ContactoEmergencia(int idcontactoEmergencia, String nombres, String apellidos, String telefonoCelular, String telefonoConvencional, int usuario_idCedula) {
        this.idcontactoEmergencia = idcontactoEmergencia;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefonoCelular = telefonoCelular;
        this.telefonoConvencional = telefonoConvencional;
        this.usuario_idCedula = usuario_idCedula;
    }

    public ContactoEmergencia(String nombres, String apellidos, String telefonoCelular, String telefonoConvencional, int usuario_idCedula) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefonoCelular = telefonoCelular;
        this.telefonoConvencional = telefonoConvencional;
        this.usuario_idCedula = usuario_idCedula;
    }
    
    

    public int getIdcontactoEmergencia() {
        return idcontactoEmergencia;
    }

    public void setIdcontactoEmergencia(int idcontactoEmergencia) {
        this.idcontactoEmergencia = idcontactoEmergencia;
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

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getTelefonoConvencional() {
        return telefonoConvencional;
    }

    public void setTelefonoConvencional(String telefonoConvencional) {
        this.telefonoConvencional = telefonoConvencional;
    }

    public int getUsuario_idCedula() {
        return usuario_idCedula;
    }

    public void setUsuario_idCedula(int usuario_idCedula) {
        this.usuario_idCedula = usuario_idCedula;
    }

    @Override
    public String toString() {
        return "ContactoEmergencia{" + "idcontactoEmergencia=" + idcontactoEmergencia + ", nombres=" + nombres + ", apellidos=" + apellidos + ", telefonoCelular=" + telefonoCelular + ", telefonoConvencional=" + telefonoConvencional + ", usuario_idCedula=" + usuario_idCedula + '}';
    }
    
}
