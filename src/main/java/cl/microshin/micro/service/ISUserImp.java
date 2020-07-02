package cl.microshin.micro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import cl.microshin.micro.model.User;
import cl.microshin.micro.repo.IRepoUser;

public class ISUserImp implements IServiceUser {

    @Autowired
    private IRepoUser Repo;

    @Override
    public User ActualizarUsuario(User Usuario) {
        return Repo.save(Usuario);
    }

    @Override
    public void EliminarUsuario(@PathVariable(name = "ID") Integer ID) {
        Repo.deleteById(ID);
    }

    @Override
    public User IngresarUsuario(User Usuario) {
        return Repo.save(Usuario);
    }

    @Override
    public List<User> MostrarUsuarios() {
        return Repo.findAll();
    }

    @Override
    public List<User> MostrarUsuariosID(List<Integer> ID) {
        return Repo.findAllById(ID);
    }
        
}