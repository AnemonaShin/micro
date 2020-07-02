package cl.microshin.micro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Automovil")
@AllArgsConstructor @Data 
public class Auto{
    @Id @Column(name = "Id_Auto",precision = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    int ID_A;
    @Column(length = 25,nullable = false)
    String Marca;
    @Column(length = 25,nullable = false)
    String Modelo;
    @Column(nullable = false)
    int Año;
    @Column(length = 250,nullable = false)
    String Descripcion;
    @Column(nullable = false)
    int IDC;
}