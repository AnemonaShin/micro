package cl.microshin.micro.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import cl.microshin.micro.model.User;
import cl.microshin.micro.repo.IRepoUser;

@RestController
public class UserRestController {

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
        404 No existe: La solicitud se derivo a algo no existente.
        
    */


    //Resive datos de un JSON RAW y los agrega a las columnas de la tabla de base de datos creada.
    //Desde acá podemos tomar algunos requerimientos y adaptarlos.
    @PostMapping("/IngresoU")
    public String IngresoUsuario(@RequestBody User Usuario){
        String Message = "";  
        if (Usuario.getEdad()<18){
            Message = "No se permite el ingreso a menores de edad";
        } else if (Usuario.getEdad() >= 18){
            //Requerimiento de Nombre de usuario.
            String UN = Usuario.getNombre(); //Toma el nombre
            char UN1 = UN.charAt(0); //Le saca una letra, en este caso la primera.
            String UA = Usuario.getApellido(); //Toma el apellido.
            char[] UA6 = UA.toCharArray(); //Le saca todas las letras y las divide en un arreglo.
            String UAN = "";
            for (int L = 0; L <= UA.length()-1;L++){
                if(UAN.length() < 6){ //Comprueba si la variable es menor que 6.
                    UAN = UAN.concat(Character.toString(UA6[L])); //Ingresa a la variable concatenando una letra del arreglo.
                }
            }
            String UFinal = UN1+UAN; //Ingresa el valor de las 2 variables en una.
            // ---- Busqueda de usuario repetido --- 
            String Mess = "";
            User Data;
            List<User> User = Repo.findAll();
            for (int U = 0; U <= User.size(); U++){
                Data = User.get(U);
                Mess = Mess.concat(Data.getApellido()); 
            }
            //---------------------------------------
            Usuario.setUsuario(UFinal.toUpperCase()); //Ingresa al usuario la variable final en minusculas.
            Usuario.setContraseña("12345678"); //Requerimiento de contraseña.
            Repo.save(Usuario);
            Message = "El usuario "+UFinal.toUpperCase()+" se ha ingresado con exito.";
        }
        return Message;
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