package ups.edu.ec.ProyectoFinal.negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoFinal.datos.VehiculoDAO;
import ups.edu.ec.ProyectoFinal.modelo.Vehiculo;

@Stateless
public class GestionVehiculos {
	@Inject
	private VehiculoDAO daoVehiculo;
	
	public void guardarVehiculos(Vehiculo vehiculo) throws Exception {
		
		if(daoVehiculo.read(vehiculo.getPlaca()) == null) {
			try {
				daoVehiculo.insert(vehiculo);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoVehiculo.update(vehiculo);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	public void eliminarCliente(Vehiculo vehiculo) throws Exception {

	    try {
	    	daoVehiculo.deleteVehiculo(vehiculo);
	    } catch (Exception e) {
	        throw new Exception("Error al eliminar: " + e.getMessage());
	    }
	}

	public void actualizarCliente(Vehiculo vehiculo) throws Exception {
	    try {
	    	daoVehiculo.update(vehiculo); 
	    } catch (Exception e) {
	        throw new Exception("Error al actualizar: " + e.getMessage());
	    }
	}
	
	public List<Vehiculo> listarVehiculos(){
		return daoVehiculo.getAll();
	}
	
}
