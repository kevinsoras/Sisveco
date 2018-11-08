package pe.edu.upeu.sprintemplate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="idcliente")
private int idcliente;
@Column(name="nombre")
private String nombre;
@Column(name="apellidos")
private String apellidos;
@Column(name="dni")
private int dni;
@Column(name="direccion")
private String direccion;
@Column(name="celular")
private String celular;
@Column(name="estado")
private String estado;

public Cliente() {
	super();
}

public int getIdcliente() {
	return idcliente;
}

public void setIdcliente(int idcliente) {
	this.idcliente = idcliente;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellidos() {
	return apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public int getDni() {
	return dni;
}

public void setDni(int dni) {
	this.dni = dni;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}

public String getCelular() {
	return celular;
}

public void setCelular(String celular) {
	this.celular = celular;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public Cliente(int idcliente, String nombre, String apellidos, int dni, String direccion, String celular,
		String estado) {
	super();
	this.idcliente = idcliente;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.dni = dni;
	this.direccion = direccion;
	this.celular = celular;
	this.estado = estado;
}

}
