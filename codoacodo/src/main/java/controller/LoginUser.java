package controller;

import com.google.gson.Gson;
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
import javax.servlet.http.HttpSession;
import models.User;

@WebServlet(name = "LoginUser", urlPatterns = {"/login"})
public class LoginUser extends HttpServlet {

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
        
        response.setContentType("apllication/json;charset=UTF-8"); /* seteamos la configuración, 
        indicamos que vamos a generar una respuesta en formato JSON */
       
        /*
        en el formulario del login solo pedimos el email y la contraseña entonces hay que obtener
        esos parámetros que nos llegan desde el formulario y lo hacemos con el método getParameter()
        donde se pasa el contenido que le hayamos dado al atributo name de html
        */
        String email = request.getParameter("email"); 
        String password = request.getParameter("password");

        Gson gson = new Gson();  // creamos una instancia de la librería Gson

        /* 
        hay que generar un objeto de la tabla Usuarios(tableUsers.java en la carpeta connect_jdbc)
        que es el objeto que vamos a utilizar para hacer las consultas
        */
        TableUsers consultasUsuarios = new TableUsers();
        
        Map<String, Object> resultJson = new LinkedHashMap<>(); /* Definimos un mapa para generar 
        la respuesta Json al final */
        
        User usuario = null;

        try {
            usuario = consultasUsuarios.getUserLogin(email, password); /* Primero llega el 
            usuario y hay que usar el objeto que creamos para hacer las consultas 
            y el método getUserLogin() que está definido en la Clase TableUsers 
            donde está la conexión a la tabla usuarios */

            if (usuario != null) {
                /* sí el usuario es distinto de null en el resultJson que es el Mapa usamos 
                  la Clase User (que está en el paquete Models -> User.java) */
                  
                resultJson = usuario.getUserData(); /* usamos el método getUserData() que 
                devuelve un mapa con toda la información que necesitamos. Todo eso está 
                definido en la clase User */
            }
        } catch (SQLException error) {
            /*
                si hay un error pasamos al catch y mandamos un error con el método sendError
                que recibe el código del error y para podes mostrarlo usamos el método toString
            */
            response.sendError(404, error.toString());
        }

        if (usuario == null) {
            /*
               si el usuario es nulo enviamos un mensaje de que no existe
            */
            response.sendError(404, "No existe");
        }

        /*
            solo falta definir la sesión que le va a pertener al usuario
        */
        
        HttpSession session = request.getSession(); // guardamos la sesión 

        session.setMaxInactiveInterval(60); /* acá definimos un intervalo de tiempo en 
        segundos para la inactividad del usuario en la sesión */

        String json = gson.toJson(resultJson); /* creamos una variable (json) donde vamos a 
        llamar al objeto gson de la libería y al método toJson para transformar el 
        resultJson en formato JSON. Eso está definido más arriba y ahí está la información 
        del usuario definida en la Clase User */

        session.setAttribute("User", usuario); /* acá  definimos un atributo en la sesión 
        que es cuando el usuario va a estar usando la sesión y va a tener datos que lo 
        definen y que se guardan en esa misma sesión */

        PrintWriter out = response.getWriter(); /* ahora generamos la respuesta, 
        el método.getWriter nos da un objeto de PrintWriter que va a escribir la
        respuesta que vamos a dar al momento de realizar una petición en javascript */
        
        out.println(json); // acá damos la respuesta del objeto que creamos

        response.sendRedirect("index.jsp"); /* mandamos al usuario ya logueado 
        al inicio de la página */
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
