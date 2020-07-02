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
@Table(name = "Categoria_Automovil")
@AllArgsConstructor @Data
public class CategoryA {
    @Id @Column(precision = 1,name = "Id_Categoria")
    @GeneratedValue(strategy = GenerationType.AUTO)
	int ID;
    @Column(length = 15, nullable = false)
	String Tipo;
    @Column(nullable = true)
	boolean Usado;
}