package ups.edu.ec.ProyectoFinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Tarifa {

	@Id
	@Column(name="tar_id")
	private int id;
	
	@Column(name="tar_tipo")
	private String tipo;
	
	@Column(name="tar_monto")
	private double monto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Tarifa [id=" + id + ", tipo=" + tipo + ", monto=" + monto + "]";
	}
	
	
    

}
