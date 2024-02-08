package MODELO;

public class ValidacionLogin {

    private static final String Admin = "root";
    private static final String Password = "123";
    private int numeroIntentos;

    // Método para verificar las credenciales del usuario
    public boolean verificarCredenciales(String nick, String contrasenia) {
        // Compara el nombre de usuario y la contraseña con los valores correctos
        return Admin.equals(nick) && Password.equals(contrasenia);
    }
    //almaceno los intentos
  public void almacenarIntentos(int vecesIntentadas) {
        this.numeroIntentos = vecesIntentadas;
    }
}
