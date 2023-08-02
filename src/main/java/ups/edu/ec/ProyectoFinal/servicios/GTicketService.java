package ups.edu.ec.ProyectoFinal.servicios;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.ProyectoFinal.modelo.Ticket;

import ups.edu.ec.ProyectoFinal.negocio.GestionTicket;


@Path("tickets")
public class GTicketService {
	
	@Inject
	private GestionTicket gVehiculo;

	@GET
	@Path("saludo")
	public String saludo() {
		return "Hola mundo";
	}

	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Ticket misDatos() {
		Ticket bi1 = new Ticket();
		return bi1;
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarVehiculo(Ticket vehiculo) {
		try {
			gVehiculo.guardarTarifas(vehiculo);
			return Response.status(Response.Status.OK).entity(vehiculo).build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}

	@GET
	@Path("ticketsListar")
	@Produces("application/json")
	public List<Ticket> listarClientes() {
		return gVehiculo.listarVehiculos();
	}

	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public Response eliminarCliente(Ticket vehiculo) {
		try {
			gVehiculo.eliminarCliente(vehiculo);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al eliminar: " + e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}

	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response actualizarCliente(Ticket vehiculo) {
		try {
			gVehiculo.actualizarCliente(vehiculo);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al actualizar: " + e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error).build();
		}
	}
}
