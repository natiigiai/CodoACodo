package connect_jdbc;

import enums.Tables;
import java.sql.*;
import java.util.*;
import models.User;

public class TableUsers {

    // Conexión
    private Connection mysql; // variable mysql de tipo Connection 
    private final Tables table = Tables.USUARIOS; /* traemos a la tabla Usuarios
    que esta guardada en un enum en el paquete enums -> Tables.java */
    
    // Campos
    private final String cID = "id_usuario";
    private final String cName = "name";
    private final String cSurname = "surname";
    private final String cEmail = "email";
    private final String cPassword = "password";
    private final String cRol = "rol";
    
    // Consultas
    private final String createuser = "INSERT INTO " + table + "(name, surname, email, password) VALUES (?, ?, ?, ?)";
    private final String login = "SELECT * FROM " + table +" where " + cEmail + "= ? and "+ cPassword +" = ?";

    public TableUsers() { // constructor donde vamos a hacer la conexión la base de datos
        mysql = new Mysql().getConnection(); /* obtenemos la conexión y la guardamos 
        en la variable mysql */
    }

    // Método para crear un usuario
    public Map<String, Object> createUser(String name, String surname, String email, String password) throws SQLException { 
        Map<String, Object> result = new LinkedHashMap<>();
        PreparedStatement query = mysql.prepareStatement(createuser); /* creamos el
        PreparedStatement(para consultas con parámetros) y pasamos la consulta */
        
        /* ahora para configurar parámetros usamos el set más el tipo de dato que es String 
        el primer parámetro para el índice y el otro para los datos que vamos a pedir
        para crear un usuario */
        query.setString(1, name);
        query.setString(2, surname);
        query.setString(3, email);
        query.setString(4, password);
        
        if(query.executeUpdate() == 1){ /* Si se ejecuta la consulta preparada mostramos el 
            mensaje que pasamos, acá cuando ejecutamos la consulta que es de tipo
            Update se nos devuelve un entero, si el entero es 1 es porque la consulta está
            bien y si se devuelve otro número está mal */
            result.put("mensaje", "user create");
        }
        return result; // se crea el usuario y se lo retorna a la base de datos
    }
    
    // Login
    public User getUserLogin(String email, String password) throws SQLException{
        PreparedStatement query = mysql.prepareStatement(login); /* creamos el
        PreparedStatement y pasamos la consulta para el login */
        
        /* configuramos los parámetros que necesitamos */
        query.setString(1, email);
        query.setString(2, password);
        
        User usuario = null; /* creamos un Usuario y lo igualamos a null por si 
        algo falla en el medio */
        
        ResultSet data = query.executeQuery(); /* como estamos haciendo un select para obtener
        información recibimos un ResultSet ahí guardamos y ejecutamos la consulta */
        
        
        while(data.next()){ // leemos los datos con data.next()
            usuario = new User(data.getInt(cID), data.getString(cName), data.getString(cSurname), data.getString(cEmail), data.getString(cPassword), data.getString(cRol));
        /* Toda la información que llega la usamos para crear un objeto de tipo User
            (package models Clase User) */
        }
        return usuario; /* una vez que lo creamos, lo retornamos. Si no llega nada el usuario 
        se va a retornar como null y si no, si encontró al usuario en la base de datos
        lo retorna.
        */
    }
}
