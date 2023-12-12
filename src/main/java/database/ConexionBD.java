package database;

import java.lang.module.InvalidModuleDescriptorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    //definimos como constantes los datos de la conexión a la base de datos
    private static final String URL = "jdbc:mariadb://localhost:3909"; //conector y localización
    private static final String USUARIO = "root";
    private static final String CLAVE = "admin";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection((URL+"/constructora"), USUARIO, CLAVE);
            System.out.println("Conexión OK BD.");
        }catch (SQLException e) {
            System.out.println("Error en la conexión BD");
            e.getMessage();
        } catch (InvalidModuleDescriptorException e) {
            System.out.println("Error PAM BD");
        }
        return conexion;
    }
}
