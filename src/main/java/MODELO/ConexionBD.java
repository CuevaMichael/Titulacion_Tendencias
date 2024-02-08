package MODELO;

import java.sql.*;

public class ConexionBD {
    //zona de atributos
    private String jdbcURL;                         //para guardar la cadena de conexion
    private String jdbcUserName;                //nombre del usuario admin de la base de datos
    private String jdbcPassword;                  //contraseña del admin de la base de datos
    private Connection jdbcConnection;                          //objeto ´para gestionar el driver 

    //zona de constructor
    public ConexionBD (String jdbcURL, String jdbcUserName, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUserName = jdbcUserName;
        this.jdbcPassword = jdbcPassword;
    }
    
    //zona de metodos
    //metodo para abrir la conexion
    public void connection() throws SQLException {
        //si la conexion esta serrada la abro
        if( jdbcConnection ==  null || jdbcConnection.isClosed()){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.err.println("Conexion exitosa");
            }
            catch( ClassNotFoundException obje){
                System.err.println("Error de conexion");
                throw new SQLException (obje);
            }
            //abro conexion a la base  
           jdbcConnection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        }
    }

    
    //metodo para desconectar la conexion
    public void disconnect() throws SQLException{
        if(jdbcConnection != null &&  ! jdbcConnection.isClosed()){
            jdbcConnection.close();//cierro conexion ala base
        }
    }
    
    //metodo para trabajar con la conexion de BD
    public Connection getJdbcConnection(){
        return jdbcConnection;
    }
}
