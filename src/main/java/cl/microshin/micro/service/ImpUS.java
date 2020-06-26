package cl.microshin.micro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.microshin.micro.model.User;
import cl.microshin.micro.repo.IRepoUser;
import java.util.regex.*;

@Service
public class ImpUS implements IUS {

    /*
     * if (Usuario.getEdad()<18){ Message =
     * "No se permite el ingreso a menores de edad"; } else if (Usuario.getEdad() >=
     * 18){ //Requerimiento de Nombre de usuario. String UN = Usuario.getNombre();
     * //Toma el nombre char UN1 = UN.charAt(0); //Le saca una letra, en este caso
     * la primera. String UA = Usuario.getApellido(); //Toma el apellido. char[] UA6
     * = UA.toCharArray(); //Le saca todas las letras y las divide en un arreglo.
     * String UAN = ""; for (int L = 0; L <= UA.length()-1;L++){ if(UAN.length() <
     * 6){ //Comprueba si la variable es menor que 6. UAN =
     * UAN.concat(Character.toString(UA6[L])); //Ingresa a la variable concatenando
     * una letra del arreglo. } } String UFinal = UN1+UAN; //Ingresa el valor de las
     * 2 variables en una. // ---- Busqueda de usuario repetido --- String Mess =
     * ""; User Data; List<User> User = Repo.findAll(); for (int U = 0; U <=
     * User.size(); U++){ Data = User.get(U); Mess =
     * Mess.concat(Data.getApellido()); } //---------------------------------------
     * Usuario.setUsuario(UFinal.toUpperCase()); //Ingresa al usuario la variable
     * final en minusculas. Usuario.setContraseña("12345678"); //Requerimiento de
     * contraseña. Repo.save(Usuario); Message =
     * "El usuario "+UFinal.toUpperCase()+" se ha ingresado con exito."; }
     */

    @Autowired
    private IRepoUser Repo;

    @Override
    public String NCV(User Usuario) {
        String Message = "";
        // ----- Verificacion de edad -----
        if (Usuario.getEdad() < 18) {
            Message = "No se permite el ingreso a menores de edad.";
        } else if (Usuario.getEdad() >= 18) {
            // ---- Generacion de nick name.
            char NFW = (Usuario.getNombre()).charAt(0);
            char[] LNSWS = (Usuario.getApellido()).toCharArray();
            String Nick = Character.toString(NFW);

            for (int W = 0; W <= (Usuario.getApellido()).length() - 1; W++) {
                if (Nick.length() < 6) {
                    Nick = Nick.concat(Character.toString(LNSWS[W]));
                }
            }
            Usuario.setUsuario(Nick.toUpperCase());
            // De momento requerimiento de contraseña.
            Usuario.setContraseña("12345678");
            Repo.save(Usuario);
            Message = "Usuario " + Nick.toUpperCase() + " ingresado con exito.";
        }
        return Message; // Mostrar mediante metodo POST nick.
    }

    @Override
    public String PMR(User Usuario) {
        String Message = "";
        if (Usuario.getEdad() < 18){
            Message = "No se puede actualizar usuario.";
        } else if(Usuario.getEdad() >= 18) {
            if ((Usuario.getContraseña()).length() < 8 || (Usuario.getContraseña()).length() == 7){
                if (Pattern.matches("^[a-zA-Z]*$", Usuario.getContraseña())){
                    Repo.save(Usuario);
                    Message = "Actualizacion correcta.";
                } else {
                    Message = "No se puede actualizar usuario.";        
                }
            } else if((Usuario.getContraseña()).length() > 8){
                Message = "No se puede actualizar usuario.";
            }
        }
        return Message;
    }
}