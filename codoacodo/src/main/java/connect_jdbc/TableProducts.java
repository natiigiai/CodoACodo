package connect_jdbc;

import enums.Tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.Statement;

public class TableProducts {

    // Conexión
    private Connection mysql; // variable mysql de tipo Connection 
    private final Tables table = Tables.PRODUCTOS;
    /* traemos a la tabla Productos
    que esta guardada en un enum en el paquete enums -> Tables.java */

    // Campos
    private final String cID = "id_producto";
    private final String cName = "name";
    private final String cPrice = "price";
    private final String cQuality = "quality";
    private final String cDescription = "description";

    // Consultas preparadas
    private final String productbyid = "SELECT * FROM " + table + " WHERE id_producto = ?";
    private final String commentsbyproduct = "SELECT id_usuario, comment, c.quality FROM productos AS p INNER JOIN "
            + "comentarios AS c ON c.id_producto = p.id_producto WHERE p.id_producto = ?;";
    private final String products = "SELECT * FROM " + table;


    public TableProducts() { // constructor donde vamos a hacer la conexión la base de datos

        mysql = new Mysql().getConnection();
        /* obtenemos la conexión y la guardamos 
        en la variable mysql */
    }

    // Todos los datos de un producto 
    public List<Map<String, Object>> allProducts() throws SQLException {

        List<Map<String, Object>> products = new ArrayList<>();
        /* Un ArrayList es una colección
        donde podemos guardar datos de forma parecida a los Arrays pero en este caso no 
        va a ser necesario declarar el tamaño que va a tener y como nosotros no sabemos cuantos 
        productos va a tener nuestra tabla no podemos crear un Array común. Acá hay un mapa anidado en una lista.
         */

        Statement query = mysql.createStatement();
        /* Creamos la hoja virtual o el objeto de 
        tipo Statement. En "query" es donde vamos a estar ingresando las consultas que necesitamos.
        Es simplemente guardarlo dentro de un objeto Statement y llamar al método que está 
        dentro de mysql, y guardar ese método dentro de la variable que creamos. */

        ResultSet data = query.executeQuery(this.products);
        /*
        Como la consulta que vamos a ejecutar es un SELECT tenemos un ResultSet. El ResultSet 
        es una tabla virtual con los datos de la consulta que los vamos a ir recorriendo fila 
        por fila. Le ponemos un nombre al ResultSet y ejecutamos la consulta que pasamos que está
        definida más arriba. */

        while (data.next()) {
            /* Mostramos los datos con un while, el método next 
            se va moviendo a la siguiente fila y pregunta si hay información válida
            para mostrar */
            Map<String, Object> product = new LinkedHashMap<>(); // creamos un mapa que va a contener estos valores

            product.put(cID, data.getInt(cID));
            product.put(cName, data.getString(cName));
            product.put(cPrice, data.getString(cPrice));
            product.put(cQuality, data.getString(cQuality));
            product.put(cDescription, data.getString(cDescription));
            products.add(product);
        }
        return products;
    }

    // Obtener los productos por su id
    public Map<String, Object> productById(int id) throws SQLException {
        PreparedStatement query = mysql.prepareStatement(productbyid);
        query.setInt(1, id);
        ResultSet data = query.executeQuery();
        Map<String, Object> resultJson = new LinkedHashMap<>();
        while (data.next()) {
            resultJson.put(cID, data.getInt(cID));
            resultJson.put(cName, data.getString(cName));
            resultJson.put(cPrice, data.getString(cPrice));
            resultJson.put(cQuality, data.getString(cQuality));
            resultJson.put(cDescription, data.getString(cDescription));
        }
        return resultJson;
    }

    // Para obtener los comentarios por id del producto
    public List<Map<String, Object>> commentsByProduct(int id) throws SQLException {
        PreparedStatement query = mysql.prepareStatement(commentsbyproduct);
        query.setInt(1, id);
        ResultSet data = query.executeQuery();
        Map<String, Object> resultJson = new LinkedHashMap<>();
        List<Map<String, Object>> comments = new ArrayList<>();
        while (data.next()) {
            Map<String, Object> json = new LinkedHashMap<>();
            json.put("id_usuario", data.getInt("id_usuario"));
            json.put("comment", data.getString("comment"));
            json.put("quality", data.getString("quality"));
            comments.add(json);
        }
        resultJson.put("comments", comments);
        return comments;
    }

}
