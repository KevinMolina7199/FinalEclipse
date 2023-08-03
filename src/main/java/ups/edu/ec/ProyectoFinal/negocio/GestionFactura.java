package ups.edu.ec.ProyectoFinal.negocio;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;


import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ups.edu.ec.ProyectoFinal.datos.FacturaDAO;
import ups.edu.ec.ProyectoFinal.modelo.Factura;

@Stateless
public class GestionFactura {
	@Inject
	private FacturaDAO daoFactura;
	
	public void guardarFacturas(Factura vehiculo) throws Exception {
		if(daoFactura.read(vehiculo.getNumero()) == null) {
			try {
				daoFactura.insert(vehiculo);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoFactura.update(vehiculo);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}
	
	public void eliminarCliente(Factura vehiculo) throws Exception {
	    try {
	    	daoFactura.deleteFactura(vehiculo);
	    } catch (Exception e) {
	        throw new Exception("Error al eliminar: " + e.getMessage());
	    }
	}

	public void actualizarCliente(Factura vehiculo) throws Exception {
	    try {
	    	daoFactura.update(vehiculo); 
	    } catch (Exception e) {
	        throw new Exception("Error al actualizar: " + e.getMessage());
	    }
	}
	
	public List<Factura> listarVehiculos(){
		return daoFactura.getAll();
	}
    
    public void calcularTotalFactura(Factura factura) throws Exception {
        // Obtener la tarifa asociada al ticket
        double tarifaMonto = factura.getTicket().getTarifa().getMonto();
        
        // Calcular el tiempo de estancia en el estacionamiento
        LocalTime fechaIngreso = factura.getTicket().getFechaIngreso();
        LocalTime fechaSalida = factura.getTicket().getFechaSalida();
        Duration duracionEstancia = Duration.between(fechaIngreso, fechaSalida);
        
        // Obtener el color del vehículo
        String colorVehiculo = factura.getTicket().getVehiculo().getColor();
        
        // Lógica para calcular el costo adicional según el color del vehículo
        double costoAdicionalPorColor = 0.0;
        if (colorVehiculo.equals("Automovil")) {
            costoAdicionalPorColor = 0; 
        } else if (colorVehiculo.equals("Motocicleta")) {
            costoAdicionalPorColor = 0; 
        }else if (colorVehiculo.equals("Camion")) {
            costoAdicionalPorColor = 0; 
        }
        // Puedes agregar más lógica para otros colores si es necesario
        // Calcular el costo total considerando el monto de la tarifa y el tiempo de estancia
        double costoTotal = ((tarifaMonto * duracionEstancia.toMinutes() + costoAdicionalPorColor) )/100;
        factura.setTotal(costoTotal); // Establecer el valor calculado en la entidad Factura
        // Actualizar la factura en la base de datos
        try {
            daoFactura.update(factura);
        } catch (Exception e) {
            throw new Exception("Error al actualizar la factura: " + e.getMessage());
        }
    }
	
    public Factura readFactura(int numeroFactura) {
        return daoFactura.read(numeroFactura);
    }
	
}
