package MODELO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DiscapacidadOenfermedadDAO {
    //zona de atributos

    private ConexionBD conecta;

//constructor
    public DiscapacidadOenfermedadDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
        //instancio la claseDB con los parametros para la conexion DB
        conecta = new ConexionBD(jdbcURL, jdbcUserName, jdbcPassword);
    }

//zona de metodos insert
    public boolean registrarDiscapacidadOenfermedad(DiscapacidadOenfermedad op) {
        //zona de variables
        boolean estado = false; //variable para detectar el estado de la insertcion
        Statement stm;  //este objero interpreta las sentencias de sql para java(insert)
        //scrip de insercion en la BD desde java
        String sql = "insert into discapacidadoenfermedad values (null,' "
                + op.getSituacion() + " ',' " + op.getNumeroCarnetConadis()
                + " ',' " + op.getCertificadoEnfermedadCarastrofica() + " ',' " + op.getTipoDiscapacidad()
                + " ',' " +  op.getPorcentaje()+ " ',' " + op.getTipoEnfermedad()
                + " ',' " + op.getTipoRelacion()+ " ',' " + op.getUsuario_idCedula() + " ');";
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
        DiscapacidadOenfermedad objDAOoperacion;
        ArrayList<DiscapacidadOenfermedad> arrOperacion = new ArrayList();
        Statement stm;// para interpretar sql desde java
        ResultSet resOperacion;//para recibir el resultado de la base
        String sql = "SELECT * FROM 5aproyectogrado.discapacidadoenfermedad";
        try {
            conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            while (resOperacion.next()) { //mientras el el objeto tenga reguistro 
                objDAOoperacion = new DiscapacidadOenfermedad(resOperacion.getInt("idDiscapacidadOenfermedad"),
                        resOperacion.getString("situacion"),
                        resOperacion.getString("numeroCarnetConadis"),
                        resOperacion.getString("certificadoEnfermedadCarastrofica"),
                        resOperacion.getString("tipoDiscapacidad"),
                        resOperacion.getString("porcentaje"),
                        resOperacion.getString("tipoEnfermedad"),
                        resOperacion.getString("tipoRelacion"),
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
        DiscapacidadOenfermedad objope;
        ArrayList<DiscapacidadOenfermedad> arrOperacion = new ArrayList();
        Statement stm;
        ResultSet resOperacion = null;
        String sql = "SELECT * FROM discapacidadoenfermedad where usuario_idCedula = " + usuario_idCedula;

        try {
            conecta.connection();//abro conexin bd
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            if (resOperacion.next()) { //mientras el el objeto tenga reguistro 
                objope = new DiscapacidadOenfermedad(resOperacion.getInt("idDiscapacidadOenfermedad"),
                        resOperacion.getString("situacion"),
                        resOperacion.getString("numeroCarnetConadis"),
                        resOperacion.getString("certificadoEnfermedadCarastrofica"),
                        resOperacion.getString("tipoDiscapacidad"),
                        resOperacion.getString("porcentaje"),
                        resOperacion.getString("tipoEnfermedad"),
                        resOperacion.getString("tipoRelacion"),
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
        String sql = "delete from discapacidadoenfermedad where idDiscapacidadOenfermedad = "+deleteId;
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
    public boolean Editar(DiscapacidadOenfermedad objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update discapacidadoenfermedad set tipoEnfermedad = '" 
                + objupdate.getTipoEnfermedad()
                + "' where idDiscapacidadOenfermedad = " + objupdate.getIdDiscapacidadOenfermedad();
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
    public boolean EditarTODO(DiscapacidadOenfermedad objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "update discapacidadoenfermedad set situacion = '" + objupdate.getSituacion() + "', "
                + " numeroCarnetConadis = '" + objupdate.getNumeroCarnetConadis() + "',"
                + " certificadoEnfermedadCarastrofica = '" + objupdate.getCertificadoEnfermedadCarastrofica() + "',"
                + " tipoDiscapacidad = '" + objupdate.getTipoDiscapacidad() + "',"
                + " porcentaje = '" + objupdate.getPorcentaje() + "',"
                + " tipoEnfermedad = '" + objupdate.getTipoEnfermedad() + "',"
                + " tipoRelacion = '" + objupdate.getTipoRelacion()
                + "' where idDiscapacidadOenfermedad = "
                + objupdate.getIdDiscapacidadOenfermedad();
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
