package models;

import enums.RolUser;
import java.util.LinkedHashMap;
import java.util.Map;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String rol; 

    public User(int id, String name, String surname, String email, String password, String rol) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    
    public Map<String, Object> getUserData(){
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("id_usuario", id);
        result.put("name", name);
        result.put("surname", surname);
        result.put("email", email);
        result.put("rol", rol);
        return result;
    }
    
    public String getFullName(){
        return name + " " + surname;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getRol(){
        return rol;
    }
    
}
