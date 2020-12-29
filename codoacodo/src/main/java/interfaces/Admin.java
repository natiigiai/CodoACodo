package interfaces;

import enums.Charges;

public interface Admin {
    /* Todos los métodos que definamos en una interface van a ser public abstract.
       Definimos una interface para Admin porque va a haber usuarios que pueden llegar
       a tener el rol de administrador, en el paquete models está la Clase Admin que extiende
       de la Clase User y que después va a implementar está interface 
    */
    void bannearUser(int id, Charges problem); // pasamos como parámetro el enum donde están los tipos de infracciones
    void permaBan(int id);
    void createUser(String name, String surname, String email, String password); // un método para que un admin pueda crear un usuario
}
