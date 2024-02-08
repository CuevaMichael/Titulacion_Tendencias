package MODELO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SituacionSenescytDAO {

    // Zona de atributos
    private ConexionBD conecta;

    // Constructor
    public SituacionSenescytDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
        // Instancio la clase DB con los parámetros para la conexión DB
        conecta = new ConexionBD(jdbcURL, jdbcUserName, jdbcPassword);
    }

    // Zona de métodos insert
    public boolean registrarSituacionSenescyt(SituacionSenescyt op) {
        // Zona de variables
        boolean estado = false;
        Statement stm;
        // Script de inserción en la BD desde Java
        String sql = "INSERT INTO situacionsenescyt VALUES (null, '" + op.getFechaIngreso() + "', '" + op.getFechaSalida() + "', '"
                + op.getModalidad() + "', '" + op.getUnidad() + "', '" + op.getPuesto() + "', '" + op.getGrupoOcupacional() + "', '"
                + op.getUsuario_idCedula() + "');";

        try {
            // Abro la conexión a la BD
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            // Ejecuto script de inserción en la BD
            stm.execute(sql);
            estado = true;
            stm.close();
            // Cierro la conexión
            conecta.disconnect();
        } catch (SQLException ex) {
            estado = false;
            ex.printStackTrace();
        }

        return estado;
    }

    public ArrayList<SituacionSenescyt> SelecionarTodo() {
        SituacionSenescyt objDAOoperacion;
        ArrayList<SituacionSenescyt> arrOperacion = new ArrayList<>();
        Statement stm;
        ResultSet resOperacion;
        String sql = "SELECT * FROM 5aproyectogrado.situacionsenescyt";

        try {
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            while (resOperacion.next()) {
                objDAOoperacion = new SituacionSenescyt(
                        resOperacion.getInt("idSituacionSenescyt"),
                        resOperacion.getString("fechaIngreso"),
                        resOperacion.getString("fechaSalida"),
                        resOperacion.getString("modalidad"),
                        resOperacion.getString("unidad"),
                        resOperacion.getString("puesto"),
                        resOperacion.getString("grupoOcupacional"),
                        resOperacion.getInt("usuario_idCedula")
                );
                arrOperacion.add(objDAOoperacion);
            }
            stm.close();
            conecta.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrOperacion;
    }

    public ArrayList<SituacionSenescyt> SelecionarUno(int usuario_idCedula) {
        SituacionSenescyt objope;
        ArrayList<SituacionSenescyt> arrOperacion = new ArrayList<>();
        Statement stm;
        ResultSet resOperacion = null;
        String sql = "SELECT * FROM situacionsenescyt WHERE usuario_idCedula = " + usuario_idCedula;

        try {
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            resOperacion = stm.executeQuery(sql);
            if (resOperacion.next()) {
                objope = new SituacionSenescyt(
                        resOperacion.getInt("idSituacionSenescyt"),
                        resOperacion.getString("fechaIngreso"),
                        resOperacion.getString("fechaSalida"),
                        resOperacion.getString("modalidad"),
                        resOperacion.getString("unidad"),
                        resOperacion.getString("puesto"),
                        resOperacion.getString("grupoOcupacional"),
                        resOperacion.getInt("usuario_idCedula")
                );
                arrOperacion.add(objope);
            }
            stm.close();
            conecta.disconnect();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrOperacion;
    }

    public boolean Eliminar(int deleteId) {
        boolean estado = false;
        Statement stm;
        String sql = "DELETE FROM situacionsenescyt WHERE idSituacionSenescyt = " + deleteId;
        try {
            conecta.connection();
            stm = conecta.getJdbcConnection().createStatement();
            stm.executeUpdate(sql);
            estado = true;
            stm.close();
            conecta.disconnect();
        } catch (SQLException e) {
            estado = false;
            e.printStackTrace();
        }
        return estado;
    }

    public boolean Editar(SituacionSenescyt objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "UPDATE situacionsenescyt SET modalidad = '"
                + objupdate.getModalidad()
                + "' WHERE idSituacionSenescyt = " + objupdate.getIdSituacionSenescyt();
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

    public boolean EditarTODO(SituacionSenescyt objupdate) {
        boolean estado = false;
        Statement stm;
        String sql = "UPDATE situacionsenescyt SET fechaIngreso = '" + objupdate.getFechaIngreso() + "', "
                + "fechaSalida = '" + objupdate.getFechaSalida() + "',"
                + "modalidad = '" + objupdate.getModalidad() + "',"
                + "unidad = '" + objupdate.getUnidad() + "',"
                + "puesto = '" + objupdate.getPuesto() + "',"
                + "grupoOcupacional = '" + objupdate.getGrupoOcupacional()
                + "' WHERE idSituacionSenescyt = "
                + objupdate.getIdSituacionSenescyt();
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
