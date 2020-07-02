package cl.microshin.micro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import cl.microshin.micro.model.User;
import cl.microshin.micro.repo.IRepoUser;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private IRepoUser Repo;

    /* Metodos api:
        GET: Resive datos.
        POST: Almacena nuevos datos.
        PUT: Actualiza datos existentes.
        DELETE: Elimina datos existentes.


        Codigo Respuesta:
        200 OK: Respuesta estandar de peticiones correctas.
        201 Created: Se ha creado un recurso.
        204 No content: Peticion con exito que no devuelve contenido en la respuesta.
        400 Bad Request: Solicitud con sintaxis erronea.
        401 Unauthorized: La autenticacion ha fallado.
        403 Forbidden: Solicitud legal, pero no tiene privilegios.
        
    */


    //Resive datos de un JSON RAW y los agrega a las columnas de la tabla de base de datos creada.
    @PostMapping("/IngresoU")
    public void IngresoUsuario(@RequestBody User Usuario){
        Repo.save(Usuario);
    }

    //Regresa los datos encontrados en la interface, es requerido devolver como una lista.
    @GetMapping("/ObtenerDA")
    public List<User> ObtenerDA(){
        return Repo.findAll();
    }

    //Obtener datos por ID, es requerido buscar como una lista.
    @GetMapping(value = "/ObtenerDA/{ID}")
    public List<User> ObtenerDAID(@PathVariable(name = "ID") List<Integer> ID) {
        return Repo.findAllById(ID);
    }
    //Elimina un dato en la base de datos tomando el ID del usuario.
    @DeleteMapping(value = "/EliminarDA/{ID}")
    public void EliminarDA(@PathVariable(name = "ID") Integer ID){
        Repo.deleteById(ID);
    }

    //Actualiza un dato existente en la base de datos desde un JSON RAW que contiene todas las columnas.
    @PutMapping("/ActualizarDA")
    public void ActualizarDA(@RequestBody User Usuario ){
        Repo.save(Usuario);
    }
}