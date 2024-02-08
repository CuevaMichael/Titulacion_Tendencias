
package MODELO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContactoEmergenciaDAO {
        //zona de atributos
private ConexionBD conecta;

//constructor
public  ContactoEmergenciaDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException{
    //instancio la claseDB con los parametros para la conexion DB
    conecta = new ConexionBD(jdbcURL, jdbcUserName, jdbcPassword);
}

//zona de metodos insert
    public boolean registrarContactoEmergencia(ContactoEmergencia op){
        //zona de variables
        boolean estado = false; //variable para detectar el estado de la insertcion
        Statement stm;  //este objero interpreta las sentencias de sql para java(insert)
        //scrip de insercion en la BD desde java
        String sql = "insert into contactoemergencia values (null,' "+
                op.getNombres()+" ',' "+op.getApellidos()+
                " ',' "+op.getTelefonoCelular()+" ',' "+op.getTelefonoConvencional()+
              " ',' "+op.getUsuario_idCedula()+" ');";
        try{
            //abro la conexion a la BD
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            //ejecuto scrip de insert en la BD
            stm.execute(sql);
            estado = true;
            stm.close();
            //sierro la conexion
            conecta.disconnect();
        }
        catch(SQLException ex){
            estado = false;
            ex.printStackTrace();
        }
        
    return estado;
    } 
    
    public ArrayList SelecionarTodo() {
        //zona objetos
        ContactoEmergencia objDAOoperacion;
        ArrayList<ContactoEmergencia> arrOperacion = new ArrayList();
        Statement stm;// para interpretar sql desde java
        ResultSet resOperacion;//para recibir el resultado de la base
        String sql = "SELECT * FROM 5aproyectogrado.contactoemergencia";
        try {
            conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            while (resOperacion.next()) { //mientras el el objeto tenga reguistro 
                objDAOoperacion = new ContactoEmergencia(resOperacion.getInt("idcontactoEmergencia"),
                        resOperacion.getString("nombres"),
                        resOperacion.getString("apellidos"), resOperacion.getString("telefonoCelular"),
                        resOperacion.getString("telefonoConvencional"), 
                        resOperacion.getInt("usuario_idCedula"));

                arrOperacion.add(objDAOoperacion);//carga cada reguistro en el arrailist
            }
            stm.close();
            conecta.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();//capturo toda la traza del error en el 
        }
        return arrOperacion;
    }

    //metodo para selecionar un registro q cumpla con una condicion
    public ArrayList SelecionarUno(int usuario_idCedula) {
        ContactoEmergencia objope;
        ArrayList<ContactoEmergencia> arrOperacion = new ArrayList();
        Statement stm;
        ResultSet resOperacion = null;
        String sql = "SELECT * FROM contactoemergencia where usuario_idCedula = " + usuario_idCedula;

        try {
            conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            if (resOperacion.next()) { //mientras el el objeto tenga reguistro 
                objope = new ContactoEmergencia(resOperacion.getInt("idcontactoEmergencia"),
                        resOperacion.getString("nombres"),
                        resOperacion.getString("apellidos"), resOperacion.getString("telefonoCelular"),
                        resOperacion.getString("telefonoConvencional"), 
                        resOperacion.getInt("usuario_idCedula"));

                arrOperacion.add(objope);
            }
            stm.close();
            conecta.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();//capturo toda la traza del error en el 
        }
        return arrOperacion;
    }
    //metodo para borrar
    public boolean Eliminar(int deleteId){
        //zona de variables
        
        boolean estado = false;
        Statement stm;
        String sql = "delete from contactoemergencia where idcontactoEmergencia = "+deleteId;
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
    public boolean Editar(ContactoEmergencia objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update contactoemergencia set telefonoCelular = '" 
                + objupdate.getTelefonoCelular()
                + "' where idcontactoEmergencia = " + objupdate.getIdcontactoEmergencia();
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
    public boolean EditarTODO(ContactoEmergencia objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update contactoemergencia set nombres = '" + objupdate.getNombres() + "', "
                + " apellidos = '" + objupdate.getApellidos() + "',"
                + " telefonoCelular = '" + objupdate.getTelefonoCelular() + "',"
                + " telefonoConvencional = '" + objupdate.getTelefonoConvencional()
                + "' where idcontactoEmergencia = "
                + objupdate.getIdcontactoEmergencia();
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
