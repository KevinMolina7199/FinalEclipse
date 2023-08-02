package ups.edu.ec.ProyectoFinal.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

//@Entity
public class DetalleFactura implements Serializable {
	/*
	@Id
	@Column(name = "det_numero_detalle")
	private int numero_detalle;

	@Column(name = "det_adicional")
	private String adicional;

	@Column(name = "det_valorHora")
	private double valorHora;

	@ManyToOne
    @JoinColumn(name = "tic_numero")
    private Ticket ticket;

	public int getNumero_detalle() {
		return numero_detalle;
	}

	public void setNumero_detalle(int numero_detalle) {
		this.numero_detalle = numero_detalle;
	}

	public String getAdicional() {
		return adicional;
	}

	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "DetalleFactura [numero_detalle=" + numero_detalle + ", adicional=" + adicional + ", valorHora="
				+ valorHora + ", ticket=" + ticket + "]";
	}

	*/
	
}
