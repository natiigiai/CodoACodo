package controller;

import com.google.gson.Gson;
import connect_jdbc.TableProducts;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListProducts", urlPatterns = {"/allproducts"}) // "allproducts" para el fetch
public class ListProducts extends HttpServlet {

     /*
        processRequest recibe los parámetros: request y response que son del tipo de dato
        HttpServletRequest y HttpServletResponse y después van esas dos excepciones 
        porque son errores que puede tomar la ejecución de este método
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8"); /* llamamos al objeto 
        response que es lo que llega como parámetro y como queremos devolver un formato 
        JSON hay que agregamos application/json y con eso decimos que vamos a generar 
        la respuesta json */
        
        Gson gson = new Gson(); // creamos el objeto de la librería Gson
        
        /* 
        hay q generar un objeto de la tabla Productos(tableProducts.java en la carpeta connect_jdbc)
        que es el objeto que vamos a utilizar para hacer las consultas y el que se hace la conexión 
        */
        TableProducts consultasProducts = new TableProducts();
        
        
        Map<String, Object> resultJson = new LinkedHashMap<>(); /* Definimos un mapa para generar 
        la respuesta Json al final */

        try {
            resultJson.put("products", consultasProducts.allProducts()); /* traemos todos 
            los productos (método allProducts es donde están definimos ( en la clase TableProducts
            en el paquete connect_jdbc) */
        } catch (SQLException e) { // si hay un error lo capturamos
            e.printStackTrace();
        }

        String json = gson.toJson(resultJson); /* creamos una variable (json) donde vamos 
        a llamar al objeto gson de la libería y al método toJson para transformar 
        lo que tenemos en el Map en formato JSON, el map lo pasamos como parámetro (resultJson) */
        
        PrintWriter out = response.getWriter(); /* ahora generamos la respuesta, 
       el método.getWriter nos da un objeto de PrintWriter que va a escribir la 
       respuesta que vamos a dar al momento de realizar una petición en javascript */
       
        out.println(json);  // acá damos la respuesta del objeto que creamos
    }
    
    /*
    const div = document.querySelector("#mostrarProductos");
        fetch(`${allproducts`)
            .then((respuesta) => respuesta.json())
            .then((data) => 
		data.forEach((product) => {
	            div.innerHTML += 
			`
		         <div>
			    <p>${product.name}</p>
		            <p> ${product.price} </p>
                            <p> ${product.description} </p>
			  </div>
			`;
		})
	);
    */

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
