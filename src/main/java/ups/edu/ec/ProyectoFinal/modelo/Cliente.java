package ups.edu.ec.ProyectoFinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@Column(name="cli_cedula")
	private String cedula;
	
	@Column(name="cli_nombre")
	private String nombre;
	
	@Column(name="cli_apellido")
	private String apellido;
	
	@Column(name="cli_direccion")
	private String direccion;
	
	@Column(name="cli_telefono")
	private String telefono;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + ", telefono=" + telefono + "]";
	}

	
	
}
