package connect_jdbc;

import enums.Tables;
import java.sql.*;

public class Mysql {

    /* Conexión a MySQL -> reemplazar porel nombre de su base de datos, 
       su nombre de usuario y contraseña. En Workbench ejecutan USE más el nombre
       de la base de datos. Si salta error por zona horaria ejecutan en MySQL: 
            SET GLOBAL time_zone = '-3:00';
     */
    private Connection connection = null; // variable de tipo Connection
    private final String url = "jdbc:mysql://localhost:3306/db_cac";
    private final String user = "root";
    private final String password = "";

    public Mysql() {
        
        /*
            acá cargamos la Clase que se registra como driver JDBC, llamamos a
            DriverManager.getConnection() q devuelve una referencia a Connection
            */
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            /* Class.forName registra el driver de conexión para la base de datos. Entonces 
               hay que registrarlo para poder conectarnos en este caso a mysql */   
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }
        
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException error) {
            error.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
