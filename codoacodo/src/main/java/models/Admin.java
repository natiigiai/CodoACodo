package models;

public class Admin extends User{
    
    // la clase Admin herada los atributos de la clase User
    public Admin(int id, String name, String surname, String email, String password, String rol) {
        super(id, name, surname, email, password, rol);
    }
    
}
