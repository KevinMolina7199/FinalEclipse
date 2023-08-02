package ups.edu.ec.ProyectoFinal.negocio;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoFinal.datos.TarifaDAO;
import ups.edu.ec.ProyectoFinal.modelo.Tarifa;

@Stateless
public class GestionTarifa {
	@Inject
	private TarifaDAO daoVehiculo;
	
	public void guardarTarifas(Tarifa vehiculo) throws Exception {
		
		if(daoVehiculo.readInt(vehiculo.getId()) == null) {
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
	
	public void eliminarCliente(Tarifa vehiculo) throws Exception {

	    try {
	    	daoVehiculo.deleteTarifa(vehiculo);
	    } catch (Exception e) {
	        throw new Exception("Error al eliminar: " + e.getMessage());
	    }
	}

	public void actualizarCliente(Tarifa vehiculo) throws Exception {
	    try {
	    	daoVehiculo.update(vehiculo); 
	    } catch (Exception e) {
	        throw new Exception("Error al actualizar: " + e.getMessage());
	    }
	}
	
	public List<Tarifa> listarVehiculos(){
		return daoVehiculo.getAll();
	}
}
