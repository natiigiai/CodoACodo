package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 /* en urlPatterns va lo que vamos a usar para el fetch ahí es donde le ponemos el nombre 
       a la api: en este caso el nombre es CleanDemo */
@WebServlet("/CleanDemo") // @WebServlet es donde está definido el Servlet 

public class CleanDemo extends HttpServlet { // CleanDemo es una Clase q extiende de HttpServlet
   
    private Gson gson = new Gson();
 
    /* Los métodos que vienen definidos en el template son métodos definidos en 
       la Clase abstracta.
       doGet y doPost son para procesar peticiones. Si hacemos un GET se ejecuta
       el método doGet y si hacemos un POST para crear datos necesitamos el método doPost.
    */
    
    // la anotación @Override xq estamos sobrescribiendo el método ya definido en la Clase Abstracta
    @Override
    
    /*
        doGet que recibe los parámetros: request y response que son del tipo de dato
        HttpServletRequest y HttpServletResponse y después van esas dos excepciones 
        porque son errores que puede tomar la ejecución de este método
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("application/json"); /* llamamos al objeto response que es lo que 
       llega como parámetro y como queremos devolver un formato JSON hay que agregar 
       application/json y con eso decimos que vamos a generar la respuesta json */
       
       /* Gson gson = new Gson(); acá creamos un objeto de la librería Gson, se puede hacer acá 
          o fuera del método. Esto esta comentado porque lo defini fuera del método
       */
       
       Map<String, Object> item = new HashMap<>(); /* Definimos un mapa para almacenar pares 
       clave/valor y lo identificamos con un nombre. String porque es el tipo de dato que 
       define a la clave y Object porque no sabemos que valor va a tomar, puede ser un int, 
       boolean, etc */
       
       item.put("name", "aylen"); // agregamos una clave y un valor
       
       String json = gson.toJson(item); /* creamos una variable (json) donde vamos a llamar al 
       objeto gson de la libería y al método toJson para transformar lo que tenemos en el Map 
       en formato JSON, el map lo pasamos como parámetro (item) */
       
       PrintWriter out = response.getWriter(); /* ahora generamos la respuesta, 
       el método.getWriter nos da un objeto de PrintWriter que va a escribir la 
       respuesta que vamos a dar al momento de realizar una petición en javascript */
       
       out.println(json); // acá damos la respuesta del objeto que creamos
       
       
       /* Ahora si en javascript hacemos un fetch al servlet se van a mostrar 
          los datos que agregamos 
       
                fetch("CleanDemo")
                    .then((response) => response.json())
                    .then((json) => console.log(json));
       */
    }
}
