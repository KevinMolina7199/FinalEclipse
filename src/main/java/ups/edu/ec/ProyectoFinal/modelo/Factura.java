package ups.edu.ec.ProyectoFinal.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Factura {

    @Id
    @Column(name = "fac_codigo")
    private int numero;

    @Column(name = "fac_fecha")
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "cli_cedula")
    private Cliente cliente;
/*
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="fac_codigo")
	private List<DetalleFactura> detalles;
    */
    @OneToOne
    @JoinColumn(name = "tic_numero")
    private Ticket ticket;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
/*
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	*/
	
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
/*
	public void addDetalle(DetalleFactura detalle) {
		if(detalles == null) {
			detalles = new ArrayList<DetalleFactura>();
		}
		detalles.add(detalle);
		
	}
*/

	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha + ", cliente=" + cliente + ", ticket=" + ticket + "]";
	}

    
    
}
