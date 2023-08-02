package ups.edu.ec.ProyectoFinal.negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoFinal.datos.TicketDAO;
import ups.edu.ec.ProyectoFinal.modelo.Ticket;

@Stateless
public class GestionTicket {
	@Inject
	private TicketDAO daoTicket;
	
	public void guardarTarifas(Ticket vehiculo) throws Exception {
		
		if(daoTicket.read(vehiculo.getNumero()) == null) {
			try {
				daoTicket.insert(vehiculo);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoTicket.update(vehiculo);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	public void eliminarCliente(Ticket vehiculo) throws Exception {

	    try {
	    	daoTicket.deleteTicket(vehiculo);
	    } catch (Exception e) {
	        throw new Exception("Error al eliminar: " + e.getMessage());
	    }
	}

	public void actualizarCliente(Ticket vehiculo) throws Exception {
	    try {
	    	daoTicket.update(vehiculo); 
	    } catch (Exception e) {
	        throw new Exception("Error al actualizar: " + e.getMessage());
	    }
	}
	
	public List<Ticket> listarVehiculos(){
		return daoTicket.getAll();
	}
}
