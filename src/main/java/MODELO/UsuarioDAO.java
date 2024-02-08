package MODELO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {
        //zona de atributos
private ConexionBD conecta;

//constructor
public  UsuarioDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException{
    //instancio la claseDB con los parametros para la conexion DB
    conecta = new ConexionBD(jdbcURL, jdbcUserName, jdbcPassword);
    
}

//zona de metodos insert
    public boolean registrarUsuario(Usuario op) {
        //zona de variables
        boolean estado = false; //variable para detectar el estado de la insertcion
        Statement stm;  //este objero interpreta las sentencias de sql para java(insert)
        //scrip de insercion en la BD desde java
     String sql = "INSERT INTO usuario VALUES (' " + op.getIdCedula()
                + "', '" + op.getEstado()
            + "', '" + op.getUsuario() + "', '" + op.getContrasenia()
            + "', '" + op.getNacionalidad() + "', '" + op.getRegimen()
            + "', '" + op.getNombres() + "', '" + op.getApellidos()
            + "', '" + op.getFechaNacimiento() + "', '" + op.getEstadoCivil()
            + "', '" + op.getFechaAntecedentesServicioPublico() + "', '" + op.getFechaUltimaDeclaracionDeBienes()
             + "', '" + op.getTipoSangre() + "', '" + op.getSexo()
            + "', '" + op.getDireccion() + "', '" + op.getEtnia() + "');";

        try {
            //abro la conexion a la BD
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            //ejecuto scrip de insert en la BD
            stm.execute(sql);
            estado = true;
            stm.close();
            //sierro la conexion
            conecta.disconnect();
        } catch (SQLException ex) {
            estado = false;
            ex.printStackTrace();
        }

        return estado;
    }
    
     public ArrayList SelecionarTodo() {
        //zona objetos
        Usuario objDAOoperacion;
        ArrayList<Usuario> arrOperacion = new ArrayList();
        Statement stm;// para interpretar sql desde java
        ResultSet resOperacion;//para recibir el resultado de la base
        String sql = "SELECT * FROM 5aproyectogrado.usuario";
        try {
            conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            while (resOperacion.next()) { //mientras el el objeto tenga reguistro 
                objDAOoperacion = new Usuario(resOperacion.getInt("idCedula"),
                        resOperacion.getString("estado"),resOperacion.getString("usuario"),
                        resOperacion.getString("contrasenia"), resOperacion.getString("nacionalidad"),
                        resOperacion.getString("regimen"),resOperacion.getString("nombres"), 
                        resOperacion.getString("apellidos"),resOperacion.getString("fechaNacimiento"),
                        resOperacion.getString("estadoCivil"),
                        resOperacion.getString("fechaAntecedentesServicioPublico"),
                        resOperacion.getString("fechaUltimaDeclaracionDeBienes"),
                        resOperacion.getString("tipoSangre"),resOperacion.getString("sexo"),
                        resOperacion.getString("direccion"),resOperacion.getString("etnia"));
                
                arrOperacion.add(objDAOoperacion);//carga cada reguistro en el arrailist
            }
            stm.close();
            conecta.disconnect();
        } 
        catch (SQLException e) {
            e.printStackTrace();//capturo toda la traza del error en el 
        }
        return arrOperacion;
    }
    //metodo para selecionar un registro q cumpla con una condicion
    public ArrayList SelecionarUno(int idCedula){
         Usuario objope;
        ArrayList<Usuario> arrOperacion = new ArrayList();
        Statement stm;
        ResultSet resOperacion = null;
        String sql = "SELECT * FROM usuario where idCedula = "+idCedula ;
        
        try {
             conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            if (resOperacion.next()) { //mientras el el objeto tenga reguistro 
                objope = new Usuario(resOperacion.getInt("idCedula"),
                        resOperacion.getString("estado"),resOperacion.getString("usuario"),
                        resOperacion.getString("contrasenia"), resOperacion.getString("nacionalidad"),
                        resOperacion.getString("regimen"),resOperacion.getString("nombres"), 
                        resOperacion.getString("apellidos"),resOperacion.getString("fechaNacimiento"),
                        resOperacion.getString("estadoCivil"),
                        resOperacion.getString("fechaAntecedentesServicioPublico"),
                        resOperacion.getString("fechaUltimaDeclaracionDeBienes"),
                        resOperacion.getString("tipoSangre"),resOperacion.getString("sexo"),
                        resOperacion.getString("direccion"),resOperacion.getString("etnia"));
            
        arrOperacion.add(objope);    
        }
            stm.close();
            conecta.disconnect();
        
        } 
        catch (SQLException e) {
            e.printStackTrace();//capturo toda la traza del error en el 
        }
        return arrOperacion;
    }
    //metodo para borrar
    public boolean Eliminar(int deleteId){
        //zona de variables
        
        boolean estado = false;
        Statement stm;
        String sql = "delete from usuario where idCedula = "+deleteId;
        try{
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            stm.executeUpdate(sql);
            estado = true;
            stm.close();
            conecta.disconnect();
        }
        catch(SQLException e){
            estado = false;
            e.printStackTrace();
        }
        return estado;
    }
    
      //METODO PARA MODIFICAR
    public boolean Editar(Usuario objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update usuario set estado = '" 
                + objupdate.getEstado()
                + "' where idCedula = " + objupdate.getIdCedula();
        try {
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            stm.executeUpdate(sql);
            estado = true;
            stm.close();
            conecta.disconnect();
        } catch (SQLException err) {
            estado = false;
            err.printStackTrace();
        }
        return estado;
    }

    //METODO PARA MODIFICAR
    public boolean EditarTODO(Usuario objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update usuario set estado = '" + objupdate.getEstado() + "', "
                + " usuario = '" + objupdate.getUsuario() + "',"
                + " contrasenia = '" + objupdate.getContrasenia() + "',"
                + " nacionalidad = '" + objupdate.getNacionalidad()+ "',"
                + " regimen = '" + objupdate.getRegimen() + "',"
                + " nombres = '" + objupdate.getNombres()+ "',"
                + " apellidos = '" + objupdate.getApellidos()+ "',"
                + " fechaNacimiento = '" + objupdate.getFechaNacimiento()+ "',"
                + " estadoCivil = '" + objupdate.getEstadoCivil()+ "',"
                + " fechaAntecedentesServicioPublico = '" + objupdate.getFechaAntecedentesServicioPublico()+ "',"
                + " fechaUltimaDeclaracionDeBienes = '" + objupdate.getFechaUltimaDeclaracionDeBienes()+ "',"
                + " tipoSangre = '" + objupdate.getTipoSangre()+ "',"
                + " sexo = '" + objupdate.getSexo()+ "',"
                + " direccion = '" + objupdate.getDireccion()+ "',"
                + " etnia = '" + objupdate.getEtnia()
                + "' where idCedula = "
                + objupdate.getIdCedula();
        try {

            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            stm.executeUpdate(sql);
            estado = true;
            stm.close();
            conecta.disconnect();
        } catch (SQLException err) {
            estado = false;
            err.printStackTrace();
        }
        return estado;
    }
}