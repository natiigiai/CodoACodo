package controller;

import com.google.gson.Gson;
import connect_jdbc.TableProducts;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ProductWithComments", urlPatterns = {"/CommentsByIdProduct"})
public class ProductWithComments extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /* el método processRequest de la clase HttpServlet recibe como parámetros 
       al objeto request y al objeto response */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=UTF-8"); /* seteamos la configuración, 
        indicamos que vamos a generar una respuesta en formato JSON */
        
        int id_product = Integer.parseInt(request.getParameter("id")); /* obtenemos el parámetro
        que es el id del producto y lo guardamos en la variable id_product, usamos el método parseInt()
        porque las consultas se guardan en String sin importar el tipo de dato que tengan en la base 
        de datos entonces convertimos la cadena de texto en un entero */
        
        Gson gson = new Gson(); // creamos una instancia de la librería Gson
        
        TableProducts consultasProducts = new TableProducts(); /* hay que generar 
        un objeto de la tabla Productos(tableProducts.java en la carpeta connect_jdbc)
        que es el objeto que vamos a utilizar para hacer las consultas */
        
        Map<String, Object> resultJson = new LinkedHashMap<>(); /* Definimos un mapa para 
        generar la respuesta Json al final */

        try {
            resultJson = consultasProducts.productById(id_product);
            /* los productos de un comentario se identifican por su id y eso lo guardamos 
            en la variable id_product después de parsearlo. En resultJson guardamos las 
            consultas que vamos a hacer para los productos que a su vez están 
            identificados por su id */
            resultJson.put("comments", consultasProducts.commentsByProduct(12));
            
        } catch (SQLException e) { // si hay un error lo capturamos y lo mostramos
            e.printStackTrace();
        }

        String json = gson.toJson(resultJson); /* creamos una variable (json) donde vamos a 
        llamar al objeto gson de la libería y al método toJson para transformar el 
        resultJson en formato JSON. Eso está definido más arriba y ahí está la información 
        del usuario definida en la Clase User */
        
        PrintWriter out = response.getWriter(); /* ahora generamos la respuesta, 
        el método.getWriter nos da un objeto de PrintWriter que va a escribir la
        respuesta que vamos a dar al momento de realizar una petición en javascript */
        
        out.println(json); // acá damos la respuesta del objeto que creamos
    }

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
