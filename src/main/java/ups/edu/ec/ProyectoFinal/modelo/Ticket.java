package ups.edu.ec.ProyectoFinal.modelo;

import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {

    @Id
    @GeneratedValue
    @Column(name = "tic_numero")
    private int numero;

    @Column(name = "tic_fecha_ingreso")
    private LocalTime fechaIngreso;
    
    @Column(name = "tic_fecha_salida")
    private LocalTime fechaSalida;

    @Column(name = "tic_estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "veh_placa")
    private Vehiculo vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "tar_id")
    private Tarifa tarifa;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalTime getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalTime fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	@Override
	public String toString() {
		return "Ticket [numero=" + numero + ", fechaIngreso=" + fechaIngreso + ", fechaSalida=" + fechaSalida
				+ ", estado=" + estado + ", vehiculo=" + vehiculo + ", tarifa=" + tarifa + "]";
	}

}
