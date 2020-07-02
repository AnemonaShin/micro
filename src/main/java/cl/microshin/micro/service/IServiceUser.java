package cl.microshin.micro.service;

import cl.microshin.micro.model.User;
import java.util.List;

public interface IServiceUser {
    
    public List<User> MostrarUsuarios();
    public List<User> MostrarUsuariosID(List<Integer> ID);
    public void EliminarUsuario(Integer ID); 
    public User IngresarUsuario(User Usuario);
    public User ActualizarUsuario(User Usuario);

}