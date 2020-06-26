package cl.microshin.micro.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
// import lombok.Data; 
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "User") //Crea una base de datos con este nombre, usualmente se separara con un _.
//Data crea automaticamente los Getter y Setter de la clase, mientras que AllArgsConstructor crea el constructor.
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id @Column(precision = 1) //Asignamos variable como ID de la clase y a su ves designamos que su valor inicial es el 1.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Estrategia de generacion de valor, en este caso al ser un ID, es clave primaria y auto-incrementable.
    private int ID;
    @Column(length = 25, nullable = false)
    private String Nombre;
    
    @Column(length = 25, nullable = false)
    private String Apellido;
    
    @Column(nullable = false)
    private int Edad;

    @Column(length = 50, nullable = false)
    private String Usuario;
    @Column(length = 8, nullable = false)
    private String Contraseña;
    //Recordar que todo lo asignado acá sera insertado en una base de datos designada en las propiedades del proyecto.
    
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    

}