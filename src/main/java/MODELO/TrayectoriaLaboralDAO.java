
package MODELO;

import java.sql.SQLException;

public class TrayectoriaLaboralDAO {
        //zona de atributos
private ConexionBD conecta;

//constructor
public  TrayectoriaLaboralDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException{
    //instancio la claseDB con los parametros para la conexion DB
    conecta = new ConexionBD(jdbcURL, jdbcUserName, jdbcPassword);
    
}
}
