
package MODELO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FormacionAcademicaDAO {
        //zona de atributos
private ConexionBD conecta;

//constructor
public  FormacionAcademicaDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException{
    //instancio la claseDB con los parametros para la conexion DB
    conecta = new ConexionBD(jdbcURL, jdbcUserName, jdbcPassword);
}

//zona de metodos insert
    public boolean registrarFormacionAcademica(FormacionAcademica op) {
        //zona de variables
        boolean estado = false; //variable para detectar el estado de la insertcion
        Statement stm;  //este objero interpreta las sentencias de sql para java(insert)
        //scrip de insercion en la BD desde java
        String sql = "insert into formacionacademica values (null,' "
                + op.getNivelInstrucion()+ " ',' " + op.getNumeroRegistroCertificado()
                + " ',' " + op.getInstitucionEducativa()+ " ',' " + op.getNumeroAniosAprobados()
                + " ',' " +  op.getAreaConocimiento()+ " ',' " + op.getEgresadoOgraduado()
                  + " ',' " +  op.getTituloObtenido()+ " ',' " + op.getPais()
                + " ',' " + op.getUsuario_idCedula() + " ');";
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
        FormacionAcademica objDAOoperacion;
        ArrayList<FormacionAcademica> arrOperacion = new ArrayList();
        Statement stm;// para interpretar sql desde java
        ResultSet resOperacion;//para recibir el resultado de la base
        String sql = "SELECT * FROM 5aproyectogrado.formacionacademica";
        try {
            conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            while (resOperacion.next()) { //mientras el objeto tenga reguistro 
                objDAOoperacion = new FormacionAcademica(resOperacion.getInt("idFormacionAcademica"),
                        resOperacion.getString("nivelInstrucion"),
                        resOperacion.getString("numeroRegistroCertificado"),
                        resOperacion.getString("institucionEducativa"),
                        resOperacion.getString("numeroAniosAprobados"),
                        resOperacion.getString("areaConocimiento"),
                        resOperacion.getString("egresadoOgraduado"),
                        resOperacion.getString("tituloObtenido"),
                        resOperacion.getString("pais"),
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
        FormacionAcademica objope;
        ArrayList<FormacionAcademica> arrOperacion = new ArrayList();
        Statement stm;
        ResultSet resOperacion = null;
        String sql = "SELECT * FROM formacionacademica where usuario_idCedula = " + usuario_idCedula;

        try {
            conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            if (resOperacion.next()) { //mientras el el objeto tenga reguistro 
                objope = new FormacionAcademica(resOperacion.getInt("idFormacionAcademica"),
                        resOperacion.getString("nivelInstrucion"),
                        resOperacion.getString("numeroRegistroCertificado"),
                        resOperacion.getString("institucionEducativa"),
                        resOperacion.getString("numeroAniosAprobados"),
                        resOperacion.getString("areaConocimiento"),
                        resOperacion.getString("egresadoOgraduado"),
                        resOperacion.getString("tituloObtenido"),
                        resOperacion.getString("pais"),
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
        String sql = "delete from formacionacademica where idFormacionAcademica = "+deleteId;
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
    public boolean Editar(FormacionAcademica objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update formacionacademica set numeroAniosAprobados = '" 
                + objupdate.getNumeroAniosAprobados()
                + "' where idFormacionAcademica = " + objupdate.getIdFormacionAcademica();
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
    public boolean EditarTODO(FormacionAcademica objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update formacionacademica set nivelInstrucion = '" + objupdate.getNivelInstrucion() + "', "
                + " numeroRegistroCertificado = '" + objupdate.getNumeroRegistroCertificado() + "',"
                + " institucionEducativa = '" + objupdate.getInstitucionEducativa() + "',"
                + " numeroAniosAprobados = '" + objupdate.getNumeroAniosAprobados() + "',"
                + " areaConocimiento = '" + objupdate.getAreaConocimiento() + "',"
                + " egresadoOgraduado = '" + objupdate.getEgresadoOgraduado() + "',"
                + " tituloObtenido = '" + objupdate.getTituloObtenido() + "',"
                + " pais = '" + objupdate.getPais()
                + "' where idFormacionAcademica = "
                + objupdate.getIdFormacionAcademica();
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
