package ups.edu.ec.ProyectoFinal.servicios;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import ups.edu.ec.ProyectoFinal.modelo.Cliente;
import ups.edu.ec.ProyectoFinal.negocio.GestionClientes;

@Path("clientes")
public class GClientesService {
	
	@Inject
	private GestionClientes gClientes;

	@GET
	@Path("saludo")
	public String saludo() {
		return "Hola mundo";
	}
	
	@GET
	@Path("suma")
	public String suma(@QueryParam("a") int a,
			@QueryParam("b") int b) {
		
		return " R = " + (a + b);
	}
	
	@GET
	@Path("multiplicacion/{a}/{b}")
	public String multiplicacion(@PathParam("a") int a,
			@PathParam("b") int b) {
		
		return " R = " + (a * b);
	}
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Cliente misDatos() {
		Cliente c1 = new Cliente();
		c1.setCedula("0105322291");
		c1.setDireccion("Octavio");
		c1.setNombre("Danny Peralta");
		
		return c1;
	}
	
	@POST	
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarCliente(Cliente cliente) {
		try {
			gClientes.guardarClientes(cliente);
			return Response.status(Response.Status.OK).entity(cliente).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
	
	@GET
	@Path("clienteL")
	@Produces("application/json")
	public List<Cliente> listarClientes() {	
		return gClientes.listarClientes();
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	public Response eliminarCliente(Cliente cliente) {
	    try {
	    	gClientes.eliminarCliente(cliente);
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
	public Response actualizarCliente(Cliente cliente) {
	    try {
	    	gClientes.actualizarCliente(cliente);
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
