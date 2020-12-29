package controller;

import com.google.gson.Gson;
import connect_jdbc.TableProducts;
import connect_jdbc.TableUsers;
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


@WebServlet(name = "RegistreUser", urlPatterns = {"/signin"})
public class RegistreUser extends HttpServlet {

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
       al objeto request y al objeto response y después van esas dos excepciones 
        porque son errores que puede tomar la ejecución de este método */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("application/json;charset=UTF-8"); /* seteamos la configuración, 
        indicamos que vamos a generar una respuesta en formato JSON */
        
        
        /*
            Igual que en el login tenemos que obtener los parámetros que nos van 
            a llegar a través del formulario, ponemos los valores que pasamos al
            atributo name, todo eso se hace con el método getParameter() del objeto
            request. Todos esos datos los guardamos en variables.
        */
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        
        Gson gson = new Gson(); // creamos una instancia de la librería Gson
        
        TableUsers consultasUsuarios = new TableUsers();  /* igual que en el login 
        hay que generar un objeto de la tabla Usuarios(tableUsers.java en la 
        carpeta connect_jdbc) que es el objeto que vamos a utilizar para hacer 
        las consultas */
        
        Map<String, Object> resultJson = new LinkedHashMap<>(); /* Definimos un mapa para generar 
        la respuesta Json al final */

        try {
           resultJson = consultasUsuarios.createUser(name, surname, email, password);
            /* En la Clase TableUsers (paquete connect_jdbc) tenemos el método 
            createUser con toda la consulta preparada para insertar los datos del nuevo
            usuario. Entonces a consultasUsuarios que es nombre que le pusimos al objeto
            que generamos más arriba le pasamos el método createUser con los
            parámetros que recibe para la creación del usuario y todo eso lo 
            guardamos en resultJson que es mapa que definimos */
           
        } catch (SQLException e) { 
            /* si hay si hay un error pasamos al catch y 
            mandamos un error con el método sendError que recibe el código del error 
            y para poder mostrarlo usamos el método toString */
            response.sendError(409,e.toString());
        }
        
        String json = gson.toJson(resultJson);  /* creamos una variable (json) donde vamos a 
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
        //processRequest(request, response);
        response.sendError(404, "To create a user you have to use the post method");
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
