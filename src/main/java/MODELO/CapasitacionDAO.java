package MODELO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CapasitacionDAO {
    private ConexionBD conecta;
//constructor
public  CapasitacionDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException{
    //instancio la claseDB con los parametros para la conexion DB
    conecta = new ConexionBD(jdbcURL, jdbcUserName, jdbcPassword);
}

    //zona de metodos insert
    public boolean registrarCapasitacion(Capasitacion op){
        //zona de variables
        boolean estado = false; //variable para detectar el estado de la insertcion
        Statement stm;  //este objero interpreta las sentencias de sql para java(insert)
        //scrip de insercion en la BD desde java
        String sql = "insert into capasitacion values (null,' "+
                op.getNombreEvento()+" ',' "+op.getTipoEvento()+
                " ',' "+op.getAuspiciante()+" ',' "+op.getDuracionHoras()+
                " ',' "+op.getTipoCertificado()+" ',' "+op.getCertificadoPor()+
                " ',' "+op.getFechaInicio()+" ',' "+op.getFechaFin()+
                " ',' "+op.getPais()+" ',' "+op.getUsuario_idCedula()+" ');";
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
        Capasitacion objDAOoperacion;
        ArrayList<Capasitacion> arrOperacion = new ArrayList();
        Statement stm;// para interpretar sql desde java
        ResultSet resOperacion;//para recibir el resultado de la base
        String sql = "SELECT * FROM 5aproyectogrado.capasitacion";
        try {
            conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            while (resOperacion.next()) { //mientras el el objeto tenga reguistro 
                objDAOoperacion = new Capasitacion(resOperacion.getInt("idCapasitacion"),
                        resOperacion.getString("nombreEvento"),
                        resOperacion.getString("tipoEvento"), resOperacion.getString("auspiciante"),
                        resOperacion.getString("duracionHoras"), resOperacion.getString("tipoCertificado"),
                        resOperacion.getString("certificadoPor"), resOperacion.getString("fechaInicio"),
                        resOperacion.getString("fechaFin"), resOperacion.getString("pais"),
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
    public ArrayList SelecionarUno(int id) {
        Capasitacion objope;
        ArrayList<Capasitacion> arrOperacion = new ArrayList();
        Statement stm;
        ResultSet resOperacion = null;
        String sql = "SELECT * FROM capasitacion where usuario_idCedula = " + id;

        try {
            conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            if (resOperacion.next()) { //mientras el el objeto tenga reguistro 
                objope = new Capasitacion(resOperacion.getInt("idCapasitacion"),
                        resOperacion.getString("nombreEvento"),
                        resOperacion.getString("tipoEvento"), resOperacion.getString("auspiciante"),
                        resOperacion.getString("duracionHoras"), resOperacion.getString("tipoCertificado"),
                        resOperacion.getString("certificadoPor"), resOperacion.getString("fechaInicio"),
                        resOperacion.getString("fechaFin"), resOperacion.getString("pais"),
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
    public boolean Eliminar(int idDelet){
        //zona de variables
        
        boolean estado = false;
        Statement stm;
        String sql = "delete from capasitacion where idCapasitacion = "+idDelet;
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
    public boolean Editar(Capasitacion objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update capasitacion set nombreEvento = '" 
                + objupdate.getNombreEvento()
                + "' where idCapasitacion = " + objupdate.getIdCapasitacion();
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
    public boolean EditarTODO(Capasitacion objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update capasitacion set nombreEvento = '" + objupdate.getNombreEvento() + "', "
                + " tipoEvento = '" + objupdate.getTipoEvento()+ "',"
                + " auspiciante = '" + objupdate.getAuspiciante()+ "',"
                + " duracionHoras = '" + objupdate.getDuracionHoras()+ "',"
                + " tipoCertificado = '" + objupdate.getTipoCertificado()+ "',"
                + " certificadoPor = '" + objupdate.getCertificadoPor()+ "',"
                + " fechaInicio = '" + objupdate.getFechaInicio()+ "',"
                  + " fechaFin = '" + objupdate.getFechaFin()+ "',"
                  + " pais = '" + objupdate.getPais()+ "',"
                + " usuario_idCedula = '" + objupdate.getUsuario_idCedula()
                + "' where idCapasitacion = "
                + objupdate.getIdCapasitacion();
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