package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    //Variable que va a contener el estado de la conexión

    static Connection objConnection = null;

    //Método para abrir la conexión entre Java y la base de datos

    public static Connection openConnection() {
        try {
            //Class forname permite  obtener o implementar driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos variables con nuestras credenciales
            String url = "jdbc:mysql://localhost:3306/_01_jdbc";
            String user = "root";
            String password = "Kloe040716*";

            //Establecemos la conexión
            objConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión fallida exitosamente");

        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver no instalado");

        } catch (SQLException e) {
            System.out.println("Error >> No se pudo establecer una conexión con la DB");
        }
        return objConnection;
    }

    public static void closeConnection (){
        try {
            //Si hay una conexión activa, la cerramos
            if (objConnection != null) objConnection.close();

        }catch (SQLException e){
            System.out.println("Error" + e.getMessage());
        }
    }
}
