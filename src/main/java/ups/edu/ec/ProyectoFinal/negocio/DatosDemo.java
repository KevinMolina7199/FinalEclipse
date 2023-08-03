package ups.edu.ec.ProyectoFinal.negocio;

import java.time.LocalTime;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoFinal.datos.ClienteDAO;
import ups.edu.ec.ProyectoFinal.datos.FacturaDAO;
import ups.edu.ec.ProyectoFinal.datos.TarifaDAO;
import ups.edu.ec.ProyectoFinal.datos.TicketDAO;
import ups.edu.ec.ProyectoFinal.datos.VehiculoDAO;
import ups.edu.ec.ProyectoFinal.modelo.Cliente;
import ups.edu.ec.ProyectoFinal.modelo.Factura;
import ups.edu.ec.ProyectoFinal.modelo.Tarifa;
import ups.edu.ec.ProyectoFinal.modelo.Ticket;
import ups.edu.ec.ProyectoFinal.modelo.Vehiculo;

@Singleton
@Startup
public class DatosDemo {

	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private VehiculoDAO daoVehiculo;
	
	@Inject
	private TicketDAO daoTicket;
	
	@Inject
	private FacturaDAO daoFactura;
	
	@Inject
	private TarifaDAO daoTarifa;
	
	/*
	@Inject
	private DetalleFacturaDAO daoDetalleFactura;
	*/
	
	@PostConstruct
	public void init() {
		
		Cliente c1 = new Cliente();
		c1.setCedula("0105322291");
		c1.setNombre("Danny");
		c1.setApellido("Peralta");
		c1.setDireccion("Octavio");
		c1.setTelefono("0998446050");
		daoCliente.insert(c1);
		
		Cliente c2 = new Cliente();
		c2.setCedula("0103709911");
		c2.setNombre("Juan");
		c2.setApellido("Sanchez");
		c2.setDireccion("Monay");
		c2.setTelefono("0998446050");
		daoCliente.insert(c2);
		
		Vehiculo v1 = new Vehiculo();
		v1.setPlaca("AFT0976");
		v1.setMarca("Chevrolet");
		v1.setModelo("Corsa Evo");
		v1.setColor("Plateado");
		daoVehiculo.insert(v1);
		
		Tarifa ta1 = new Tarifa();
		//ta1.setId(1);
		ta1.setMonto(1.5);
		ta1.setTipo("Normal");
		daoTarifa.insert(ta1);
		
		Ticket t1 = new Ticket();
		//t1.setNumero(1);
		t1.setFechaIngreso(LocalTime.now());
		t1.setFechaSalida(LocalTime.of(14, 30));
		t1.setEstado("Activo");
		t1.setVehiculo(v1);
		t1.setTarifa(ta1);
		daoTicket.insert(t1);
		
		Factura f = new Factura();
		//f.setNumero(0);
		f.setFecha(LocalTime.now());
		f.setTotal(1);
		f.setCliente(c1);
		f.setTicket(t1);
		daoFactura.insert(f);
		
		List<Cliente> clientes = daoCliente.getAll();
		for(Cliente cli: clientes) {
			System.out.println(cli);
		}
		
		List<Vehiculo> vehiculos = daoVehiculo.getAll();
		for(Vehiculo veh: vehiculos) {
			System.out.println(veh);
		}
		
		List<Tarifa> tarifas = daoTarifa.getAll();
		for(Tarifa tar: tarifas) {
			System.out.println(tar);
		}
		
		List<Ticket> tickets = daoTicket.getAll();
		for(Ticket tic: tickets) {
			System.out.println(tic);
		}
		
		/*
		List<DetalleFactura> detsFactura = daoDetalleFactura.getAll();
		for(DetalleFactura dfacs: detsFactura) {
			System.out.println(dfacs);
		}
		*/
		
		List<Factura> facturas = daoFactura.getAll();
		for(Factura fac: facturas) {
			System.out.println("Num Factura" + ": " + fac.getNumero() + "- " + fac.getCliente().getNombre() + 
					" total Vehiculos: " + fac.getTicket());
		}
		
	}
}
