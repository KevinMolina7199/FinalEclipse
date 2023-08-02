package ups.edu.ec.ProyectoFinal.negocio;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoFinal.datos.ClienteDAO;
import ups.edu.ec.ProyectoFinal.modelo.Cliente;

@Stateless
public class GestionClientes {

	@Inject
	private ClienteDAO daoCliente;
	
	public void guardarClientes(Cliente cliente) throws Exception {
		if(!this.isCedulaValida(cliente.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		if(daoCliente.read(cliente.getCedula()) == null) {
			try {
				daoCliente.insert(cliente);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoCliente.update(cliente);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	private boolean isCedulaValida(String cedula) {
		return cedula.length() == 10;
	}
	
	public void eliminarCliente(Cliente cliente) throws Exception {

	    try {
	    	daoCliente.deleteCliente(cliente);
	    } catch (Exception e) {
	        throw new Exception("Error al eliminar: " + e.getMessage());
	    }
	}

	public void actualizarCliente(Cliente cliente) throws Exception {
	    try {
	    	daoCliente.update(cliente); 
	    } catch (Exception e) {
	        throw new Exception("Error al actualizar: " + e.getMessage());
	    }
	}
	
	public List<Cliente> listarClientes(){
		return daoCliente.getAll();
	}
	
}
