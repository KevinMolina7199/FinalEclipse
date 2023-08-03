package ups.edu.ec.ProyectoFinal.modelo;

import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Factura {

    @Id
    @GeneratedValue
    @Column(name = "fac_codigo")
    private int numero;

    @Column(name = "fac_fecha")
    private LocalTime fecha;
    
    @Column(name = "fac_total")
    private double total;

    @OneToOne
    @JoinColumn(name = "cli_cedula")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name = "tic_numero")
    private Ticket ticket;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalTime fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", total=" + total + ", cliente=" + cliente
				+ ", ticket=" + ticket + "]";
	}


    
    
}
